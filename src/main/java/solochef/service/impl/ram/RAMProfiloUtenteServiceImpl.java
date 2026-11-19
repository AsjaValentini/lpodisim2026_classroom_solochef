package solochef.service.impl.ram;

import solochef.domain.ProfiloUtente;
import solochef.service.ProfiloUtenteService;

import java.io.IOException;

public class RAMProfiloUtenteServiceImpl implements ProfiloUtenteService {

        private ProfiloUtente profilo;

        public RAMProfiloUtenteServiceImpl() {
            this.profilo = new ProfiloUtente();
        }

        @Override
        public void salvaProfilo(ProfiloUtente profilo) throws IOException {
            if (profilo == null) {
                throw new IllegalArgumentException("Il profilo non può essere nullo");
            }

            this.profilo = profilo;
        }

        @Override
        public ProfiloUtente caricaProfilo() throws IOException {
            return profilo;
        }
    }

