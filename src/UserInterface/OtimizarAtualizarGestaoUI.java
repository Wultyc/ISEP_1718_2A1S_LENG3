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
        
        String armazem, alteracoes;
        double areaLogica, corredor;
        
        //Listar armazens
        System.out.println("Especifique Armazém: ");
        armazem = sc.next();
        
        //Listar Areas Logicas
        System.out.println("Especifique Aréa Lógica: ");
        areaLogica = sc.nextDouble();
        
        //Listar Corredores
        System.out.println("Especifique Corredor: ");
        corredor = sc.nextDouble();        
        
        //Confere condições para o uso do AMPL
        
        //Envia os dados para o servidor 
        
        System.out.println("Pretende aplicar alterações ?");
        alteracoes = sc.next();
        
        //Se sim -> sistema aplica alteracções
        
    }
    
    
}
