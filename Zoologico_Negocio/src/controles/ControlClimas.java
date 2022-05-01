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
    
    protected ControlClimas(IDatos datos){
        this.datos = datos;
    }
    
    public List<Clima> consultarClimas(){
        return datos.consultarClimas();
    }
}
