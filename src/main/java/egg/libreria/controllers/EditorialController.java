/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.controllers;

import egg.libreria.errors.ErrorsService;
import egg.libreria.services.EditorialService;
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
@RequestMapping("/editorial")
public class EditorialController {
    

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/administrador")
    public String editorialAdmin() {
        return "editorial_admin";
    }

    @PostMapping("/agregar")
    public String agregar(ModelMap vistaEditorial, @RequestParam String nombre, @RequestParam String alta) throws Exception {
        try {
            Boolean auxAlta = Boolean.valueOf(alta);
            editorialService.crearEditorial(nombre, auxAlta);
            vistaEditorial.addAttribute("exito", "se agregó con exito");
            
        } catch (ErrorsService e) {
            e.printStackTrace();
            vistaEditorial.put("exito","error al registrar");
        }
        return "autor_admin";
    }

}


