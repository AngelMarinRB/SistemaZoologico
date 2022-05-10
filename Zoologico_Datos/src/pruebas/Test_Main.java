package pruebas;

import daos.ClimasDAO;
import daos.ContinentesDAO;
import daos.FabricaDAO;
import daos.HabitatsDAO;
import daos.VegetacionesDAO;
import daos.VisitasGuiadasDAO;
import entidades.Clima;
import entidades.Continente;
import entidades.Habitat;
import entidades.Vegetacion;
import entidades.VisitaGuiada;
import interfaces.IConexionBD;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marin
 */
public class Test_Main {
    
    
    public static void main(String[] args){
        
        // Objeto de tipo Fabrica
        FabricaDAO fabrica = new FabricaDAO();
        
        // Objeto de Conexión
        //IConexionBD conexion = new ConexionBD();
        
        // Objetos DAO
        ClimasDAO climas = fabrica.crearClimasDAO();
        ContinentesDAO continentes = fabrica.crearContinentesDAO();
        VegetacionesDAO vegetaciones = fabrica.crearVegetacionesDAO();
        HabitatsDAO habitats = fabrica.crearHabitatsDAO();
        VisitasGuiadasDAO visitas = fabrica.crearVisitaGuiadaDAO();
        
        // Consulta de Climas
//        List<Clima> registrosClimas = climas.consultarTodos();
//       
//        registrosClimas.forEach(clima -> { 
//            System.out.println(clima); 
//        });
//        
//        // Consulta de Continentes
//        List<Continente> registrosContinentes = continentes.consultarTodos();
//        
//        registrosContinentes.forEach(continente -> {
//            System.out.println(continente);
//        });
//        
//        // Consulta de Vegetaciones
//        List<Vegetacion> registrosVegetaciones = vegetaciones.consultarTodos();
//        
//        registrosVegetaciones.forEach(vegetacion -> {
//            System.out.println(vegetacion);
//        });
//        
//        // Almacenar un habitat
//        Habitat habitat = new Habitat("Test", registrosClimas.get(0) , registrosVegetaciones.get(0), Arrays.asList(registrosContinentes.get(0)));
//        habitats.guardar(habitat);
//        
//        // Consultar habitats
//        Habitat registroHabitat = habitats.consultarNombre("Test");
//        
//        System.out.println(registroHabitat);
        
          List<VisitaGuiada> registroVisitas = visitas.consultarMes();
          
          registroVisitas.forEach(visit ->{
              System.out.println(visit);
          });
    }

    
    
    
}
