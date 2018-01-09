package UserInterface;

import Controller.ListarOcupacaoController;
import java.util.List;
import java.util.Scanner;
import model.Armazem;
import model.CorredorArmazem;
import model.Empresa;
import model.EspacoArmazem;
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

        //Objetos de apoio
        Utils u = new Utils();
        ListarOcupacaoController controller = new ListarOcupacaoController();

        //Registo de informação
        List<Armazem> la;
        List<EspacoArmazem> al;
        List<CorredorArmazem> corr;
        int tamanhoLista = 0, i = 0, armazem = 0, areaLogica = 0, corredor = 0;

        //Define a empresa
        controller.setEmpresa(e);

        //Listar armazens
        la = controller.getListaArmazem();
        tamanhoLista = la.size();
        u.imprimeSeparador();
        System.out.println("Lista de Armazens");
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
        u.imprimeSeparador();
        System.out.println("Lista de Areas Logicas");
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
        u.imprimeSeparador();
        System.out.println("Lista de Corredores");
        for (i = 0; i < tamanhoLista; i++) {
            System.out.println(i + ") " + corr.get(i).toString());
        }
        corredor = u.readIntFromConsole("Especifique Corredor: ");
        while (corredor == -1) {
            System.out.println("Erro: Insira um valor válido");
            corredor = u.readIntFromConsole("Especifique Corredor: ");
        }
        controller.setCorredor(corr.get(corredor));
        
        //Listar Ocupação
        System.out.println(controller.getOcupacao());
    }

}
