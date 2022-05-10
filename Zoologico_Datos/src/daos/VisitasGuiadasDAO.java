
package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import entidades.VisitaGuiada;
import interfaces.IConexionBD;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 * Clase de Acceso a Datos para las visitas guiadas registradas en el sistema
 * 
 * @author alanf
 */
public class VisitasGuiadasDAO {
    private IConexionBD conexion;
    private MongoDatabase baseDatos;
    
    /**
     * Crea un objeto utilizando la conexión dada como parámetro.
     * 
     * @param conexion Conexión a Base de Datos 
     */
    protected VisitasGuiadasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de Visitas guiadas de la base de datos.
     * 
     * @return MongoCollection.
     */
    private MongoCollection<VisitaGuiada> getColeccion(){
        return this.baseDatos.getCollection("visitasGuiadas", VisitaGuiada.class);
    }
    
    public List<VisitaGuiada> consultarMes(){

        MongoCollection<VisitaGuiada> coleccion = this.getColeccion();
         
        Date fechaActual = new Date();
        fechaActual.setDate(1);
        
        Bson query = gte("inicio.inicio", fechaActual);
        FindIterable<VisitaGuiada> iterable = coleccion.find(query);
        
        List<VisitaGuiada> lista = new LinkedList<>();

        
        iterable.forEach((Consumer<VisitaGuiada>) (VisitaGuiada visita) -> {
            lista.add(visita);
        });
        
        return lista;
       
       
       
    }
    
    
}
