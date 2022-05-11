/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.services;

import egg.libreria.entities.Autor;
import egg.libreria.errors.ErrorsService;
import egg.libreria.repositories.AutorRepository;
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
public class AutorService {
    
    @Autowired
    private AutorRepository autorRepository;
    
    @Transactional (propagation = Propagation.NESTED)
    public void crearAutor(String nombre, boolean alta) throws ErrorsService{
        
        if( nombre==null || nombre.isEmpty()){
            throw new ErrorsService("El nombre del autor no puede ser nulo");
        }
        
        Autor autor = new Autor(nombre, alta);
        autor.setNombre(nombre);
        autor.setAlta(alta);
        
        autorRepository.save(autor);

    }
    
    public void modificarAutor(Integer id, String nombre, boolean alta){
        Autor autor = autorRepository.findById(id).get();
        autor.setNombre(nombre);
        autor.setAlta(alta);
        
        autorRepository.save(autor);
    }
    
    @Transactional (readOnly = true)
    public List<Autor> mostrarAutores(){
        return autorRepository.findAll();
    }
    
    @Transactional (readOnly = true)
    public Autor buscarPorId(Integer id){
        return autorRepository.buscarPorId(id);
    }
    
    @Transactional (readOnly = true)
    public void eliminarPorId(Integer id){
        Optional<Autor> optional = autorRepository.findById(id);
        
        if(optional.isPresent()){
            autorRepository.delete(optional.get());
        }
    }
    
}
