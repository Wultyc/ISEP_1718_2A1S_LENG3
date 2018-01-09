
package model;

import java.util.List;


public class Armazem {

    private String codUn;
    private String descr;
    private EndPostal endPostal;
    private CoordGPS coordGPS;
    private PlantaArmazem planta;
    private List<AGV> agvs;
    private Colaborador diretor;
    private List<Colaborador> chefes;

    public Armazem() {
        this.codUn = null;
        this.descr = null;
        this.endPostal = new EndPostal();
        this.coordGPS = new CoordGPS();
    }
    

    public Armazem(String codUn, String descr, String endPostalL1, String endPostalL2, int endPostal_cpCidade, int endPostal_cpRua, double latd, double longt, double altd) {
        this.codUn = codUn;
        this.descr = descr;
        this.endPostal = new EndPostal(endPostalL1, endPostalL2, endPostal_cpCidade, endPostal_cpRua);
        this.coordGPS = new CoordGPS(latd, longt, altd);
    }

    public void setCodUn(String codUn) {
        this.codUn = codUn;
    }
    
    public String getCodUn() {
        return codUn;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getDescr() {
        return descr;
    }

    public void setEndPostal(String endPostalL1, String endPostalL2, int endPostal_cpCidade, int endPostal_cpRua) {
        this.endPostal.setLinha1(endPostalL1);
        this.endPostal.setLinha2(endPostalL2);
        this.endPostal.setCp_cidade(endPostal_cpCidade);
        this.endPostal.setCp_rua(endPostal_cpRua);
    }

    public void setCoordGPS(double latd, double longt, double altd) {
        this.coordGPS.setLatitude(latd);
        this.coordGPS.setLongitude(longt);
        this.coordGPS.setAltitude(altd);
    }

    public void setPlanta(PlantaArmazem planta) {
        this.planta = planta;
    }

    public PlantaArmazem getPlanta() {
        return this.planta;
    }
    
     public void addAGV(AGV agv) {
        this.agvs.add(agv);
    }

    public List<AGV> getAGVs() {
        return this.agvs;
    }
    
    public boolean isIdentifiableAs(String sCodigo) {
        return this.codUn.equals(sCodigo);
    }

    public boolean valida() {
        return true;
    }

    @Override
    public String toString() {
        return "Codigo Unico: " + codUn + "\n Descricao: " + descr + "\n Endereco Postal: " + endPostal.toString() + "\n Coordenadas GPS: " + coordGPS.toString();
    }
}
