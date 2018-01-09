
package model;

import java.util.Date;


public class AGV {
    private Date dAquisicao;
    private String nSerie;
    private CatAGV cat;

    public AGV() {
        this.dAquisicao = new Date();
        this.nSerie = "";
        this.cat = new CatAGV();
    }

    public AGV(Date dAquisicao, String nSerie, int autonomia, int tCarga, double pMax, double AlturaM, double velocidade) {
        this.dAquisicao = dAquisicao;
        this.nSerie = nSerie;
        this.cat = new CatAGV(autonomia, tCarga, pMax, AlturaM, velocidade);
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
        return getnSerie() + "\t" + getdAquisicao().toGMTString();
    }

    /**
     * @return the dAquisicao
     */
    public Date getdAquisicao() {
        return dAquisicao;
    }

    /**
     * @return the nSerie
     */
    public String getnSerie() {
        return nSerie;
    }

    /**
     * @return the cat
     */
    public CatAGV getCat() {
        return cat;
    }
}
