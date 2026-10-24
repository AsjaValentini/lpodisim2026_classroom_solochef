package solochef.domain;

import solochef.enumerazioni.CategoriaPasto;
import solochef.enumerazioni.Difficolta;

import java.util.List;

public class RicettaVeloce extends RicettaBase {
    private int tempoDiminuito;



    public RicettaVeloce(String titolo, String descrizione, int tempoPreparazioneTotale, int tempoCottura, int numeroPorzioni, int valutazione, CategoriaPasto categoriaPasto, Difficolta difficolta, List<PassoDiPreparazione> passi) {
        super(titolo, descrizione, tempoPreparazioneTotale, tempoCottura, numeroPorzioni, valutazione, categoriaPasto, difficolta, passi);
    }
    public int getTempoDiminuito() {
        return tempoDiminuito;
    }

    public void setTempoDiminuito(int tempoDiminuito) {
        this.tempoDiminuito = tempoDiminuito;
    }
}
