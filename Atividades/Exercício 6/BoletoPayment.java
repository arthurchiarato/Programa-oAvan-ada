package strategy;

import java.util.Random;

public class BoletoPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        Random random = new Random();
        int boletoNumber = random.nextInt(1000000);
        System.out.println("Pagamento via Boleto realizado.");
        System.out.println("Número do Boleto: " + boletoNumber);
        System.out.println("Valor: R$" + amount);
    }
}