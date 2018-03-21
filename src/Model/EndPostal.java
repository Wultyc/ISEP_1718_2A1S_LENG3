
package model;


public class EndPostal {
    private String linha1;
    private String linha2;
    private int cp_cidade;
    private int cp_rua;

    public EndPostal() {
        this.linha1 = "";
        this.linha2 = "";
        this.cp_cidade = 0;
        this.cp_rua = 0;
    }
    
    public EndPostal(String linha1, String linha2, int cp_cidade, int cp_rua) {
        this.linha1 = linha1;
        this.linha2 = linha2;
        this.cp_cidade = cp_cidade;
        this.cp_rua = cp_rua;
    }
    
    /**
     * @param linha1 the linha1 to set
     */
    public void setLinha1(String linha1) {
        this.linha1 = linha1;
    }

    /**
     * @param linha2 the linha2 to set
     */
    public void setLinha2(String linha2) {
        this.linha2 = linha2;
    }

    /**
     * @param cp_cidade the cp_cidade to set
     */
    public void setCp_cidade(int cp_cidade) {
        this.cp_cidade = cp_cidade;
    }

    /**
     * @param cp_rua the cp_rua to set
     */
    public void setCp_rua(int cp_rua) {
        this.cp_rua = cp_rua;
    }

    @Override
    public String toString() {
        String endereco = linha1;

        if(linha1.length()>0){
            endereco += "\n" + this.linha2;
        }

        endereco += this.cp_cidade + "-" + this.cp_rua;

        return endereco;
    }
}
