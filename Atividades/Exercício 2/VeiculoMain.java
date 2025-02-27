package src;

abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;
    protected String combustivel;

    public Veiculo(String marca, String modelo, int ano, String combustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
    }

    public abstract int calcularAutonomia();

    public void exibirDetalhes() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Combustível: " + combustivel);
    }
}

class Onibus extends Veiculo {
    private int quantidadeEixos;
    private int capacidadePassageiros;

    public Onibus(String marca, String modelo, int ano, String combustivel, int quantidadeEixos, int capacidadePassageiros) {
        super(marca, modelo, ano, combustivel);
        this.quantidadeEixos = quantidadeEixos;
        this.capacidadePassageiros = capacidadePassageiros;
    }

    @Override
    public int calcularAutonomia() {
        return 200 * 5;
    }
}

class Caminhao extends Veiculo {
    private String tipoCaminhao;
    private int capacidadeCarga;

    public Caminhao(String marca, String modelo, int ano, String combustivel, String tipoCaminhao, int capacidadeCarga) {
        super(marca, modelo, ano, combustivel);
        this.tipoCaminhao = tipoCaminhao;
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public int calcularAutonomia() {
        return 300 * 6;
    }
}

public class VeiculoMain {
    public static void main(String[] args) {
        Onibus onibus = new Onibus("Mercedes", "Benz", 2019, "Diesel", 6, 40);
        Caminhao caminhao = new Caminhao("Volvo", "FH", 2020, "Diesel", "Carga pesada", 10);

        Veiculo[] veiculos = {onibus, caminhao};

        for (Veiculo veiculo : veiculos) {
            veiculo.exibirDetalhes();
            System.out.println("Autonomia: " + veiculo.calcularAutonomia() + " km\n");
        }
    }
}
