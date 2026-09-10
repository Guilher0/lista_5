/**
 * Exercício 10 - equals() e "==".
 * Análise de atribuição de referências compartilhadas entre objetos String.
 */
public class Exercicio10 {

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 10 — equals() e \"==\" ===");

        // Criação de um único objeto String com new
        String endereco1 = new String("Rua das Flores");
        // Copiando o valor da referência para endereco2
        String endereco2 = endereco1;

        System.out.println("Saída do código:");
        System.out.println(endereco1 == endereco2);
        System.out.println(endereco1.equals(endereco2));

        System.out.println("\n--- Respostas das Perguntas ---");
        System.out.println("a) Qual será a saída?");
        System.out.println("   true");
        System.out.println("   true");

        System.out.println("\nb) Quantos objetos String foram criados?");
        System.out.println("   Apenas 1 objeto String foi instanciado (através da única instrução 'new String(...)').");

        System.out.println("\nc) Para qual objeto endereco1 aponta?");
        System.out.println("   Aponta para o objeto String com conteúdo \"Rua das Flores\" alocado no Heap.");

        System.out.println("\nd) Para qual objeto endereco2 aponta?");
        System.out.println("   Aponta para exatamente o mesmo objeto alocado para endereco1 (\"Rua das Flores\").");

        System.out.println("\ne) Por que endereco1 == endereco2 resulta em true?");
        System.out.println("   Porque a instrução 'endereco2 = endereco1' copiou o endereço de memória contido em endereco1.");
        System.out.println("   Como o operador '==' compara os endereços referenciados, e ambas as variáveis guardam");
        System.out.println("   o mesmo endereço para o mesmo objeto no Heap, o resultado é true.");
    }
}

