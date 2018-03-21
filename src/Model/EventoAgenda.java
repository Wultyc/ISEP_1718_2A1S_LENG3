package model;

import java.util.Date;

public class EventoAgenda {
    private Date data_hora;
    private PontoCargaDescarga pCargaDescarga;
    private String docExterno;
    private LocalEntregaLevantamento localOrigemDestino;
    private int qnt;

    public EventoAgenda(){
        this.setData_hora(null);
        this.setpCargaDescarga(null);
        this.setDocExterno(null);
        this.setLocalOrigemDestino(null);
        this.setQnt(0);
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public PontoCargaDescarga getpCargaDescarga() {
        return pCargaDescarga;
    }

    public void setpCargaDescarga(PontoCargaDescarga pCargaDescarga) {
        this.pCargaDescarga = pCargaDescarga;
    }

    public String getDocExterno() {
        return docExterno;
    }

    public void setDocExterno(String docExterno) {
        this.docExterno = docExterno;
    }

    public LocalEntregaLevantamento getLocalOrigemDestino() {
        return localOrigemDestino;
    }

    public void setLocalOrigemDestino(LocalEntregaLevantamento localOrigemDestino) {
        this.localOrigemDestino = localOrigemDestino;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    @Override
    public String toString() {
        return "Data: " + this.data_hora + "\nPonto de Carga/Descarga" + this.pCargaDescarga.toString() + "\nLocal de Origem" + this.localOrigemDestino.toString() + "\nReferencia de Documento Externo: " + this.docExterno + "\nQuantidade: " + this.qnt;
    }
}
