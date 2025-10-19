package model;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private String data;

    public Emprestimo(Usuario usuario, Livro livro, String data) {
        this.usuario = usuario;
        this.livro = livro;
        this.data = data;
    }

    // Getters
    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getData() {
        return data;
    }

    // Setters
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setData(String data) {
        this.data = data;
    }
}
