package daos;

import interfaces.IConexionBD;
import interfaces.IFabricaDAO;

/**
 * Fabrica para la creación de DAOs
 * 
 * @author Marin
 */

public class FabricaDAO implements IFabricaDAO{
    
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
    @Override
    public HabitatsDAO crearHabitatsDAO(){
        return new HabitatsDAO(conexion);
    }
    
     /**
     * Crea y devuelve un objeto QuejasDAO.
     * @return QuejasDAO.
     */
    @Override
    public QuejasDAO crearQuejasDAO(){
    return new QuejasDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto VegetacionesDAO.
     * @return VegetacionesDAO.
     */
    @Override
    public VegetacionesDAO crearVegetacionesDAO(){
        return new VegetacionesDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto ContinentesDAO.
     * @return ContinentesDAO.
     */
    @Override
    public ContinentesDAO crearContinentesDAO(){
        return new ContinentesDAO();
    }
    
    /**
     * Crea y devuelve un objeto ClimasDAO.
     * @return ClimasDAO.
     */
    @Override
    public ClimasDAO crearClimasDAO(){
        return new ClimasDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto ItinerariosDAO.
     * @return ItinerariosDAO.
     */
    @Override
    public ItinerariosDAO crearItinerariosDAO(){
        return new ItinerariosDAO(conexion);
    }
     
    /**
     * Crea y devuelve un objeto ZonasDAO.
     * @return ZonasDAO.
     */
    @Override
    public ZonasDAO crearZonasDAO(){
        return new ZonasDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto CuidadoresDAO.
     * @return CuidadoresDAO.
     */
    @Override
    public CuidadoresDAO crearCuidadoresDAO(){
        return new CuidadoresDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto AnimalesDAO.
     * @return AnimalesDAO.
     */
    @Override
    public AnimalesDAO crearAnimalesDAO(){
        return new AnimalesDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto EspeciesDAO.
     * @return EspeciesDAO.
     */
    @Override
    public EspeciesDAO crearEspeciesDAO(){
        return new EspeciesDAO(conexion);
    }
    
    /**
     * Crea y devuelve un objeto VisitasGuiadasDAO.
     * @return VisitasGuiadasDAO.
     */
    @Override
    public VisitasGuiadasDAO crearVisitaGuiadaDAO(){
        return new VisitasGuiadasDAO(conexion);
    }
}
