package services;

import model.Emprestimo;
import model.Livro;
import model.Usuario;
import utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private static final String MENSAGEM_EMPRESTIMO_REALIZADO = "Emprestimo realizado: %s pegou %s";
    private static final String MENSAGEM_LIVRO_NAO_DISPONIVEL = "Livro não disponível";
    private static final String MENSAGEM_LIVRO_NAO_ENCONTRADO = "Livro não encontrado";
    private static final String MENSAGEM_USUARIO_INVALIDO = "Usuário inválido";
    private static final String MENSAGEM_TITULO_INVALIDO = "Título do livro inválido";
    
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(String titulo, String autor, int ano) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser vazio");
        }
        if (ano <= 0) {
            throw new IllegalArgumentException("Ano deve ser positivo");
        }
        
        Livro livro = new Livro(titulo.trim(), autor.trim(), ano);
        livros.add(livro);
    }

    public void realizarEmprestimo(Usuario usuario, String tituloLivro) {
        if (usuario == null) {
            System.out.println(MENSAGEM_USUARIO_INVALIDO);
            return;
        }
        if (tituloLivro == null || tituloLivro.trim().isEmpty()) {
            System.out.println(MENSAGEM_TITULO_INVALIDO);
            return;
        }
        
        Livro livro = buscarLivroPorTitulo(tituloLivro.trim());
        if (livro == null) {
            System.out.println(MENSAGEM_LIVRO_NAO_ENCONTRADO);
            return;
        }
        if (!livro.isDisponivel()) {
            System.out.println(MENSAGEM_LIVRO_NAO_DISPONIVEL);
            return;
        }
        
        Emprestimo emprestimo = new Emprestimo(usuario, livro, DataUtils.getDataAtual());
        emprestimos.add(emprestimo);
        livro.setDisponivel(false);
        System.out.println(String.format(MENSAGEM_EMPRESTIMO_REALIZADO, usuario.getNome(), livro.getTitulo()));
    }

    private Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado");
            return;
        }
        
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Usuário: " + emprestimo.getUsuario().getNome() + 
                             " - Livro: " + emprestimo.getLivro().getTitulo() +
                             " - Data: " + emprestimo.getData());
        }
    }
    
    public void relatorioLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado");
            return;
        }
        
        for (Livro livro : livros) {
            System.out.println(livro.getTitulo() + " - " + livro.getAutor() + " (" + livro.getAno() + ")");
        }
    }
    
    public List<Livro> getLivros() {
        return livros;
    }
    
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
