package solochef.controller;



import javafx.fxml.FXML;

import javafx.scene.control.Label;


public class HomeController  {

    @FXML
    private Label labelBenvenuto;


    @FXML
    public void initialize() {
        System.out.println("Home caricata correttamente!");
    }


}