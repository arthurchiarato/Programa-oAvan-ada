import java.util.List;

public class Venda {
    private Usuario usuario;
    private List<Produto> produtos;
    private double valorTotal;
    private FormaPagamento formaPagamento;

    // Construtor com os parâmetros necessários
    public Venda(Usuario usuario, List<Produto> produtos, double valorTotal, FormaPagamento formaPagamento) {
        this.usuario = usuario;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    // Getters e setters
    public Usuario getUsuario() {
        return usuario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
}
