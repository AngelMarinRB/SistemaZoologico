
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Vegetacion;
import java.util.List;


public interface IVegetacionesDAO {
    
     /**
     * Devuelve la colección de Vegetaciones de la base de datos.
     * 
     * @return MongoCollection.
     */
    public MongoCollection<Vegetacion> getColeccion();
    
     /**
     * Devuelve una lista de todos los tipos de vegetacion registrados en la base de datos.
     * @return Vegetaciones.
     */
    public List<Vegetacion> consultarTodos();
}
