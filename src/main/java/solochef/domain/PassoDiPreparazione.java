package solochef.domain;

public class PassoDiPreparazione {
    private Integer id;
    private int  numeroDordine;
    private String descrizione;

    public PassoDiPreparazione(int numeroDordine, String descrizione) {
        this.numeroDordine = numeroDordine;
        this.descrizione = descrizione;
    }

    public Integer getId() {
        return id;
    }

    public int getNumeroDordine() {
        return numeroDordine;
    }

    public void setNumeroDordine(int numeroDordine) {
        this.numeroDordine = numeroDordine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
