/**
 * Exercício 9 - equals() e "==".
 * Comparação de referências vs. comparação de conteúdo em objetos String instanciados com new.
 */
public class Exercicio9 {

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 9 — equals() e \"==\" ===");

        // Criação explícita de dois objetos distintos no Heap usando 'new'
        String casa1 = new String("Casa Azul");
        String casa2 = new String("Casa Azul");

        System.out.println("Saída do código:");
        System.out.println(casa1 == casa2);
        System.out.println(casa1.equals(casa2));

        System.out.println("\n--- Respostas das Perguntas ---");
        System.out.println("a) Qual será a saída?");
        System.out.println("   false");
        System.out.println("   true");

        System.out.println("\nb) casa1 e casa2 possuem o mesmo conteúdo?");
        System.out.println("   SIM. Ambas as Strings contêm exatamente a mesma sequência de caracteres: \"Casa Azul\".");

        System.out.println("\nc) casa1 e casa2 são o mesmo objeto?");
        System.out.println("   NÃO. Como foi utilizado o operador 'new' para cada uma, foram alocados dois objetos distintos");
        System.out.println("   em endereços de memória separados dentro do Heap.");

        System.out.println("\nd) O que o operador == está comparando nesse caso?");
        System.out.println("   O operador '==' compara as referências (endereços de memória). Ele avalia se casa1 e casa2");
        System.out.println("   apontam fisicamente para a mesma instância de objeto na memória.");

        System.out.println("\ne) O que o método equals() está comparando?");
        System.out.println("   O método 'equals()' compara o valor/conteúdo semântico dos objetos. Na classe String, o equals()");
        System.out.println("   foi sobrescrito para verificar se os caracteres de ambas as cadeias de texto são idênticos.");
    }
}

