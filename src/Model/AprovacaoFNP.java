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
public class AprovacaoFNP {
    private int aprovacao;
    private String fundm;
    private String[] aprovacaoS = {"Reprovada", "Aprovada"};

    public void setAprovacao(int aprovacao) {

        this.aprovacao = aprovacao;
    }

    public void setFundm(String fundm) {

        this.fundm = fundm;
    }
    
    public void valida(){
        
    }

    @Override
    public String toString() {
        return "Aprovacao: " + aprovacaoS[aprovacao] + "\n" + "Fundamentacao: " + fundm;
    }
    
}
