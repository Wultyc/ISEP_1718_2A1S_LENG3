/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import Controller.ListarOcupacaoController;
import java.util.List;
import java.util.Scanner;
import model.AGV;
import model.Armazem;
import model.CorredorArmazem;
import model.Empresa;
import model.EspacoArmazem;
import model.FNP;
import utils.Utils;


public class OtimizarAtualizarGestaoUI {
    
        Empresa e;
    
    public void main(String[] args) {

        //Recebe o objeto da classe empresa
        this.e = e;

        //Objetos de apoio
        Utils u = new Utils();
        ListarOcupacaoController controller = new ListarOcupacaoController();

        //Registo de informação
        List<Armazem> la;
        List<EspacoArmazem> al;
        List<CorredorArmazem> corr;
        List<AGV> agv;
        List<FNP> fnp; 
        int tamanhoLista = 0, i = 0, armazem = 0, areaLogica = 0, corredor = 0, qntPaletes = 0;
        boolean confirmacao;

        //Define a empresa
        controller.setEmpresa(e);

        //Listar armazens
        la = controller.getListaArmazem();
        tamanhoLista = la.size();
        for (i = 0; i < tamanhoLista; i++) {
            System.out.println(i + ") " + la.get(i).getCodUn() + ": " + la.get(i).getDescr());
        }
        armazem = u.readIntFromConsole("Especifique Armazém: ");
        while (armazem == -1) {
            System.out.println("Erro: Insira um valor válido");
            armazem = u.readIntFromConsole("Especifique Armazém: ");
        }
        controller.setArmazem(la.get(armazem));

        //Listar Areas Logicas
        al = controller.getListaAreasLogicas();
        tamanhoLista = al.size();
        for (i = 0; i < tamanhoLista; i++) {
            System.out.println(i + ") " + al.get(i).toString());
        }
        areaLogica = u.readIntFromConsole("Especifique Aréa Lógica: ");
        while (areaLogica == -1) {
            System.out.println("Erro: Insira um valor válido");
            areaLogica = u.readIntFromConsole("Especifique Aréa Lógica: ");
        }
        controller.setAreaLogica(al.get(areaLogica));
        
        //Listar Corredores
        corr = controller.getListaCorredores();
        tamanhoLista = corr.size();
        for (i = 0; i < tamanhoLista; i++) {
            System.out.println(i + ") " + corr.get(i).toString());
        }
        corredor = u.readIntFromConsole("Especifique Corredor: ");
        while (corredor == -1) {
            System.out.println("Erro: Insira um valor válido");
            corredor = u.readIntFromConsole("Especifique Corredor: ");
        }
        controller.setCorredor(corr.get(corredor));
        
        //Listar AGV
        agv = controller.get;
        tamanhoLista = corr.size();
        for (i = 0; i < tamanhoLista; i++) {
            System.out.println(i + ") " + corr.get(i).toString());
        }
        corredor = u.readIntFromConsole("Especifique Corredor: ");
        while (corredor == -1) {
            System.out.println("Erro: Insira um valor válido");
            corredor = u.readIntFromConsole("Especifique Corredor: ");
        }
        controller.setCorredor(corr.get(corredor));
        
        confirmacao = u.readConfirmationFromConsole("Pretende aplicar alterações?");
        
        if(confirmacao == true){
            
        }
        
    }
    
    
}
