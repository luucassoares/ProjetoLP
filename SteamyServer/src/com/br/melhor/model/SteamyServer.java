/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.model;

import com.br.melhor.DAO.GruposDAO;
import com.br.melhor.DAO.JogoDAO;
import com.br.melhor.DAO.ServidorDAO;
import com.br.melhor.DAO.UsuarioDAO;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author felipemramos
 */
public class SteamyServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
//        UsuarioDAO dao = new UsuarioDAO();
//        Usuario user = dao.busca(2);
//        user.setUsuarioNome("BomNome");
//        dao.update(user);
//        
        
        try {
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("UsuarioDAO", new UsuarioDAO() );
            System.out.println("Serviço registrado com sucesso!");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
}
