package entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa un Animal del Zoológico
 * 
 * @author Marin
 */
public class Animal {
    
    private ObjectId id;
    private Especie especie;
    private String nombre;
    private int edad;
    private String sexo;
    
    /**
     * Crea un Animal
     */
    public Animal() {
    }

    /**
     * Crea un animal con los parámetros dados.
     * 
     * @param especie Especie a la que pertenece.
     * @param nombre Nombre.
     * @param edad Edad.
     * @param sexo Sexo
     */
    public Animal(Especie especie, String nombre, int edad, String sexo) {
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    
    /**
     * Crea un animal con los parámetros dados.
     * 
     * @param nombre Nombre.
     * @param edad Edad.
     * @param sexo Sexo.
     */
    public Animal(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    /**
     * Crea un animal con los parámetros dados.
     * 
     * @param id ObjectId id.
     * @param especie Especie.
     * @param nombre Nombre.
     * @param edad Edad.
     * @param sexo Sexo.
     */
    public Animal(ObjectId id, Especie especie, String nombre, int edad, String sexo) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    /**
     * Devuelve el ObjectID del animal.
     * @return ObjectID.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID al dado como parámetro.
     * @param id Id.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve la especie a la que pertenece.
     * @return Especie.
     */
    public Especie getEspecie() {
        return especie;
    }

    /**
     * Establece la especie a la que pertenece a la dada como parámetro.
     * @param especie Especie.
     */
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    /**
     * Devuelve el nombre
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre al dado como parámetro.
     * @param nombre Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la edad.
     * @return Edad.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad a la dada como parámetro.
     * @param edad Edad.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve el Sexo.
     * @return Sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo al dado como parámetro.
     * @param sexo Sexo.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    /**
     * Genera el ID del objeto.
     */
    public void generarId(){
        this.id = new ObjectId();
    }

    /**
     * Genera un HASH del objeto.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.especie);
        return hash;
    }

    /**
     * Verifica si el objeto dado como parámetro es igual a este objeto.
     * Dos Animales son iguales si tienen el mismo ID.
     * @param obj Animal a comparar.
     * @return True si son iguales, False en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.especie, other.especie);
    }

    /**
     * Devuelve el nombre del animal en representación al objeto.
     * @return Nombre.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
