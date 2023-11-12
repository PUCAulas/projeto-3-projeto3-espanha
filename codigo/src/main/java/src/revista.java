package src;
public class revista extends itemBiblioteca {

    public revista(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        super(titulo, autor, anoPublicacao, exemplaresDisponiveis);
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public boolean isEmprestavel() {
        return false;
    }
}