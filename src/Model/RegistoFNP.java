package model;

import java.util.List;

public class RegistoFNP {
    private List<FNP> m_lstFNPs;

    public RegistoFNP(){

    }

    public FNP novaFNP() {
        return new FNP();
    }

    public boolean validaFNP(FNP obj) {
        boolean bRet = false;
        if (obj.valida()) {
            // Escrever aqui o código de validação

            //
            bRet = true;
        }
        return bRet;
    }

    public boolean registaFNP(FNP local) {
        if (this.validaFNP(local)) {
            return addFNP(local);
        }
        return false;
    }

    private boolean addFNP(FNP local) {
        return m_lstFNPs.add(local);
    }

    public List<FNP> getListaFNPs() {
        return this.m_lstFNPs;
    }

    public FNP getFNP(String sCodigo) {
        for (FNP obj : this.m_lstFNPs) {
            if (obj.isIdentifiableAs(sCodigo)) {
                return obj;
            }
        }

        return null;
    }
}
