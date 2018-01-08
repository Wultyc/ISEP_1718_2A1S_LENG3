
package model;

import java.util.List;


public class PlantaArmazem {

    /**
     * @param corredores the corredores to set
     */
    public void setCorredores(List<CorredorArmazem> corredores) {
        this.corredores = corredores;
    }
    private int comprimento;
    private int largura;
    private int altura;
    private List<PontoCargaDescarga> pontosCargaDescarga;
    private List<EspacoArmazem> espacos;
    private List<CorredorArmazem> corredores;
    
    public PlantaArmazem(){
        this.setComprimento(0);
        this.setLargura(0);
        this.setAltura(0);
        this.pontosCargaDescarga = null;
        this.espacos = null;
    }


    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }


    public void setLargura(int largura) {
        this.largura = largura;
    }


    public void setAltura(int altura) {
        this.altura = altura;
    }


    public void addPontosCargaDescarga(PontoCargaDescarga pontosCargaDescarga) {
        this.pontosCargaDescarga.add(pontosCargaDescarga);
    }


    public void addEspacos(EspacoArmazem espacos) {
        this.espacos.add(espacos);
    }

    public void addCorredores(CorredorArmazem corredor) {
        this.corredores.add(corredor);
    }
    public List<CorredorArmazem> getCorredores() {
        return this.corredores;
    }
}
