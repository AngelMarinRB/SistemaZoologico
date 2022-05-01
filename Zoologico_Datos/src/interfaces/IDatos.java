package interfaces;

import entidades.Clima;
import entidades.Continente;
import entidades.Habitat;
import entidades.Vegetacion;
import java.util.List;

/**
 * Interfaz para la manipulación de las entidades de la aplicación.
 * 
 * @author Marin
 */
public interface IDatos {
    
    /**
     * Almacena el habitat dado como parámetro.
     * @param habitat Habitat a guardar.
     * @return True si se almacena, False en caso contrario.
     */
    boolean guardarHabitat(Habitat habitat);
    
    /**
     * Devuelve el habitat que coincida con el nombre dado como parámetro
     * (No toma en cuenta mayúsculas)
     * @param nombre Nombre a buscar.
     * @return Habitat si hay coincidencias, Null si no existe.
     */
    Habitat consultarHabitatNombre(String nombre);
    
    /**
     * Devuelve una lista de todos los climas que se encuentren almacenados.
     * @return Lista de Climas.
     */
    List<Clima> consultarClimas();
    
    /**
     * Devuelve una lista de todas las vegetaciones que se encuentren almacenadas.
     * @return Lista de Vegetaciones.
     */
    List<Vegetacion> consultarVegetaciones();
    
    /**
     * Devuelve una lista de todos los continentes que se encuentren almacenados.
     * @return Lista de continentes.
     */
    List<Continente> consultarContinentes();

}
