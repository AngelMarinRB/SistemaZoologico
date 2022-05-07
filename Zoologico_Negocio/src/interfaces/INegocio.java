package interfaces;

import entidades.Clima;
import entidades.Continente;
import entidades.Cuidador;
import entidades.Habitat;
import entidades.Itinerario;
import entidades.Vegetacion;
import entidades.Zona;
import java.util.List;

/**
 * Interfáz para el control del subsistema de Negocio.
 * 
 * @author Marin
 */
public interface INegocio {
    
    boolean guardarHabitat(Habitat habitat);
    
    Habitat verificarExistenciaHabitat(String nombre);
    
    List<Continente> consultarContinentes();
    
    List<Vegetacion> consultarVegetaciones();
    
    List<Clima> consultarClimas();
    
    boolean guardarItinerario(Itinerario itinerario);
    
    Itinerario verificarExistenciaItinerario(String nombre);
    
    List<Zona> consultarZonas();
    
    /**
     * Devuelve una lista de todos los habitats registrados en el sistema.
     * @return Lista de habitats.
     */
    List<Habitat> consultarHabitats();
    
    /**
     * Devuelve una lista de todos los cuidadores registrados en el sistema.
     * @return Lista de cuidadores.
     */
    List<Cuidador> consultarCuidadores();
    
}
