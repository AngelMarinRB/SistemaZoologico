
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Zona;
import java.util.List;


public interface IZonasDAO {
    
    /**
     * Devuelve la colección de Zonas de la base de datos.
     * 
     * @return MongoCollection.
     */
    public MongoCollection<Zona> getColeccion();
    
     /**
     * Devuelve una lista de todas las zonas registradas en la base de datos.
     * @return Zonas.
     */
    public List<Zona> consultarTodos();
    
}
