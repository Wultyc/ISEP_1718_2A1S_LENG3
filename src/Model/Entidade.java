/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Entidade {

    private String m_sCodigo;
    private String m_sDesignacaoComercial;
    private String m_sDesignacaoComum;
    private String m_sNIF;
    private String m_sEnderecoPostal;
    private String m_sEnderecoEletronico;
    private Colaborador m_oGestor;

    public Entidade() {
    }

    public Entidade(String sCodigo, String sDesComercial, String sDesComum, String sNIF, String sEnderecoPostal, String sEnderecoEletronico, Colaborador oColab) {
        this.setCodigo(sCodigo);
        this.setDesignacaoComercial(sDesComercial);
        this.setDesignacaoComum(sDesComum);
        this.setNIF(sNIF);
        this.setEnderecoPostal(sEnderecoPostal);
        this.setEnderecoEletronico(sEnderecoEletronico);
        this.setGestor(oColab);
    }

    /**
     * @param m_sCodigo the m_sCodigo to set
     */
    public final void setCodigo(String m_sCodigo) {
        this.m_sCodigo = m_sCodigo;
    }

    /**
     * @param m_sDesignacaoComercial the m_sDesignacaoComercial to set
     */
    public final void setDesignacaoComercial(String m_sDesignacaoComercial) {
        this.m_sDesignacaoComercial = m_sDesignacaoComercial;
    }

    /**
     * @param m_sDesignacaoComum the m_sDesignacaoComum to set
     */
    public final void setDesignacaoComum(String m_sDesignacaoComum) {
        this.m_sDesignacaoComum = m_sDesignacaoComum;
    }

    /**
     * @param m_sNIF the m_sNIF to set
     */
    public final void setNIF(String m_sNIF) {
        this.m_sNIF = m_sNIF;
    }

    /**
     * @param m_sEnderecoPostal the m_sEnderecoPostal to set
     */
    public final void setEnderecoPostal(String m_sEnderecoPostal) {
        this.m_sEnderecoPostal = m_sEnderecoPostal;
    }

    /**
     * @param m_sEnderecoEletronico the m_sEnderecoEletronico to set
     */
    public final void setEnderecoEletronico(String m_sEnderecoEletronico) {
        this.m_sEnderecoEletronico = m_sEnderecoEletronico;
    }

    /**
     * @param m_oGestor the m_oGestor to set
     */
    public final void setGestor(Colaborador m_oGestor) {
        this.m_oGestor = m_oGestor;
    }

    public final Colaborador getGestor() {
        return this.m_oGestor;
    }

    public boolean valida() {
        // Escrever aqui o código de validação

        //
        return true;
    }

    public boolean isIdentifiableAs(String sCodigo) {
        return this.m_sCodigo.equals(sCodigo);
    }

    @Override
    public String toString() {
        return this.m_sCodigo + ";" + this.m_sNIF + ";" + this.m_sDesignacaoComercial + ";" + this.m_sDesignacaoComum + ";" + this.m_sEnderecoPostal + ";" + this.m_sEnderecoEletronico + "; {" + this.m_oGestor.toString() + "};";
    }
}
