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
    private static final String FXML_SUFFIX = ".fxml";

    public void mostraBenvenuto(Stage stage) throws ViewException, IOException {
         this.stage = stage;

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/viste/home.fxml"));

        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setTitle("SoloChef");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        }
     /*        try {
            layout = (BorderPane) caricaVista("layout");

            Parent home = caricaVista("home");

            layout.setCenter(home);

            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.show();

        } catch (ViewException e) {
            throw new ViewException(e);
        }
    }*/

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
                            RESOURCE_BASE + nomeVistaCaricata + FXML_SUFFIX));

            return loader.load();

        } catch (IOException | NullPointerException e) {
            throw new ViewException(e);
        }
    }
}
