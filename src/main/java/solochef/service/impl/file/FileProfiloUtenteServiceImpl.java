package solochef.service.impl.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import solochef.domain.ProfiloUtente;
import solochef.service.ProfiloUtenteService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProfiloUtenteServiceImpl implements ProfiloUtenteService {

    private static final String FILE_PATH = "data/profilo.json";

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    @Override
    public void salvaProfilo(ProfiloUtente profilo) throws IOException {

        Path path = Paths.get(FILE_PATH);

        Files.createDirectories(path.getParent());

        try (var writer = Files.newBufferedWriter(path)) {
            gson.toJson(profilo, writer);
        }
    }

    @Override
    public ProfiloUtente caricaProfilo() throws IOException {

        Path path = Paths.get(FILE_PATH);

        if (!Files.exists(path)) {
            return new ProfiloUtente();
        }

        try (var reader = Files.newBufferedReader(path)) {
            return gson.fromJson(reader, ProfiloUtente.class);
        }
    }
}