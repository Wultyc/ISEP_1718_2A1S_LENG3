package model;

import java.util.List;

public class RegistoArmazens {
    private List<Armazem> m_lstArmazens;

    public RegistoArmazens(){

    }

    public Armazem novaArmazem() {
        return new Armazem();
    }

    public boolean validaArmazem(Armazem obj) {
        boolean bRet = false;
        if (obj.valida()) {
            // Escrever aqui o código de validação

            //
            bRet = true;
        }
        return bRet;
    }

    public boolean registaArmazem(Armazem local) {
        if (this.validaArmazem(local)) {
            return addArmazem(local);
        }
        return false;
    }

    private boolean addArmazem(Armazem local) {
        return m_lstArmazens.add(local);
    }

    public List<Armazem> getListaArmazems() {
        return this.m_lstArmazens;
    }

    public Armazem getArmazem(String sCodigo) {
        for (Armazem obj : this.m_lstArmazens) {
            if (obj.isIdentifiableAs(sCodigo)) {
                return obj;
            }
        }

        return null;
    }
}
