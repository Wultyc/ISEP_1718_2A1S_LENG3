# parâmetros
param n;
param t;
param p{i in 1..n};
param r{i in 1..n};
param m{i in 1..n};

# variáveis
var x {i in 1..n} integer  >=0;
# função objetivo
maximize lucro: sum {i in 1..n} p[i]*x[i];

# restrições
subject to TempDisp: 
sum{i in 1..n} (1/r[i])*x[i]<=t;
subject to  ProcMax {i in 1..n}: 
x[i]<=m[i];