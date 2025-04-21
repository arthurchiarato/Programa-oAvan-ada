import java.sql.*;
import java.util.List;

public class Database {

    private static final String URL = "jdbc:sqlite:ecommerce.db";

    // Método para criar uma conexão com o banco de dados
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Método para buscar um usuário por e-mail
    public Usuario buscarUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM Usuario WHERE email = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int id = rs.getInt("id");
                return new Usuario(id, nome, email); // Agora retornando o id do usuário
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Retorna null caso não encontre o usuário
    }

    // Método para adicionar um usuário no banco de dados
    public void adicionarUsuario(String nome, String email) {
        String sql = "INSERT INTO Usuario (nome, email) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("Usuário adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar um produto por ID
    public Produto buscarProdutoPorId(int id) {
        String sql = "SELECT * FROM Produto WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                return new Produto(id, nome, preco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Retorna null caso não encontre o produto
    }

    // Método para registrar uma venda
    public void registrarVenda(Usuario usuario, List<Produto> produtos, double valorTotal, FormaPagamento formaPagamento) {
        String sql = "INSERT INTO Venda (usuario_id, valorTotal, formaPagamento) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Insere a venda no banco de dados
            stmt.setInt(1, usuario.getId());
            stmt.setDouble(2, valorTotal);
            stmt.setString(3, formaPagamento.getClass().getSimpleName());
            stmt.executeUpdate();

            // Obtém o ID da venda inserida
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int vendaId = rs.getInt(1);

                // Insere os produtos relacionados à venda
                for (Produto produto : produtos) {
                    String produtoSql = "INSERT INTO Venda_Produto (venda_id, produto_id) VALUES (?, ?)";
                    try (PreparedStatement produtoStmt = conn.prepareStatement(produtoSql)) {
                        produtoStmt.setInt(1, vendaId);
                        produtoStmt.setInt(2, produto.getId());
                        produtoStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
