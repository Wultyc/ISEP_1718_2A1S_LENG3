

package model;


public class CatAGV {
    private String desig;
    private int autonomia;
    private int tCarga;
    private double pMax;
    private double AlturaM;
    private double velocidade;

       
    public CatAGV(){
        this.setAutonomia(0);
        this.settCarga(0);
        this.setpMax(0);
        this.setAlturaM(0);
    }
    
    public CatAGV(int autonomia, int tCarga, double pMax, double AlturaM, double velocidade){
        this.setAutonomia(autonomia);
        this.settCarga(tCarga);
        this.setpMax(pMax);
        this.setAlturaM(AlturaM);
        this.setVelocidade(velocidade);
    }


    public void setDesig(String desig) {
        this.desig = desig;
    }


    public String getDesig() {
        return this.desig;
    }


    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }


    public void settCarga(int tCarga) {
        this.tCarga = tCarga;
    }


    public void setpMax(double pMax) {
        this.pMax = pMax;
    }


    public void setAlturaM(double AlturaM) {
        this.AlturaM = AlturaM;
    }
    
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }


    public double getVelocidade() {
        return this.velocidade;
    }

    @Override
    public String toString() {
        return "Designacao: " + this.desig + "\nAutonomia: " + this.autonomia + "h\nTempo de Carga: " + this.tCarga + "h\nPeso Max: " + this.pMax + "Kg\nAltura Max: " + this.AlturaM + "m";
    }
}
