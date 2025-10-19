//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        b.adicionarLivro("O senhor dos anéis", "J. R. R. Tolkien", 1954);
        b.adicionarLivro("Refatoração", "Martin Fowler", 2020);

        Usuario u = new Usuario();
        u.nome = "Maria";
        u.idade = 21;
        u.email = "maria@gmail.com";

        b.realizarEmprestimo(u, "O senhor dos anéis");
        b.realizarEmprestimo(u, "Refatoração");

        b.listarEmprestimos();
    }
}