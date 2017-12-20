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

    private RegistoEntidades ListaEntidades;
    private List<Colaborador> m_lstColaboradores;
    private RegistoArmazens ListaArmazens;
    private RegistoFNP ListaFNP;

    public Empresa() {
        this.m_lstColaboradores = new ArrayList<>();
        this.setListaEntidades(new RegistoEntidades());
        this.setListaArmazens(new RegistoArmazens());
        this.setListaFNP(new RegistoFNP());

        fillInData();
    }

    private void fillInData() {
        // Dados de Teste
        //Preenche alguns Colaboradores
        for (Integer i = 1; i <= 4; i++) {
            addColaborador(new Colaborador(i, "Colaborador: " + i.toString()));
        }

        //Preencher outros dados aqui
    }
    
    /************************* Colaboradores **********************************/

    private boolean addColaborador(Colaborador colab) {
        return m_lstColaboradores.add(colab);
    }

    public List<Colaborador> getListaColaboradores() {
        return this.m_lstColaboradores;
    }

    /**************************** Entidades ************************************/

    public RegistoEntidades getListaEntidades() {
        return ListaEntidades;
    }

    public void setListaEntidades(RegistoEntidades ListaEntidades) {
        this.ListaEntidades = ListaEntidades;
    }

    /**************************** Armazens ************************************/

    public RegistoArmazens getListaArmazens() {
        return ListaArmazens;
    }

    public void setListaArmazens(RegistoArmazens ListaArmazens) {
        this.ListaArmazens = ListaArmazens;
    }

    /***************************** FNP ****************************************/

    public RegistoFNP getListaFNP() {
        return ListaFNP;
    }

    public void setListaFNP(RegistoFNP ListaFNP) {
        this.ListaFNP = ListaFNP;
    }
}
