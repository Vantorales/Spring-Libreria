/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Vanesa
 */
@Controller
@RequestMapping("/autor")
public class AutorController {
    
    
@GetMapping("/administrador")
public String autorAdmin(){
    return "autor_admin";
}
    
}
