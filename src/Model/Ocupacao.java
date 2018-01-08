package model;

import java.util.Date;

public class Ocupacao {

    /**
     * @return the data_hora
     */
    public Date getData_hora() {
        return data_hora;
    }

    /**
     * @param data_hora the data_hora to set
     */
    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }
    private boolean ocupado;
    private FNP produto;
    private Date data_hora;

    public Ocupacao(){
        this.setOcupado(false);
        this.setProduto(null);
    }


    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public FNP getProduto() {
        return produto;
    }

    public void setProduto(FNP produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {

        String return_str;

        if(this.ocupado){
            return_str = "Estado: Ocupado\nFNP:" + this.produto.toString() + "\nData de Ocupação: " + this.getData_hora();
        } else{
            return_str = "Estado: Livre";
        }

        return return_str;
    }
}