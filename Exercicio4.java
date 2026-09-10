/**
 * Exercício 4 - Calculando a pontuação.
 * Prática de métodos com tipo de retorno numérico (int), devolução de valor
 * para o chamador e distinção entre imprimir na tela vs. devolver valor.
 */
public class Exercicio4 {

    /**
     * Calcula o total de pontos acumulados baseado na quantidade de inimigos e valor unitário.
     *
     * @param inimigosDerrotados quantidade de inimigos abatidos
     * @param pontosPorInimigo pontuação concedida por cada inimigo
     * @return a pontuação total calculada
     */
    public static int calcularPontos(int inimigosDerrotados, int pontosPorInimigo) {
        return inimigosDerrotados * pontosPorInimigo;
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 4 — Calculando a pontuação ===");

        // Dados do jogador
        int inimigosDerrotados = 8;
        int pontosPorInimigo = 150;

        // Chamada do método e armazenamento do resultado
        int pontuacao = calcularPontos(inimigosDerrotados, pontosPorInimigo);

        // Apresentação na tela
        System.out.println("Inimigos derrotados: " + inimigosDerrotados);
        System.out.println("Pontos por inimigo: " + pontosPorInimigo);
        System.out.println("Pontuação total obtida: " + pontuacao);

        // Desafio: verificar se atingiu 1.000 pontos sem alterar calcularPontos()
        System.out.println("\n--- Desafio: Verificação de pontuação mínima para avançar ---");
        if (pontuacao >= 1000) {
            System.out.println("Parabéns! Você passou de fase!");
        } else {
            System.out.println("Continue jogando!");
        }

        // Teste adicional com pontuação insuficiente para validar ambos os ramos
        System.out.println("\nTeste com jogador que não atingiu a meta (4 inimigos):");
        int pontuacaoMenor = calcularPontos(4, 150);
        System.out.println("Pontuação: " + pontuacaoMenor);
        if (pontuacaoMenor >= 1000) {
            System.out.println("Parabéns! Você passou de fase!");
        } else {
            System.out.println("Continue jogando!");
        }

        System.out.println("\n--- Pergunta e Explicação ---");
        System.out.println("Pergunta: O método calcularPontos() imprime a pontuação ou devolve a pontuação para quem o chamou?");
        System.out.println("          Explique a diferença entre essas duas situações.");
        System.out.println("Resposta: O método DEVOLVE (retorna) a pontuação através da instrução 'return'.");
        System.out.println("Diferença:");
        System.out.println("1. Método que apenas imprime (void): Realiza uma saída direta no terminal (efeito colateral),");
        System.out.println("   mas não entrega o valor calculado de volta. O chamador não consegue armazenar o valor em variáveis,");
        System.out.println("   nem reutilizá-lo em cálculos posteriores ou estruturas de decisão (como o 'if (pontuacao >= 1000)').");
        System.out.println("2. Método que devolve um valor (com retorno): Entrega o dado computado para quem o chamou.");
        System.out.println("   Isso garante flexibilidade, desacoplamento e reutilização de código, deixando a decisão de exibir,");
        System.out.println("   gravar em banco ou usar em regras de negócio para a camada chamadora.");
    }
}
