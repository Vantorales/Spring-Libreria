/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.controllers;

import egg.libreria.errors.ErrorsService;
import egg.libreria.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Vanesa
 */
@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/administrador")
    public String autorAdmin() {
        return "autor_admin";
    }
    
    @GetMapping("/getAutores")
    public String getAutores(ModelMap vistaAutor){
        vistaAutor.addAttribute("autores", autorService.getAutores());
        
        return "autor_admin";
    }

    @PostMapping("/agregar")
    public String agregar(ModelMap vistaAutor, @RequestParam String nombre, @RequestParam String alta) throws Exception {
        try {
            Boolean auxAlta = Boolean.valueOf(alta);
            autorService.crearAutor(nombre, auxAlta);
            vistaAutor.addAttribute("exito", "se agregó con exito");
            
        } catch (ErrorsService e) {
            e.printStackTrace();
            vistaAutor.put("exito","error al registrar");
        }
        return "autor_admin";
    }
    
    @PostMapping("/eliminar")
    public String Eliminar(ModelMap vistaAutor, @RequestParam String nombre) throws Exception {
        try {
           
            autorService.eliminarAutorPorNombre(nombre);
                
        } catch (ErrorsService e) {
            e.printStackTrace();
        }
        return "autor_admin";
    }
   
}
