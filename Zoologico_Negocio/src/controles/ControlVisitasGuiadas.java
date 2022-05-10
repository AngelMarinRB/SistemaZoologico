
package controles;

import entidades.VisitaGuiada;
import interfaces.IDatos;
import java.util.List;


public class ControlVisitasGuiadas {
    private IDatos datos;
    
    protected ControlVisitasGuiadas(IDatos datos){
         this.datos = datos;
    }
    
    public List<VisitaGuiada> consultarMes(){
        return datos.consultarMes();
    }
}
