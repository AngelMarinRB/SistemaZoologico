package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Clima;
import interfaces.IConexionBD;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Clase de acceso a los Climas en la base de datos de MongoDB.
 * 
 * @author Marin
 */
public class ClimasDAO {
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Crea un objeto utilizando la conexión dada como parámetro.
     * 
     * @param conexion Conexión a Base de Datos 
     */
    protected ClimasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de Climas de la base de datos.
     * 
     * @return MongoCollection.
     */
    private MongoCollection<Clima> getColeccion(){
        return this.baseDatos.getCollection("climas", Clima.class);
    }
    
    /**
     * Devuelve una lista de todos los climas registrados en la base de datos.
     * @return Climas.
     */
    public List<Clima> consultarTodos(){
        
        MongoCollection<Clima> coleccion = this.getColeccion();

        FindIterable<Clima> iterable = coleccion.find();
        
        List<Clima> listaClimas = new LinkedList<>();

        
        iterable.forEach((Consumer<Clima>) (Clima clima) -> {
            listaClimas.add(clima);
        });
        
        return listaClimas;
    
    }
}
