/**
 * Exercício 11 - equals() e "==".
 * Comparação cruzada entre instâncias distintas com o mesmo texto e referências copiadas.
 */
public class Exercicio11 {

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 11 — equals() e \"==\" ===");

        String proprietario1 = new String("Carlos");
        String proprietario2 = new String("Carlos");
        String proprietario3 = proprietario1;

        System.out.println("Saída das quatro linhas:");
        System.out.println(proprietario1 == proprietario2);
        System.out.println(proprietario1 == proprietario3);
        System.out.println(proprietario1.equals(proprietario2));
        System.out.println(proprietario2.equals(proprietario3));

        System.out.println("\n--- Respostas das Perguntas ---");
        System.out.println("a) Qual será a saída das quatro linhas?");
        System.out.println("   false");
        System.out.println("   true");
        System.out.println("   true");
        System.out.println("   true");

        System.out.println("\nb) Quais referências apontam para o mesmo objeto?");
        System.out.println("   proprietario1 e proprietario3 (ambas compartilham o endereço do primeiro objeto criado).");

        System.out.println("\nc) Quais referências apontam para objetos diferentes?");
        System.out.println("   proprietario1 e proprietario2 (são dois objetos distintos alocados com new);");
        System.out.println("   e proprietario2 e proprietario3 (pois proprietario3 aponta para o mesmo que proprietario1).");

        System.out.println("\nd) Qual comparação verifica se os objetos são o mesmo objeto?");
        System.out.println("   As comparações feitas com o operador de igualdade de referências '==':");
        System.out.println("   (proprietario1 == proprietario2) e (proprietario1 == proprietario3).");

        System.out.println("\ne) Qual comparação verifica se os objetos possuem o mesmo conteúdo?");
        System.out.println("   As comparações feitas com o método 'equals()':");
        System.out.println("   (proprietario1.equals(proprietario2)) e (proprietario2.equals(proprietario3)).");
    }
}

