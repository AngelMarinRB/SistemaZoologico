
package interfaces;

import entidades.Continente;
import java.util.List;


public interface IContinentesDAO {
     /**
     * Devuelve una lista de todos los continentes registrados.
     * @return Continentes.
     */
    public List<Continente> consultarTodos();
}
