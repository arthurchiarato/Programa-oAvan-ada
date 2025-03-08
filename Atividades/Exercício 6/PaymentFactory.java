package factory;

import strategy.*;

public class PaymentFactory {
    public static PaymentStrategy createPaymentMethod(int option) {
        return switch (option) {
            case 1 -> new PixPayment();
            case 2 -> new CreditCardPayment();
            case 3 -> new BoletoPayment();
            default -> throw new IllegalArgumentException("Opção inválida!");
        };
    }
}