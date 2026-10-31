package solochef.service;

import solochef.service.impl.file.FileSoloChefServiceFactoryImpl;

public abstract class  SoloChefServiceFactory {
    private static final SoloChefServiceFactory factory = new FileSoloChefServiceFactoryImpl();

    public static SoloChefServiceFactory getInstance() {
        return factory;
    }

    public abstract ProfiloUtenteService getProfiloUtenteService();
}

