/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author jorge
 */
public class Armazem {
    private String codUn;
    private String descr;
    private EndPostal endPostal;
    private CoordGPS coordGPS;
    private PlantaArmazem planta;
    private List<AGV> agvs;
    private Colaborador diretor;
    private List<Colaborador> chefes;

    public void Armazem(){
        this.codUn = null;
        this.descr = null;
        this.endPostal = new EndPostal();
        this.coordGPS = new CoordGPS();
    }
    
    public void Armazem(String codUn, String descr, String endPostalL1, String endPostalL2, int endPostal_cpCidade, int endPostal_cpRua, int latd, int longt, int altd){
        this.codUn = codUn;
        this.descr = descr;
        this.endPostal = new EndPostal(endPostalL1, endPostalL2, endPostal_cpCidade, endPostal_cpRua);
        this.coordGPS = new CoordGPS(latd, longt, altd);
    }
    
    public void setCodUn(String codUn) {
        this.codUn = codUn;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setEndPostal(String endPostalL1, String endPostalL2, int endPostal_cpCidade, int endPostal_cpRua) {
        this.endPostal.setLinha1(endPostalL1);
        this.endPostal.setLinha2(endPostalL2);
        this.endPostal.setCp_cidade(endPostal_cpCidade);
        this.endPostal.setCp_rua(endPostal_cpRua);
    }

    public void setCoordGPS(int latd, int longt, int altd) {
        this.coordGPS.setLatitude(latd);
        this.coordGPS.setLongitude(longt);
        this.coordGPS.setAltitude(altd);
    }

    public boolean isIdentifiableAs(String sCodigo) {
        return this.codUn.equals(sCodigo);
    }

    public boolean valida(){
        return true;
    }

    @Override
    public String toString() {
        return "Codigo Unico: " + codUn + "\n Descricao: " + descr + "\n Endereco Postal: " + endPostal.toString() + "\n Coordenadas GPS: " + coordGPS.toString();
    }
}
