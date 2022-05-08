package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.regex;
import entidades.Especie;
import entidades.Habitat;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Clase de Acceso a Datos para las Especies registradas en el sistema
 * 
 * @author Marin
 */
public class EspeciesDAO {
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Crea un objeto utilizando la conexión dada como parámetro.
     * 
     * @param conexion Conexión a Base de Datos 
     */
    protected EspeciesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de Animales de la base de datos.
     * 
     * @return MongoCollection.
     */
    private MongoCollection<Especie> getColeccion(){
        return this.baseDatos.getCollection("especies", Especie.class);
    }
    
    public boolean guardar(Especie especie) {

        try {
            MongoCollection<Especie> coleccion = this.getColeccion();
            coleccion.insertOne(especie);
            return true;
        } catch (Exception e) {
            System.err.print(e);
            return false;
        }
    }
    
    public Especie consultarNombre(String nombre){
        
        FindIterable<Especie> registros = this.getColeccion().find(regex("nombreVulgar" ,"^" + nombre + "$" ,"i"));
        
        Especie especie = registros.first();
        
        return especie;
    }
    
    public Especie consultarNombreCientifico(String nombre){
        
        FindIterable<Especie> registros = this.getColeccion().find(regex("nombreCientifico" ,"^" + nombre + "$" ,"i"));
        
        Especie especie = registros.first();
        
        return especie;
    }
    
    public List<Especie> consultarTodos(){
        
        FindIterable<Especie> registros = this.getColeccion().find();
        
        List<Especie> listaEspecies = new ArrayList<>();
        
        registros.forEach((Consumer<Especie>) (Especie especie) -> {
            listaEspecies.add(especie);
        });
        
        return listaEspecies;
    }
}
