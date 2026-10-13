package solochef.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HomeController {

    @FXML
    private BorderPane rootPane;

    @FXML
    private VBox menuLaterale;

    @FXML
    private VBox contenutoCentrale;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnRicette;

    @FXML
    private Button btnNuovaRicetta;

    @FXML
    private Button btnPreferite;

    @FXML
    private Button btnImpostazioni;

    @FXML
    private Label lblTitolo;

    @FXML
    private Label lblSottotitolo;

    @FXML
    public void initialize() {
        System.out.println("Home caricata correttamente!");
    }
}