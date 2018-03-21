package model;

public class Setor {

    private String designacao;
    private Ocupacao estado;

    public Setor() {
        this.setDesignacao("");
        this.setEstado(new Ocupacao());
    }

    public Setor(String desig, Ocupacao estado) {
        this.setDesignacao(desig);
        this.setEstado(estado);
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Ocupacao getEstado() {
        return estado;
    }

    public void setEstado(Ocupacao estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Designação: " + this.designacao + "\n" + this.estado.toString();
    }
}
