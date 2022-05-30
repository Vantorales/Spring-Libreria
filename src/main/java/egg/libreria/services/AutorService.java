/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.services;

import egg.libreria.entities.Autor;
import egg.libreria.entities.Libro;
import egg.libreria.errors.ErrorsService;
import egg.libreria.repositories.AutorRepository;
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
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Transactional(propagation = Propagation.NESTED)
    public void crearAutor(String nombre, Boolean alta) throws Exception {

        validacion(nombre);
        Autor autor = new Autor(nombre, alta);
        
        autorRepository.save(autor);

    }

    public Autor buscarAutorPorNombre(String nombre) throws ErrorsService {
        validacion(nombre);
        Optional<Autor> respuesta = autorRepository.findById(autorRepository.buscarPorNombre(nombre).getId());
        if (respuesta.isPresent()) {
            return autorRepository.buscarPorNombre(nombre);
        } else {
            throw new ErrorsService("No se encontró el autor ingresado");
        }

    }
    
   public List<Autor> getAutores()
   {
       List<Autor> listaAutores = autorRepository.findAll();
       return listaAutores;
   }

    @Transactional
    public void modificarNombreAutor(String nombre, String nuevoNombre) throws ErrorsService {
        validacion(nombre);
        if (nuevoNombre == null || nuevoNombre.length() < 4 || nuevoNombre.trim().isEmpty()) {
            throw new ErrorsService("El nuevo nombre introducido no es válido.");
        }
        Autor autor = autorRepository.findById(autorRepository.buscarPorNombre(nombre).getId()).get();

        autor.setNombre(nuevoNombre);
        autorRepository.save(autor);
    }

    public Autor buscarAutorPorLibro(String titulo) throws ErrorsService {
        validacion(titulo);
        Optional<Libro> respuesta = libroRepository.findById(libroRepository.buscarPorTitulo(titulo).getId());
        if (respuesta.isPresent()) {
            return libroRepository.buscarPorTitulo(titulo).getAutor();
        } else {
            throw new ErrorsService("El autor del libro no se encuentra");
        }

    }

    @Transactional
    public void eliminarAutorPorNombre(String nombre) throws ErrorsService {
        validacion(nombre);
        Autor autor = autorRepository.findById(autorRepository.buscarPorNombre(nombre).getId()).get();
        Optional<Autor> respuesta = autorRepository.findById(autorRepository.buscarPorNombre(nombre).getId());
        if (respuesta.isPresent()) {
            autor.setAlta(false);
            autorRepository.save(autor);
        } else {
            throw new ErrorsService("El autor no se encuentra");
        }
    }

    public void validacion(String nombre) throws ErrorsService {
        if (nombre == null || nombre.trim().isEmpty() || nombre.length() < 3) {
            throw new ErrorsService("El nombre no puede estar vacío y debe contener 3 caracteres o más");
        }
    }

}
