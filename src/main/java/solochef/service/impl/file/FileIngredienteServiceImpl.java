
package solochef.service.impl.file;

import solochef.domain.Ingrediente;
import solochef.enumerazioni.Allergene;
import solochef.enumerazioni.CategoriaMerceologica;
import solochef.service.IngredienteService;
import solochef.util.JsonFileManager;
import solochef.util.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileIngredienteServiceImpl implements IngredienteService {

    private static final String FILE_PATH = "data/ingredienti.json";

    private final JsonFileManager fileManager = JsonFileManager.getInstance();

    private  List<Ingrediente> listaIngredienti;

    private Integer prossimoId = 1;

    public FileIngredienteServiceImpl() throws IOException {

        listaIngredienti = fileManager.caricaLista(FILE_PATH, Ingrediente.class);

        if (listaIngredienti == null) {listaIngredienti = new ArrayList<>();}

        for (Ingrediente ingrediente : listaIngredienti) {
            if (ingrediente.getId() != null && ingrediente.getId() >= prossimoId) {
                prossimoId = ingrediente.getId() + 1;
            }
        }
    }

    @Override
    public void aggiungiIngrediente(Ingrediente daAggiungere) throws IOException {

        validaIngrediente(daAggiungere);
        String nome = daAggiungere.getNomeIngrediente().trim();
        boolean duplicato = listaIngredienti.stream().anyMatch(i -> i.getNomeIngrediente().equalsIgnoreCase(nome));

        if (duplicato) {throw new IllegalArgumentException("Esiste già un ingrediente con questo nome");
        }

        daAggiungere.setNomeIngrediente(nome);
        daAggiungere.setId(prossimoId++);
        listaIngredienti.add(daAggiungere);
        salvaSuFile();
    }

    @Override
    public List<Ingrediente> getIngredienti() {
        return new ArrayList<>(listaIngredienti);
    }

    @Override
    public  List<Ingrediente> applicaFiltri(String nomeIngrediente, Set<CategoriaMerceologica> categorie, Set<Allergene> allergeni) {


        List<Ingrediente> risultati = new ArrayList<>();

        nomeIngrediente=nomeIngrediente.trim().toLowerCase();

        boolean nomeAttivo = !nomeIngrediente.isEmpty();
        boolean categoriaAttiva = categorie != null && !categorie.isEmpty();
        boolean allergeneAttivo = allergeni != null && !allergeni.isEmpty();

        boolean nessunFiltroAttivo =
                !nomeAttivo && !categoriaAttiva && !allergeneAttivo;

        for (Ingrediente ingrediente : listaIngredienti) {

            boolean nomeCorrisponde = nomeAttivo && ingrediente.getNomeIngrediente().toLowerCase().contains(nomeIngrediente);

            boolean categoriaCorrisponde = categoriaAttiva && categorie.contains(ingrediente.getCategoriaMerceologica());

            boolean allergeneCorrisponde = allergeneAttivo && !allergeni.contains(ingrediente.getAllergene());

            if (nessunFiltroAttivo || nomeCorrisponde ||
                    categoriaCorrisponde || allergeneCorrisponde) {

                risultati.add(ingrediente);
            }
        }

        return risultati;
    }


    @Override
    public void modificaIngrediente(Ingrediente ingrediente) throws IOException {

    }

    @Override
    public void rimuoviIngrediente(Integer id) throws IOException {

        }

    private void salvaSuFile() throws IOException {

        try {
            fileManager.salva(listaIngredienti, FILE_PATH);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private void validaIngrediente(Ingrediente ingrediente) {

        if (ingrediente == null) {
            throw new IllegalArgumentException("Ingrediente non valido");
        }

        if (ingrediente.getNomeIngrediente() == null || ingrediente.getNomeIngrediente().trim().isEmpty()) {
            throw new IllegalArgumentException("Il nome è obbligatorio");
        }

        if (ingrediente.getUnitaDiMisura() == null || ingrediente.getUnitaDiMisura().trim().isEmpty()) {
            throw new IllegalArgumentException("L'unità di misura è obbligatoria");
        }

        if (ingrediente.getCaloriePerUnita() <= 0 || !Double.isFinite(ingrediente.getCaloriePerUnita())) {
            throw new IllegalArgumentException("Le calorie devono essere maggiori di zero");
        }

        if (ingrediente.getCategoriaMerceologica() == null) {throw new IllegalArgumentException("La categoria merceologica è obbligatoria");
        }

        if (ingrediente.getAllergene() == null) {throw new IllegalArgumentException("L'allergene è obbligatorio");
        }
    }
}
