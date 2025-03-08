 
import java.util.Random;
import java.util.Scanner;

interface PaymentStrategy {
    void processPayment(double amount);
}

class PixPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        Random random = new Random();
        int pixCode = random.nextInt(1000000);
        System.out.println("Pagamento via Pix realizado.");
        System.out.println("Código Pix: " + pixCode);
        System.out.println("Valor: R$" + amount);
    }
}

class CreditCardPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão: ");
        String cardNumber = scanner.nextLine();
        System.out.println("Pagamento via Cartão de Crédito realizado.");
        System.out.println("Número do Cartão: " + cardNumber);
        System.out.println("Valor: R$" + amount);
    }
}

class BoletoPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        Random random = new Random();
        int boletoCode = random.nextInt(1000000);
        System.out.println("Pagamento via Boleto realizado.");
        System.out.println("Código do Boleto: " + boletoCode);
        System.out.println("Valor: R$" + amount);
    }
}

class PaymentFactory {
    public static PaymentStrategy createPayment(String type) {
        return switch (type) {
            case "Pix" -> new PixPayment();
            case "Cartão" -> new CreditCardPayment();
            case "Boleto" -> new BoletoPayment();
            default -> throw new IllegalArgumentException("Método de pagamento inválido!");
        };
    }
}

class PaymentProcessor {
    private PaymentStrategy strategy;

    public PaymentProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void process(double amount) {
        strategy.processPayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o método de pagamento:");
        System.out.println("1: Pix");
        System.out.println("2: Cartão de Crédito");
        System.out.println("3: Boleto");
        System.out.print("Opção: ");
        int option = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Digite o valor da transação: R$");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        PaymentStrategy strategy = switch (option) {
            case 1 -> PaymentFactory.createPayment("Pix");
            case 2 -> PaymentFactory.createPayment("Cartão");
            case 3 -> PaymentFactory.createPayment("Boleto");
            default -> {
                System.out.println("Opção inválida!");
                yield null;
            }
        };

        if (strategy != null) {
            PaymentProcessor processor = new PaymentProcessor(strategy);
            processor.process(amount);
        }
    }
}
