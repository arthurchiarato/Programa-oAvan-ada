import java.util.Scanner;

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Enviando e-mail: " + message);
    }
}

class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}

class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Enviando Notificação Push: " + message);
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("sms")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("push")) {
            return new PushNotification();
        } else {
            throw new IllegalArgumentException("Tipo de notificação inválido!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de notificação:");
        System.out.println("1: Email");
        System.out.println("2: SMS");
        System.out.println("3: Push Notification");
        System.out.print("Opção: ");
        int option = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Digite a mensagem a ser enviada: ");
        String message = scanner.nextLine();

        Notification notification = null;
        if (option == 1) {
            notification = NotificationFactory.createNotification("email");
        } else if (option == 2) {
            notification = NotificationFactory.createNotification("sms");
        } else if (option == 3) {
            notification = NotificationFactory.createNotification("push");
        } else {
            System.out.println("Opção inválida!");
            return;
        }

        notification.send(message);
    }
}
