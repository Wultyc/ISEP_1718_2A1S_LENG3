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
        
        //Armazem
        ListaArmazens.add(new Armazem("AR30", "ARM LENG3", "Rua Dr. Antonio Bernardino de Almeida", "N 431", 4200, 072, 41.17, -8.59, 50));
        ListaArmazens.get(0).setPlanta(new PlantaArmazem());
        ListaArmazens.get(0).getPlanta().setLargura(20);
        ListaArmazens.get(0).getPlanta().setAltura(10);
        ListaArmazens.get(0).getPlanta().setComprimento(50);
        ListaArmazens.get(0).getPlanta().addCorredores(new CorredorArmazem("C12", 1000, 500, 0, 1210, 2900, 0));
        for(int i = 1; i<=20; i++){
            for(int j = 1; j <= 2; j++){
                for(int k = 1; k <= 3; k++){
                    ListaArmazens.get(0).getPlanta().getCorredores().get(0).addSetor(new Setor("S"+i+j+k));
                }
            }
        }
        ListaArmazens.get(0).addAGV(new AGV(new Date(12, 10, 2003), "KJ53", 8, 2, 100.0, 1.0, 0.5));
        
        //Entidade
        ListaEntidades.add(new Entidade("ent1", "Instituto Superior de Engenharia do Porto", "ISEP", "123456789", "Rua Dr. António Bernardino de Almeida, nº 431, 4200-072, Porto", "gitsubishi@gitsubishi.com", m_lstColaboradores.get(2)));
        
        //FNP
        ListaFNP.add(new FNP("FNP1", "leite a vaca feliz", "leite", "", "liquido",new Date(2018,02,05), 10));
        ListaFNP.add(new FNP("FNP2", "ovos a galinha que canta", "ovo", "", "solido", new Date(2018,02,05), 5));
        ListaFNP.add(new FNP("FNP3", "fruta pomar saudavel", "fruta", "", "solido", new Date(2018,02,05), 10));
        ListaFNP.add(new FNP("FNP4", "aspiradores tudo limpo", "aspiradores", "", "solido", null, 10));
        ListaFNP.add(new FNP("FNP5", "parafusos sempre fixo", "parafusos", "", "solido", null, 10));
        ListaFNP.add(new FNP("FNP6", "porcas ferragens e ca", "porcas", "", "solido", null, 10));
        ListaFNP.add(new FNP("FNP7", "alface pomar saudavel", "alface", "", "solido", new Date(2018,02,05), 5));
        ListaFNP.add(new FNP("FNP8", "tomate pomar saudavel", "tomate", "", "solido", new Date(2018,02,05), 5));
        ListaFNP.add(new FNP("FNP9", "chouriços enchidos da ericeira", "chouriços", "", "solido",new Date(2018,02,05) , 10));
        ListaFNP.add(new FNP("FNP10", "smartphones ching-ling", "smatphones", "", "solido", null, 10));
    }
    
    /************************* Colaboradores **********************************/

    private boolean addColaborador(Colaborador colab) {
        return m_lstColaboradores.add(colab);
    }

    public List<Colaborador> getListaColaboradores() {
        return this.m_lstColaboradores;
    }

    /**************************** Entidades ************************************/

    public List<Entidade> getListaEntidades() {
        return this.ListaEntidades;
    }

    public boolean addEntidades(Entidade ent) {
        return this.ListaEntidades.add(ent);
    }

    /**************************** Armazens ************************************/

    public List<Armazem> getListaArmazens() {
        return ListaArmazens;
    }

    public boolean setListaArmazens(Armazem arm) {
        return this.ListaArmazens.add(arm);
    }

    /***************************** FNP ****************************************/

    public List<FNP> getListaFNP() {
        return ListaFNP;
    }

    public boolean setListaFNP(FNP fnp) {
        return this.ListaFNP.add(fnp);
    }
}
