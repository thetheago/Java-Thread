
# Threads Java

Este projeto é um projeto de "estudo" resolvendo 3 problemas clássicos sobre programação concorrente sendo resolvidos controlando o fluxo de threads em Java.

Os problemas são :
-
    1. Assuma que há três threads A, B e C que imprimam repetidamente as letras “A”, “B” e “C”,
    respectivamente. Use semáforos para coordenar as impressões de tal forma que o número de “C”
    impressos seja sempre menor ou igual à soma dos números de “A” e “B” já impressos.

    2. Problema do barbeiro dorminhoco: em uma barbearia há um único barbeiro (representado por um
    thread). O barbeiro corta o cabelo de clientes que aguardam para ser atendidos (cada cliente é re-
    presentado por uma thread). Se não há nenhum cliente, o barbeiro dorme. Um cliente aguarda pelo

    barbeiro se houver uma cadeira disponível na sala de espera; caso contrário, o cliente imediatamente
    deixa a barbearia. Se houver uma cadeira disponível, o cliente a ocupa (há um número limitado
    de cadeiras na sala de espera). Se o barbeiro estiver dormindo, o cliente o acorda. Assuma que
    há n cadeiras na barbearia. Escreva uma classe BarbeiroDorminhoco para sincronizar as threads
    do problema utilizando semáforos. Inclua também em sua solução classes para as demais threads e
    uma classe Principal.

        3. Escreva uma classe ContadorLimitado que tenha valores máximo e mínimo. Essa classe deve oferecer
    dois métodos: incrementa() e decrementa(). Tentativas de decremento abaixo do valor mínimo ou
    de incremento acima do valor máximo devem bloquear a thread chamadora até que a operação
    possa ser efetuada sem violar os limites estabelecidos. Resolva utilizando semáforos.

