/**
 * Exercício 6 - A troca de controle.
 * Análise de rastreamento de referências e mutação de estado de objetos em chamadas de métodos.
 */
public class Exercicio6 {

    /**
     * Classe modelo que representa o controle de um jogador.
     */
    public static class Controle {
        String jogador;
    }

    /**
     * Demonstra a reatribuição da referência local 'a' para onde 'b' aponta,
     * seguida pela alteração do atributo do objeto compartilhado.
     *
     * @param a referência local que recebe o endereço do objeto de c1
     * @param b referência local que recebe o endereço do objeto de c2
     */
    public static void trocar(Controle a, Controle b) {
        // 'a' deixa de apontar para o objeto de c1 e passa a apontar para o objeto de c2
        a = b;

        // Modifica o atributo do objeto apontado por 'a' (que é o mesmo de c2)
        a.jogador = "Carlos";
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 6 — A troca de controle ===");

        Controle c1 = new Controle();
        Controle c2 = new Controle();

        c1.jogador = "Maria";
        c2.jogador = "João";

        System.out.println("Valores antes de trocar(c1, c2):");
        System.out.println("c1.jogador = " + c1.jogador);
        System.out.println("c2.jogador = " + c2.jogador);

        // Execução do método
        trocar(c1, c2);

        System.out.println("\nValores após trocar(c1, c2):");
        System.out.println("c1.jogador = " + c1.jogador);
        System.out.println("c2.jogador = " + c2.jogador);

        System.out.println("\n--- Respostas das Perguntas ---");
        System.out.println("a) Qual será o resultado?");
        System.out.println("   c1.jogador: Maria");
        System.out.println("   c2.jogador: Carlos");

        System.out.println("\nb) Por que c1 não passou a apontar para o mesmo objeto que c2, mesmo tendo sido executado 'a = b;'?");
        System.out.println("   R: Porque os parâmetros 'a' e 'b' são variáveis locais na pilha de execução do método trocar(),");
        System.out.println("   contendo cópias dos valores das referências c1 e c2. A atribuição 'a = b' altera unicamente a variável");
        System.out.println("   local 'a'. A variável c1 do método main() não sofre nenhuma alteração e continua apontando");
        System.out.println("   para o seu objeto original ('Maria').");

        System.out.println("\nc) Por que, mesmo assim, o valor de c2.jogador foi alterado para 'Carlos'?");
        System.out.println("   R: Após 'a = b;', a variável local 'a' passou a conter o endereço do objeto de c2.");
        System.out.println("   Ao fazer 'a.jogador = \"Carlos\";', a alteração foi aplicada diretamente na instância daquele");
        System.out.println("   objeto na memória Heap. Como a referência 'c2' do main() aponta para esse exato objeto,");
        System.out.println("   a alteração é refletida ao consultar c2.jogador.");
    }
}
