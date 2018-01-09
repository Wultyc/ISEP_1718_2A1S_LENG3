package Controller;

import java.util.List;
import model.Armazem;
import model.CorredorArmazem;
import model.Empresa;
import model.EspacoArmazem;
import model.Ocupacao;

public class ListarOcupacaoController {

    private Empresa e;
    private Armazem a;
    private EspacoArmazem areaLogica;
    private CorredorArmazem corredor;

    public ListarOcupacaoController() {
        this.e = null;
        this.a = null;
        this.areaLogica = null;
        this.corredor = null;
    }

    public ListarOcupacaoController(Empresa e, Armazem a, EspacoArmazem areaLogica, CorredorArmazem corredor) {
        this.e = e;
        this.a = a;
        this.areaLogica = areaLogica;
        this.corredor = corredor;
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
    
    public List<Armazem> getListaArmazem() {
        return e.getListaArmazens();
    }

    public void setArmazem(Armazem a) {
        this.a = a;
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
    
    public String getOcupacao() {
        String armazem = "", c = "";
        int setorPos = 0, i = 0, j = 0, k = 0;
        Ocupacao o;

        //Cabeçalho da imagem
        armazem = "    Baia 1        Baia 2\n";
        armazem += "     1 2 3         1 2 3\n";

        for (i = 0; i < 20; i++) {

            //Identificador da linha
            if (i < 9) {
                armazem += "0" + (i+1) + " ";
            } else {
                armazem += (i+1) + " ";
            }

            for (j = 0; j < 2; j++) {

                armazem += "| "; //Separador exterior da baía

                for (k = 0; k < 3; k++) {
                    setorPos++;
                    o = corredor.getSetores().get(setorPos).getEstado();

                    //Carater que indica a precença de um produto ou não
                    if (o.isOcupado()) {
                        c = "X";
                    } else {
                        c = " ";
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
