/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.repositories;

import egg.libreria.entities.Editorial;
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
public interface EditorialRepository extends JpaRepository<Editorial, String> {
    
    @Query("SELECT e FROM Editorial e WHERE e.nombre= :nombre")
    public Editorial buscarPorNombre(@Param("nombre") String nombre);
    
    @Query("SELECT e FROM Editorial e WHERE e.id= :id")
    public Editorial buscarPorId(@Param("id") Integer id);
    
    @Query("SELECT e FROM Editorial e")
    public List<Editorial> mostrarEditoriales();
    
    public Optional <Editorial>findById(Integer id);
}
