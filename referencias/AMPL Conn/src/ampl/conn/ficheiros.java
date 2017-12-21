/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ampl.conn;


public class ficheiros {
    public static String getModel(){
        return "# parâmetros"
                + "param n;"
                + "param t;"
                + "param p{i in 1..n};"
                + "param r{i in 1..n};"
                + "param m{i in 1..n};"
                + ""
                + "# variáveis"
                + "var x {i in 1..n} integer  >=0;"
                + "# função objetivo"
                + "maximize lucro: sum {i in 1..n} p[i]*x[i];"
                + ""
                + "# restrições"
                + "subject to TempDisp: "
                + "sum{i in 1..n} (1/r[i])*x[i]<=t;"
                + "subject to  ProcMax {i in 1..n}: "
                + "x[i]<=m[i];";
    }
    
    public static String getData(){
        return "# número de sabores"
                + "param n := 4;"
                + "# tempo trabalho/semana"
                + "param t := 40; "
                + "# lucro por pacote do tipo i"
                + "param p := 1 1 2 1.5 3 1 4 1.5;"
                + "# taxa de produção de pacotes do tipo i"
                + "param r := 1 40 2 30 3 50 4 20; "
                + "# máxima procura de pacotes do tipo i"
                + "param m := 1 1000 2 900 3 500 4 800;";
    }
    
    public static String getRun(){
        return "expand; # verifica modelo com dados"
                + "solve; # resolve"
                + "# vê resultados obtidos"
                + "display lucro;"
                + "display x;"
                + "expand TempDisp;"
                + "display TempDisp.slack, TempDisp.ub;"
                + "expand ProcMax;"
                + "display ProcMax.slack, ProcMax.ub;";
    }
}
