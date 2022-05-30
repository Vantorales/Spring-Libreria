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
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Autor {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(unique = true)
    private String nombre;
    @Column(nullable = false)
    private Boolean alta;
    @Column(nullable = false)
    private Boolean visible; //Esto simulara una eliminación, solo lo ocultara para que no sea visible en el front y no borrar de la bd

    public Autor() {
    }

    public Autor(String nombre, Boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public Autor(String nombre, Boolean alta, Boolean visible) {
        this.nombre = nombre;
        this.alta = alta;
        this.visible = visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getVisible() {
        return visible;
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
