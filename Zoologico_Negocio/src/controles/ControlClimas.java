package controles;

import entidades.Clima;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase de control de Climas
 * 
 * @author Marin
 */
public class ControlClimas {
    
    private IDatos datos;
    
    /**
     * Crea un control de climas
     * @param datos Datos.
     */
    protected ControlClimas(IDatos datos){
        this.datos = datos;
    }
    
    /**
     * Devuelve una lista de todos los climas registrados en la base de datos.
     * @return Climas.
     */
    public List<Clima> consultarClimas(){
        return datos.consultarClimas();
    }
}
