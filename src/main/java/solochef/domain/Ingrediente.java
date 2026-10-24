package solochef.domain;

import solochef.enumerazioni.Allergene;
import solochef.enumerazioni.CategoriaMerceologica;

public class Ingrediente {

    private Integer id;
    private String nomeIngrediente;
    private String unitaDiMisura;
    private double caloriePerUnita;
    private CategoriaMerceologica categoriaMerceologica;
    private Allergene allergene;

    public Integer getId() {
        return id;
    }

    public Ingrediente(String nomeIngrediente, String unitaDiMisura, double caloriePerUnita, CategoriaMerceologica categoriaMerceologica, Allergene allergene) {
        this.nomeIngrediente = nomeIngrediente;
        this.unitaDiMisura = unitaDiMisura;
        this.caloriePerUnita = caloriePerUnita;
        this.categoriaMerceologica = categoriaMerceologica;
        this.allergene = allergene;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public String getUnitaDiMisura() {
        return unitaDiMisura;
    }

    public void setUnitaDiMisura(String unitaDiMisura) {
        this.unitaDiMisura = unitaDiMisura;
    }

    public double getCaloriePerUnita() {
        return caloriePerUnita;
    }

    public void setCaloriePerUnita(double caloriePerUnita) {
        this.caloriePerUnita = caloriePerUnita;
    }

    public CategoriaMerceologica getCategoriaMerceologica() {
        return categoriaMerceologica;
    }

    public void setCategoriaMerceologica(CategoriaMerceologica categoriaMerceologica) {
        this.categoriaMerceologica = categoriaMerceologica;
    }

    public Allergene getAllergene() {
        return allergene;
    }

    public void setAllergene(Allergene allergene) {
        this.allergene = allergene;
    }
}
