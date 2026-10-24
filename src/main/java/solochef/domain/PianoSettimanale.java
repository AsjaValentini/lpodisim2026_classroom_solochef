package solochef.domain;

import solochef.enumerazioni.CategoriaPasto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PianoSettimanale {
    private Integer id;
    private LocalDate dataInizio;

    private ProfiloUtente utente ;
    private Map<DayOfWeek, Map<CategoriaPasto, List<RicettaBase>>> pianoSettimanale;

    public PianoSettimanale(LocalDate dataInizio, ProfiloUtente utente, Map<DayOfWeek, Map<CategoriaPasto, List<RicettaBase>>> pianoSettimanale) {
        this.dataInizio = dataInizio;
        this.utente = utente;
        this.pianoSettimanale = pianoSettimanale;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public ProfiloUtente getUtente() {
        return utente;
    }

    public void setUtente(ProfiloUtente utente) {
        this.utente = utente;
    }

    public Map<DayOfWeek, Map<CategoriaPasto, List<RicettaBase>>> getPianoSettimanale() {
        return pianoSettimanale;
    }

    public void setPianoSettimanale(Map<DayOfWeek, Map<CategoriaPasto, List<RicettaBase>>> pianoSettimanale) {
        this.pianoSettimanale = pianoSettimanale;
    }


}
