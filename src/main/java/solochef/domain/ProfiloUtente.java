package solochef.domain;

import solochef.enumerazioni.Allergene;
import solochef.enumerazioni.TipoDiDieta;

import java.io.Serializable;
import java.util.*;

public class ProfiloUtente implements Serializable {
    private Integer id;
    private int numeroPersoneInFamiglia;

    private Set<Allergene> allergeneDaEvitare;

    private List<String> dieta;

    private ArrayList<PianoSettimanale> pianoSettimanale;

    public ProfiloUtente(int numeroPersoneInFamiglia,ArrayList<PianoSettimanale> pianoSettimanale) {
        this.numeroPersoneInFamiglia = numeroPersoneInFamiglia;
        this.allergeneDaEvitare = new HashSet<>();
        this.dieta = new ArrayList<>();
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

    public Set<Allergene> getAllergeneDaEvitare() {
        return allergeneDaEvitare;
    }

    public void setAllergeneDaEvitare(Set<Allergene> allergeneDaEvitare) {
        this.allergeneDaEvitare = allergeneDaEvitare;
    }

    public List<String> getDieta() {
        return dieta;
    }

    public ProfiloUtente() {
    }

    public void setDieta(List<String> dieta) {
        this.dieta = dieta;
    }

    public ArrayList<PianoSettimanale> getPianoSettimanale() {
        return pianoSettimanale;
    }

    public void setPianoSettimanale(ArrayList<PianoSettimanale> pianoSettimanale) {
        this.pianoSettimanale = pianoSettimanale;
    }


    @Override
    public String toString() {
        return "ProfiloUtente{" +
                "numeroPersoneInFamiglia=" + numeroPersoneInFamiglia +
                ", allergeneDaEvitare=" + allergeneDaEvitare +
                ", dieta=" + dieta +
                ", pianoSettimanale=" + pianoSettimanale +
                '}';
    }
}
