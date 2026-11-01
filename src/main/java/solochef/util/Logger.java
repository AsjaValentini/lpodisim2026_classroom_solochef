package solochef.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private static final String CARTELLA_LOG = "data/";
    private String nomeFile = "solochef.log";

    private Logger(){

    }

    public static Logger getInstance(){
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }


    /**
     * Scrive un'entrata nel log corrente.
     *
     * @param data i dati da scrivere nel log.
     */

    public void writeLog(String data) {
        if (nomeFile == null) {
            System.out.println("Errore: nessun file di log impostato per la scrittura.");
            return;
        }
        Path logFilePath = Paths.get(CARTELLA_LOG + nomeFile);
        try (FileWriter writer = new FileWriter(logFilePath.toFile(), true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            String[] lines = data.split("\\r?\\n");
            for (String line : lines) {
                bufferedWriter.write("[" + timeStamp + "] " + line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file di log: " + e.getMessage());
        }
    }



}
