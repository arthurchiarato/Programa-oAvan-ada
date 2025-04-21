public class Usuario {
    private String nome;
    private String email;

    public Usuario(int id, String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Usuario(String nome, String email) {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return 0;
    }
}
