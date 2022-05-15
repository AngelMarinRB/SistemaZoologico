package daos;

import entidades.Continente;
import interfaces.IContinentesDAO;
import java.util.ArrayList;
import java.util.List;
import utils.Continentes;

/**
 * Clase de Acceso a Datos para los continentes.
 * 
 * @author Marin
 */
public class ContinentesDAO implements IContinentesDAO{

    /**
     * Crea la DAO para los continentes
     */
    protected ContinentesDAO() {
    }
    
    /**
     * Devuelve una lista de todos los continentes registrados.
     * @return Continentes.
     */
    @Override
    public List<Continente> consultarTodos(){

        List<Continente> continentes = new ArrayList<>();
        for(Continentes continente : Continentes.values()){
            continentes.add(new Continente(continente.toString()));
        }
    
        return continentes;
    }
}
