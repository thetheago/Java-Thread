Escreva uma classe ContadorLimitado que tenha valores máximo e mínimo. Essa classe deve oferecer
dois métodos: incrementa() e decrementa(). Tentativas de decremento abaixo do valor mínimo ou
de incremento acima do valor máximo devem bloquear a thread chamadora até que a operação
possa ser efetuada sem violar os limites estabelecidos. Resolva utilizando semáforos.