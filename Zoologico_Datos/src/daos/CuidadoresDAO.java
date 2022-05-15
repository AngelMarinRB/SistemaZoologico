package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import entidades.CargoEspecie;
import entidades.Cuidador;
import interfaces.IConexionBD;
import interfaces.ICuidadoresDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.bson.conversions.Bson;

/**
 * Clase de Acceso a Datos para los Cuidados del Zoológico
 * 
 * @author Marin
 */
public class CuidadoresDAO implements ICuidadoresDAO{
    
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    protected CuidadoresDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de Empleados de la base de datos
     * 
     * @return MongoCollection.
     */
    @Override
    public MongoCollection<Cuidador> getColeccion(){
        return this.baseDatos.getCollection("cuidadores", Cuidador.class);
    }
    
    /**
     * Agrega al cuidador dado como parámetro, la ficha de cargo dada como parámetro.
     * @param cuidador Cuidador a agregar ficha de cargo.
     * @param fichaCargo Ficha de cargo a agregar.
     * @return True si se agregó, False en caso contrario.
     */
    @Override
    public boolean agregarFichaCargo(Cuidador cuidador, CargoEspecie fichaCargo) {

        //Document query = new Document("$eq", new Document().append("_id", cuidador.getId()));
        
        Bson query = Filters.eq("_id" , cuidador.getId());

        Bson updates = Updates.combine(Updates.addToSet("especiesCargo", fichaCargo));

        UpdateOptions options = new UpdateOptions().upsert(true);

        UpdateResult result = getColeccion().updateOne(query, updates, options);
        
        if(result.getModifiedCount() != 0)
            return true;

        return false;
    }

    /**
     * Devuelve una lista de todos los cuidadores registrados.
     * @return Lista de cuidadores.
     */
    @Override
    public List<Cuidador> consultarTodos(){
        
        FindIterable<Cuidador> registros = this.getColeccion().find();
        
        List<Cuidador> listaCuidadores = new ArrayList<>();
        
        registros.forEach((Consumer<Cuidador>) (Cuidador cuidador) -> {
            listaCuidadores.add(cuidador);
        });
        
        return listaCuidadores;
    }
}
