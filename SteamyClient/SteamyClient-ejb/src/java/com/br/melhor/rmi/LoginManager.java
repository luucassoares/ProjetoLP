/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.rmi;

import com.br.melhor.DAO.GenericDAO;
import com.br.melhor.entities.Usuario;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author felipemramos
 */
@Stateless
public class LoginManager implements LoginManagerLocal {

    @Override
    public List<Usuario> buscarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            GenericDAO servico = (GenericDAO) registro.lookup("UsuarioDAO");
            lista = servico.read();
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
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

}
