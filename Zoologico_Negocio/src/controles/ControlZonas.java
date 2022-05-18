package controles;


import entidades.Zona;
import interfaces.IDatos;
import java.util.List;

/**
 * Control de zonas
 * @author ricardosn saavedra
 */
public class ControlZonas {
    /**
     * Objeto IDatos
     */
    private IDatos datos;
    
    /**
     * metodo constructor que inicializa el objeto IDatos
     * @param datos objeto IDatos
     */
    protected ControlZonas(IDatos datos){
        this.datos = datos;
    }
    
    /**
     * metodo que consulta las zonas 
     * @return lista con las zonas encontradas
     */
    public List<Zona> consultarZonas(){
        return datos.consultarZonas();
    }
}
