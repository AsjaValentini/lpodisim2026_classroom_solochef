package solochef;

import javafx.application.Application;
import javafx.stage.Stage;
import solochef.domain.ProfiloUtente;
import solochef.service.ProfiloUtenteService;
import solochef.service.SoloChefServiceFactory;
import solochef.util.Logger;
import solochef.view.ViewDispatcher;
import solochef.view.ViewException;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

 /*   @Override
    public void start(Stage stage) throws ViewException {
        ViewDispatcher dispatcher =
                ViewDispatcher.getInstance();

        dispatcher.mostraBenvenuto(stage);
    }*/

    @Override
    public void start(Stage stage) throws Exception {
     //   Logger.getInstance().writeLog("Applicazione avviata");

        ProfiloUtenteService profiloService = SoloChefServiceFactory.getInstance().getProfiloUtenteService();

        ProfiloUtente profilo;
        try {
            profilo = profiloService.caricaProfilo();
        } catch (IOException e) {
            Logger.getInstance().writeLog("ERRORE caricamento profilo: " + e.getMessage());
            profilo = new ProfiloUtente();
        }

        ViewDispatcher dispatcher = ViewDispatcher.getInstance();
        dispatcher.mostraBenvenuto(stage,profilo);   // o il metodo che usi tu per aprire il layout
    }
}