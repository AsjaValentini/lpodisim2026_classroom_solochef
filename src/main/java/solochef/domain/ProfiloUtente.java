package solochef.domain;

import solochef.enumerazioni.Allergene;
import solochef.enumerazioni.TipoDiDieta;

import java.util.ArrayList;
import java.util.List;

public class ProfiloUtente {
    private Integer id;
    private int numeroPersoneInFamiglia;

    private Allergene allergeneDaEvitare;

    private TipoDiDieta dieta;

    private ArrayList<PianoSettimanale> pianoSettimanale;

    public ProfiloUtente(int numeroPersoneInFamiglia, Allergene allergeneDaEvitare, TipoDiDieta dieta, ArrayList<PianoSettimanale> pianoSettimanale) {
        this.numeroPersoneInFamiglia = numeroPersoneInFamiglia;
        this.allergeneDaEvitare = allergeneDaEvitare;
        this.dieta = dieta;
        this.pianoSettimanale = pianoSettimanale;
    }

    public Integer getId() {
        return id;
    }

    public int getNumeroPersoneInFamiglia() {
        return numeroPersoneInFamiglia;
    }

    public void setNumeroPersoneInFamiglia(int numeroPersoneInFamiglia) {
        this.numeroPersoneInFamiglia = numeroPersoneInFamiglia;
    }

    public Allergene getAllergeneDaEvitare() {
        return allergeneDaEvitare;
    }

    public void setAllergeneDaEvitare(Allergene allergeneDaEvitare) {
        this.allergeneDaEvitare = allergeneDaEvitare;
    }

    public TipoDiDieta getDieta() {
        return dieta;
    }

    public void setDieta(TipoDiDieta dieta) {
        this.dieta = dieta;
    }

    public ArrayList<PianoSettimanale> getPianoSettimanale() {
        return pianoSettimanale;
    }

    public void setPianoSettimanale(ArrayList<PianoSettimanale> pianoSettimanale) {
        this.pianoSettimanale = pianoSettimanale;
    }


}
