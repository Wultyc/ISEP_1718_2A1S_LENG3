
package model;


public class EspacoArmazem {
    private PontoEspaco pontoA;
    private PontoEspaco pontoB;
    private String designacao; 
    
    public EspacoArmazem(){
        pontoA = new PontoEspaco();
        pontoB = new PontoEspaco();
        this.setDesignacao(""); 
    }
    
    public EspacoArmazem(String designacao, int xA, int yA, int zA, int xB, int yB, int zB){
        pontoA = new PontoEspaco(xA,yA,zA);
        pontoB = new PontoEspaco(xB,yB,zB);
        this.setDesignacao(designacao); 
    }

    /**
     * @param pontoA the ponto to set
     */
    public void setPontoA(int x, int y, int z) {
        this.pontoA.setX(x);
        this.pontoA.setY(y);
        this.pontoA.setZ(z);
    }
    
    /**
     * @param pontoB the ponto to set
     */
    public void setPontoB(int x, int y, int z) {
        this.pontoB.setX(x);
        this.pontoB.setY(y);
        this.pontoB.setZ(z);
    }

    /**
     * @param designacao the designacao to set
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @Override
    public String toString() {
        return this.designacao + ": " + this.pontoA + " x " + this.pontoB;
    }
}
