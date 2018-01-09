/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Empresa {

    private List<Entidade> ListaEntidades;
    private List<Colaborador> m_lstColaboradores;
    private List<Armazem> ListaArmazens;
    private List<FNP> ListaFNP;

    public Empresa() {
        this.m_lstColaboradores = new ArrayList<Colaborador>();
        this.ListaEntidades = new ArrayList<Entidade>();
        this.ListaArmazens = new ArrayList<Armazem>();
        this.ListaFNP = new ArrayList<FNP>();

        fillInData();
    }

    private void fillInData() {
        // Dados de Teste
        //Preenche alguns Colaboradores
        for (Integer i = 1; i <= 10; i++) {
            addColaborador(new Colaborador(i, "Colaborador: " + i.toString()));
        }

        //Entidade
        ListaEntidades.add(new Entidade("ent1", "Instituto Superior de Engenharia do Porto", "ISEP", "123456789", "Rua Dr. António Bernardino de Almeida, nº 431, 4200-072, Porto", "gitsubishi@gitsubishi.com", m_lstColaboradores.get(2)));

        //FNP
        ListaFNP.add(new FNP("FNP1", "leite a vaca feliz", "leite", "", "liquido", new Date(2018, 02, 05), 10, new AprovacaoFNP(1, "")));
        ListaFNP.add(new FNP("FNP2", "ovos a galinha que canta", "ovo", "", "solido", new Date(2018, 02, 05), 5, new AprovacaoFNP(1, "")));
        ListaFNP.add(new FNP("FNP3", "fruta pomar saudavel", "fruta", "", "solido", new Date(2018, 02, 05), 10, new AprovacaoFNP(1, "")));
        ListaFNP.add(new FNP("FNP4", "aspiradores tudo limpo", "aspiradores", "", "solido", null, 10, new AprovacaoFNP(1, "")));
        ListaFNP.add(new FNP("FNP5", "parafusos sempre fixo", "parafusos", "", "solido", null, 10, new AprovacaoFNP(1, "")));
        ListaFNP.add(new FNP("FNP6", "porcas ferragens e ca", "porcas", "", "solido", null, 10, new AprovacaoFNP(1, "")));
        ListaFNP.add(new FNP("FNP7", "alface pomar saudavel", "alface", "", "solido", new Date(2018, 02, 05), 5, new AprovacaoFNP(1, "")));
        ListaFNP.add(new FNP("FNP8", "tomate pomar saudavel", "tomate", "", "solido", new Date(2018, 02, 05), 5, new AprovacaoFNP(1, "")));
        ListaFNP.add(new FNP("FNP9", "chouriços enchidos da ericeira", "chouriços", "", "solido", new Date(2018, 02, 05), 10, new AprovacaoFNP(1, "")));
        ListaFNP.add(new FNP("FNP10", "smartphones ching-ling", "smatphones", "", "solido", null, 10, new AprovacaoFNP(1, "")));

        //Armazem
        ListaArmazens.add(new Armazem("AR30", "ARM LENG3", "Rua Dr. Antonio Bernardino de Almeida", "N 431", 4200, 072, 41.17, -8.59, 50));
        ListaArmazens.get(0).setPlanta(new PlantaArmazem());
        ListaArmazens.get(0).getPlanta().setLargura(20);
        ListaArmazens.get(0).getPlanta().setAltura(10);
        ListaArmazens.get(0).getPlanta().setComprimento(50);
        ListaArmazens.get(0).getPlanta().addEspacos(new EspacoArmazem("E1", 1000, 500, 0, 1210, 2900, 0));
        ListaArmazens.get(0).getPlanta().addCorredores(new CorredorArmazem("C12", 1000, 500, 0, 1210, 2900, 0));
        ListaArmazens.get(0).addAGV(new AGV(new Date(12, 10, 2003), "KJ53", 8, 2, 100.0, 1.0, 0.5));

        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 0 + 0 + 0, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 0 + 0 + 0, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 0 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 0 + 0 + 2, new Ocupacao(true, ListaFNP.get(8))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 0 + 1 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 0 + 1 + 1, new Ocupacao(true, ListaFNP.get(7))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 0 + 1 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 1 + 0 + 0, new Ocupacao(true, ListaFNP.get(5))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 1 + 0 + 1, new Ocupacao(true, ListaFNP.get(7))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 1 + 0 + 2, new Ocupacao(true, ListaFNP.get(1))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 1 + 1 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 1 + 1 + 1, new Ocupacao(true, ListaFNP.get(5))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 1 + 1 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 2 + 0 + 0, new Ocupacao(true, ListaFNP.get(5))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 2 + 0 + 1, new Ocupacao(true, ListaFNP.get(1))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 2 + 0 + 2, new Ocupacao(true, ListaFNP.get(3))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 2 + 1 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 2 + 1 + 1, new Ocupacao(true, ListaFNP.get(5))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 2 + 1 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 3 + 0 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 3 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 3 + 0 + 2, new Ocupacao(true, ListaFNP.get(1))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 3 + 1 + 0, new Ocupacao(true, ListaFNP.get(7))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 3 + 1 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 3 + 1 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 4 + 0 + 0, new Ocupacao(true, ListaFNP.get(3))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 4 + 0 + 1, new Ocupacao(true, ListaFNP.get(8))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 4 + 0 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 4 + 1 + 0, new Ocupacao(true, ListaFNP.get(8))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 4 + 1 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 4 + 1 + 2, new Ocupacao(true, ListaFNP.get(5))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 5 + 0 + 0, new Ocupacao(true, ListaFNP.get(6))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 5 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 5 + 0 + 2, new Ocupacao(true, ListaFNP.get(3))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 5 + 1 + 0, new Ocupacao(true, ListaFNP.get(0))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 5 + 1 + 1, new Ocupacao(true, ListaFNP.get(3))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 5 + 1 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 6 + 0 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 6 + 0 + 1, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 6 + 0 + 2, new Ocupacao(true, ListaFNP.get(0))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 6 + 1 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 6 + 1 + 1, new Ocupacao(true, ListaFNP.get(1))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 6 + 1 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 7 + 0 + 0, new Ocupacao(true, ListaFNP.get(1))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 7 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 7 + 0 + 2, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 7 + 1 + 0, new Ocupacao(true, ListaFNP.get(8))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 7 + 1 + 1, new Ocupacao(true, ListaFNP.get(2))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 7 + 1 + 2, new Ocupacao(true, ListaFNP.get(9))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 8 + 0 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 8 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 8 + 0 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 8 + 1 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 8 + 1 + 1, new Ocupacao(true, ListaFNP.get(9))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 8 + 1 + 2, new Ocupacao(true, ListaFNP.get(3))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 9 + 0 + 0, new Ocupacao(true, ListaFNP.get(0))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 9 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 9 + 0 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 9 + 1 + 0, new Ocupacao(true, ListaFNP.get(5))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 9 + 1 + 1, new Ocupacao(true, ListaFNP.get(0))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 9 + 1 + 2, new Ocupacao(true, ListaFNP.get(2))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 10 + 0 + 0, new Ocupacao(true, ListaFNP.get(8))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 10 + 0 + 1, new Ocupacao(true, ListaFNP.get(0))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 10 + 0 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 10 + 1 + 0, new Ocupacao(true, ListaFNP.get(0))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 10 + 1 + 1, new Ocupacao(true, ListaFNP.get(6))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 10 + 1 + 2, new Ocupacao(true, ListaFNP.get(8))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 11 + 0 + 0, new Ocupacao(true, ListaFNP.get(9))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 11 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 11 + 0 + 2, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 11 + 1 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 11 + 1 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 11 + 1 + 2, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 12 + 0 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 12 + 0 + 1, new Ocupacao(true, ListaFNP.get(7))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 12 + 0 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 12 + 1 + 0, new Ocupacao(true, ListaFNP.get(2))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 12 + 1 + 1, new Ocupacao(true, ListaFNP.get(9))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 12 + 1 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 13 + 0 + 0, new Ocupacao(true, ListaFNP.get(9))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 13 + 0 + 1, new Ocupacao(true, ListaFNP.get(2))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 13 + 0 + 2, new Ocupacao(true, ListaFNP.get(6))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 13 + 1 + 0, new Ocupacao(true, ListaFNP.get(0))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 13 + 1 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 13 + 1 + 2, new Ocupacao(true, ListaFNP.get(0))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 14 + 0 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 14 + 0 + 1, new Ocupacao(true, ListaFNP.get(8))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 14 + 0 + 2, new Ocupacao(true, ListaFNP.get(7))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 14 + 1 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 14 + 1 + 1, new Ocupacao(true, ListaFNP.get(7))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 14 + 1 + 2, new Ocupacao(true, ListaFNP.get(6))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 15 + 0 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 15 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 15 + 0 + 2, new Ocupacao(true, ListaFNP.get(5))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 15 + 1 + 0, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 15 + 1 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 15 + 1 + 2, new Ocupacao(true, ListaFNP.get(7))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 16 + 0 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 16 + 0 + 1, new Ocupacao(true, ListaFNP.get(1))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 16 + 0 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 16 + 1 + 0, new Ocupacao(true, ListaFNP.get(1))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 16 + 1 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 16 + 1 + 2, new Ocupacao(true, ListaFNP.get(9))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 17 + 0 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 17 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 17 + 0 + 2, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 17 + 1 + 0, new Ocupacao(true, ListaFNP.get(9))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 17 + 1 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 17 + 1 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 18 + 0 + 0, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 18 + 0 + 1, new Ocupacao(true, ListaFNP.get(6))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 18 + 0 + 2, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 18 + 1 + 0, new Ocupacao(true, ListaFNP.get(2))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 18 + 1 + 1, new Ocupacao(true, ListaFNP.get(5))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 18 + 1 + 2, new Ocupacao(true, ListaFNP.get(2))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 19 + 0 + 0, new Ocupacao(true, ListaFNP.get(6))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 19 + 0 + 1, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 19 + 0 + 2, new Ocupacao(true, ListaFNP.get(4))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 19 + 1 + 0, new Ocupacao(false, null)));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 19 + 1 + 1, new Ocupacao(true, ListaFNP.get(2))));
        ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S" + 19 + 1 + 2, new Ocupacao(true, ListaFNP.get(8))));

    }

    /**
     * *********************** Colaboradores *********************************
     */
    private boolean addColaborador(Colaborador colab) {
        return m_lstColaboradores.add(colab);
    }

    public List<Colaborador> getListaColaboradores() {
        return this.m_lstColaboradores;
    }

    /**
     * ************************** Entidades ***********************************
     */
    public List<Entidade> getListaEntidades() {
        return this.ListaEntidades;
    }

    public boolean addEntidades(Entidade ent) {
        return this.ListaEntidades.add(ent);
    }

    /**
     * ************************** Armazens ***********************************
     */
    public List<Armazem> getListaArmazens() {
        return ListaArmazens;
    }

    public boolean setListaArmazens(Armazem arm) {
        return this.ListaArmazens.add(arm);
    }

    /**
     * *************************** FNP ***************************************
     */
    public List<FNP> getListaFNP() {
        return ListaFNP;
    }

    public boolean setListaFNP(FNP fnp) {
        return this.ListaFNP.add(fnp);
    }
}
