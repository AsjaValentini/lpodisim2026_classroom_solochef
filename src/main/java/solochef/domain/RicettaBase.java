package solochef.domain;

import solochef.enumerazioni.CategoriaPasto;
import solochef.enumerazioni.Difficolta;

import java.util.List;

public abstract class RicettaBase {
    private Integer id;
    private String titolo;

    private String descrizione;

    private int tempoPreparazioneTotale;

    private int tempoCottura;

    private int numeroPorzioni;

    private int valutazione;
    private CategoriaPasto categoriaPasto;
    private Difficolta difficolta;
    private List<PassoDiPreparazione> passi;

    public RicettaBase(String titolo, String descrizione, int tempoPreparazioneTotale, int tempoCottura, int numeroPorzioni, int valutazione, CategoriaPasto categoriaPasto, Difficolta difficolta, List<PassoDiPreparazione> passi) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.tempoPreparazioneTotale = tempoPreparazioneTotale;
        this.tempoCottura = tempoCottura;
        this.numeroPorzioni = numeroPorzioni;
        this.valutazione = valutazione;
        this.categoriaPasto = categoriaPasto;
        this.difficolta = difficolta;
        this.passi = passi;
    }

    public Integer getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getTempoPreparazioneTotale() {
        return tempoPreparazioneTotale;
    }

    public void setTempoPreparazioneTotale(int tempoPreparazioneTotale) {
        this.tempoPreparazioneTotale = tempoPreparazioneTotale;
    }

    public int getTempoCottura() {
        return tempoCottura;
    }

    public void setTempoCottura(int tempoCottura) {
        this.tempoCottura = tempoCottura;
    }

    public int getNumeroPorzioni() {
        return numeroPorzioni;
    }

    public void setNumeroPorzioni(int numeroPorzioni) {
        this.numeroPorzioni = numeroPorzioni;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public CategoriaPasto getCategoriaPasto() {
        return categoriaPasto;
    }

    public void setCategoriaPasto(CategoriaPasto categoriaPasto) {
        this.categoriaPasto = categoriaPasto;
    }

    public Difficolta getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(Difficolta difficolta) {
        this.difficolta = difficolta;
    }

    public List<PassoDiPreparazione> getPassi() {
        return passi;
    }

    public void setPassi(List<PassoDiPreparazione> passi) {
        this.passi = passi;
    }



}
