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
    
    protected ControlContinentes(IDatos datos){
        this.datos = datos;
    }
    
    /**
     * Devuelve una lista de todos los continentes registrados.
     * @return Continentes.
     */
    public List<Continente> consultarContinentes(){
        return datos.consultarContinentes();
    }
}
