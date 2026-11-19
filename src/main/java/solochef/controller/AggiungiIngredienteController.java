
package solochef.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import solochef.domain.Ingrediente;
import solochef.enumerazioni.Allergene;
import solochef.enumerazioni.CategoriaMerceologica;
import solochef.service.IngredienteService;
import solochef.service.SoloChefServiceFactory;
import solochef.view.ViewDispatcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AggiungiIngredienteController
        implements Initializable, DataInitializable<Ingrediente> {

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldUnita;

    @FXML
    private TextField textFieldCalorie;

    @FXML
    private MenuButton menuButtonCategorie;

    @FXML
    private MenuButton menuButtonAllergeni;

    @FXML
    private Button bottoneSalvaIngrediente;

    @FXML
    private Button bottoneAnnulla;

    @FXML
    private Label labelConfermaAllergene;

    @FXML
    private Label labelConfermaCategoria;

    private CategoriaMerceologica categoriaSelezionata;
    private Allergene allergeneSelezionato;

    private IngredienteService ingredienteService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ingredienteService = SoloChefServiceFactory.getInstance().getIngredienteService();
        //Visualizzazione categoria merceologica
        for (CategoriaMerceologica categoria : CategoriaMerceologica.values()) {
            CheckBox checkBox = new CheckBox(categoria.name());
            CustomMenuItem sceltaCategoria = new CustomMenuItem(checkBox);
            sceltaCategoria.setHideOnClick(true);

            checkBox.setOnAction(event -> {

                // Deselezione di tutte le altre check-box tranne la scelta
                for (MenuItem menuItem : menuButtonCategorie.getItems()) {
                    if (menuItem instanceof CustomMenuItem altraCategoria && altraCategoria.getContent() instanceof CheckBox altraCheckBox && altraCheckBox != checkBox) {
                        altraCheckBox.setSelected(false);
                        }
                    }
                categoriaSelezionata = categoria;
                menuButtonCategorie.setText(categoria.name());

                labelConfermaCategoria.setText("Categoria selezionata: " + categoria.name()
                );
            });

            menuButtonCategorie.getItems().add(sceltaCategoria);
        }

        for (Allergene allergene : Allergene.values()) {

            CheckBox checkBox = new CheckBox(allergene.name());
            CustomMenuItem scelta = new CustomMenuItem(checkBox);
            scelta.setHideOnClick(true);
            checkBox.setOnAction(event -> {
                for (MenuItem menuItem : menuButtonAllergeni.getItems()) {

                    if (menuItem instanceof CustomMenuItem altraScelta && altraScelta.getContent() instanceof CheckBox altraCheckBox && altraCheckBox != checkBox) {

                        altraCheckBox.setSelected(false);
                    }
                }

                allergeneSelezionato = allergene;
                menuButtonAllergeni.setText(allergene.name());

                labelConfermaAllergene.setText("Allergene selezionato: " + allergene.name()
                );
            });

            menuButtonAllergeni.getItems().add(scelta);
        }
    }
        @FXML
    public void salvaIngredienteAggiunto() throws IOException {

        String nome = textFieldNome.getText().trim();
        String unita = textFieldUnita.getText().trim();

        // Controllo dei campi testuali
        if (nome.isEmpty() || unita.isEmpty() || textFieldCalorie.getText().trim().isEmpty()) {
            System.out.println("Compila tutti i campi obbligatori.");
            return;
        }

        // Controllo della categoria
        if (categoriaSelezionata == null) {
            System.out.println("Seleziona una categoria merceologica.");
            return;
        }

        // Controllo dell'allergene
        if (allergeneSelezionato == null) {
            System.out.println("Seleziona un allergene.");
            return;
        }

        // Conversione delle calorie
        double calorie;

        try {
            calorie = Double.parseDouble(textFieldCalorie.getText().trim().replace(',', '.')
            );

            if (calorie < 0) {
                System.out.println("Le calorie non possono essere negative.");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println("Inserisci un valore numerico valido per le calorie.");
            return;
        }

        // Creazione dell'ingrediente
        Ingrediente daAggiungere = new Ingrediente(nome, unita, calorie, categoriaSelezionata, allergeneSelezionato);

        ingredienteService.aggiungiIngrediente(daAggiungere);

        // Ritorno alla vista principale
        ViewDispatcher.getInstance().renderView("ingrediente", null);
    }

    @FXML
    public void annullaAggiunta(ActionEvent event) {
        ViewDispatcher.getInstance().renderView("ingrediente", null);
    }


    @Override
    public void initializeData(Ingrediente ingrediente) {

    }
}
