/**
 * Exercício 8 - Rastreamento e ciclo de vida de referências.
 * Exercícios conceituais, Verdadeiro ou Falso, e simulação de múltiplas atribuições em cadeia.
 */
public class Exercicio8 {

    /**
     * Classe modelo que representa uma Casa com proprietário.
     */
    public static class Casa {
        String proprietario;

        public Casa(String proprietario) {
            this.proprietario = proprietario;
        }

        @Override
        public String toString() {
            return "Casa(" + proprietario + ")";
        }
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 8 — Rastreamento Completo de Referências ===");

        // Criação inicial dos 5 objetos
        Casa c1 = new Casa("Ana");       // Objeto A
        Casa c2 = new Casa("Bruno");     // Objeto B
        Casa c3 = new Casa("Carlos");    // Objeto C
        Casa c4 = new Casa("Daniel");    // Objeto D
        Casa c5 = new Casa("Eduarda");   // Objeto E

        // Primeira sequência de atribuições
        c2 = c1;
        c4 = null;
        c5 = c3;
        c1 = c5;
        c3 = c2;

        System.out.println("\n--- a. Identifique as referências ---");
        System.out.println("Tabela de referências após a 1ª etapa:");
        System.out.println("+------------+--------------------+------------------------+");
        System.out.println("| Referência | Aponta para        | Proprietário do Objeto |");
        System.out.println("+------------+--------------------+------------------------+");
        System.out.println("| c1         | Objeto C           | Carlos                 |");
        System.out.println("| c2         | Objeto A           | Ana                    |");
        System.out.println("| c3         | Objeto A           | Ana                    |");
        System.out.println("| c4         | null               | null (nenhum)          |");
        System.out.println("| c5         | Objeto C           | Carlos                 |");
        System.out.println("+------------+--------------------+------------------------+");

        System.out.println("\n--- b. Verdadeiro ou Falso ---");
        System.out.println("i.   Depois de c2 = c1, c1 e c2 apontam para o mesmo objeto.");
        System.out.println("     Resposta: (V) VERDADEIRO. Ambos passam a guardar a mesma referência ao Objeto A.");
        System.out.println("ii.  c4 = null destrói imediatamente o objeto que c4 referenciava.");
        System.out.println("     Resposta: (F) FALSO. O Java não destrói objetos imediatamente; ele apenas fica elegível");
        System.out.println("     para ser coletado pelo Garbage Collector no momento em que a JVM julgar necessário.");
        System.out.println("iii. Depois de c5 = c3, c5 e c3 apontam para o mesmo objeto.");
        System.out.println("     Resposta: (V) VERDADEIRO. c5 recebe o endereço que estava em c3 (Objeto C).");
        System.out.println("iv.  A instrução c1 = c5 copia o objeto referenciado por c5.");
        System.out.println("     Resposta: (F) FALSO. Copia apenas o valor da referência (endereço), não duplicando o objeto na memória.");
        System.out.println("v.   Depois de c1 = c5, c1 passa a apontar para o mesmo objeto que c5.");
        System.out.println("     Resposta: (V) VERDADEIRO. As duas variáveis passam a apontar para o Objeto C.");

        // c. Novas mudanças
        System.out.println("\n--- c. Novas mudanças nas referências ---");
        System.out.println("Executando: c2 = c4; c4 = c3;");
        c2 = c4;
        c4 = c3;

        System.out.println("Respostas:");
        System.out.println("i)   Para onde c2 está apontando?");
        System.out.println("     R: Para null (pois recebeu o valor de c4, que era null).");
        System.out.println("ii)  Para onde c4 está apontando?");
        System.out.println("     R: Para o Objeto A (Ana), pois recebeu o valor de c3.");
        System.out.println("iii) Quais referências estão apontando para o mesmo objeto?");
        System.out.println("     R: c1 e c5 apontam para o Objeto C (Carlos);");
        System.out.println("        c3 e c4 apontam para o Objeto A (Ana).");

        // d. Agora execute
        System.out.println("\n--- d. Próxima sequência de atribuições ---");
        System.out.println("Executando: c1 = c2; c2 = c3; c3 = c4; c4 = c5; c5 = null;");
        c1 = c2;
        c2 = c3;
        c3 = c4;
        c4 = c5;
        c5 = null;

        System.out.println("Tabela de referências resultante:");
        System.out.println("+------------+--------------------+------------------------+");
        System.out.println("| Referência | Aponta para        | Proprietário do Objeto |");
        System.out.println("+------------+--------------------+------------------------+");
        System.out.println("| c1         | null               | null (nenhum)          |");
        System.out.println("| c2         | Objeto A           | Ana                    |");
        System.out.println("| c3         | Objeto A           | Ana                    |");
        System.out.println("| c4         | Objeto C           | Carlos                 |");
        System.out.println("| c5         | null               | null (nenhum)          |");
        System.out.println("+------------+--------------------+------------------------+");

        System.out.println("\n--- Resposta da pergunta final (Se executarmos: c1 = c3;) ---");
        c1 = c3;
        System.out.println("Após c1 = c3:");
        System.out.println("• Qual referência foi alterada?");
        System.out.println("  R: Apenas a referência 'c1' foi modificada.");
        System.out.println("• Para qual objeto c1 passa a apontar?");
        System.out.println("  R: Passa a apontar para o Objeto A (Ana).");
        System.out.println("• c3 também foi alterada?");
        System.out.println("  R: NÃO. c3 continua apontando firmemente para o Objeto A (Ana).");
        System.out.println("• Algum objeto passou a não ter nenhuma referência apontando para ele?");
        System.out.println("  R: NÃO. O Objeto A agora é apontado por c1, c2 e c3; e o Objeto C é apontado por c4.");
        System.out.println("  Nenhum objeto perdeu referências nessa instrução.");
    }
}

