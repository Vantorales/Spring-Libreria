/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Vanesa
 */
@Entity
@ToString
public class Editorial {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column
    private String nombre;
    @Column
    private Boolean alta;

    public Editorial() {
    }

    public Editorial(String nombre, Boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
    
    
}
