/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jorge
 */
public class LocalEntregaLevantamento {
    private int numIdentificacao;
    private String denominacao;
    private String abr;
    private EndPostal endPostal;

    public LocalEntregaLevantamento(){
        this.numIdentificacao = 0;
        this.denominacao = null;
        this.abr = null;
        this.endPostal = null;
    }
    
    public LocalEntregaLevantamento(int numIdentificacao, String denominacao, String abr, String endPostalL1, String endPostalL2, int endPostal_cpCidade, int endPostal_cpRua){
        this.numIdentificacao = 0;
        this.denominacao = null;
        this.abr = null;
        this.endPostal = new EndPostal(endPostalL1, endPostalL2, endPostal_cpCidade, endPostal_cpRua);
    }
    
    /**
     * @param numIdentificacao the numIdentificacao to set
     */
    public void setNumIdentificacao(int numIdentificacao) {
        this.numIdentificacao = numIdentificacao;
    }

    /**
     * @param denominacao the denominacao to set
     */
    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    /**
     * @param abr the abr to set
     */
    public void setAbr(String abr) {
        this.abr = abr;
    }

    /**
     * @param endPostal the endPostal to set
     */
    public void setEndPostal(String endPostalL1, String endPostalL2, int endPostal_cpCidade, int endPostal_cpRua) {
        this.endPostal.setLinha1(endPostalL1);
        this.endPostal.setLinha2(endPostalL2);
        this.endPostal.setCp_cidade(endPostal_cpCidade);
        this.endPostal.setCp_rua(endPostal_cpRua);
    }
    
    public void valida(){
        
    }

    @Override
    public String toString() {
        return "N unico: " + this.numIdentificacao + "\tDenomicacao: " + this.denominacao + "\tAbreviatura: " + this.abr + "\t"+"End. Postal: " + this.endPostal.toString();
    }
}
