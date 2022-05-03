package daos;

import interfaces.IConexionBD;

/**
 * Fabrica para la creación de DAOs
 * 
 * @author Marin
 */
public class FabricaDAO {
    
    private IConexionBD conexion;
    
    public FabricaDAO(){
        this.conexion = new ConexionBD();
    }
    
    public HabitatsDAO crearHabitatsDAO(){
        return new HabitatsDAO(conexion);
    }
    
    public VegetacionesDAO crearVegetacionesDAO(){
        return new VegetacionesDAO(conexion);
    }
    
    public ContinentesDAO crearContinentesDAO(){
        return new ContinentesDAO(conexion);
    }
    
    public ClimasDAO crearClimasDAO(){
        return new ClimasDAO(conexion);
    }
    
    public ItinerariosDAO crearItinerariosDAO(){
        return new ItinerariosDAO(conexion);
    }
    
    public ZonasDAO crearZonasDAO(){
        return new ZonasDAO(conexion);
    }
}
