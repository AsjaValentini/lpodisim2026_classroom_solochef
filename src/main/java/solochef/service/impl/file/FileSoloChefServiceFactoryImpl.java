package solochef.service.impl.file;

import solochef.service.ProfiloUtenteService;
import solochef.service.SoloChefServiceFactory;

public class FileSoloChefServiceFactoryImpl extends SoloChefServiceFactory {

    private final ProfiloUtenteService profiloUtenteService;

    public FileSoloChefServiceFactoryImpl() {
        profiloUtenteService = new FileProfiloUtenteServiceImpl();
    }

    @Override
    public ProfiloUtenteService getProfiloUtenteService() {
        return profiloUtenteService;
    }
}
