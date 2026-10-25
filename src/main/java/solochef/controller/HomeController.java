package solochef.controller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import solochef.domain.ProfiloUtente;
import solochef.view.ViewDispatcher;


public class HomeController implements DataInitializable<ProfiloUtente>  {

    @FXML
    private Label labelBenvenuto;


    @FXML
    public void initialize() {
        System.out.println("Home caricata correttamente!");
    }
}

