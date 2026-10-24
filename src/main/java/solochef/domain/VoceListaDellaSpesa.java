package solochef.domain;

public class VoceListaDellaSpesa {
    private Integer id;
    private int  quanitaDaComprare;
    private boolean acquistato;

    private Ingrediente ingrediente;

    public VoceListaDellaSpesa(int quanitaDaComprare, boolean acquistato, Ingrediente ingrediente) {
        this.quanitaDaComprare = quanitaDaComprare;
        this.acquistato = acquistato;
        this.ingrediente = ingrediente;
    }

    public Integer getId() {
        return id;
    }

    public int getQuanitaDaComprare() {
        return quanitaDaComprare;
    }

    public void setQuanitaDaComprare(int quanitaDaComprare) {
        this.quanitaDaComprare = quanitaDaComprare;
    }

    public boolean isAcquistato() {
        return acquistato;
    }

    public void setAcquistato(boolean acquistato) {
        this.acquistato = acquistato;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}
