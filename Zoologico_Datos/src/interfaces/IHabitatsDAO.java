
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Habitat;
import java.util.List;


public interface IHabitatsDAO {
    /**
     * Devuelve la colección de Habitats de la base de datos.
     * 
     * @return MongoCollection.
     */
    public MongoCollection<Habitat> getColeccion();
    
    /**
     * Almacena dentro de la base de datos el habitat dado como parámetro.
     * 
     * @param habitat Habitat a guardar. 
     * @return  regresa verdadero si pudo guardar el habitat
     */
    public boolean guardar(Habitat habitat);
    
    /**
     * Consulta todos los habitats que se encuentran en la base de datos
     * 
     * @return  regresa la lista de los habitats encontrados
     */
    public List<Habitat> consultarTodos();
    
    /**
     * Consulta todos los habitats por nombre que se encuentran en la base de datos
     * 
     * @param nombre nombre para buscar el habitat en la base de datos
     * @return  regresa la lista de los habitats encontrados
     */
    public Habitat consultarNombre(String nombre);

}
