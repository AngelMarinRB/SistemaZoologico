
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Queja;


public interface IQuejasDAO {
    
    /**
     * Devuelve la colección de quejas de la base de datos.
     * 
     * @return MongoCollection.
     */
    public MongoCollection<Queja> getColeccion();
    
    /**
     * Almacena dentro de la base de datos la queja dada como parámetro.
     * 
     * @param queja Queja a guardar. 
     */
    public void guardar(Queja queja);
}
