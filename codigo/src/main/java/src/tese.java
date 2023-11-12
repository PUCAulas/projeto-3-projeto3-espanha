package src;
public class tese extends itemBiblioteca {

    public tese(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        super(titulo, autor, anoPublicacao, exemplaresDisponiveis);
    }

    @Override
    public String getTipo() {
        return "Tese";
    }

    @Override
    public boolean isEmprestavel() {
        return false;
    }
}