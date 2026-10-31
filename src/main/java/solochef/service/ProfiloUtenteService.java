package solochef.service;

import solochef.domain.ProfiloUtente;

import java.io.IOException;

public interface ProfiloUtenteService {
    void salvaProfilo(ProfiloUtente profilo) throws IOException;

    ProfiloUtente caricaProfilo() throws IOException;
}
