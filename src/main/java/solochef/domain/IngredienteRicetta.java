package solochef.domain;

public class IngredienteRicetta {
    private Integer id;
    private double quantita;
    private Ingrediente ingrediente;
    private RicettaBase ricetta;

    public IngredienteRicetta(double quantita, Ingrediente ingrediente, RicettaBase ricetta) {
        this.quantita = quantita;
        this.ingrediente = ingrediente;
        this.ricetta = ricetta;
    }

    public Integer getId() {
        return id;
    }

    public double getQuantita() {
        return quantita;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public RicettaBase getRicetta() {
        return ricetta;
    }

    public void setRicetta(RicettaBase ricetta) {
        this.ricetta = ricetta;
    }
}
