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

    /**
     * @return the codEnt
     */
    public String getCodEnt() {
        return codEnt;
    }

    /**
     * @return the dComp
     */
    public String getdComp() {
        return dComp;
    }

    /**
     * @return the dBrv
     */
    public String getdBrv() {
        return dBrv;
    }

    /**
     * @return the classe
     */
    public String getClasse() {
        return classe;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @return the dVal
     */
    public Date getdVal() {
        return dVal;
    }

    /**
     * @return the pMax
     */
    public float getpMax() {
        return pMax;
    }

    /**
     * @return the aprovacao
     */
    public AprovacaoFNP getAprovacao() {
        return aprovacao;
    }
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
    
    public FNP(String codEnt, String dComp, String dBrv, String classe, String estado, Date dVal, float pMax, AprovacaoFNP aprovacao){
        this.codEnt = codEnt;
        this.dComp = dComp;
        this.dBrv = dBrv;
        this.classe = classe;
        this.estado = estado;
        this.dVal = new Date();
        this.pMax = 0;
        this.aprovacao = aprovacao;
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
        this.getAprovacao().setAprovacao(aprovacao);
        this.getAprovacao().setFundm(fundm);
    }
    
    public void validarAprovacaoFNP(AprovacaoFNP apr){
        
    }
    public void registaAprovacaoFNP(AprovacaoFNP apr){
        
    }
    
    public boolean valida(){
        return true;
    }

    public boolean isIdentifiableAs(String sCodigo) {
        return this.getCodEnt().equals(sCodigo);
    }

    @Override
    public String toString() {
        return "Descricao Breve" + this.getdBrv()+ "\nDescricao Completa: " + this.getdComp()+ "\nClasse: " + this.getClasse()+ "\nEstado: " + this.getEstado()+ "\nData de Validade: " + this.getdVal().toString()+ "\nPeso Máximo por Europalete: " + this.getpMax()+ "Kg\n" + this.getAprovacao().toString();
    }
}
