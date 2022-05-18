package controles;

import entidades.Vegetacion;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase de control de vegetaciones
 * 
 * @author Marin
 */
public class ControlVegetaciones {
    
    private IDatos datos;
    
    protected ControlVegetaciones(IDatos datos){
        this.datos = datos;
    }
    
    /**
     * Devuelve una lista de todas las vegetaciones registradas en la base de datos.
     * 
     * @return Lista de vegetaciones. 
     */
    public List<Vegetacion> consultarVegetaciones(){
        return datos.consultarVegetaciones();
    }
}
