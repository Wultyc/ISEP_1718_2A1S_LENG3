package UserInterface;
import java.util.Scanner;
import model.Empresa;
import utils.Utils;

/**
 *
 * @author DEE
 */
public class ListarOcupacaoUI {
    
    Empresa e;
         
    public void main(Empresa e) {
        
        //Recebe o objeto da classe empresa
        this.e = e;
        
        Utils u = new Utils();
        
        String armazem, areaLogica, corredor;
        
            
        //Listar armazens
        armazem = u.readLineFromConsole("Especifique Armazém: ");
        
        //Listar Areas Logicas
        areaLogica = u.readLineFromConsole("Especifique Aréa Lógica: ");
        
        //Listar Corredores
        corredor = u.readLineFromConsole("Especifique Corredor: ");
        
        //Listar Ocupação
    }
    
    
    
    
}
