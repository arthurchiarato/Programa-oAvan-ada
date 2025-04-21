import java.util.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database db = new Database();

        // e-mail
        System.out.print("Digite o Email do usuário: ");
        String email = scanner.nextLine();

        Usuario usuario = db.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        } else {
            System.out.println("Usuário encontrado: " + usuario.getNome());
        }

        // IDs
        System.out.print("Digite os IDs dos produtos (separados por vírgula): ");
        String[] produtosIdsInput = scanner.nextLine().split(",");
        List<Produto> produtos = new ArrayList<>();

        System.out.println("Produtos encontrados:");

        for (String idStr : produtosIdsInput) {
            int id = Integer.parseInt(idStr.trim());
            Produto produto = db.buscarProdutoPorId(id);
            if (produto != null) {
                produtos.add(produto);
                System.out.println("- " + produto.getNome() + " (R$ " + produto.getPreco() + ")");
            } else {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }
        }

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto válido encontrado. Abortando venda.");
            return;
        }

        // Pagamento
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - Boleto");
        System.out.println("3 - PIX");
        System.out.print("Opção: ");
        int opcaoPagamento = Integer.parseInt(scanner.nextLine());
        FormaPagamento formaPagamento = FormaPagamentoFactory.getFormaPagamento(opcaoPagamento);
        if (formaPagamento == null) {
            System.out.println("Forma de pagamento inválida.");
            return;
        }

        System.out.println("\nAguarde, efetuando pagamento...");
        String chaveAutenticacao = UUID.randomUUID().toString(); // Gerando uma chave única de autenticação
        System.out.println("Pagamento confirmado com sucesso via " + formaPagamento.getClass().getSimpleName() + ". Chave de Autenticação: " + chaveAutenticacao);

        //  total
        double valorTotal = 0;
        for (Produto produto : produtos) {
            valorTotal += produto.getPreco();
        }

        // resumo da venda
        System.out.println("\nResumo da venda:");
        System.out.println("Cliente: " + usuario.getNome());
        System.out.println("Produtos:");
        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome());
        }
        System.out.println("Valor total: R$ " + valorTotal);
        System.out.println("Pagamento: " + formaPagamento.getClass().getSimpleName());

        // Registrar no banco de dados
        db.registrarVenda(usuario, produtos, valorTotal, formaPagamento);

        System.out.println("\nVenda registrada com sucesso!");
    }
}
