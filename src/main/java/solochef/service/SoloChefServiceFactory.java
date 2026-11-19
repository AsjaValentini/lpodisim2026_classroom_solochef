package solochef.service;

import solochef.service.impl.file.FileSoloChefServiceFactoryImpl;
import solochef.service.impl.ram.RAMIngredienteServiceImpl;
import solochef.service.impl.ram.RAMSoloChefServiceFactoryImpl;

public abstract class  SoloChefServiceFactory {
    //private static final SoloChefServiceFactory factory = new FileSoloChefServiceFactoryImpl();


    private static final SoloChefServiceFactory factory = new RAMSoloChefServiceFactoryImpl();
    //private  IngredienteService ingredienteService = new FileIngredienteServiceImpl();


    public static SoloChefServiceFactory getInstance() {
        return factory;
    }

    public abstract ProfiloUtenteService getProfiloUtenteService();
    public abstract IngredienteService getIngredienteService() ;
    }


