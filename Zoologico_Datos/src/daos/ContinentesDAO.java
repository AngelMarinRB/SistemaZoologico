package daos;

import entidades.Continente;
import java.util.ArrayList;
import java.util.List;
import utils.Continentes;

/**
 * Clase de Acceso a Datos para los continentes.
 * 
 * @author Marin
 */
public class ContinentesDAO {

    /**
     * Crea la DAO para los continentes
     */
    protected ContinentesDAO() {
    }
    
    /**
     * Devuelve una lista de todos los continentes registrados.
     * @return Continentes.
     */
    public List<Continente> consultarTodos(){

        List<Continente> continentes = new ArrayList<>();
        for(Continentes continente : Continentes.values()){
            continentes.add(new Continente(continente.toString()));
        }
    
        return continentes;
    }
}
