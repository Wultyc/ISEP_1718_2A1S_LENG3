package Controller;

import java.util.Vector;
import jdk.nashorn.internal.codegen.CompilerConstants;
import model.Armazem;
import model.CorredorArmazem;
import model.Empresa;
import model.EspacoArmazem;
import model.FNP;
import org.apache.xmlrpc.XmlRpcException;
import org.neos.client.NeosJobXml;
import org.neos.client.NeosXmlRpcClient;
import org.neos.client.ResultReceiver;
import utils.Utils;

public class OtimizarAtualizarGestaoController {

    private Empresa e;
    private Armazem a;
    private EspacoArmazem areaLogica;
    private CorredorArmazem corredor;
    private FNP fnp;
    private int quantidade;
    private String run;
    private String model;
    private String data;
    private String respostaNEOS;
    private int z;
    private String StringMatriz;
    private int[][][] armazem = new int[20][2][3];

    private final String caminhoRun = "LENG3.run";
    private final String caminhoModel = "LENG3.mod";
    private static final String HOST = "neos-server.org";
    private static final String PORT = "3333";

    public OtimizarAtualizarGestaoController() {

    }

    public OtimizarAtualizarGestaoController(Empresa e) {
        this.e = e;
    }

    public Empresa getE() {
        return e;
    }

    public void setE(Empresa e) {
        this.e = e;
    }

    public Armazem getA() {
        return a;
    }

    public void setA(Armazem a) {
        this.a = a;
    }

    public EspacoArmazem getAreaLogica() {
        return areaLogica;
    }

    public void setAreaLogica(EspacoArmazem areaLogica) {
        this.areaLogica = areaLogica;
    }

    public CorredorArmazem getCorredor() {
        return corredor;
    }

    public void setCorredor(CorredorArmazem corredor) {
        this.corredor = corredor;
    }

    public FNP getFnp() {
        return fnp;
    }

    public void setFnp(FNP fnp) {
        this.fnp = fnp;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean validaQuantidade(int qnt) {
        return true;
    }

    public String genData() {
        return "";
    }

    public boolean inciaOtimizacao() {
        Utils u = new Utils();
        this.model = u.loadTextFile(this.caminhoModel);
        this.run = u.loadTextFile(this.caminhoRun);
        this.data = genData();
        if (validaQuantidade(this.quantidade)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean fazOtimizacao() {
        String resolucao;
        int inicioResolucao;
        boolean feedbackNEOS, feedbackIntrepetacao;

        feedbackNEOS = otimiza(); //Envia o trabalho para o servidor NEOS

        if (feedbackNEOS == false) { //Ser ocurrer um erro para por aqui a execução
            return false;
        }

        feedbackIntrepetacao = processaString(); //Processa a String
        
        if (feedbackIntrepetacao == false) { //Ser ocurrer um erro para por aqui a execução
            return false;
        }
        
        gerarArmazem(); //Converte a String matriz num armazem

        return true;
    }

    public boolean otimiza() {
        //Cria o cliente de ligação ao Servidor NEOS
        NeosXmlRpcClient client = new NeosXmlRpcClient(HOST, PORT);

        //Define o trabalho e Solver
        NeosJobXml exJob = new NeosJobXml("lp", "CPLEX", "AMPL");

        //Insere os ficheiros do problema
        exJob.addParam("model", model);
        exJob.addParam("data", data);
        exJob.addParam("commands", run);
        exJob.addParam("email", "1160929@isep.ipp.pt");

        Vector params = new Vector();
        String jobString = exJob.toXMLString();
        params.add(jobString);

        Integer currentJob = 0;
        String currentPassword = "";
        String result = "";

        try {
            client.connect();
            //Inicia e aguarda 5 segundo pela resposta
            Object[] results = (Object[]) client.execute("submitJob", params, 5000);

            //Recebe o numero do trabalho e password
            currentJob = (Integer) results[0];
            currentPassword = (String) results[1];
            //System.out.println("submitted" + results);

            //Envia o trabalho
            JobReceiver jobReceiver = new JobReceiver();
            ResultReceiver receiver = new ResultReceiver(client, jobReceiver, currentJob, currentPassword);
            receiver.run();

            this.respostaNEOS = receiver.getResult();

            return true;
        } catch (XmlRpcException e) {
            this.respostaNEOS = "Erro na submicao do trabalho:" + e.getMessage();
            return false;
        }
    }

    public boolean processaString() {
        String StringLimpa = "";

        StringLimpa = limpaString(this.respostaNEOS);
        this.z = encontraZ(StringLimpa);
        this.StringMatriz = limpaZ(StringLimpa);
        
        //Despista algum erro na conversão
        if(this.z == -1 || this.StringMatriz.equals("")){
            return false;
        }else{
            return true;
        }

    }

    public String limpaString(String s) {
        int inicio = 0;
        String resFinal = "";
        inicio = s.indexOf("InicioResultadoLENG3") + 21;
        resFinal = s.substring(inicio);
        return resFinal;
    }

    public int encontraZ(String s) {
        int z = 0, fimZ = 0;
        String resFinal = "";
        fimZ = s.indexOf("\n");
        resFinal = s.substring(4, fimZ);
        try {
            z = Integer.parseInt(resFinal);
        } catch (Exception e) {
            z = -1;
        }
        return z;
    }

    public String limpaZ(String s) {
        int inicio = 0;
        String resFinal = "";
        inicio = s.indexOf("\n\n") + 2;
        resFinal = s.substring(inicio);
        return resFinal;
    }

    public void gerarArmazem() {
        int pos1, pos2, pos3, pos4;
        int i, j, k1, k2,k3;
        String s1, s2;
        String[] matrizes = new String[2];
        
        s1 = this.StringMatriz;
        
        pos1 = s1.indexOf(":=\n")+3;
        pos2 = s1.indexOf("\n [*,2,*]\n")-1;
        matrizes[0] = s1.substring(pos1, pos2);
        
        s2 = s1.substring(pos2);
        pos3 = s2.indexOf(":=\n")+3;
        pos4 = s2.indexOf(";")-1;
        matrizes[1] = s2.substring(pos3, pos4);
        
        for(i=0;i<20;i++){
            k1 = 5 + 15*i;
            k2 = 9 + 15*i;
            k3 = 13 + 15*i;
            for(j=0;j<2;j++){
                armazem[i][j][0] = Integer.parseInt(matrizes[j].substring(k1, k1+1));
                armazem[i][j][1] = Integer.parseInt(matrizes[j].substring(k2, k2+1));
                armazem[i][j][2] = Integer.parseInt(matrizes[j].substring(k3, k3+1));
            }
        }
    }
    
    public void aplicaArmazem(){
        
    }
}
