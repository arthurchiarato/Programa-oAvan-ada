public class FormaPagamentoFactory {
    public static FormaPagamento getFormaPagamento(int opcao) {
        switch (opcao) {
            case 1:
                return new CartaoCredito();
            case 2:
                return new Boleto();
            case 3:
                return new PIX();
            default:
                return null;
        }
    }
}
