
package solochef.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import solochef.domain.ProfiloUtente;
import solochef.enumerazioni.Allergene;
import solochef.enumerazioni.TipoDiDieta;
import solochef.service.ProfiloUtenteService;
import solochef.service.SoloChefServiceFactory;
import solochef.view.ViewDispatcher;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProfiloController implements Initializable, DataInitializable<ProfiloUtente> {


    @FXML
    private Label labelTitolo;

    @FXML
    private Label labelDieta;


    @FXML
    private AnchorPane baseProfilo;

    @FXML
    private Button bottoneSalvaDieta;
    @FXML
    private Label labelAllergeni;

    @FXML
    private Button bottoneSalvaAllergeni;
    @FXML
    private Label labelNumeroPersone;
    @FXML
    private Spinner<Integer> spinnerNumeroPersone;
    @FXML
    private Button bottoneSalvaPersone;
    @FXML
    private VBox boxDiete;

    @FXML
    private VBox boxAllergeni;

    private ProfiloUtenteService profiloUtenteService;

    private ProfiloUtente profiloUtente;

    // Lista delle checkbox delle diete
    private final List<CheckBox> checkboxDiete = new ArrayList<>();

    // Lista dei nomi delle diete
    private final List<TipoDiDieta> nomiDiete = new ArrayList<>();
    private final List<Allergene> nomiAllergeni = new ArrayList<>();
    private final List<CheckBox> checkboxAllergeni = new ArrayList<>();

    private ViewDispatcher viewDispatcher;

    // Indice della riga corrente nella GridPane
    private int rigaCorrente = 0;


    public ProfiloController() {

        viewDispatcher = ViewDispatcher.getInstance();

        SoloChefServiceFactory factory = SoloChefServiceFactory.getInstance();

        profiloUtenteService = factory.getProfiloUtenteService();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20);

        spinnerNumeroPersone.setValueFactory(valueFactory);

        boxDiete.setSpacing(12);
        boxAllergeni.setSpacing(12);



    }


    // Inizializza i dati del profilo
    @Override
    public void initializeData(ProfiloUtente profiloUtente) {

        if (profiloUtente == null) {
            return;
        }

        this.profiloUtente = profiloUtente;

        // Recupera le diete già salvate nel profilo
        List<TipoDiDieta> dieteSalvate = profiloUtente.getDieta();

        if (dieteSalvate == null) {
            dieteSalvate = new ArrayList<>();
        }

        // Pulisce la griglia e le liste
        boxDiete.getChildren().clear();
        checkboxDiete.clear();
        nomiDiete.clear();
        rigaCorrente = 0;

        // Carica esclusivamente le diete dell'enumerazione
        for (TipoDiDieta dieta : TipoDiDieta.values()) {

            aggiungiRiga(dieta);

        }

        // Ripristina le checkbox delle diete già salvate
        for (int i = 0; i < nomiDiete.size(); i++) {

            if (dieteSalvate.contains(nomiDiete.get(i))) {

                checkboxDiete.get(i).setSelected(true);

            }
        }
        List<Allergene> allergeniSalvati =
                profiloUtente.getAllergeneDaEvitare();

        if (allergeniSalvati == null) {
            allergeniSalvati = new ArrayList<>();
        }

        boxAllergeni.getChildren().clear();
        checkboxAllergeni.clear();
        nomiAllergeni.clear();

        rigaCorrente = 0;

        for (Allergene allergene : Allergene.values()) {
            aggiungiRigaAllergene(allergene);
        }

        for (int i = 0; i < nomiAllergeni.size(); i++) {
            if (allergeniSalvati.contains(nomiAllergeni.get(i))) {
                checkboxAllergeni.get(i).setSelected(true);
            }
        }

        // CARICAMENTO NUMERO PERSONE
        spinnerNumeroPersone.getValueFactory()
                .setValue(profiloUtente.getNumeroPersoneInFamiglia());
    }





    // Crea una riga con la checkbox relativa alla dieta
    private void aggiungiRiga(TipoDiDieta nomeDieta) {

        CheckBox checkbox = new CheckBox(nomeDieta.name());

        checkboxDiete.add(checkbox);

        nomiDiete.add(nomeDieta);

        boxDiete.getChildren().add(checkbox);

        rigaCorrente++;
    }
    private void aggiungiRigaAllergene(Allergene nomeAllergene) {

        CheckBox checkbox = new CheckBox(nomeAllergene.name());

        checkboxAllergeni.add(checkbox);

        nomiAllergeni.add(nomeAllergene);

        boxAllergeni.getChildren().add(checkbox);

        rigaCorrente++;
    }


    // Salva le diete selezionate dall'utente
    @FXML
    private void salvaDieta() {

        if (profiloUtente == null) {
            return;
        }

      List <TipoDiDieta> dieteSelezionate =new ArrayList<>() ;

        // Controlla tutte le checkbox
        for (int i = 0; i < checkboxDiete.size(); i++) {

            if (checkboxDiete.get(i).isSelected()) {

                dieteSelezionate.add(nomiDiete.get(i));

            }
        }

        // Aggiorna le diete del profilo
        profiloUtente.setDieta(dieteSelezionate);

        System.out.println("Diete selezionate: " + dieteSelezionate);

        // Salva il profilo
        try {

            profiloUtenteService.salvaProfilo(profiloUtente);

            System.out.println("Diete salvate correttamente!");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    @FXML
    public void salvaAllergene(){
        if (profiloUtente == null) {
            return;
        }

        List<Allergene> allergeniSelezionati= new ArrayList<>();

        // Controlla tutte le checkbox
        for (int i = 0; i < checkboxAllergeni.size(); i++) {

            if (checkboxAllergeni.get(i).isSelected()) {

                allergeniSelezionati.add(nomiAllergeni.get(i));

            }
        }

        // Aggiorna le diete del profilo
        profiloUtente.setAllergeneDaEvitare(allergeniSelezionati);

        System.out.println("Diete selezionate: " + allergeniSelezionati);

        // Salva il profilo
        try {

            profiloUtenteService.salvaProfilo(profiloUtente);

            System.out.println("Allergeni salvati correttamente!");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    @FXML
    public void salvaPersone(){
        int numeroPersone = spinnerNumeroPersone.getValue();

        profiloUtente.setNumeroPersoneInFamiglia(numeroPersone);
        try {

            profiloUtenteService.salvaProfilo(profiloUtente);

            System.out.println("Persone salvate correttamente!");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    }


