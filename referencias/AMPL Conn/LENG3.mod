# parâmetros  
param I; #Numero de posições na baia
param J; #Numero de baias
param K; #Numero de niveis
param trec; #tempo de recolha
param tsub; #tempo de subida
param tdes; #tempo de descarga
param vagv; #velocidade do agv
param da; #distância do ponto de recolha à baia 
param N; #Tamanho da encomenda 
param A {i in 1 .. I, j in 1 .. J, k in 1 .. K}; #Ocupação incial do armazem
param v {i in 1 .. I, j in 1 .. J, k in 1 .. K}; #Validade dos produtos

#variáveis 
var x {i in 1 .. I, j in 1 .. J, k in 1 .. K} binary;
var y {i in 1 .. I, j in 1 .. J} binary;

#função objetivo
minimize V : sum {i in 1 .. 20} sum {j in 1..2} sum {k in 1..3} (v[i,j,k] * x[i,j,k]);
minimize W : sum {i in 1 .. 20} sum {j in 1..2} y[i,j];
minimize Z : sum {i in 1 .. 20} sum {j in 1..2} sum {k in 1..3} (2*(da + i)/vagv + trec + (k-1)*tsub + tdes) * x[i,j,k];

#restrições 
subject to stock {i in 1 .. 20, j in 1..2, k in 1..3}:
 x[i,j,k] <= A[i,j,k];
 
subject to tamanhoEcomenda: 
 sum {i in 1 .. 20} sum {j in 1..2} sum {k in 1..3} x[i,j,k] >= N;
 
subject to posicoesSelecionadas {i in 1 .. 20, j in 1..2}:
 3*y[i,j] >= sum {k in 1..3} A[i,j,k] - sum {k in 1..3} x[i,j,k];

