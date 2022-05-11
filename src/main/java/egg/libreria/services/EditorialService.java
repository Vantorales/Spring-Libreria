/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.services;

import egg.libreria.entities.Editorial;
import egg.libreria.errors.ErrorsService;
import egg.libreria.repositories.EditorialRepository;
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
public class EditorialService {
    
    @Autowired
    private EditorialRepository editorialRepository;
    
    @Transactional (propagation = Propagation.NESTED)
    public void crearEditorial(String nombre, boolean alta) throws ErrorsService{
        
        if( nombre==null || nombre.isEmpty()){
            throw new ErrorsService("El nombre de la editorial no puede ser nulo");
        }
        
        Editorial editorial = new Editorial(nombre, alta);
        editorial.setNombre(nombre);
        editorial.setAlta(alta);
        
        editorialRepository.save(editorial);

    }
    
    public void modificarAutor(Integer id, String nombre, boolean alta){
        Editorial editorial = editorialRepository.findById(id).get();
        editorial.setNombre(nombre);
        editorial.setAlta(alta);
        
       editorialRepository.save(editorial);
    }
    
    @Transactional (readOnly = true)
    public List<Editorial> mostrarEditoriales(){
        return editorialRepository.findAll();
    }
    
    @Transactional (readOnly = true)
    public Editorial buscarPorId(Integer id){
        return editorialRepository.buscarPorId(id);
    }
    
    @Transactional (readOnly = true)
    public void eliminarPorId(Integer id){
        Optional<Editorial> optional = editorialRepository.findById(id);
        
        if(optional.isPresent()){
            editorialRepository.delete(optional.get());
        }
    }
    
}
