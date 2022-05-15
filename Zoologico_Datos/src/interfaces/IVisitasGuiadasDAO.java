
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.VisitaGuiada;
import java.util.List;


public interface IVisitasGuiadasDAO {
    
    /**
     * Devuelve la colección de Visitas guiadas de la base de datos.
     * 
     * @return MongoCollection.
     */
    public MongoCollection<VisitaGuiada> getColeccion();
    
    /**
     * Devuelve los itinerarios de las visitas guiadas del ultimo mes
     * 
     * @return lista de itinerarios de las visitas guiadas del ultimo mes
     */
    public List<VisitaGuiada> consultarMes();
}
