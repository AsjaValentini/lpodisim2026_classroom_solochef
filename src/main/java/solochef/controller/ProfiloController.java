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
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import solochef.domain.ProfiloUtente;
import solochef.enumerazioni.TipoDiDieta;

import java.awt.*;
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
    private Button bottoneModifica;
    @FXML
    private Button bottoneAggiungi;
    @FXML
    private TableView<TipoDiDieta> tableViewDieta;
    @FXML
    private AnchorPane baseProfilo;
    @FXML
    private TableColumn<TipoDiDieta, CheckBox> colonnaSelezione;

    @FXML
    private TableColumn<TipoDiDieta, String> colonnaDieta;

    private ProfiloUtente profiloUtente;


    @Override
    public void initializeData(ProfiloUtente profiloUtente) {
        this.profiloUtente=profiloUtente;

        try{

            ObservableList dieteVisualizzate = FXCollections.observableArrayList(TipoDiDieta.values());
            tableViewDieta.setItems(dieteVisualizzate);

        }catch(NullPointerException e){

        }
    }

    @FXML
    private void azioneAggiungi(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colonnaSelezione.setCellValueFactory(param ->
                new SimpleObjectProperty<>(new CheckBox())
        );

        colonnaSelezione.setCellFactory(param ->
                new TableCell<TipoDiDieta, CheckBox>() {

                    @Override
                    protected void updateItem(CheckBox check, boolean empty) {
                        super.updateItem(check, empty);

                        if (empty || check == null) {
                            setGraphic(null);
                        } else {
                            setGraphic(check);
                        }
                    }
                }
        );


        colonnaDieta.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<TipoDiDieta, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<TipoDiDieta, String> param) {
                return new SimpleObjectProperty<>(param.getValue().toString());
            }
        });
    }
}


