public class CartaoCredito implements FormaPagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Pagamento processado via Cartão de Crédito.");
    }
}
