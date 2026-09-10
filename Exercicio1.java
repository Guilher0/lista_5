/**
 * Exercício 1 - Dobro de um número.
 * Demonstração do comportamento de passagem por valor em tipos primitivos e escopo de variáveis.
 */
public class Exercicio1 {

    /**
     * Dobra o valor do parâmetro recebido dentro do escopo local do método.
     * Como int é um tipo primitivo em Java, o método recebe uma cópia do valor,
     * não alterando a variável original no chamador.
     *
     * @param numero valor inteiro a ser dobrado localmente
     */
    public static void dobrar(int numero) {
        System.out.println("  [dobrar] Valor recebido no método: " + numero);
        numero = numero * 2;
        System.out.println("  [dobrar] Valor após dobrar dentro do método: " + numero);
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 1 — Dobro de um número ===");

        // 1. Cria uma variável numero com o valor 10
        int numero = 10;

        // 3. Imprime o valor antes da chamada
        System.out.println("Valor de numero ANTES da chamada: " + numero);

        // 2. Passa numero como argumento para dobrar()
        dobrar(numero);

        // 3. Imprime o valor depois da chamada
        System.out.println("Valor de numero DEPOIS da chamada: " + numero);

        System.out.println("\n--- Pergunta e Explicação ---");
        System.out.println("Pergunta: O valor de numero será alterado após a execução de dobrar()? Explique o motivo.");
        System.out.println("Resposta: NÃO. Em Java, todos os tipos primitivos são passados estritamente por valor.");
        System.out.println("Ao chamar dobrar(numero), uma cópia independente do valor 10 é colocada na pilha de execução");
        System.out.println("do método. A multiplicação afeta exclusivamente o parâmetro local do método dobrar().");
        System.out.println("A variável 'numero' declarada no método main() permanece intacta com seu valor original (10).");
    }
}

