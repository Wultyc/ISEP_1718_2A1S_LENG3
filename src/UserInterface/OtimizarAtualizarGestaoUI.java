/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author DEE
 */
public class OtimizarAtualizarGestaoUI {
    
    public static void main(String[] args) {
        
        Utils u = new Utils();
        
        String armazem, alteracoes, areaLogica, corredor;
        
        //Listar armazens
        armazem = u.readLineFromConsole("Especifique CArmazem: ");
        
        //Listar Areas Logicas
        areaLogica = u.readLineFromConsole("Especifique Area Logica: ");
        
        //Listar Corredores
        corredor = u.readLineFromConsole("Especifique Corredor: ");        
        
        //Confere condições para o uso do AMPL
        
        //Envia os dados para o servidor 
        
        alteracoes = u.readLineFromConsole("Pretende aplicar alterações ?");
        
        //Se sim -> sistema aplica alteracções
        
    }
    
    
}
