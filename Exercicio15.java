import java.util.Objects;

/**
 * Exercício 15 - Ingressos de cinema.
 * Sobrescrita do equals() na classe Ingresso com critério de igualdade baseado no número da poltrona.
 */
public class Exercicio15 {

    /**
     * Representa um ingresso de cinema com filme e número do assento.
     */
    public static class Ingresso {
        String filme;
        int numero;

        public Ingresso(String filme, int numero) {
            this.filme = filme;
            this.numero = numero;
        }

        /**
         * Dois ingressos são considerados iguais se possuírem o mesmo número de assento.
         *
         * @param obj objeto a ser comparado
         * @return true se o número for igual, false caso contrário
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Ingresso outro = (Ingresso) obj;
            return this.numero == outro.numero;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numero);
        }
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 15 — Ingressos de cinema ===");

        Ingresso i1 = new Ingresso("Avatar", 25);
        Ingresso i2 = new Ingresso("Interestelar", 25);
        Ingresso i3 = new Ingresso("Avatar", 30);

        System.out.println("Testes com ingressos originais:");
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(i3));

        System.out.println("\n--- Simulação da pergunta (d): Mudando número de i2 para 30 ---");
        i2.numero = 30;
        System.out.println("i1 == i2: " + (i1 == i2));
        System.out.println("i1.equals(i2): " + i1.equals(i2));
        System.out.println("i1.equals(i3): " + i1.equals(i3));
        System.out.println("i2.equals(i3): " + i2.equals(i3) + " (Passou a retornar true!)");

        // Retorna para o valor original para documentação
        i2.numero = 25;

        System.out.println("\n--- Questões de Fixação ---");
        System.out.println("a) Qual será a saída inicial?");
        System.out.println("   false");
        System.out.println("   true");
        System.out.println("   false");

        System.out.println("\nb) Por que i1 == i2 e i1.equals(i2) podem apresentar resultados diferentes?");
        System.out.println("   Porque 'i1 == i2' compara os endereços de memória dos dois objetos (e como foram criados separadamente");
        System.out.println("   com 'new', são instâncias distintas, dando false). Já 'i1.equals(i2)' executa o método sobrescrito,");
        System.out.println("   que compara o valor do atributo 'numero' (ambos valem 25, resultando em true).");

        System.out.println("\nc) Qual é o critério usado para considerar dois ingressos iguais?");
        System.out.println("   O número do ingresso (atributo 'numero'), independentemente do filme.");

        System.out.println("\nd) Se o número de i2 mudar para 30, quais comparações passarão a retornar true?");
        System.out.println("   A comparação entre i2 e i3 (ou seja, i2.equals(i3) ou i3.equals(i2)) passará a retornar true,");
        System.out.println("   pois ambos terão número 30. Entre as 3 linhas originais do teste, i1.equals(i2) se tornará false.");

        System.out.println("\ne) Qual é a vantagem de sobrescrever equals() nesse sistema?");
        System.out.println("   Permite identificar duplicidade de assentos de forma simples e segura, evitando que o mesmo lugar");
        System.out.println("   seja vendido duas vezes, além de viabilizar o uso de estruturas como Set, List.contains() e List.remove().");

        System.out.println("\nf) Por que o equals() padrão de Object não seria adequado para esse critério de igualdade?");
        System.out.println("   O equals() padrão herdado de Object apenas verifica se duas variáveis apontam para o mesmo objeto no Heap.");
        System.out.println("   Ele consideraria dois ingressos com o mesmo número como objetos diferentes, falhando em detectar a colisão de assentos.");
    }
}
