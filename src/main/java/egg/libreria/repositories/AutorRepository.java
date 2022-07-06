/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.repositories;

import egg.libreria.entities.Autor;
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
public interface AutorRepository extends JpaRepository<Autor, String> {
    
     @Query("SELECT a FROM Autor a WHERE a.nombre= :nombre")
     public Autor buscarPorNombre(@Param("nombre") String nombre);
     
     @Query("SELECT a FROM Autor a WHERE a.visible= 1")
     public List<Autor> mostrarAutores();

    public Optional<Autor>findById(String id);
    
}
