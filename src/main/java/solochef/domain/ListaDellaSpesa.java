package solochef.domain;

import java.util.ArrayList;

public class ListaDellaSpesa {
private Integer id;
private PianoSettimanale piano;
private ArrayList<VoceListaDellaSpesa> voci;

    public Integer getId() {
        return id;
    }

    public ListaDellaSpesa(PianoSettimanale piano, ArrayList<VoceListaDellaSpesa> voci) {
        this.piano = piano;
        this.voci = voci;
    }

    public PianoSettimanale getPiano() {
        return piano;
    }

    public void setPiano(PianoSettimanale piano) {
        this.piano = piano;
    }

    public ArrayList<VoceListaDellaSpesa> getVoci() {
        return voci;
    }

    public void setVoci(ArrayList<VoceListaDellaSpesa> voci) {
        this.voci = voci;
    }
}
