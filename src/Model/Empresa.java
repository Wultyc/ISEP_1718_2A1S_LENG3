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
        ListaArmazens.get(0).addAGV(new AGV(new Date(12, 10, 2003), "KJ53", 8, 2, 100.0, 1.0));
        
        //Entidade
        ListaEntidades.add(new Entidade(sCodigo, sDesComercial, sDesComum, sNIF, sEnderecoPostal, sEnderecoEletronico, oColab));
        
        //FNP
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
        ListaFNP.add(new FNP(codEnt, dComp, dBrv, classe, estado, dVal, 0));
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
