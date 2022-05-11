/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.errors;

import org.springframework.stereotype.Service;

/**
 *
 * @author Vanesa
 */
@Service
public class ErrorsService extends Exception{

    public ErrorsService(String mensaje) {
        super(mensaje);
    }

    public ErrorsService() {
    }
    
    
    
    
    
}
