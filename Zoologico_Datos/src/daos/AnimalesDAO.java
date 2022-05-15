package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Animal;
import entidades.Especie;
import interfaces.IConexionBD;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.eq;
import interfaces.IAnimalesDAO;

/**
 * Clase de acceso a datos para los animales del zoológico
 * 
 * @author Marin
 */
public class AnimalesDAO implements IAnimalesDAO{
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Crea un objeto utilizando la conexión dada como parámetro.
     * 
     * @param conexion Conexión a Base de Datos 
     */
    protected AnimalesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de Animales de la base de datos.
     * 
     * @return MongoCollection.
     */
    @Override
    public MongoCollection<Animal> getColeccion(){
        return this.baseDatos.getCollection("animales", Animal.class);
    }
    
    /**
     * Guarda en la base de datos el animal dado como parámetro.
     * 
     * @param animal Animal a guardar.
     * @return True si se guardó, False en caso contrario.
     */
    @Override
    public boolean guardar(Animal animal){
        try {
            MongoCollection<Animal> coleccion = this.getColeccion();
            coleccion.insertOne(animal);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    /**
     * Elimina de la base de datos el animal dado como parámetro.
     * 
     * @param animal Animal a eliminar.
     * @return True si se eliminó, False en caso contrario.
     */
    @Override
    public boolean eliminar(Animal animal){
        try {
            MongoCollection<Animal> coleccion = this.getColeccion();
            Bson query = eq("_id" , animal.getId());
            coleccion.deleteOne(query);
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    /**
     * Devuelve una lista de todos los animales registrados que pertenezcan a la
     * especie dada como parámetro.
     * 
     * @param especie Especie a buscar.
     * @return Lista de Animales de la misma Especie.
     */
    @Override
    public List<Animal> consultarPorEspecie(Especie especie){
        
        MongoCollection<Animal> coleccion = this.getColeccion();

        Bson query = eq("especie._id", especie.getId());
        
        FindIterable<Animal> iterable = coleccion.find(query);
        
        List<Animal> listaAnimalesEspecie = new LinkedList<>();

        
        iterable.forEach((Consumer<Animal>) (Animal animal) -> {
            listaAnimalesEspecie.add(animal);
        });
        
        return listaAnimalesEspecie;
    }
}
