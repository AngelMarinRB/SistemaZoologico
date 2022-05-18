package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.regex;
import entidades.Itinerario;
import interfaces.IConexionBD;
import interfaces.IItinerariosDAO;

/**
 * DAO del objeto itinerario
 * @author ricardosn saavedra
 */
public class ItinerariosDAO implements IItinerariosDAO{
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    protected ItinerariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de itinerarios de la base de datos.
     * 
     * @return MongoCollection.
     */
    @Override
    public MongoCollection<Itinerario> getColeccion(){
        return this.baseDatos.getCollection("itinerarios", Itinerario.class);
    }
    
    /**
     * Almacena dentro de la base de datos el itinerario dado como parámetro.
     * 
     * @param itinerario itinerario a guardar. 
     */
    @Override
    public void guardar(Itinerario itinerario){
        
        MongoCollection<Itinerario> coleccion = this.getColeccion();
        coleccion.insertOne(itinerario);
    }
    
    /**
     * Devuelve un itinerario que coincida con el nombre
     * @param nombre nombre con el que comparar
     * @return itinerario
     */
    @Override
    public Itinerario consultarNombre(String nombre){
        
        FindIterable<Itinerario> registros = this.getColeccion().find(regex("nombre" ,"^" + nombre + "$" ,"i"));
        
        Itinerario itinerario = registros.first();
        
        return itinerario;
    }
}
