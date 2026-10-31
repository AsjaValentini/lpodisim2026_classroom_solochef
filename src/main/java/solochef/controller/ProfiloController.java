package solochef.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import solochef.domain.ProfiloUtente;
import solochef.enumerazioni.TipoDiDieta;
import solochef.service.ProfiloUtenteService;
import solochef.service.SoloChefServiceFactory;
import solochef.view.ViewDispatcher;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProfiloController implements Initializable, DataInitializable<ProfiloUtente> {
    @FXML
    private TextField inputTesto;
    @FXML
    private Label labelTitolo;
    @FXML
    private Label labelDieta;
    @FXML
    private Button bottoneModifica;
    @FXML
    private Button bottoneAggiungi;

   @FXML
    private AnchorPane baseProfilo;
   @FXML
   private GridPane grigliaDiete;

   @FXML
   private Button bottoneSalva;

    private ProfiloUtenteService profiloUtenteService;

    private ProfiloUtente profiloUtente;
    private final List<CheckBox> checkboxDiete = new ArrayList<>();
    private final List<String> nomiDiete = new ArrayList<>();

    private ViewDispatcher viewDispatcher ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public ProfiloController() {
        viewDispatcher = ViewDispatcher.getInstance();

        SoloChefServiceFactory factory = SoloChefServiceFactory.getInstance();
        profiloUtenteService = factory.getProfiloUtenteService();
        System.out.println("Servizio inizializzato: " + profiloUtenteService);
    }


    @Override
    public void initializeData(ProfiloUtente profiloUtente) {
        this.profiloUtente = profiloUtente;

        // Recupera le diete già salvate
        List<String> dieteSalvate = profiloUtente.getDieta();

        if (dieteSalvate == null) {
            dieteSalvate = new ArrayList<>();
        }

        // Pulisce i controlli e le liste della schermata
        grigliaDiete.getChildren().clear();
        checkboxDiete.clear();
        nomiDiete.clear();
        rigaCorrente = 0;

        // Inserisce le diete predefinite
        for (TipoDiDieta dieta : TipoDiDieta.values()) {
            aggiungiRiga(dieta.toString());
        }

        // Aggiunge eventuali diete personalizzate già salvate
        for (String dieta : dieteSalvate) {
            if (!nomiDiete.contains(dieta)) {
                aggiungiRiga(dieta);
            }
        }

        // Ripristina le selezioni precedenti
        for (int i = 0; i < nomiDiete.size(); i++) {
            if (dieteSalvate.contains(nomiDiete.get(i))) {
                checkboxDiete.get(i).setSelected(true);
            }
        }

        System.out.println("Diete caricate: " + dieteSalvate);
    }


    private int rigaCorrente = TipoDiDieta.values().length;
    @FXML
    private void azioneAggiungi(){
        String nuovaDieta = inputTesto.getText().trim();

        if (!nuovaDieta.isEmpty()) {

            aggiungiRiga(nuovaDieta);

            inputTesto.clear();
        }
    }


    private void aggiungiRiga(String nomeDieta) {

        CheckBox checkBox = new CheckBox();

        Label label = new Label(nomeDieta);

        grigliaDiete.add(checkBox, 0, rigaCorrente);
        grigliaDiete.add(label, 1, rigaCorrente);
        checkboxDiete.add(checkBox);
        nomiDiete.add(nomeDieta);
        rigaCorrente++;

    }

    @FXML
    private void salvaDieta() {
        List<String> dieteSelezionate = new ArrayList<>();

        for (int i = 0; i < checkboxDiete.size(); i++) {
            if (checkboxDiete.get(i).isSelected()) {
                dieteSelezionate.add(nomiDiete.get(i));
            }
        }


        profiloUtente.setDieta(dieteSelezionate);

        System.out.println("Diete salvate: " + profiloUtente.getDieta());
        try {
            profiloUtenteService.salvaProfilo(profiloUtente);
            System.out.println("Diete salvate correttamente!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }





