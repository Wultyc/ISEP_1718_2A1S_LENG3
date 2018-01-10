package Controller;

import java.util.Date;
import java.util.List;
import java.util.Vector;
import jdk.nashorn.internal.codegen.CompilerConstants;
import model.AGV;
import model.Armazem;
import model.CorredorArmazem;
import model.Empresa;
import model.EspacoArmazem;
import model.FNP;
import model.Ocupacao;
import model.PlantaArmazem;
import model.Setor;
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
    private AGV agv;
    private FNP fnp;
    private int quantidade;
    private int quantidadeMax;
    private String run;
    private String model;
    private String data;
    private String respostaNEOS;
    private int z;
    private String StringMatriz;
    private int[][][] armazem;
    private boolean recolha;
    private FNP produtofinal;

    private final String caminhoRun = "AMPL_LENG3.run";
    private final String caminhoModel = "AMPL_LENG3.mod";
    private final String HOST = "neos-server.org";
    private final String PORT = "3333";

    public OtimizarAtualizarGestaoController() {
        this.e = null;
        this.a = null;
        this.areaLogica = null;
        this.corredor = null;
        this.agv = null;
        this.fnp = null;
        this.quantidade = 0;
        this.quantidadeMax = 0;
        this.run = "";
        this.model = "";
        this.data = "";
        this.respostaNEOS = "";
        this.z = 0;
        this.StringMatriz = "";
        this.armazem = new int[20][2][3];
    }

    public OtimizarAtualizarGestaoController(Empresa e, Armazem a, EspacoArmazem areaLogica, CorredorArmazem corredor, AGV agv, FNP fnp, boolean recolha) {
        this.e = e;
        this.a = a;
        this.areaLogica = areaLogica;
        this.corredor = corredor;
        this.agv = agv;
        this.fnp = fnp;
        this.quantidade = 0;
        this.quantidadeMax = 0;
        this.run = "";
        this.model = "";
        this.data = "";
        this.respostaNEOS = "";
        this.z = 0;
        this.StringMatriz = "";
        this.armazem = new int[20][2][3];
        this.recolha = recolha;
    }

    public Empresa getEmpresa() {
        return e;
    }

    public void setEmpresa(Empresa e) {
        this.e = e;
    }

    public Armazem getArmazem() {
        return a;
    }

    public void setArmazem(Armazem a) {
        this.a = a;
    }

    public List<Armazem> getListaArmazem() {
        return e.getListaArmazens();
    }

    public EspacoArmazem getAreaLogica() {
        return areaLogica;
    }

    public void setAreaLogica(EspacoArmazem areaLogica) {
        this.areaLogica = areaLogica;
    }

    public List<EspacoArmazem> getListaAreasLogicas() {
        return a.getPlanta().getAreasLogicas();
    }

    public CorredorArmazem getCorredor() {
        return corredor;
    }

    public void setCorredor(CorredorArmazem corredor) {
        this.corredor = corredor;
    }

    public List<CorredorArmazem> getListaCorredores() {
        return a.getPlanta().getCorredores();
    }

    public AGV getAGV() {
        return this.agv;
    }

    public void setAGV(AGV agv) {
        this.agv = agv;
    }

    public List<AGV> getListaAGVs() {
        return a.getAGVs();
    }

    public FNP getFnp() {
        return fnp;
    }

    public void setFnp(FNP fnp) {
        this.fnp = fnp;
        if (this.recolha) {
            this.produtofinal = null;
        } else {
            this.produtofinal = this.fnp;
        }
    }

    public List<FNP> getListaFnp() {
        return e.getListaFNP();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isRecolha() {
        return recolha;
    }

    public String getRecolha() {
        if (recolha) {
            return "Recolha";
        } else {
            return "Entrega";
        }
    }

    public void setRecolha(boolean recolha) {
        this.recolha = recolha;
    }

    public String getResumo() {
        String resumo = "";
        resumo += "Resumo da otimização:\n"
                + "Armazem: " + a.getDescr() + "\n"
                + "Area Lógica: " + areaLogica.toString() + "\n"
                + "Corredor: " + corredor.toString() + "\n"
                + "AGV: " + agv.toString() + "\n"
                + "FNP: " + fnp.getCodEnt() + ": " + fnp.getdBrv() + "(" + fnp.getAprovacao().getAprovacaoToString() + ")\n"
                + "Tipo: " + getRecolha() + "\n"
                + "Quantidade de paletes pedidas: " + this.quantidade;
        return resumo;
    }

    public boolean validaQuantidade() {
        if (this.quantidade > this.quantidadeMax) {
            return false;
        } else {
            return true;
        }
    }

    public String genData() {
        String data = "", a = "", v = "";
        int i = 0, j = 0, k = 0, setorPos = -1, tmpData = 0, tmpBin = 0;
        boolean ocupado, produtoEscolhido;
        Date tmpDate = null;
        Setor s = null;

        data = "# parametros \n"
                + "param I:= 20; #Numero de posicoes na baia\n"
                + "param J:= 2; #Numero de baias\n"
                + "param K:= 3; #Numero de niveis\n"
                + "param trec := 5; #tempo de recolha\n"
                + "param tsub := 5; #tempo de subida\n"
                + "param tdes := 5; #tempo de descarga\n"
                + "param da := 4; #distancia do ponto de recolha a baia\n";
        data += "param vagv := " + this.agv.getCat().getVelocidade() + "; #velocidade do agv\n";
        data += "param N := " + this.quantidade + "; #Tamanho da encomenda\n";
        a = "param A default 0 :=\n";
        v = "param v default 0 :=\n";
        for (i = 0; i < 20; i++) {
            for (j = 0; j < 2; j++) {
                for (k = 0; k < 3; k++) {
                    setorPos++;
                    s = this.corredor.getSetores().get(setorPos);
                    ocupado = s.getEstado().isOcupado();
                    //Obtem os dados para a String
                    if (ocupado) {
                        produtoEscolhido = s.getEstado().getProduto().isIdentifiableAs(fnp.getCodEnt());
                        if (produtoEscolhido) {
                            tmpDate = s.getEstado().getData_hora();
                            tmpData = (tmpDate.getYear() - 2000) * 10000 + tmpDate.getMonth() * 100 + tmpDate.getDate();
                        } else {
                            tmpData = 0;
                        }
                    } else {
                        produtoEscolhido = false;
                        tmpData = 0;
                    }

                    if (this.recolha == true && ocupado == true && produtoEscolhido == true) {
                        tmpBin = 1;
                        this.quantidadeMax++;
                    } else if (this.recolha == false && ocupado == false) {
                        tmpBin = 1;
                        tmpData = 1;
                        this.quantidadeMax++;
                    } else {
                        tmpBin = 0;
                        tmpData = 0;
                    }

                    a += "" + (i + 1) + " " + (j + 1) + " " + (k + 1) + "\t" + tmpBin + "\n";
                    v += "" + (i + 1) + " " + (j + 1) + " " + (k + 1) + "\t" + tmpData + "\n";
                }
            }
        }
        a += ";\n";
        v += ";\n";
        data += a + v;
        data += "#variaveis \n"
                + "var x default 0;\n"
                + "var y default 0;";
        return data;
    }

    public boolean inciaOtimizacao() {
        Utils u = new Utils();
        this.model = u.loadTextFile(this.caminhoModel);
        this.run = u.loadTextFile(this.caminhoRun);
        this.data = genData();
        System.out.println(data);
        return validaQuantidade();
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

        gerarArmazem();
        //Despista algum erro na conversão
        if (this.z == -1 || this.StringMatriz.equals("")) {
            return false;
        } else {
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
        int i, j, k;
        int[] posK = new int[3];
        int[] posKbase = {5, 9, 13};
        String s1, s2, c;
        String[] matrizes = new String[2];

        s1 = this.StringMatriz;

        pos1 = s1.indexOf(":=\n") + 3;
        pos2 = s1.indexOf("\n [*,2,*]\n") - 1;
        matrizes[0] = s1.substring(pos1, pos2);

        s2 = s1.substring(pos2);
        pos3 = s2.indexOf(":=\n") + 3;
        pos4 = s2.indexOf(";") - 1;
        matrizes[1] = s2.substring(pos3, pos4);

        for (i = 0; i < 20; i++) {
            for (j = 0; j < 2; j++) {
                for (k = 0; k < 3; k++) {
                    posK[k] = posKbase[k] + 15 * i;
                    c = matrizes[j].substring(posK[k], posK[k] + 1);
                    armazem[i][j][k] = Integer.parseInt(c);
                }
            }
        }
    }

    public void aplicaArmazem() {
        int i = 0, j = 0, k = 0, setorPos = -1;
        Ocupacao estado;
        for (i = 0; i < 20; i++) {
            for (j = 0; j < 2; j++) {
                for (k = 0; k < 3; k++) {
                    setorPos++;
                    if (armazem[i][j][k] == 1) {
                        estado = this.corredor.getSetores().get(setorPos).getEstado();
                        estado.setOcupado(!this.recolha);
                        estado.setProduto(this.produtofinal);
                        if (!this.recolha) {
                            estado.setData_hora(new Date());
                            System.out.println("data adicionada");
                        }
                    }
                }
            }
        }
    }

    public String getResultado() {
        String armazem = "", c = "";
        int setorPos = 0, i = 0, j = 0, k = 0;
        Ocupacao o;
        armazem = "Tempo da tarefa: " + this.z + " segundo\n\n";
        //Cabeçalho da imagem
        armazem += "    Baia 1        Baia 2\n";
        armazem += "     1 2 3         1 2 3\n";

        for (i = 0; i < 20; i++) {

            //Identificador da linha
            if (i < 9) {
                armazem += "0" + (i + 1) + " ";
            } else {
                armazem += (i + 1) + " ";
            }

            for (j = 0; j < 2; j++) {

                armazem += "| "; //Separador exterior da baía

                for (k = 0; k < 3; k++) {
                    setorPos++;

                    //Carater que indica a precença de um produto ou não
                    if (this.armazem[i][j][k] == 1) {
                        c = "X";
                    } else {
                        c = "O";
                    }
                    armazem += c + " ";
                }

                //Finalizador de baía
                if (j == 0) {
                    armazem += "|  '  ";
                } else {
                    armazem += "|\n";
                }

            }
        }

        return armazem;
    }
}
