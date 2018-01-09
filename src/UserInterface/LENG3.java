package UserInterface;

import java.util.Scanner;
import model.Empresa;
import utils.Utils;

/**
 * @author Grupo 3
 */
public class LENG3 {

    public static void main(String[] args) {
        // TODO code application logic here
        Empresa e = new Empresa();
        OtimizarAtualizarGestaoUI otimiza = new OtimizarAtualizarGestaoUI();
        ListarOcupacaoUI lista = new ListarOcupacaoUI();
        Utils u = new Utils();
        String resp = "";
        
        while(!resp.equalsIgnoreCase("F")){
            u.imprimeSeparador();
            System.out.println("Bem-vindo\n"
                + "Menu:\n"
                + "N) Nova Otimização\n"
                + "L) Listar Ocupação\n"
                + "F) Fechar a aplicação");
            resp = u.readLineFromConsole("Selcione uma das opções: ");
            
            if(resp.equalsIgnoreCase("N")){
                otimiza.main(e);
            }else if(resp.equalsIgnoreCase("L")){
                lista.main(e);
            }else{
                System.out.println("Obrigado pela utlização");
            }
        }
    }
    
}
