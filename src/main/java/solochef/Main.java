package solochef;

import javafx.application.Application;
import javafx.stage.Stage;
import solochef.view.ViewDispatcher;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewDispatcher dispatcher = ViewDispatcher.getInstance();
        dispatcher.mostraBenvenuto(stage);
    }
}