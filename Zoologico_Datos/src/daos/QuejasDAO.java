package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Queja;
import interfaces.IConexionBD;


/**
 * Clase de Acceso a Datos para las quejas registradas en el sistema
 * 
 * @author alanf
 */
public class QuejasDAO {
    private IConexionBD conexion;
    private MongoDatabase baseDatos;
    
    /**
     * Crea un objeto utilizando la conexión dada como parámetro.
     * 
     * @param conexion Conexión a Base de Datos 
     */
    public QuejasDAO (IConexionBD conexion){
    this.conexion = conexion;
    this.baseDatos = conexion.getConnection();
    }
    
   /**
     * Devuelve la colección de quejas de la base de datos.
     * 
     * @return MongoCollection.
     */
    private MongoCollection<Queja> getColeccion(){
        return this.baseDatos.getCollection("quejas", Queja.class);
    } 
   
    
    /**
     * Almacena dentro de la base de datos la queja dada como parámetro.
     * 
     * @param queja Queja a guardar. 
     */
    public void guardar(Queja queja){
        
        MongoCollection<Queja> coleccion = this.getColeccion();
        coleccion.insertOne(queja);
    }
 
    
    
}
