package controles;

import entidades.Animal;
import entidades.Especie;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase de control para las Especies del zoológico
 *  
 * @author Marin
 */
public class ControlEspecies {
    
    private IDatos datos;
    
    protected ControlEspecies(IDatos datos){
        this.datos = datos;
    }
    
    public boolean guardarEspecie(Especie especie){
        return datos.guardarEspecie(especie);
    }
    
    public Especie verificarExistencia(String nombre){
        return datos.consultarEspecieNombre(nombre);
    }
    
    public Especie verificarNombreCientifico(String nombreCientifico){
        return datos.consultarEspecieNombreCientifico(nombreCientifico);
    }
}
