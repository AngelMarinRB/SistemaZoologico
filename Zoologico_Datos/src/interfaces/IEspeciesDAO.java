
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Especie;
import java.util.List;


public interface IEspeciesDAO {
    
    /**
     * Devuelve la colección de Animales de la base de datos.
     * 
     * @return MongoCollection.
     */
    public MongoCollection<Especie> getColeccion();
    
     /**
     * Guarda en la base de datos la especie dada como parámetro
     * @param especie Especie a gaurdar
     * @return True si se guardó, False en caso contrario.
     */
    public boolean guardar(Especie especie);
    
    /**
     * Devuelve la Especie que tenga el nombre igual al dado como parámetro.
     * 
     * @param nombre Nombre de Especie a buscar.
     * @return Especie si encuntra una, Null si no existe.
     */
    public Especie consultarNombre(String nombre);
    
    /**
     * Devuelve la Especie que tenga el nombre científico igual al dado como parámetro.
     * 
     * @param nombre Nombre científico de la especie a buscar.
     * @return Especie si enceuntra una, Null si no existe.
     */
    public Especie consultarNombreCientifico(String nombre);
    
    /**
     * Devuelve una lista de todas las especies registradas en la base de datos.
     * @return Lista de especies.
     */
    public List<Especie> consultarTodos();
}
