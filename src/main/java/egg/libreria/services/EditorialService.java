/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.services;

import egg.libreria.entities.Editorial;
import egg.libreria.errors.ErrorsService;
import egg.libreria.repositories.EditorialRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vanesa
 */
@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Transactional
    public void crearEditorial(String nombre) throws ErrorsService {

        validacion(nombre);
        Optional<Editorial> respuesta = editorialRepository.findById(editorialRepository.buscarPorNombre(nombre).getId());
        if (!respuesta.isPresent()) {
            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            editorialRepository.save(editorial);
        }

    }

    public Editorial buscarEditorialPorNombre(String nombre) throws ErrorsService {
        validacion(nombre);
        Optional<Editorial> respuesta = editorialRepository.findById(editorialRepository.buscarPorNombre(nombre).getId());
        if (!respuesta.isPresent()) {
            return respuesta.get();
        } else {
            throw new ErrorsService("No se encontró la editorial ingresada.");
        }
    }

    @Transactional
    public void modificarNombreEditorial(String nombre, String nuevoNombre) throws ErrorsService {
        validacion(nombre);
        if (nuevoNombre == null || nuevoNombre.length() < 4 || nuevoNombre.trim().isEmpty()) {
            throw new ErrorsService("El nuevo nombre introducido no es válido.");
        }
        Editorial editorial = editorialRepository.findById(editorialRepository.buscarPorNombre(nombre).getId()).get();
        editorial.setNombre(nuevoNombre);
        editorialRepository.save(editorial);

    }

    @Transactional
    public void eliminarEditorialPorNombre(String nombre) throws ErrorsService {
        validacion(nombre);
        Editorial editorial = editorialRepository.findById(editorialRepository.buscarPorNombre(nombre).getId()).get();
        Optional<Editorial> respuesta = editorialRepository.findById(editorialRepository.buscarPorNombre(nombre).getId());
        if (respuesta.isPresent()) {
            editorial.setAlta(false);
            editorialRepository.save(editorial);
        } else {
            throw new ErrorsService("La editorial no se encuentra");
        }
    }

    public void validacion(String nombre) throws ErrorsService {
        if (nombre == null || nombre.trim().isEmpty() || nombre.length() < 3) {
            throw new ErrorsService("El nombre no puede estar vacío y debe contener 3 caracteres o más");
        }
    }

}
