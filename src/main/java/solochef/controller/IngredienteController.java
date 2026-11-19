package solochef.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import solochef.domain.Ingrediente;
import solochef.domain.ProfiloUtente;

import javafx.event.ActionEvent;
import solochef.enumerazioni.Allergene;
import solochef.enumerazioni.CategoriaMerceologica;
import solochef.enumerazioni.TipoDiDieta;
import solochef.service.IngredienteService;
import solochef.view.ViewDispatcher;
import solochef.service.SoloChefServiceFactory;


import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;


public class IngredienteController implements Initializable, DataInitializable<Ingrediente> {

    @FXML
    private Button bottoneAggiungiIngrediente;

    @FXML
    private Button bottoneCercaIngrediente;

    @FXML
    private Button bottoneResetFiltri;

    @FXML
    private MenuButton bottoneCategoria;
    @FXML
    private MenuButton bottoneAllergeni;


    @FXML
    private TextField ricercaIngredientiNome;

    @FXML
    private TableView<Ingrediente> tabellaIngredienti;

    @FXML
    private TableColumn<Ingrediente, String> colonnaNomeIngrediente;

    @FXML
    private TableColumn<Ingrediente, String> colonnaUnitaDiMisura;

    @FXML
    private TableColumn<Ingrediente, Double> colonnaCalorie;

    @FXML
    private TableColumn<Ingrediente, CategoriaMerceologica> colonnaCategoriaMerceologica;

    @FXML
    private TableColumn<Ingrediente, Allergene> colonnaAllergene;


    private ObservableList<Ingrediente> listaIngredienti = FXCollections.observableArrayList();

    private IngredienteService ingredienteService;
    private List<CategoriaMerceologica> categorieSelezionate = new ArrayList<>();
    private List<Allergene> allergeniSelezionati = new ArrayList<>();
    private List<Ingrediente> tuttiGliIngredienti = new ArrayList<>();

    @FXML
    void aggiungiIngrediente(ActionEvent event) {
        ViewDispatcher.getInstance().renderView("aggiuntaIngrediente", null);

    }

    @FXML
    void cercaIngrediente(ActionEvent event) {
        filtraIngredienti();
    }


    @FXML
    void resetDeiFiltri(ActionEvent event) {

        // Svuota la ricerca per nome
        ricercaIngredientiNome.clear();
        // Svuota le categorie selezionate
        categorieSelezionate.clear();
        // Svuota gli allergeni selezionati
        allergeniSelezionati.clear();

        //Deselezioniamo le checkbox selezionate per gli allergeni
        for (MenuItem allergeni : bottoneAllergeni.getItems()) {
            CustomMenuItem allergeniScelti = (CustomMenuItem) allergeni;
            CheckBox checkBoxAllergeni = (CheckBox) allergeniScelti.getContent();
            checkBoxAllergeni.setSelected(false);
        }

        //Deselezioniamo le checkbox selezionate per le categorie
        for (MenuItem categoria : bottoneCategoria.getItems()) {
            CustomMenuItem categorieScelte = (CustomMenuItem) categoria;
            CheckBox checkBoxCategorie = (CheckBox) categorieScelte.getContent();
            checkBoxCategorie.setSelected(false);
        }
        // Aggiorna la tabella così mostrerà di nuovo tutti gli ingredienti
        filtraIngredienti();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ingredienteService = SoloChefServiceFactory.getInstance().getIngredienteService();

        //riempire le colonne
        tabellaIngredienti.setItems(listaIngredienti);

        // Collegamento delle colonne ai getter di Ingrediente
        colonnaNomeIngrediente.setCellValueFactory(new PropertyValueFactory<>("nomeIngrediente"));
        colonnaUnitaDiMisura.setCellValueFactory(new PropertyValueFactory<>("unitaDiMisura"));
        colonnaCalorie.setCellValueFactory(new PropertyValueFactory<>("caloriePerUnita"));
        colonnaCategoriaMerceologica.setCellValueFactory(new PropertyValueFactory<>("categoriaMerceologica"));
        colonnaAllergene.setCellValueFactory(new PropertyValueFactory<>("allergene"));


        //Metodo per popolare il MenuButton e gestione del filtro per quanto riguarda gli allergeni
        for (Allergene allergene : Allergene.values()) {

            CheckBox checkBox = new CheckBox(allergene.name());
            CustomMenuItem item = new CustomMenuItem(checkBox);
            item.setHideOnClick(false);
            checkBox.setOnAction(event -> {
                if (checkBox.isSelected()) {
                    allergeniSelezionati.add(allergene);
                } else {
                    allergeniSelezionati.remove(allergene);
                }
                filtraIngredienti();
            });

            bottoneAllergeni.getItems().add(item);
        }

        //Metodo per popolare il MenuButton e gestione del filtro per quanto riguarda le categorie
        for (CategoriaMerceologica categoria : CategoriaMerceologica.values()) {
            CheckBox checkBox = new CheckBox(categoria.name());
            CustomMenuItem item = new CustomMenuItem(checkBox);
            item.setHideOnClick(false);
            checkBox.setOnAction(event -> {
                if (checkBox.isSelected()) {
                    categorieSelezionate.add(categoria);
                } else {
                    categorieSelezionate.remove(categoria);
                }
                filtraIngredienti();
            });

            bottoneCategoria.getItems().add(item);
        }


    }

    /*Metodo per filtrare gli ingredienti singolarmente per nome categoria e allergene o anche tutti e tre insieme
     verranno mostrati i relativi risultati per il nome ,per la categoria scelta e per gli ingredienti che non hanno l'allergene scelto
     */
    private void filtraIngredienti() {


            String nome = ricercaIngredientiNome.getText();

            List<Ingrediente> risultati = ingredienteService.applicaFiltri(
                    nome,
                    new HashSet<>(categorieSelezionate),
                    new HashSet<>(allergeniSelezionati)
            );

            listaIngredienti.setAll(risultati);
        }



    @Override
    public void initializeData(Ingrediente ingrediente) {
        tuttiGliIngredienti = ingredienteService.getIngredienti();
        listaIngredienti.setAll(tuttiGliIngredienti);

        }

    }




