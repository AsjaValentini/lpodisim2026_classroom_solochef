
package solochef.service;

import solochef.domain.Ingrediente;
import solochef.enumerazioni.CategoriaMerceologica;
import solochef.enumerazioni.Allergene;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface IngredienteService {

    void aggiungiIngrediente(Ingrediente daAggiungere) throws IOException;

    List<Ingrediente> getIngredienti();


    List<Ingrediente> applicaFiltri(String nome, Set<CategoriaMerceologica> categorie, Set<Allergene> allergeni);

    void modificaIngrediente(Ingrediente ingrediente) throws IOException;

    void rimuoviIngrediente(Integer id) throws IOException;
}
