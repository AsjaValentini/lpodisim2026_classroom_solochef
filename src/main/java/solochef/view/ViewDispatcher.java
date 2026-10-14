package solochef.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewDispatcher {
    private static ViewDispatcher instance = new ViewDispatcher();
    private Stage stage;
    private BorderPane layout;

    private ViewDispatcher() {
    }

    public static ViewDispatcher getInstance() {
        return instance;
    }

    private static final String RESOURCE_BASE = "/viste/";
    private static final String FXML_SUFFISSO = ".fxml";


    // Mostra il layout principale
    public void mostraBenvenuto(Stage stage) throws ViewException, IOException {
         this.stage = stage;

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/viste/layout.fxml"));

      //  Parent root = loader.load();
        layout = (BorderPane) loader.load();
        Scene scene = new Scene(layout);

        stage.setTitle("SoloChef");
        stage.setScene(scene);
        stage.setResizable(false);
        //carica la home nella zona centrale
        cambiaVista("home");
        stage.show();

        }
    

    // Cambia la vista centrale
    public void cambiaVista(String nomeVista)
            throws ViewException {
        Parent view = caricaVista(nomeVista);
        layout.setCenter(view);
    }

    // Carica una vista FXML
    private Parent caricaVista(String nomeVistaCaricata)
            throws ViewException {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            RESOURCE_BASE + nomeVistaCaricata + FXML_SUFFISSO));

            return loader.load();

        } catch (IOException | NullPointerException e) {
            throw new ViewException(e);
        }
    }
}
