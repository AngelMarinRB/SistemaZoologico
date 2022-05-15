
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Animal;
import entidades.Especie;
import java.util.List;


public interface IAnimalesDAO {
    /**
     * Devuelve la colección de Animales de la base de datos.
     * 
     * @return MongoCollection.
     */
    public MongoCollection<Animal> getColeccion();
    
    /**
     * Guarda en la base de datos el animal dado como parámetro.
     * 
     * @param animal Animal a guardar.
     * @return True si se guardó, False en caso contrario.
     */
    public boolean guardar(Animal animal);
    
    /**
     * Elimina de la base de datos el animal dado como parámetro.
     * 
     * @param animal Animal a eliminar.
     * @return True si se eliminó, False en caso contrario.
     */
    public boolean eliminar(Animal animal);
    
    /**
     * Devuelve una lista de todos los animales registrados que pertenezcan a la
     * especie dada como parámetro.
     * 
     * @param especie Especie a buscar.
     * @return Lista de Animales de la misma Especie.
     */
    public List<Animal> consultarPorEspecie(Especie especie);
}
