
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.Itinerario;


public interface IItinerariosDAO {
    /**
     * Devuelve la colección de itinerarios de la base de datos.
     * 
     * @return MongoCollection.
     */
    public MongoCollection<Itinerario> getColeccion();
    
    /**
     * Almacena dentro de la base de datos el itinerario dado como parámetro.
     * 
     * @param itinerario itinerario a guardar. 
     */
    public void guardar(Itinerario itinerario);
    
    /**
     * Devuelve un itinerario que coincida con el nombre
     * @param nombre nombre con el que comparar
     * @return itinerario
     */
    public Itinerario consultarNombre(String nombre);
}
