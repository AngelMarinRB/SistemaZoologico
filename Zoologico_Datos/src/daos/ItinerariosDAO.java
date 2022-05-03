/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.regex;
import entidades.Itinerario;
import interfaces.IConexionBD;

/**
 *
 * @author ricardosn saavedra
 */
public class ItinerariosDAO {
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    protected ItinerariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de itinerarios de la base de datos.
     * 
     * @return MongoCollection.
     */
    private MongoCollection<Itinerario> getColeccion(){
        return this.baseDatos.getCollection("itinerarios", Itinerario.class);
    }
    
    /**
     * Almacena dentro de la base de datos el itinerario dado como parámetro.
     * 
     * @param itinerario itinerario a guardar. 
     */
    public void guardar(Itinerario itinerario){
        
        MongoCollection<Itinerario> coleccion = this.getColeccion();
        coleccion.insertOne(itinerario);
    }
    
    public Itinerario consultarNombre(String nombre){
        
        FindIterable<Itinerario> registros = this.getColeccion().find(regex("nombre" ,"^" + nombre + "$" ,"i"));
        
        Itinerario itinerario = registros.first();
        
        return itinerario;
    }
}
