public class PIX implements FormaPagamento {
    @Override
    public void processarPagamento() {
        System.out.println("Pagamento processado via PIX.");
    }
}