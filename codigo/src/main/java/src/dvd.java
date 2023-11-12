package src;
public class dvd extends itemBiblioteca {

    public dvd(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        super(titulo, autor, anoPublicacao, exemplaresDisponiveis);
    }

    @Override
    public String getTipo() {
        return "dvd";
    }

    @Override
    public boolean isEmprestavel() {
        return true;
    }
}