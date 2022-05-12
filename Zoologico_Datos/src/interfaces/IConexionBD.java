package interfaces;

import com.mongodb.client.MongoDatabase;

/**
 * Interfaz para la obtención de las conexiones hacia la base de datos.
 * 
 * @author Marin
 */
public interface IConexionBD {
    
    /**
     * Devuelve una conexión a la base de datos.
     * @return Connection
     */
    public MongoDatabase getConnection();
    
}
