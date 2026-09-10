import java.util.ArrayList;
import java.util.List;

/**
 * Exercício 18 - Sistema de Pedidos de um Restaurante.
 * Implementação completa e encapsulada da classe Pedido com gestão de itens,
 * cálculo de taxa de entrega, descontos, regras de pagamento e validação de entrega.
 */
public class Exercicio18 {

    /**
     * Representa um item individual pertencente a um pedido.
     */
    public static class ItemPedido {
        private String nome;
        private double precoUnitario;
        private int quantidade;

        public ItemPedido(String nome, double precoUnitario, int quantidade) {
            this.nome = nome;
            this.precoUnitario = precoUnitario;
            this.quantidade = quantidade;
        }

        public double getSubtotal() {
            return precoUnitario * quantidade;
        }

        @Override
        public String toString() {
            return String.format("  - %s (x%d): R$ %.2f", nome, quantidade, getSubtotal());
        }
    }

    /**
     * Classe modelo para representação e manipulação de um Pedido no restaurante.
     */
    public static class Pedido {
        private String nomeCliente;
        private List<ItemPedido> itens;
        private double valorAcumulado;
        private double desconto;
        private double taxaEntrega;
        private boolean pago;
        private boolean entregue;

        /**
         * Inicializa um novo pedido para o cliente especificado.
         *
         * @param nomeCliente nome do cliente que fez o pedido
         */
        public Pedido(String nomeCliente) {
            this.nomeCliente = nomeCliente;
            this.itens = new ArrayList<>();
            this.valorAcumulado = 0.0;
            this.desconto = 0.0;
            this.taxaEntrega = 0.0;
            this.pago = false;
            this.entregue = false;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public void setNomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
        }

        public double getValorAcumulado() {
            return valorAcumulado;
        }

        public boolean isPago() {
            return pago;
        }

        public boolean isEntregue() {
            return entregue;
        }

        public double getDesconto() {
            return desconto;
        }

        public double getTaxaEntrega() {
            return taxaEntrega;
        }

        /**
         * Adiciona um item ao pedido e atualiza automaticamente o valor acumulado.
         *
         * @param nome nome do prato ou bebida
         * @param precoUnitario preço unitário do item
         * @param quantidade quantidade desejada
         */
        public void adicionarItem(String nome, double precoUnitario, int quantidade) {
            if (entregue) {
                System.out.println("Não é possível adicionar itens: pedido já entregue.");
                return;
            }
            if (pago) {
                System.out.println("Não é possível adicionar itens: pedido já está pago e fechado.");
                return;
            }
            if (precoUnitario <= 0 || quantidade <= 0) {
                System.out.println("Item com preço ou quantidade inválida.");
                return;
            }

            ItemPedido item = new ItemPedido(nome, precoUnitario, quantidade);
            itens.add(item);
            this.valorAcumulado += item.getSubtotal();
            System.out.printf("Item '%s' adicionado. Subtotal acumulado: R$ %.2f%n", nome, this.valorAcumulado);
        }

        /**
         * Calcula e aplica uma porcentagem de desconto sobre o valor acumulado.
         *
         * @param percentual valor entre 0 e 100
         */
        public void aplicarDescontoPorcentagem(double percentual) {
            if (percentual < 0 || percentual > 100) {
                System.out.println("Percentual de desconto inválido.");
                return;
            }
            this.desconto = this.valorAcumulado * (percentual / 100.0);
            System.out.printf("Desconto de %.1f%% aplicado: R$ %.2f de economia.%n", percentual, this.desconto);
        }

        /**
         * Calcula a taxa de entrega baseando-se na distância em quilômetros.
         * Regra: R$ 5,00 fixos de taxa base + R$ 2,00 por km.
         *
         * @param distanciaKm distância até o endereço de entrega
         */
        public void calcularTaxaEntrega(double distanciaKm) {
            if (distanciaKm < 0) {
                System.out.println("Distância não pode ser negativa.");
                return;
            }
            if (distanciaKm == 0) {
                this.taxaEntrega = 0.0; // Retirada no balcão
            } else {
                this.taxaEntrega = 5.0 + (distanciaKm * 2.0);
            }
            System.out.printf("Taxa de entrega para %.1f km calculada: R$ %.2f%n", distanciaKm, this.taxaEntrega);
        }

        /**
         * Calcula o valor final do pedido (acumulado - desconto + taxa de entrega).
         *
         * @return valor total a ser pago
         */
        public double calcularValorFinal() {
            double total = (valorAcumulado - desconto) + taxaEntrega;
            return Math.max(0.0, total);
        }

        /**
         * Registra o pagamento do pedido.
         */
        public void registrarPagamento() {
            if (itens.isEmpty()) {
                System.out.println("Não é possível pagar um pedido sem nenhum item.");
                return;
            }
            this.pago = true;
            System.out.printf("Pagamento de R$ %.2f registrado com sucesso para o cliente %s!%n",
                    calcularValorFinal(), nomeCliente);
        }

        /**
         * Verifica se o pedido pode ser entregue com base nas condições do sistema:
         * 1. Deve conter pelo menos um item.
         * 2. O pedido deve estar pago.
         * 3. O pedido não deve ter sido entregue anteriormente.
         *
         * @return true se atender a todos os critérios para entrega
         */
        public boolean podeSerEntregue() {
            return !itens.isEmpty() && pago && !entregue;
        }

        /**
         * Tenta realizar a entrega do pedido, validando as condições necessárias.
         */
        public void realizarEntrega() {
            if (entregue) {
                System.out.println("Aviso: O pedido já foi entregue anteriormente.");
                return;
            }

            if (!podeSerEntregue()) {
                System.out.println("[ALERTA] O pedido NAO pode ser entregue no momento!");
                if (itens.isEmpty()) {
                    System.out.println("   Motivo: O pedido está vazio.");
                } else if (!pago) {
                    System.out.println("   Motivo: O pedido ainda não foi pago.");
                }
                return;
            }

            this.entregue = true;
            System.out.println("-> Entrega realizada com sucesso para " + nomeCliente + "! Bom apetite!");
        }

        /**
         * Exibe no terminal o resumo completo do pedido.
         */
        public void exibirResumo() {
            System.out.println("\n------------------------------------------------");
            System.out.println("             RESUMO DO PEDIDO");
            System.out.println("------------------------------------------------");
            System.out.println("Cliente: " + nomeCliente);
            System.out.println("Itens:");
            for (ItemPedido item : itens) {
                System.out.println(item);
            }
            System.out.printf("Subtotal acumulado: R$ %.2f%n", valorAcumulado);
            System.out.printf("Desconto aplicado: -R$ %.2f%n", desconto);
            System.out.printf("Taxa de entrega:   +R$ %.2f%n", taxaEntrega);
            System.out.printf("VALOR FINAL:        R$ %.2f%n", calcularValorFinal());
            System.out.println("Status do Pagamento: " + (pago ? "PAGO [OK]" : "PENDENTE [AGUARDANDO]"));
            System.out.println("Status da Entrega:   " + (entregue ? "ENTREGUE [CONCLUIDO]" : "NAO ENTREGUE [EM PREPARO]"));
            System.out.println("------------------------------------------------\n");
        }
    }

    /**
     * Ponto de entrada do programa com demonstração completa de fluxo.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=== Exercício 18 — Sistema de Pedidos de Restaurante ===\n");

        // 1. Registrar o nome do cliente
        Pedido pedido = new Pedido("Guilherme");

        // 2. Adicionar itens e atualizar valor acumulado
        pedido.adicionarItem("Pizza Calabresa Especial", 48.0, 1);
        pedido.adicionarItem("Refrigerante Guaraná 2L", 12.0, 1);
        pedido.adicionarItem("Sobremesa Petit Gâteau", 18.0, 2);

        // 3. Calcular e aplicar desconto (ex: cupom de 10%)
        pedido.aplicarDescontoPorcentagem(10.0);

        // 4. Calcular a taxa de entrega (distância de 4.5 km)
        pedido.calcularTaxaEntrega(4.5);

        // 5. Exibir resumo e valor final antes da entrega
        pedido.exibirResumo();

        // 6. Tentar entregar antes de pagar (validação de regra de negócio)
        System.out.println("Tentativa de entrega 1 (Antes do pagamento):");
        pedido.realizarEntrega();

        // 7. Efetuar o pagamento
        System.out.println("\nEfetuando o pagamento:");
        pedido.registrarPagamento();

        // 8. Tentar entregar após o pagamento (deve ter sucesso)
        System.out.println("\nTentativa de entrega 2 (Após o pagamento):");
        pedido.realizarEntrega();

        // 9. Exibir resumo final com status atualizados
        pedido.exibirResumo();

        System.out.println("--- Conclusão da Modelagem ---");
        System.out.println("A classe Pedido encapsula todos os dados do pedido (itens, valores, status)");
        System.out.println("e expõe métodos claros de negócio (adicionarItem, aplicarDescontoPorcentagem,");
        System.out.println("calcularTaxaEntrega, calcularValorFinal, registrarPagamento e realizarEntrega),");
        System.out.println("garantindo consistência e impedindo que pedidos saiam para entrega sem pagamento.");
    }
}
