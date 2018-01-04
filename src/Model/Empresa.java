/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
        ListaArmazens.add(new Armazem());
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
