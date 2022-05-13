/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Vanesa
 */
@Entity
public class Libro {

    //Attributes with getters and setters
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column
    private String titulo;

    @Column
    private Boolean alta;

    @Column
    private Integer anio;

    @Column
    private Integer ejemplares;

    @Column(name = "ejemplares_prestados")
    private Integer ejemplaresPrestados;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Autor autor;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String isbn, String titulo, Boolean alta, Integer anio, Integer ejemplares) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.alta = alta;
        this.anio = anio;
        this.ejemplares = ejemplares;
    }

    public Libro(String bn, String titulo, Integer anio, Autor buscarAutorPorNombre, Editorial buscarEditorialPorNombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Boolean getAlta() {
        return alta;
    }

    public Integer getAnio() {
        return anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    

    @Override
    public String toString() {
        return "Libro{"
                + "id='" + id + '\''
                + ", isbn=" + isbn
                + ", titulo='" + titulo + '\''
                + ", alta=" + alta
                + ", anio=" + anio
                + ", ejemplares=" + ejemplares
                + ", ejemplares prestados=" + ejemplaresPrestados
                + ", autor=" + autor
                + ", editorial=" + editorial
                + '}';
    }

}
