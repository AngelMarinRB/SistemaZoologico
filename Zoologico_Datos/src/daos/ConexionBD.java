package daos;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import interfaces.IConexionBD;

/**
 * Implementación de la ConexionBD para conectarse hacia MongoDB.
 * 
 * @author Marin
 */
class ConexionBD implements IConexionBD{

    private static final String HOST = "localhost";
    private static final int PUERTO = 27017;
    private static final String BASE_DATOS = "zoologico";
    
    private static MongoDatabase conexion = null;
    
    
    @Override
    public MongoDatabase getConnection() {
        
        if(conexion != null){
            return conexion;
        }
        
        try{
            //CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            
            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
            
            ConnectionString cadenaConexion = new ConnectionString("mongodb://"+HOST+"/"+PUERTO);
            
            MongoClientSettings clientsSettings = MongoClientSettings.builder()
                .applyConnectionString(cadenaConexion)
                .codecRegistry(codecRegistry)
                .build();
            
            MongoClient clienteMongo = MongoClients.create(clientsSettings);
            
            MongoDatabase baseDatos = clienteMongo.getDatabase(BASE_DATOS);
            
            return baseDatos;           
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
}