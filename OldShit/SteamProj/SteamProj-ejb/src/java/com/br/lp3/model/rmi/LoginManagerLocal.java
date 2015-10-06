/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.rmi;

import java.util.List;
import com.br.lp3.model.entity.Usuario;

/**
 *
 * @author felipemramos
 */
public interface LoginManagerLocal {
    public List<Usuario> buscarUsuarios();
    public boolean authorize(String username, String password);
}
