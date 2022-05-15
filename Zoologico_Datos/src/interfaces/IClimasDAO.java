
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Clima;
import java.util.List;


public interface IClimasDAO {
    /**
     * Devuelve la colección de Climas de la base de datos.
     * 
     * @return MongoCollection.
     */
    public MongoCollection<Clima> getColeccion();
    
    /**
     * Devuelve una lista de todos los climas registrados en la base de datos.
     * @return Climas.
     */
    public List<Clima> consultarTodos();
    
    
}
