/**
 * Exercício 13 - Sobrescrita do método equals().
 * Demonstração prática e teórica da herança de java.lang.Object,
 * do comportamento padrão do equals() (que usa '==') e da necessidade de sobrescrevê-lo.
 */
public class Exercicio13 {

    /**
     * Classe que NÃO sobrescreve equals().
     * Herda a implementação padrão de Object: public boolean equals(Object obj) { return (this == obj); }
     */
    public static class AlunoPadrao {
        String matricula;
        String nome;

        public AlunoPadrao(String matricula, String nome) {
            this.matricula = matricula;
            this.nome = nome;
        }
    }

    /**
     * Classe que SOBRESCREVE equals() definindo critério próprio de igualdade baseado na matrícula.
     */
    public static class AlunoCustomizado {
        String matricula;
        String nome;

        public AlunoCustomizado(String matricula, String nome) {
            this.matricula = matricula;
            this.nome = nome;
        }

        @Override
        public boolean equals(Object obj) {
            // 1. Verifica se aponta para a mesma referência de memória
            if (this == obj) return true;
            // 2. Valida se o objeto passado é nulo ou pertence a outra classe
            if (obj == null || getClass() != obj.getClass()) return false;
            // 3. Converte para o tipo correto e compara a chave de negócio (matrícula)
            AlunoCustomizado outro = (AlunoCustomizado) obj;
            return this.matricula != null && this.matricula.equals(outro.matricula);
        }

        @Override
        public int hashCode() {
            return matricula != null ? matricula.hashCode() : 0;
        }
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 13 — Conceito e Sobrescrita do equals() ===");

        System.out.println("\n--- 1. Comportamento PADRÃO herdado de Object ---");
        AlunoPadrao a1 = new AlunoPadrao("202401", "Lucas");
        AlunoPadrao a2 = new AlunoPadrao("202401", "Lucas");
        System.out.println("a1 == a2: " + (a1 == a2) + " (Endereços diferentes)");
        System.out.println("a1.equals(a2): " + a1.equals(a2) + " (Object.equals usa internamente '==')");

        System.out.println("\n--- 2. Comportamento SOBRESCRITO com critério de negócio ---");
        AlunoCustomizado c1 = new AlunoCustomizado("202401", "Lucas");
        AlunoCustomizado c2 = new AlunoCustomizado("202401", "Lucas Silva");
        System.out.println("c1 == c2: " + (c1 == c2) + " (Continuam sendo objetos distintos no Heap)");
        System.out.println("c1.equals(c2): " + c1.equals(c2) + " (True! Sobrescrita comparou o conteúdo da matrícula)");

        System.out.println("\n--- Resumo Teórico dos Conceitos Avaliados ---");
        System.out.println("• Herança de Object: Toda classe em Java herda direta ou indiretamente de java.lang.Object.");
        System.out.println("• equals() padrão de Object: Implementado como 'this == obj', verificando apenas identidade física.");
        System.out.println("• Sobrescrita (@Override): Permite redefinir a regra para igualdade semântica/conteúdo (ex.: mesmo CPF, ID ou matrícula).");
        System.out.println("• Regra de ouro: Sempre que dois objetos diferentes precisarem ser considerados logicamente iguais por seus dados,");
        System.out.println("  o método equals() DEVE ser sobrescrito.");
    }
}

