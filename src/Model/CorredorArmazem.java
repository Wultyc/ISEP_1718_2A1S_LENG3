/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


public class CorredorArmazem {
    private PontoEspaco pontoA;
    private PontoEspaco pontoB;
    private String designacao; 
    private List<Setor> setores;
    
    public CorredorArmazem(){
        pontoA = new PontoEspaco();
        pontoB = new PontoEspaco();
        this.setDesignacao(""); 
    }
    
    public CorredorArmazem(String designacao, int xA, int yA, int zA, int xB, int yB, int zB){
        pontoA = new PontoEspaco(xA,yA,zA);
        pontoB = new PontoEspaco(xB,yB,zB);
        this.setDesignacao(designacao); 
    }


    public void setPontoA(int x, int y, int z) {
        this.pontoA.setX(x);
        this.pontoA.setY(y);
        this.pontoA.setZ(z);
    }
    

    public void setPontoB(int x, int y, int z) {
        this.pontoB.setX(x);
        this.pontoB.setY(y);
        this.pontoB.setZ(z);
    }


    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    
    public void addSetor(Setor s){
        this.setores.add(s);
    }
    public List<Setor> getSetores(){
        return this.setores;
    }

    @Override
    public String toString() {
        return this.designacao + ": " + this.pontoA + " x " + this.pontoB;
    }
}
