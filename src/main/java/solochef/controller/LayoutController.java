package solochef.controller;


import javafx.fxml.FXML;

import javafx.scene.control.Button;
import solochef.domain.ProfiloUtente;
import solochef.view.ViewDispatcher;
import solochef.view.ViewException;

public class LayoutController implements DataInitializable<ProfiloUtente> {
    @FXML
    private Button bottoneHome;
    @FXML
    private Button bottoneProfilo;
    @FXML
    private Button bottoneRicettario;
    @FXML
    private Button bottoneIngredienti;
    @FXML
    private Button bottonePianoSettimanale;
    @FXML
    private Button bottoneListaSpesa;


   private ProfiloUtente utente;


    @FXML
    private void homeAction() {
        ViewDispatcher.getInstance().renderView("home", utente);
    }

    @FXML
    private void profiloAction() {
        ViewDispatcher.getInstance().renderView("profilo",utente);
    }
}
