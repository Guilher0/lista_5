/**
 * Exercício 2 - Troca de valores.
 * Demonstração da impossibilidade de trocar primitivos diretamente por passagem por valor
 * e formas idiomáticas em Java para realizar a troca (usando array como estrutura mutável).
 */
public class Exercicio2 {

    /**
     * Tenta trocar os valores de duas variáveis inteiras recebidas por parâmetro.
     * Como a passagem é por valor (cópia), a inversão ocorre apenas nas variáveis locais do método.
     *
     * @param a primeira variável
     * @param b segunda variável
     */
    public static void trocar(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("  [trocar] Valores internos ao método: a = " + a + ", b = " + b);
    }

    /**
     * Solução para o Desafio: troca os elementos nas posições 0 e 1 de um array.
     * Como o array é um objeto, o método recebe a referência para o array,
     * permitindo que as alterações nas posições reflitam no chamador.
     *
     * @param valores array contendo ao menos dois inteiros
     */
    public static void trocarNoArray(int[] valores) {
        int temp = valores[0];
        valores[0] = valores[1];
        valores[1] = temp;
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 2 — Troca de valores ===");

        int a = 10;
        int b = 20;

        System.out.println("Valores ANTES da chamada de trocar(a, b):");
        System.out.println("a = " + a + ", b = " + b);

        trocar(a, b);

        System.out.println("Valores DEPOIS da chamada de trocar(a, b):");
        System.out.println("a = " + a + ", b = " + b);

        System.out.println("\n--- Desafio: Conseguir a troca efetiva de valores ---");
        System.out.println("Em Java, para que um método altere valores de quem o chamou,");
        System.out.println("utilizamos uma estrutura de objeto ou array:");

        int[] par = {10, 20};
        System.out.println("Array antes: a = " + par[0] + ", b = " + par[1]);
        trocarNoArray(par);
        a = par[0];
        b = par[1];
        System.out.println("Array depois: a = " + a + ", b = " + b);

        System.out.println("\n--- Pergunta e Explicação ---");
        System.out.println("Pergunta: É possível realizar essa troca diretamente usando passagem por valor em Java? Explique.");
        System.out.println("Resposta: NÃO. Em Java não existe passagem por referência de variáveis primitivas (como em C++ com ponteiros ou referências '&').");
        System.out.println("O método trocar(int a, int b) recebe cópias independentes dos valores das variáveis locais do main().");
        System.out.println("Qualquer atribuição feita aos parâmetros modifica apenas as variáveis da moldura de pilha de trocar().");
        System.out.println("Para trocar os valores no chamador, deve-se usar um array, um objeto que encapsule os valores,");
        System.out.println("ou retornar os novos valores calculados.");
    }
}

