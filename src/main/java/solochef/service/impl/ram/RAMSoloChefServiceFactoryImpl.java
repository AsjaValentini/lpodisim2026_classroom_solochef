
package solochef.service.impl.ram;

import solochef.service.IngredienteService;
import solochef.service.ProfiloUtenteService;
import solochef.service.SoloChefServiceFactory;

public class RAMSoloChefServiceFactoryImpl extends SoloChefServiceFactory {

    private final IngredienteService ingredienteService;
    private final ProfiloUtenteService profiloUtenteService;

    public RAMSoloChefServiceFactoryImpl() {
        ingredienteService = new RAMIngredienteServiceImpl();
        profiloUtenteService = new RAMProfiloUtenteServiceImpl();
    }

    @Override
    public IngredienteService getIngredienteService() {
        return ingredienteService;
    }

    @Override
    public ProfiloUtenteService getProfiloUtenteService() {
        return profiloUtenteService;
    }
}
