package src;
public class cd extends itemBiblioteca {

    public cd(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        super(titulo, autor, anoPublicacao, exemplaresDisponiveis);
    }

    @Override
    public String getTipo() {
        return "CD";
    }

    @Override
    public boolean isEmprestavel() {
        return true;
    }
}