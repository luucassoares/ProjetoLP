/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.model;

import com.br.melhor.DAO.UsuarioDAO;
import java.rmi.RemoteException;

/**
 *
 * @author felipemramos
 */
public class SteamyServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        UsuarioDAO userdao = new UsuarioDAO();
//        Usuario user = new Usuario();
//        user.setUsuarioNome("bobe");
//        user.setUsuarioSenha("1234");
        Usuario user = userdao.busca(1);
        user.setUsuarioNome("O fagote");
        userdao.update(user);
    }
    
}
