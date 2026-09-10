/**
 * Exercício 16 - Funcionário e salário.
 * Demonstração de encapsulamento, proteção de atributos sensíveis e controle de acesso baseado em papéis.
 */
public class Exercicio16 {

    /**
     * Representa um funcionário da empresa com proteção de dados salariais por encapsulamento.
     */
    public static class Funcionario {
        private String nome;
        private String cargo;
        private double salario;

        /**
         * Construtor da classe Funcionario.
         *
         * @param nome nome do funcionário
         * @param cargo cargo ocupado (ex: "Desenvolvedor", "Gerente")
         * @param salario salario inicial
         */
        public Funcionario(String nome, String cargo, double salario) {
            this.nome = nome;
            this.cargo = cargo;
            this.salario = salario;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        /**
         * Permite consultar o salário com base na permissão do solicitante.
         * Regras:
         * - O próprio funcionário pode consultar seu salário.
         * - O gerente pode consultar o salário de qualquer funcionário.
         * - Outros funcionários não têm acesso.
         *
         * @param solicitante funcionário que está solicitando a consulta
         * @return o valor do salário caso autorizado
         */
        public double getSalario(Funcionario solicitante) {
            if (solicitante == this || "Gerente".equalsIgnoreCase(solicitante.getCargo())) {
                return this.salario;
            }
            throw new SecurityException("Acesso Negado: '" + solicitante.getNome() + 
                "' não tem permissão para visualizar o salário de '" + this.nome + "'.");
        }

        /**
         * Permite alterar o salário mediante autorização estrita de um Gerente.
         * Regras:
         * - O funcionário comum NÃO pode alterar seu salário.
         * - Apenas o Gerente pode alterar o salário.
         *
         * @param solicitante quem está tentando aplicar a alteração
         * @param novoSalario novo valor a ser definido
         */
        public void setSalario(Funcionario solicitante, double novoSalario) {
            if (!"Gerente".equalsIgnoreCase(solicitante.getCargo())) {
                throw new SecurityException("Acesso Negado: '" + solicitante.getNome() + 
                    "' não possui permissão de Gerente para alterar salários.");
            }
            if (novoSalario < 0) {
                throw new IllegalArgumentException("O salário não pode ser negativo.");
            }
            this.salario = novoSalario;
        }
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 16 — Funcionário e Salário (Encapsulamento) ===");

        Funcionario f1 = new Funcionario("Lucas", "Desenvolvedor", 4500.0);
        Funcionario f2 = new Funcionario("Beatriz", "Designer", 4200.0);
        Funcionario gerente = new Funcionario("Roberto", "Gerente", 12000.0);

        System.out.println("Cenário 1: Funcionário consultando o próprio salário");
        try {
            System.out.println(f1.getNome() + " consultando seu salário: R$ " + f1.getSalario(f1));
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCenário 2: Gerente consultando o salário do funcionário");
        try {
            System.out.println(gerente.getNome() + " consultando salário de " + f1.getNome() + ": R$ " + f1.getSalario(gerente));
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCenário 3: Colega (outro funcionário) tentando consultar salário");
        try {
            f1.getSalario(f2);
        } catch (SecurityException e) {
            System.out.println("[Segurança Ativada] " + e.getMessage());
        }

        System.out.println("\nCenário 4: Funcionário tentando alterar o próprio salário");
        try {
            f1.setSalario(f1, 8000.0);
        } catch (SecurityException e) {
            System.out.println("[Segurança Ativada] " + e.getMessage());
        }

        System.out.println("\nCenário 5: Gerente alterando o salário do funcionário com sucesso");
        try {
            gerente.setSalario(gerente, 13000.0); // gerente alterando próprio salário
            f1.setSalario(gerente, 5500.0);       // gerente promovendo Lucas
            System.out.println("Novo salário de " + f1.getNome() + " ajustado pelo Gerente: R$ " + f1.getSalario(gerente));
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Questões de Fixação ---");
        System.out.println("1. Quem pode utilizar o método get do salário?");
        System.out.println("   R: O próprio funcionário titular e qualquer usuário com cargo/perfil de Gerente.");

        System.out.println("\n2. Quem pode utilizar o método set do salário?");
        System.out.println("   R: Exclusivamente o Gerente.");

        System.out.println("\n3. Por que o salário não deve ser um atributo de acesso direto?");
        System.out.println("   R: Porque atributos públicos permitem que qualquer parte do código altere ou consulte os dados");
        System.out.println("   sem validações ou restrições. Qualquer funcionário poderia adulterar seu próprio salário para quantias");
        System.out.println("   absurdas ou valores negativos, quebrando a segurança e a integridade da empresa.");

        System.out.println("\n4. Qual é a importância do encapsulamento nesse caso?");
        System.out.println("   R: O encapsulamento protege a informação sensível, restringe a manipulação direta e garante");
        System.out.println("   que todas as operações passem por métodos que validam regras de negócio, autorizações e consistência.");
    }
}

