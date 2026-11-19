
package solochef.service.impl.file;

import solochef.service.ProfiloUtenteService;
import solochef.service.IngredienteService;
import solochef.service.SoloChefServiceFactory;

public class FileSoloChefServiceFactoryImpl extends SoloChefServiceFactory {

    private final ProfiloUtenteService profiloUtenteService;
    private final IngredienteService ingredienteService;

    public FileSoloChefServiceFactoryImpl() {
        profiloUtenteService = new FileProfiloUtenteServiceImpl();

        try {
            ingredienteService = new FileIngredienteServiceImpl();
        } catch (java.io.IOException e) {
            throw new RuntimeException("Errore nel caricamento degli ingredienti", e);
        }
    }

    @Override
    public ProfiloUtenteService getProfiloUtenteService() {
        return profiloUtenteService;
    }

    @Override
    public IngredienteService getIngredienteService() {
        return ingredienteService;
    }
}
