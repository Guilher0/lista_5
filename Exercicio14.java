import java.util.Objects;

/**
 * Exercício 14 - Sobrescrita do método equals().
 * Implementação da classe Pessoa com critério de igualdade semântica baseado no CPF.
 */
public class Exercicio14 {

    /**
     * Representa uma pessoa com nome e CPF.
     */
    public static class Pessoa {
        String nome;
        String cpf;

        /**
         * Sobrescrita do método equals para comparar instâncias pelo CPF.
         *
         * @param obj objeto a ser comparado com esta instância
         * @return true se o CPF for idêntico, false caso contrário
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pessoa outra = (Pessoa) obj;
            return Objects.equals(this.cpf, outra.cpf);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cpf);
        }
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 14 — Sobrescrita do equals() na classe Pessoa ===");

        Pessoa p1 = new Pessoa();
        p1.nome = "Carlos";
        p1.cpf = "111.111.111-11";

        Pessoa p2 = new Pessoa();
        p2.nome = "João";
        p2.cpf = "111.111.111-11";

        Pessoa p3 = new Pessoa();
        p3.nome = "Maria";
        p3.cpf = "222.222.222-22";

        System.out.println("Resultados executados no console:");
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

        System.out.println("\n--- Questões de Fixação ---");
        System.out.println("a) Qual será a saída?");
        System.out.println("   false");
        System.out.println("   true");
        System.out.println("   false");

        System.out.println("\nb) p1 e p2 são o mesmo objeto?");
        System.out.println("   NÃO. São dois objetos instanciados separadamente ('new Pessoa()'), ocupando endereços");
        System.out.println("   distintos de memória no Heap.");

        System.out.println("\nc) Por que p1.equals(p2) deve retornar true?");
        System.out.println("   Porque o método equals() foi sobrescrito para comparar o atributo CPF, e tanto p1 quanto p2");
        System.out.println("   possuem o mesmo valor de CPF: \"111.111.111-11\".");

        System.out.println("\nd) O que mudou no comportamento do equals() depois da sobrescrita?");
        System.out.println("   Antes da sobrescrita, o equals() herdado de Object comparava apenas a referência de memória (this == obj).");
        System.out.println("   Após a sobrescrita, ele passou a comparar o conteúdo significativo dos dados (o valor do CPF).");

        System.out.println("\ne) Por que comparar pessoas apenas com == pode ser inadequado?");
        System.out.println("   Porque em aplicações reais, dados da mesma pessoa física podem ser instanciados em locais diferentes");
        System.out.println("   (ex.: buscas em banco, requisições HTTP distintas). O operador == diria falsamente que são pessoas");
        System.out.println("   diferentes apenas porque não estão no mesmo endereço de memória, ignorando a unicidade do CPF.");

        System.out.println("\nf) Qual informação foi escolhida como critério de igualdade?");
        System.out.println("   O atributo 'cpf'.");
    }
}

