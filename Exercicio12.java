/**
 * Exercício 12 - equals() e "==".
 * Reatribuição de referências e análise de objetos que perdem todas as suas referências (Garbage Collection).
 */
public class Exercicio12 {

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 12 — equals() e \"==\" ===");

        String cidade1 = new String("Gurupi");
        String cidade2 = new String("Palmas");

        // Reatribuição: cidade2 passa a apontar para o objeto referenciado por cidade1
        cidade2 = cidade1;

        System.out.println("Saída do código:");
        System.out.println(cidade1 == cidade2);
        System.out.println(cidade1.equals(cidade2));

        System.out.println("\n--- Respostas das Perguntas ---");
        System.out.println("a) Para qual objeto cidade1 aponta?");
        System.out.println("   Aponta para o objeto String contendo o texto \"Gurupi\".");

        System.out.println("\nb) Para qual objeto cidade2 aponta depois de cidade2 = cidade1?");
        System.out.println("   Passa a apontar para o mesmíssimo objeto referenciado por cidade1 (com texto \"Gurupi\").");

        System.out.println("\nc) Qual será a saída?");
        System.out.println("   true");
        System.out.println("   true");

        System.out.println("\nd) O objeto \"Palmas\" continua existindo após a atribuição? Explique considerando as referências.");
        System.out.println("   SIM, temporariamente ele ainda ocupa espaço na memória Heap, mas nenhuma variável de referência");
        System.out.println("   do programa aponta mais para ele (ficou órfão/inacessível). Com isso, torna-se elegível para ser");
        System.out.println("   coletado e destruído pelo Garbage Collector da JVM na próxima execução da limpeza de memória.");

        System.out.println("\ne) A instrução cidade2 = cidade1 copia o objeto ou copia a referência?");
        System.out.println("   Copia unicamente a REFERÊNCIA (o endereço de memória). O objeto em si não é duplicado.");
    }
}

