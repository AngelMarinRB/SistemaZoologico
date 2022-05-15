
package interfaces;

import com.mongodb.client.MongoCollection;
import entidades.CargoEspecie;
import entidades.Cuidador;
import java.util.List;

public interface ICuidadoresDAO {
    /**
     * Devuelve la colección de Empleados de la base de datos
     * 
     * @return MongoCollection.
     */
    public MongoCollection<Cuidador> getColeccion();
    
    /**
     * Agrega al cuidador dado como parámetro, la ficha de cargo dada como parámetro.
     * @param cuidador Cuidador a agregar ficha de cargo.
     * @param fichaCargo Ficha de cargo a agregar.
     * @return True si se agregó, False en caso contrario.
     */
    public boolean agregarFichaCargo(Cuidador cuidador, CargoEspecie fichaCargo);
    
     /**
     * Devuelve una lista de todos los cuidadores registrados.
     * @return Lista de cuidadores.
     */
    public List<Cuidador> consultarTodos();
}
