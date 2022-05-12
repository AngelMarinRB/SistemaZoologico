/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entidades.Clima;
import entidades.Zona;
import interfaces.IConexionBD;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * DAO del objeto zona
 * @author ricardosn saavedra
 */
public class ZonasDAO {
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Crea un objeto utilizando la conexión dada como parámetro.
     * 
     * @param conexion Conexión a Base de Datos 
     */
    protected ZonasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = conexion.getConnection();
    }
    
    /**
     * Devuelve la colección de Zonas de la base de datos.
     * 
     * @return MongoCollection.
     */
    private MongoCollection<Zona> getColeccion(){
        return this.baseDatos.getCollection("zonas", Zona.class);
    }
    
    /**
     * Devuelve una lista de todas las zonas registradas en la base de datos.
     * @return Zonas.
     */
    public List<Zona> consultarTodos(){
        
        MongoCollection<Zona> coleccion = this.getColeccion();

        FindIterable<Zona> iterable = coleccion.find();
        
        List<Zona> listaZonas = new LinkedList<>();

        
        iterable.forEach((Consumer<Zona>) (Zona zona) -> {
            listaZonas.add(zona);
        });
        
        return listaZonas;
    
    }
}
