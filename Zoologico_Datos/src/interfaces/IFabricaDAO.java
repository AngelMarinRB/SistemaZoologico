
package interfaces;

import daos.AnimalesDAO;
import daos.ClimasDAO;
import daos.ContinentesDAO;
import daos.CuidadoresDAO;
import daos.EspeciesDAO;
import daos.HabitatsDAO;
import daos.ItinerariosDAO;
import daos.QuejasDAO;
import daos.VegetacionesDAO;
import daos.VisitasGuiadasDAO;
import daos.ZonasDAO;

public interface IFabricaDAO {
    
    /**
     * Crea y devuelve un objeto HabitatsDAO.
     * @return HabitatsDAO.
     */
    public HabitatsDAO crearHabitatsDAO();
    
    /**
     * Crea y devuelve un objeto QuejasDAO.
     * @return QuejasDAO.
     */
    public QuejasDAO crearQuejasDAO();
    
    /**
     * Crea y devuelve un objeto VegetacionesDAO.
     * @return VegetacionesDAO.
     */
    public VegetacionesDAO crearVegetacionesDAO();
    
    /**
     * Crea y devuelve un objeto ContinentesDAO.
     * @return ContinentesDAO.
     */
    public ContinentesDAO crearContinentesDAO();
    
    /**
     * Crea y devuelve un objeto ClimasDAO.
     * @return ClimasDAO.
     */
    public ClimasDAO crearClimasDAO();
    
    /**
     * Crea y devuelve un objeto ItinerariosDAO.
     * @return ItinerariosDAO.
     */
    public ItinerariosDAO crearItinerariosDAO();
    
     /**
     * Crea y devuelve un objeto ZonasDAO.
     * @return ZonasDAO.
     */
    public ZonasDAO crearZonasDAO();
    
    /**
     * Crea y devuelve un objeto CuidadoresDAO.
     * @return CuidadoresDAO.
     */
    public CuidadoresDAO crearCuidadoresDAO();
    
    /**
     * Crea y devuelve un objeto AnimalesDAO.
     * @return AnimalesDAO.
     */
    public AnimalesDAO crearAnimalesDAO();
    
    /**
     * Crea y devuelve un objeto EspeciesDAO.
     * @return EspeciesDAO.
     */
    public EspeciesDAO crearEspeciesDAO();
    
    /**
     * Crea y devuelve un objeto VisitasGuiadasDAO.
     * @return VisitasGuiadasDAO.
     */
    public VisitasGuiadasDAO crearVisitaGuiadaDAO();
}
