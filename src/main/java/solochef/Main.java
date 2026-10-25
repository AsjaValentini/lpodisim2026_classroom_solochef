package solochef;

import javafx.application.Application;
import javafx.stage.Stage;
import solochef.view.ViewDispatcher;
import solochef.view.ViewException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws ViewException {
        ViewDispatcher dispatcher =
                ViewDispatcher.getInstance();

        dispatcher.mostraBenvenuto(stage);
    }
}