package solochef.domain;

import solochef.enumerazioni.CategoriaPasto;
import solochef.enumerazioni.Difficolta;

import java.util.List;

public class RicettaTradizionale extends RicettaBase{
    private String regioneOrigine;




    public RicettaTradizionale(String titolo, String descrizione, int tempoPreparazioneTotale, int tempoCottura, int numeroPorzioni, int valutazione, CategoriaPasto categoriaPasto, Difficolta difficolta, List<PassoDiPreparazione> passi) {
        super(titolo, descrizione, tempoPreparazioneTotale, tempoCottura, numeroPorzioni, valutazione, categoriaPasto, difficolta, passi);
    }
    public String getRegioneOrigine() {
        return regioneOrigine;
    }

    public void setRegioneOrigine(String regioneOrigine) {
        this.regioneOrigine = regioneOrigine;
    }

}
