package src;
public class CD extends ItemBiblioteca {

    public CD(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
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