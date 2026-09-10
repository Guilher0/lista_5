/**
 * Exercício 3 - O Cofre Digital.
 * Prática de métodos com tipo de retorno boolean, palavra-chave return
 * e uso direto do retorno em expressões condicionais.
 */
public class Exercicio3 {

    /**
     * Valida a senha numérica de acesso ao cofre.
     *
     * @param senhaDigitada senha numérica informada pelo usuário
     * @return true se a senha for 1234, false caso contrário
     */
    public static boolean verificarSenha(int senhaDigitada) {
        return senhaDigitada == 1234;
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 3 — O Cofre Digital ===");

        // 1. Cria uma variável senha contendo 1234
        int senha = 1234;

        // --- Etapa 1: Armazenando o retorno na variável 'acesso' ---
        System.out.println("--- Etapa 1: Utilizando a variável 'acesso' ---");
        // 2. Chama o método verificarSenha()
        // 3. Armazena o valor retornado em uma variável chamada acesso
        boolean acesso = verificarSenha(senha);

        // 4. Exibição condicional
        if (acesso) {
            System.out.println("Acesso liberado!");
        } else {
            System.out.println("Senha incorreta!");
        }

        // Teste com senha incorreta
        int senhaIncorreta = 9999;
        boolean acessoNegado = verificarSenha(senhaIncorreta);
        System.out.println("Teste com senha 9999:");
        if (acessoNegado) {
            System.out.println("Acesso liberado!");
        } else {
            System.out.println("Senha incorreta!");
        }

        // --- Desafio: Usando o retorno diretamente dentro do if ---
        System.out.println("\n--- Desafio: Chamada direta dentro da condição if ---");
        if (verificarSenha(senha)) {
            System.out.println("Acesso liberado! (verificado diretamente no if sem variável intermediária)");
        } else {
            System.out.println("Senha incorreta!");
        }

        System.out.println("\n--- Conclusão pedagógica ---");
        System.out.println("O valor de retorno de um método que devolve boolean é avaliado como uma expressão booleana válida,");
        System.out.println("eliminando a necessidade de variáveis temporárias intermediárias quando não forem reutilizadas.");
    }
}
