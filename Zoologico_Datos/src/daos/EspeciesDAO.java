package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.regex;
import entidades.Especie;
import interfaces.IConexionBD;
import interfaces.IEspeciesDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Clase de Acceso a Datos para las Especies registradas en el sistema
 * 
 * @author Marin
 */
public class EspeciesDAO implements IEspeciesDAO{
    
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
    @Override
    public MongoCollection<Especie> getColeccion(){
        return this.baseDatos.getCollection("especies", Especie.class);
    }
    
    /**
     * Guarda en la base de datos la especie dada como parámetro
     * @param especie Especie a gaurdar
     * @return True si se guardó, False en caso contrario.
     */
    @Override
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
    
    /**
     * Devuelve la Especie que tenga el nombre igual al dado como parámetro.
     * 
     * @param nombre Nombre de Especie a buscar.
     * @return Especie si encuntra una, Null si no existe.
     */
    @Override
    public Especie consultarNombre(String nombre){
        
        FindIterable<Especie> registros = this.getColeccion().find(regex("nombreVulgar" ,"^" + nombre + "$" ,"i"));
        
        Especie especie = registros.first();
        
        return especie;
    }
    
    /**
     * Devuelve la Especie que tenga el nombre científico igual al dado como parámetro.
     * 
     * @param nombre Nombre científico de la especie a buscar.
     * @return Especie si enceuntra una, Null si no existe.
     */
    @Override
    public Especie consultarNombreCientifico(String nombre){
        
        FindIterable<Especie> registros = this.getColeccion().find(regex("nombreCientifico" ,"^" + nombre + "$" ,"i"));
        
        Especie especie = registros.first();
        
        return especie;
    }
    
    /**
     * Devuelve una lista de todas las especies registradas en la base de datos.
     * @return Lista de especies.
     */
    @Override
    public List<Especie> consultarTodos(){
        
        FindIterable<Especie> registros = this.getColeccion().find();
        
        List<Especie> listaEspecies = new ArrayList<>();
        
        registros.forEach((Consumer<Especie>) (Especie especie) -> {
            listaEspecies.add(especie);
        });
        
        return listaEspecies;
    }
}
