package controles;

import entidades.Continente;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase de control de continentes
 * 
 * @author Marin
 */
public class ControlContinentes {
    
    private IDatos datos;
    
    public ControlContinentes(IDatos datos){
        this.datos = datos;
    }
    
    public List<Continente> consultarContinentes(){
        return datos.consultarContinentes();
    }
}
