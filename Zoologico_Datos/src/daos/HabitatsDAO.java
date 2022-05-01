package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Habitat;
import interfaces.IConexionBD;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import java.util.regex.Pattern;


/**
 * Clase de acceso a Habitats en la base de datos de MongoDB
 * 
 * @author Marin
 */
public class HabitatsDAO {
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    protected HabitatsDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de Habitats de la base de datos.
     * 
     * @return MongoCollection.
     */
    private MongoCollection<Habitat> getColeccion(){
        return this.baseDatos.getCollection("habitats", Habitat.class);
    }
    
    /**
     * Almacena dentro de la base de datos el habitat dado como parámetro.
     * 
     * @param habitat Habitat a guardar. 
     */
    public void guardar(Habitat habitat){
        
        MongoCollection<Habitat> coleccion = this.getColeccion();
        coleccion.insertOne(habitat);
    }
    
    public Habitat consultarNombre(String nombre){
        
        FindIterable<Habitat> registros = this.getColeccion().find(regex("nombre" ,"^" + nombre + "$" ,"i"));
        
        Habitat habitat = registros.first();
        
        return habitat;
    }
}
