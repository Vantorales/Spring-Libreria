/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.controllers;

import egg.libreria.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Vanesa
 */
@Controller
@RequestMapping("/libro")
public class LibroController {
    
    @Autowired
    private LibroService libroService;
    
    @GetMapping("/administrador")
    public String libroAdmin(){
        return "libro_admin";
    }
    
    
    
    
    
    
    
}
