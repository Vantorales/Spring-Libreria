/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.services;

import egg.libreria.entities.Editorial;
import egg.libreria.entities.Libro;
import egg.libreria.errors.ErrorsService;
import egg.libreria.repositories.AutorRepository;
import egg.libreria.repositories.LibroRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Vanesa
 */
@Service
public class LibroService {

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditorialService editorialService;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @javax.transaction.Transactional
    public void crearLibro(String isbn, String titulo, Integer anio, String autor, String editorial) throws ErrorsService {

        validacion(isbn, titulo, anio, autor);
        Optional<Libro> respuesta = libroRepository.findById(libroRepository.buscarPorTitulo(titulo).getId());
        Libro libro;
        if (respuesta.isPresent()) {
            libro = respuesta.get();
            libro.setEjemplares(libro.getEjemplares() + 1);
            libro.setAlta(true);
            libro.setAutor(autorService.buscarAutorPorNombre(autor));
            libro.setEditorial(editorialService.buscarEditorialPorNombre(editorial));
        } else {
            libro = new Libro(isbn, titulo, anio, autorService.buscarAutorPorNombre(autor), editorialService.buscarEditorialPorNombre(editorial));
            libro.setEjemplares(1);
            libro.setAlta(true);
        }
        libroRepository.save(libro);

    }

/*
    public void modifyBook(){
        Optional<Author> answer2 = authorRepository.findById(authorRepository.findAuthorByName(nameAuthor).getId());
        Author author = new Author();
        if (answer2.isPresent()){
            author
        }

        author.setName(nameAuthor);
        author.setUp(true);
        book.setAuthor(author);
    }
*/

    public void validacion(String isbn, String titulo, Integer anio, String nombreAutor) throws ErrorsService {

        if (isbn == null || isbn.trim().isEmpty()) throw new ErrorsService("El isbn no puede estar vacío");
        if (titulo == null || titulo.trim().isEmpty()) throw new ErrorsService("El titulo no puede estar vacío");
        if (anio== null || anio.toString().trim().isEmpty()) throw new ErrorsService("El año no puede estar vacío");
        if (nombreAutor == null || nombreAutor.trim().isEmpty())
            throw new ErrorsService("El nombre del autor no puede estar vacío");

    }

    public void validacionEditorialesList(List<Editorial> editoriales) throws ErrorsService {

        for (Editorial editorial :editoriales) {
            if (editorial.getNombre().trim().isEmpty())
                throw new ErrorsService("El nombre del editor no puede estar vacío");
        }

    }

    public List<Editorial> mergeEditorialesList(List<Editorial> list1, List<Editorial> list2) {
        return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
    }

}