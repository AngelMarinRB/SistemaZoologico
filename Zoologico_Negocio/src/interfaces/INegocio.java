package interfaces;

import entidades.Clima;
import entidades.Continente;
import entidades.Habitat;
import entidades.Vegetacion;
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
}
