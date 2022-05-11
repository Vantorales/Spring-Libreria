/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.repositories;

import egg.libreria.entities.Libro;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vanesa
 */
@Repository
public interface LibroRepository extends JpaRepository <Libro, String> {
    
    @Query("SELECT l FROM Libro l WHERE l.titulo= :titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo);
    
    @Query("SELECT l FROM Libro l WHERE l.id= :id")
    public Libro buscarPorId(@Param("id") Integer id);
    
    @Query("SELECT l FROM Libro l")
    public List<Libro> mostrarLibros();
    
    public Optional <Libro>findById(Integer id);
    
}
