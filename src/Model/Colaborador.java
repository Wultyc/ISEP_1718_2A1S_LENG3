/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author paulomaio
 */
public class Colaborador {

    private int m_iID;
    private String m_sNome;

    public Colaborador() {
    }

    public Colaborador(int iID, String sNome) {
        this.setID(iID);
        this.setNome(sNome);
    }

    /**
     * @return the m_iID
     */
    public int getID() {
        return m_iID;
    }

    /**
     * @param m_iID the m_iID to set
     */
    public final void setID(int m_iID) {
        this.m_iID = m_iID;
    }

    /**
     * @return the m_sNome
     */
    public String getNome() {
        return m_sNome;
    }

    /**
     * @param m_sNome the m_sNome to set
     */
    public final void setNome(String m_sNome) {
        this.m_sNome = m_sNome;
    }

    public boolean isIdentifiableAs(int iID) {
        return this.m_iID == iID;
    }

    @Override
    public String toString() {
        return this.m_iID + ";" + this.m_sNome + ";";
    }

}
