/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author jorge
 */
public class FNP {
    private String codEnt;
    private String dComp;
    private String dBrv;
    private String classe;
    private String estado;
    private Date dVal;
    private float pMax;
    private AprovacaoFNP aprovacao;
    
    public FNP(){
        this.codEnt = "";
        this.dComp = "";
        this.dBrv = "";
        this.classe = "";
        this.estado = "";
        this.dVal = new Date();
        this.pMax = 0;
        this.aprovacao = new AprovacaoFNP();
    }
    
    public FNP(String codEnt, String dComp, String dBrv, String classe, String estado, Date dVal, float pMax){
        this.codEnt = codEnt;
        this.dComp = "";
        this.dBrv = "";
        this.classe = "";
        this.estado = "";
        this.dVal = new Date();
        this.pMax = 0;
        this.aprovacao = new AprovacaoFNP();
    }

    public void setCodEnt(String codEnt) {
        this.codEnt = codEnt;
    }

    public void setdComp(String dComp) {
        this.dComp = dComp;
    }

    public void setdBrv(String dBrv) {
        this.dBrv = dBrv;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setdVal(Date dVal) {
        this.dVal = dVal;
    }

    public void setpMax(float pMax) {
        this.pMax = pMax;
    }
    
    public void novaAprovacaoFNP(int aprovacao, String fundm){
        this.aprovacao.setAprovacao(aprovacao);
        this.aprovacao.setFundm(fundm);
    }
    
    public void validarAprovacaoFNP(AprovacaoFNP apr){
        
    }
    public void registaAprovacaoFNP(AprovacaoFNP apr){
        
    }
    
    public boolean valida(){
        return true;
    }

    public boolean isIdentifiableAs(String sCodigo) {
        return this.codEnt.equals(sCodigo);
    }

    @Override
    public String toString() {
        return "Descricao Breve" + this.dBrv+ "\nDescricao Completa: " + this.dComp+ "\nClasse: " + this.classe+ "\nEstado: " + this.estado+ "\nData de Validade: " + this.dVal.toString()+ "\nPeso Máximo por Europalete: " + this.pMax+ "Kg\n" + this.aprovacao.toString();
    }
}
