
package model;


public class PontoCargaDescarga {
    private PontoEspaco ponto;
    private String designacao; 
    
    public PontoCargaDescarga(){
        ponto = new PontoEspaco();
        this.setDesignacao(""); 
    }
    
    public PontoCargaDescarga(String designacao, int x, int y, int z){
        ponto = new PontoEspaco(x,y,z);
        this.setDesignacao(designacao); 
    }


    public void setPonto(int x, int y, int z) {
        this.ponto.setX(x);
        this.ponto.setY(y);
        this.ponto.setZ(z);
    }


    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @Override
    public String toString() {
        return "Designacao: " + this.designacao + "\nLocalização no Armazém: " + this.ponto.toString();
    }
}
