package strategy;

import java.util.Random;

public class PixPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        Random random = new Random();
        int pixCode = random.nextInt(1000000);
        System.out.println("Pagamento via Pix realizado.");
        System.out.println("Código Pix: " + pixCode);
        System.out.println("Valor: R$" + amount);
    }
}