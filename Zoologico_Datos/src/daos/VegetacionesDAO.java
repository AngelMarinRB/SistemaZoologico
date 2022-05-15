package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Vegetacion;
import interfaces.IConexionBD;
import interfaces.IVegetacionesDAO;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Clase de acceso a los tipos de Vegetaciones almacenados en la base de datos de MongoDB
 * 
 * @author Marin
 */
public class VegetacionesDAO implements IVegetacionesDAO{
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Crea un objeto utilizando la conexión dada como parámetro.
     * @param conexion Conexion.
     */
    protected VegetacionesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de Vegetaciones de la base de datos.
     * 
     * @return MongoCollection.
     */
    @Override
    public MongoCollection<Vegetacion> getColeccion(){
        return this.baseDatos.getCollection("vegetaciones", Vegetacion.class);
    }
    
    /**
     * Devuelve una lista de todos los tipos de vegetacion registrados en la base de datos.
     * @return Vegetaciones.
     */
    @Override
    public List<Vegetacion> consultarTodos(){
        
        MongoCollection<Vegetacion> coleccion = this.getColeccion();

        FindIterable<Vegetacion> iterable = coleccion.find();
        
        List<Vegetacion> listaVegetaciones = new LinkedList<>();

        
        iterable.forEach((Consumer<Vegetacion>) (Vegetacion vegetacion) -> {
            listaVegetaciones.add(vegetacion);
        });
        
        return listaVegetaciones;
    
    }
    
}
