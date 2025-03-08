import java.util.Scanner;
import factory.PaymentFactory;
import strategy.PaymentStrategy;
import processor.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o método de pagamento:");
        System.out.println("1 - Pix");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Boleto");
        System.out.print("Opção: ");
        int option = scanner.nextInt();

        System.out.print("Digite o valor da transação: ");
        double amount = scanner.nextDouble();

        try {
            PaymentStrategy strategy = PaymentFactory.createPaymentMethod(option);
            PaymentProcessor processor = new PaymentProcessor(strategy);
            processor.process(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}