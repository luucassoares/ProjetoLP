/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.rmi;

import com.br.melhor.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author felipemramos
 */
@Local
public interface LoginManagerLocal {
    
    public List<Usuario> buscarUsuarios();

    public boolean authorize(String username, String password);
    
}
