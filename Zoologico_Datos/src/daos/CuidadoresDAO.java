package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Cuidador;
import entidades.Habitat;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Clase de Acceso a Datos para los Cuidados del Zoológico
 * 
 * @author Marin
 */
public class CuidadoresDAO {
    
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
    private MongoCollection<Cuidador> getColeccion(){
        return this.baseDatos.getCollection("cuidadores", Cuidador.class);
    }
    
    public List<Cuidador> consultarTodos(){
        
        FindIterable<Cuidador> registros = this.getColeccion().find();
        
        List<Cuidador> listaCuidadores = new ArrayList<>();
        
        registros.forEach((Consumer<Cuidador>) (Cuidador cuidador) -> {
            listaCuidadores.add(cuidador);
        });
        
        return listaCuidadores;
    }
}
