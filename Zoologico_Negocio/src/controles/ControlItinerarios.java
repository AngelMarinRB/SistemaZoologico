package controles;


import entidades.Itinerario;
import interfaces.IDatos;

/**
 * Control de itinerarios
 * @author ricardosn saavedra
 */
public class ControlItinerarios {
    /**
     * objeto que permite usar metodos de las dao
     */
    private IDatos datos;
    
    /**
     * metodo constructor que inicializa un objeto IDatos
     * @param datos parametro para la creacion del objeto
     */
    protected ControlItinerarios(IDatos datos){
        this.datos = datos;
    }
    
    /**
     * Almacena el itinerario dado como parámetro.
     * @param itinerario itinerario a guardar.
     * @return True si se guardó, False en caso contrairo.
     */
    public boolean guardarItinerario(Itinerario itinerario){
        return (datos.guardarItinerario(itinerario) == true);
    }
    
    /**
     * Verifica si ya se encuentra registrado un itinerario con el mismo nombre.
     * @param nombre Nombre a buscar.
     * @return False si no existe, True en caso contrario
     */
    public Itinerario verificarExistenciaItinerario(String nombre){
        return datos.consultarItinerarioNombre(nombre);
    }
}
