package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Continente;
import interfaces.IConexionBD;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Clase de acceso a los Continentes en la base de datos de MongoDB.
 * 
 * @author Marin
 */
public class ContinentesDAO {
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Crea un objeto utilizando la conexión dada como parámetro.
     * 
     * @param conexion Conexion a Base de Datos
     */
    protected ContinentesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de Continentes de la base de datos.
     * 
     * @return MongoCollection.
     */
    private MongoCollection<Continente> getColeccion(){
        return this.baseDatos.getCollection("continentes", Continente.class);
    }
    
    /**
     * Devuelve una lista de todos los continentes registrados en la base de datos.
     * @return Continentes.
     */
    public List<Continente> consultarTodos(){
        
        MongoCollection<Continente> coleccion = this.getColeccion();

        FindIterable<Continente> iterable = coleccion.find();
        
        List<Continente> listaClimas = new LinkedList<>();

        
        iterable.forEach((Consumer<Continente>) (Continente continente) -> {
            listaClimas.add(continente);
        });
        
        return listaClimas;
    
    }
}
