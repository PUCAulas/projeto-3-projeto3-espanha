package src;
public class Livro extends ItemBiblioteca {

    public Livro(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        super(titulo, autor, anoPublicacao, exemplaresDisponiveis);
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public boolean isEmprestavel() {
        return true;
    }
}