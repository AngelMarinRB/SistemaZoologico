package controles;

import entidades.Habitat;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase de control para los objetos de tipo Habitat.
 * 
 * @author Marin
 */
public class ControlHabitats {
    
    private IDatos datos;
    
    protected ControlHabitats(IDatos datos){
        this.datos = datos;
    }
    
    /**
     * Almacena el hábitat dado como parámetro.
     * @param habitat Habitat a guardar.
     * @return True si se guardó, False en caso contrairo.
     */
    public boolean guardarHabitat(Habitat habitat){
        return (datos.guardarHabitat(habitat) == true);
    }
    
    /**
     * Verifica si ya se encuentra registrado un habitat con el mismo nombre.
     * @param nombre Nombre a buscar.
     * @return False si no existe, True en caso contrario
     */
    public Habitat verificarExistencia(String nombre){
        return datos.consultarHabitatNombre(nombre);
    }
    
    /**
     * Devuelve una lista de todos los habitats registrados en el sistema.
     * @return Lista de habitats registrados.
     */
    public List<Habitat> consultarHabitats(){
        return datos.consultarHabitats();
    }
}
