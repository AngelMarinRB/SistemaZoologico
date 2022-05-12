package daos;

import interfaces.IConexionBD;

/**
 * Fabrica para la creación de DAOs
 * 
 * @author Marin
 */

public class FabricaDAO {
    
    private IConexionBD conexion;
    
    /**
     * Crea un objeto de tipo fábrica de DAOs.
     */
    public FabricaDAO(){
        this.conexion = new ConexionBD();
    }
    
    /**
     * Crea y devuelve un objeto HabitatsDAO.
     * @return HabitatsDAO.
     */
    public HabitatsDAO crearHabitatsDAO(){
        return new HabitatsDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto VegetacionesDAO.
     * @return VegetacionesDAO.
     */
    public VegetacionesDAO crearVegetacionesDAO(){
        return new VegetacionesDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto ContinentesDAO.
     * @return ContinentesDAO.
     */
    public ContinentesDAO crearContinentesDAO(){
        return new ContinentesDAO();
    }
    
    /**
     * Crea y devuelve un objeto ClimasDAO.
     * @return ClimasDAO.
     */
    public ClimasDAO crearClimasDAO(){
        return new ClimasDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto ItinerariosDAO.
     * @return ItinerariosDAO.
     */
    public ItinerariosDAO crearItinerariosDAO(){
        return new ItinerariosDAO(conexion);
    }
     
    /**
     * Crea y devuelve un objeto ZonasDAO.
     * @return ZonasDAO.
     */
    public ZonasDAO crearZonasDAO(){
        return new ZonasDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto CuidadoresDAO.
     * @return CuidadoresDAO.
     */
    public CuidadoresDAO crearCuidadoresDAO(){
        return new CuidadoresDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto AnimalesDAO.
     * @return AnimalesDAO.
     */
    public AnimalesDAO crearAnimalesDAO(){
        return new AnimalesDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto EspeciesDAO.
     * @return EspeciesDAO.
     */
    public EspeciesDAO crearEspeciesDAO(){
        return new EspeciesDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto VisitasGuiadasDAO.
     * @return VisitasGuiadasDAO.
     */
    public VisitasGuiadasDAO crearVisitaGuiadaDAO(){
        return new VisitasGuiadasDAO(conexion);
    }
}
