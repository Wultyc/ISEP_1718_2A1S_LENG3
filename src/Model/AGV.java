
package model;

import java.util.Date;


public class AGV {
    private Date dAquisicao;
    private String nSerie;
    private CatAGV cat;

    private void AGV() {
        this.dAquisicao = new Date();
        this.nSerie = "";
        this.cat = new CatAGV();
    }

    private void AGV(Date dAquisicao, String nSerie, int autonomia, int tCarga, float pMax, float AlturaM) {
        this.dAquisicao = dAquisicao;
        this.nSerie = nSerie;
        this.cat = new CatAGV(autonomia, tCarga, pMax, AlturaM);
    }


    public void setdAquisicao(Date dAquisicao) {
        this.dAquisicao = dAquisicao;
    }

    public void setnSerie(String nSerie) {

        this.nSerie = nSerie;
    }

    public void setCat(CatAGV cat) {

        this.cat = cat;
    }

    @Override
    public String toString() {
        return dAquisicao.toString() + "\t" + nSerie + "\t" + cat.getDesig();
    }
}
