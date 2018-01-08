package Controller;

import model.Armazem;
import model.CorredorArmazem;
import model.Empresa;
import model.EspacoArmazem;


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

    public void setArmazem(Armazem a) {
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
    
}

