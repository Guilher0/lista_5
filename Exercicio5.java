/**
 * Exercício 5 - A casa mudou de dono e de tamanho.
 * Demonstração da passagem de objetos por valor em Java (cópia da referência).
 * Explicação da diferença entre alterar o estado de um objeto e tentar reatribuir a referência.
 */
public class Exercicio5 {

    /**
     * Classe modelo que representa uma Casa.
     */
    public static class Casa {
        String proprietario;
        int quartos;
    }

    /**
     * Modifica os atributos do objeto Casa referenciado.
     * Como o método recebe uma cópia do endereço de memória do objeto,
     * as modificações em seus atributos afetam o mesmo objeto existente na Heap.
     *
     * @param casa referência para o objeto Casa
     */
    public static void modificarCasa(Casa casa) {
        casa.quartos = casa.quartos + 2;
        casa.proprietario = "Ana";
    }

    /**
     * Demonstração do Desafio: tentativa de substituir a referência recebida.
     *
     * @param casa referência recebida
     */
    public static void modificarCasaComReatribuicao(Casa casa) {
        // Cria um novo objeto na memória Heap e aponta a variável local 'casa' para ele
        casa = new Casa();
        casa.proprietario = "João";
        casa.quartos = 10;
        System.out.println("  [Dentro do método do desafio] Novo objeto local:");
        System.out.println("  Proprietário: " + casa.proprietario + " | Quartos: " + casa.quartos);
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 5 — A casa mudou de dono e de tamanho ===");

        // 1. Cria uma casa
        Casa minhaCasa = new Casa();

        // 2 e 3. Define os atributos iniciais
        minhaCasa.proprietario = "Carlos";
        minhaCasa.quartos = 3;

        // 4. Exibe os dados antes da alteração
        System.out.println("Antes:");
        System.out.println("Proprietário: " + minhaCasa.proprietario);
        System.out.println("Quartos: " + minhaCasa.quartos);

        // 5. Chama modificarCasa(), passando a casa como argumento
        modificarCasa(minhaCasa);

        // 6. Exibe os dados depois da alteração
        System.out.println("\nDepois:");
        System.out.println("Proprietário: " + minhaCasa.proprietario);
        System.out.println("Quartos: " + minhaCasa.quartos);

        // Demonstração do Desafio
        System.out.println("\n--- Execução do Desafio (casa = new Casa()) ---");
        System.out.println("Chamando método que instancia um novo objeto dentro do escopo local...");
        modificarCasaComReatribuicao(minhaCasa);
        System.out.println("Objeto original do main após a tentativa de reatribuição:");
        System.out.println("Proprietário: " + minhaCasa.proprietario + " (Permanece Ana)");
        System.out.println("Quartos: " + minhaCasa.quartos + " (Permanece 5)");

        System.out.println("\n--- Questão para Reflexão e Desafio ---");
        System.out.println("1. Por que as alterações (quartos + 2 e proprietario = 'Ana') são percebidas no main()?");
        System.out.println("   R: Porque o Java passa a referência por valor. Isso significa que o método modificarCasa()");
        System.out.println("   recebeu uma cópia do endereço que aponta para o mesmo objeto 'Casa' alocado no Heap.");
        System.out.println("   Ao acessar casa.quartos ou casa.proprietario, o método navega até o objeto real compartilhado");
        System.out.println("   e altera seu estado interno.");
        System.out.println("\n2. Por que a casa original do main() NÃO passa a ter 'João' e 10 quartos no desafio?");
        System.out.println("   R: A instrução 'casa = new Casa()' faz com que a variável local 'casa' do método aponte");
        System.out.println("   para uma nova instância criada no Heap. Essa reatribuição afeta unicamente o ponteiro local");
        System.out.println("   do método. A variável 'minhaCasa' do main() continua apontando para o objeto original.");
    }
}
