/**
 * Exercício 7 - Rastreamento de referências em Java.
 * Análise detalhada do apontamento de referências, objetos órfãos (coleta de lixo) e valor null.
 */
public class Exercicio7 {

    /**
     * Classe modelo que representa uma Casa com construtor.
     */
    public static class Casa {
        String proprietario;

        public Casa(String proprietario) {
            this.proprietario = proprietario;
        }
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 7 — Rastreamento de Referências ===");

        // Criação inicial dos 5 objetos no Heap
        Casa c1 = new Casa("Ana");       // Objeto A
        Casa c2 = new Casa("Bruno");     // Objeto B
        Casa c3 = new Casa("Carlos");    // Objeto C
        Casa c4 = new Casa("Daniel");    // Objeto D
        Casa c5 = new Casa("Eduarda");   // Objeto E

        System.out.println("--- Executando as atribuições de referências ---");
        // Passo a passo de atribuições
        c2 = c1;    // c2 aponta para "Ana" (Objeto A). Objeto B ("Bruno") fica sem referências.
        c4 = null;  // c4 aponta para null. Objeto D ("Daniel") fica sem referências.
        c5 = c3;    // c5 aponta para "Carlos" (Objeto C). Objeto E ("Eduarda") fica sem referências.
        c1 = c5;    // c1 aponta para "Carlos" (Objeto C).
        c3 = c2;    // c3 aponta para "Ana" (Objeto A).

        // Exibição do estado real verificado em execução
        System.out.println("\nEstado atual das variáveis:");
        System.out.println("c1: " + (c1 != null ? c1.proprietario : "null"));
        System.out.println("c2: " + (c2 != null ? c2.proprietario : "null"));
        System.out.println("c3: " + (c3 != null ? c3.proprietario : "null"));
        System.out.println("c4: " + (c4 != null ? c4.proprietario : "null"));
        System.out.println("c5: " + (c5 != null ? c5.proprietario : "null"));

        System.out.println("\n--- Respostas das Questões ---");
        System.out.println("a. Tabela de apontamento das referências:");
        System.out.println("+------------+-------------------------+------------------------+");
        System.out.println("| Referência | Para qual objeto aponta | Proprietário do objeto |");
        System.out.println("+------------+-------------------------+------------------------+");
        System.out.println("| c1         | Objeto C                | Carlos                 |");
        System.out.println("| c2         | Objeto A                | Ana                    |");
        System.out.println("| c3         | Objeto A                | Ana                    |");
        System.out.println("| c4         | null (nenhum objeto)    | null (nenhum)          |");
        System.out.println("| c5         | Objeto C                | Carlos                 |");
        System.out.println("+------------+-------------------------+------------------------+");

        System.out.println("\nb. Qual objeto possui mais de uma referência apontando para ele?");
        System.out.println("   R: Dois objetos possuem múltiplas referências:");
        System.out.println("      - Objeto A (Ana): referenciado simultaneamente por c2 e c3;");
        System.out.println("      - Objeto C (Carlos): referenciado simultaneamente por c1 e c5.");

        System.out.println("\nc. Existe algum objeto que não possui mais nenhuma referência apontando para ele? Se sim, qual ou quais?");
        System.out.println("   R: SIM. Os objetos que ficaram sem referências são:");
        System.out.println("      - Objeto B (Bruno): perdeu sua única referência quando c2 recebeu c1;");
        System.out.println("      - Objeto D (Daniel): perdeu sua referência quando c4 foi definido como null;");
        System.out.println("      - Objeto E (Eduarda): perdeu sua referência quando c5 recebeu c3.");
        System.out.println("      Esses 3 objetos tornam-se elegíveis para coleta pelo Garbage Collector.");

        System.out.println("\nd. O que significa null neste contexto?");
        System.out.println("   R: Significa ausência de referência para um objeto. A variável de referência existe na memória,");
        System.out.println("   mas não armazena o endereço de nenhuma instância válida no Heap (não aponta para lugar nenhum).");

        System.out.println("\ne. Qual referência está apontando para null?");
        System.out.println("   R: A referência 'c4'.");
    }
}

