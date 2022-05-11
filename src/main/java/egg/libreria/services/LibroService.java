/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.services;

import egg.libreria.entities.Autor;
import egg.libreria.entities.Editorial;
import egg.libreria.entities.Libro;
import egg.libreria.repositories.LibroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vanesa
 */
@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepository;
    
    @Transactional (propagation = Propagation.NESTED)
    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial){
        
        Libro libro = new Libro(isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, alta, autor, editorial);
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplaresRestantes);
        libro.setAlta(alta);
        libro.getAutor().getNombre();
        libro.getEditorial().getNombre();
        
        libroRepository.save(libro);
    }
    
    public void ModificarLibro(Integer id,Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial){
        Libro libro = libroRepository.findById(id).get();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setEjemplaresPrestados(ejemplaresPrestados);
        libro.setEjemplaresRestantes(ejemplaresRestantes);
        libro.setAlta(alta);
        libro.getAutor().setNombre(titulo);
        libro.getEditorial().setNombre(titulo);
        
        libroRepository.save(libro);
    }
    
    @Transactional (readOnly = true )
    public List<Libro> mostrarLibros(){
        return libroRepository.findAll();
    }
    
    @Transactional (readOnly = true)
    public Libro buscarPorId(Integer id){
        return libroRepository.buscarPorId(id);
    }
  
    @Transactional (readOnly = true )
    public void eliminarPorId(Integer id){
        Optional<Libro> optional = libroRepository.findById(id);
        
        if(optional.isPresent()){
            libroRepository.delete(optional.get());
        }
    }   
    
}
