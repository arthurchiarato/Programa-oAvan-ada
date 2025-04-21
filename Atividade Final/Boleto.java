public class Boleto implements FormaPagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Pagamento processado via Boleto.");
    }
}
