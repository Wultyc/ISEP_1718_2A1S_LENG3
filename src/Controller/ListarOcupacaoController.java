package Controller;

import java.util.List;
import model.Armazem;
import model.Empresa;


public class ListarOcupacaoController {
    
    Empresa e;
    
    public ListarOcupacaoController(){
        e = null;
    }
    
    public ListarOcupacaoController(Empresa e){
        this.e = e;
    }
    
    public List<Armazem> getListaArmazens() {
        
        return e.getListaArmazens();
    }
}
public class 
