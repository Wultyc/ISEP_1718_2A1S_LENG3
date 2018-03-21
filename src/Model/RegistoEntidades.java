package model;

import java.util.ArrayList;
import java.util.List;

public class RegistoEntidades {
    private List<Entidade> m_lstEntidades;

    public RegistoEntidades(){

    }

    public Entidade novaEntidade() {
        return new Entidade();
    }

    public boolean validaEntidade(Entidade obj) {
        boolean bRet = false;
        if (obj.valida()) {
            // Escrever aqui o código de validação

            //
            bRet = true;
        }
        return bRet;
    }

    public boolean registaEntidade(Entidade local) {
        if (this.validaEntidade(local)) {
            return addEntidade(local);
        }
        return false;
    }

    private boolean addEntidade(Entidade local) {
        return m_lstEntidades.add(local);
    }

    public List<Entidade> getListaEntidades() {
        return this.m_lstEntidades;
    }

    public Entidade getEntidade(String sCodigo) {
        for (Entidade obj : this.m_lstEntidades) {
            if (obj.isIdentifiableAs(sCodigo)) {
                return obj;
            }
        }

        return null;
    }

    public ArrayList getEntidades(Colaborador clb) {

        ArrayList<Entidade> entidades = new ArrayList<Entidade>();

        for (Entidade obj : this.m_lstEntidades) {
            if (obj.getGestor().getID() == clb.getID()) {
                entidades.add(obj);
            }
        }

        return entidades;
    }
}
