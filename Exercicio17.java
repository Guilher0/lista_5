/**
 * Exercício 17 - Conta bancária.
 * Modelagem de proteção de saldo e regras de transação bancária através de encapsulamento.
 */
public class Exercicio17 {

    /**
     * Representa uma conta bancária com restrição estrita de modificação de saldo.
     */
    public static class ContaBancaria {
        private String numeroConta;
        private String titular;
        private double saldo;

        /**
         * Construtor da conta bancária.
         *
         * @param numeroConta identificador da conta (somente leitura após criação)
         * @param titular nome do titular da conta
         * @param saldoInicial saldo com o qual a conta é aberta
         */
        public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
            this.numeroConta = numeroConta;
            this.titular = titular;
            this.saldo = Math.max(0, saldoInicial);
        }

        public String getNumeroConta() {
            return numeroConta;
        }

        public String getTitular() {
            return titular;
        }

        /**
         * Permite que o titular altere seu nome cadastrado.
         *
         * @param novoTitular novo nome a ser cadastrado
         */
        public void setTitular(String novoTitular) {
            if (novoTitular != null && !novoTitular.trim().isEmpty()) {
                this.titular = novoTitular;
            } else {
                System.out.println("Nome do titular inválido.");
            }
        }

        /**
         * Permite consultar o saldo da conta.
         *
         * @return o saldo disponível atual
         */
        public double getSaldo() {
            return saldo;
        }

        // NÃO EXISTE 'setSaldo(double saldo)' para impedir alterações arbitrárias!

        /**
         * Operação controlada de depósito.
         *
         * @param valor quantia a ser creditada
         */
        public void depositar(double valor) {
            if (valor > 0) {
                this.saldo += valor;
                System.out.println("Depósito de R$ " + valor + " realizado com sucesso. Novo saldo: R$ " + this.saldo);
            } else {
                System.out.println("Valor de depósito deve ser positivo.");
            }
        }

        /**
         * Operação controlada de saque.
         *
         * @param valor quantia a ser debitada
         * @return true se o saque for realizado, false se não houver saldo suficiente
         */
        public boolean sacar(double valor) {
            if (valor <= 0) {
                System.out.println("Valor de saque inválido.");
                return false;
            }
            if (valor <= this.saldo) {
                this.saldo -= valor;
                System.out.println("Saque de R$ " + valor + " realizado com sucesso. Saldo restante: R$ " + this.saldo);
                return true;
            } else {
                System.out.println("Saldo insuficiente para saque de R$ " + valor + ". Saldo atual: R$ " + this.saldo);
                return false;
            }
        }
    }

    /**
     * Ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 17 — Conta Bancária (Encapsulamento) ===");

        ContaBancaria conta = new ContaBancaria("12345-6", "Mariana Souza", 500.0);

        System.out.println("Titular inicial: " + conta.getTitular());
        System.out.println("Número da conta: " + conta.getNumeroConta());
        System.out.println("Saldo consultado: R$ " + conta.getSaldo());

        // Alterando nome cadastrado
        conta.setTitular("Mariana Souza Oliveira");
        System.out.println("Titular atualizado: " + conta.getTitular());

        // Operações de saldo via métodos de negócio (sem setSaldo)
        System.out.println("\n--- Movimentações na Conta ---");
        conta.depositar(300.0);
        conta.sacar(150.0);
        conta.sacar(1000.0); // Tentativa sem saldo suficiente

        System.out.println("\nSaldo final verificado: R$ " + conta.getSaldo());

        System.out.println("\n--- Questões de Fixação ---");
        System.out.println("1. Quais atributos devem possuir método get?");
        System.out.println("   R: Todos os três atributos: numeroConta (para identificar a conta),");
        System.out.println("      titular (para consulta cadastral) e saldo (para conferir o extrato).");

        System.out.println("\n2. Quais atributos podem possuir método set?");
        System.out.println("   R: Apenas o atributo 'titular', pois o cliente pode atualizar seu nome de cadastro.");
        System.out.println("      'numeroConta' não deve ter set (identificador fixo) e 'saldo' não deve ter set.");

        System.out.println("\n3. Por que o saldo não deve possuir um set comum?");
        System.out.println("   R: Porque um método 'setSaldo(valor)' permitiria que qualquer parte externa atribuísse");
        System.out.println("   qualquer quantia arbitrária (ex.: conta.setSaldo(1_000_000)), ignorando regras financeiras básicas,");
        System.out.println("   validação de fundos, limites diários, taxas e histórico de transações.");

        System.out.println("\n4. Como o encapsulamento ajuda a proteger os dados da conta?");
        System.out.println("   R: Ocultando os campos privados e expondo apenas portas de entrada controladas (depositar/sacar),");
        System.out.println("   o encapsulamento garante que o estado da conta seja sempre íntegro e consistente, impedindo fraudes,");
        System.out.println("   valores negativos indevidos ou corrupção de memória.");
    }
}

