/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.rmi;

import com.br.lp3.model.entity.Usuario;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author felipemramos
 */
@Stateless
@LocalBean
public class LoginManager implements LoginManagerLocal{

    @Override
    public List<Usuario> buscarUsuarios() {
        List<Usuario> users = new ArrayList<>();
        
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 8080);
            GenericDao servico =(GenericDao) registro.lookup("UsuarioDAO");
        } catch (RemoteException | NotBoundException  ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }

    @Override
    public boolean authorize(String username, String password) {
        List<Usuario> lista = buscarUsuarios();
        for (Usuario usuario : lista) {
            if(usuario.getUsuarioNome().equals(username) && usuario.getUsuarioSenha().equals(password)){
                return true;
            }
        }
        return false;
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
