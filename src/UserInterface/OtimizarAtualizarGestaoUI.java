/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Controller.ListarOcupacaoController;
import Controller.OtimizarAtualizarGestaoController;
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

    public void main(Empresa e) {

        //Recebe o objeto da classe empresa
        this.e = e;

        //Objetos de apoio
        Utils u = new Utils();
        OtimizarAtualizarGestaoController controller = new OtimizarAtualizarGestaoController();

        //Registo de informação
        List<Armazem> la;
        List<EspacoArmazem> al;
        List<CorredorArmazem> corr;
        List<AGV> lagv;
        List<FNP> lfnp;
        int tamanhoLista = 0, i = 0, armazem = 0, areaLogica = 0, corredor = 0, fnp = 0, agv = 0, qntPaletes = 0;
        boolean confirmacao, valida;

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
        lagv = controller.getListaAGVs();
        tamanhoLista = lagv.size();
        for (i = 0; i < tamanhoLista; i++) {
            System.out.println(i + ") " + lagv.get(i).toString());
        }
        agv = u.readIntFromConsole("Especifique AGV: ");
        while (corredor == -1) {
            System.out.println("Erro: Insira um valor válido");
            agv = u.readIntFromConsole("Especifique AGV: ");
        }
        controller.setAGV(lagv.get(agv));

        //Listar FNP
        lfnp = controller.getListaFnp();
        tamanhoLista = lfnp.size();
        for (i = 0; i < tamanhoLista; i++) {
            System.out.println(i + ") " + lfnp.get(i).getCodEnt() + ": " + lfnp.get(i).getdComp() + "(" + lfnp.get(i).getAprovacao().getAprovacaoToString() + ")");
        }
        fnp = u.readIntFromConsole("Especifique FNP: ");
        while (corredor == -1) {
            System.out.println("Erro: Insira um valor válido");
            fnp = u.readIntFromConsole("Especifique FNP: ");
        }
        controller.setFnp(lfnp.get(fnp));

        //Define a quantidade
        qntPaletes = u.readIntFromConsole("Que quantidade de paletes pretende? ");
        controller.setQuantidade(qntPaletes);

        System.out.println(controller.getResumo());

        confirmacao = u.readConfirmationFromConsole("Pretende continuar?");

        if (confirmacao == true) {
            valida = controller.inciaOtimizacao();
            if (!valida) {
                System.out.println("Quantidade inválida!");
                return;
            }
            controller.fazOtimizacao();
            controller.getResultado();

            confirmacao = u.readConfirmationFromConsole("Pretende continuar?");
            if (confirmacao) {
                controller.aplicaArmazem();
                System.out.println("Alterações aplicadas!");
            }

        }
    }

}
