package solochef.view;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import solochef.controller.DataInitializable;


public class ViewDispatcher {

    private static final String RESOURCE_BASE = "/viste/";
    private static final String FXML_SUFFIX = ".fxml";

    private static ViewDispatcher instance = new ViewDispatcher();

    private Stage stage;
    private BorderPane layout;

    private ViewDispatcher() {
    }
    public static ViewDispatcher getInstance() {
        return instance;
    }


    public void mostraBenvenuto(Stage stage) throws ViewException {
        this.stage = stage;

        try {
            URL url = getClass().getResource(
                    RESOURCE_BASE + "layout" + FXML_SUFFIX);

            if (url == null) {
                throw new IOException(
                        "File layout.fxml non trovato.");
            }

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            if (!(root instanceof BorderPane)) {
                throw new IOException(
                        "layout.fxml deve avere un BorderPane come radice.");
            }

            layout = (BorderPane) root;

            Scene scene = new Scene(layout);

            stage.setTitle("SoloChef");
            stage.setScene(scene);
            stage.setResizable(false);

            // La Home non richiede dati iniziali.
            renderView("home", (Void) null);

            stage.show();

        } catch (IOException e) {
            throw new ViewException(e);
        }
    }




    public <T> void renderView(String viewName, T data) {
        try {
            View<T> view = loadView(viewName);
            DataInitializable<T> controller = view.getController();
            controller.initializeData(data);
            layout.setCenter(view.getView());
        } catch (ViewException e) {
            renderError(e);
        }
    }

    public void renderError(Exception e) {
        e.printStackTrace();
        System.exit(1);
    }



    private <T> View<T> loadView(String viewName) throws ViewException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(RESOURCE_BASE + viewName + FXML_SUFFIX));
            Parent parent = (Parent) loader.load();
            return new View<>(parent, loader.getController());

        } catch (IOException ex) {
            throw new ViewException(ex);
        }
    }
}