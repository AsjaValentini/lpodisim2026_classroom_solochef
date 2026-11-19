
package solochef.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class  JsonFileManager {

    private static JsonFileManager instance;

    private final Gson gson;

       /*Costruttore : Gson è la libreria che si utilizza per convertire gli oggetti Java in JSON e viceversa.
       1)GsonBuilder permette di personalizzare il comportamento di Gson prima di crearlo.
       2)setPrettyPrinting formatta json in modo da renderlo leggibile(altrimenti sarebbe tutto in una riga)
       3)create conclude la configurazione e crea effettivamente l'oggetto Gson*/
    private JsonFileManager() {gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public static JsonFileManager getInstance() {
        if (instance == null) {instance = new JsonFileManager();}
        return instance;}

    // Metodo per salvare un oggetto o una lista su file JSON
    public <T> void salva(T oggetto, String filePath) throws IOException {

        Path path = Path.of(filePath);

        Files.createDirectories(path.getParent());

        try (var writer = Files.newBufferedWriter(path)) {
            gson.toJson(oggetto, writer);
        }
    }

    // Metodo per caricare un oggetto singolo
    public <T> T carica(String filePath, Class<T> tipo)
            throws IOException {

        Path path = Path.of(filePath);

        if (!Files.exists(path)) {
            return null;
        }

        try (var reader = Files.newBufferedReader(path)) {
            return gson.fromJson(reader, tipo);
        }
    }

    // Metodo per caricare una lista di oggetti
    public <T> java.util.List<T> caricaLista(String filePath, Class<T> tipoElemento) throws IOException {

        Path path = Path.of(filePath);

        if (!Files.exists(path)) {return new ArrayList<>();}

        Type tipoLista = TypeToken.getParameterized(java.util.List.class, tipoElemento).getType();

        try (var reader = Files.newBufferedReader(path)) {
            return gson.fromJson(reader, tipoLista);
        }
    }
}
