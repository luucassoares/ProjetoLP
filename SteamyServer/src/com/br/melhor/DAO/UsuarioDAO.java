/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.DAO;

import com.br.melhor.model.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author felipemramos
 */
public class UsuarioDAO  extends UnicastRemoteObject implements GenericDAO<Usuario>{
    
    public EntityManagerFactory emf;
    public EntityManager em;
    
    public UsuarioDAO() throws RemoteException{
        createEM();
    }

    public void createEM(){
        if(em == null){
            emf = Persistence.createEntityManagerFactory("SteamyServerPU");
            em = emf.createEntityManager();
        }
    }
    
    
    @Override
    public void create(Usuario t) throws RemoteException{
        System.out.println("OIiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiCREATEiiiiiiiiiiiiiii");
        createEM();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();//comitar ftw
//        em.close();
    }

    @Override
    public List<Usuario> read() throws RemoteException {
        
        List<Usuario> users ;
        createEM();
        
        Query query = em.createNamedQuery("Usuario.findAll");
        
        em.getTransaction().begin();
        
        users = query.getResultList();
        
        em.getTransaction().commit();//comitar ftw
//        em.close();
        return users;
    }

    @Override
    public void update(Usuario t) throws RemoteException {
        createEM();
        
        em.getTransaction().begin();
        
        em.merge(t);
        
  
        em.getTransaction().commit();//comitar ftw
//        em.close();
    }

    @Override
    public void delete(Usuario t)  throws RemoteException{
        createEM();
        em.getTransaction().begin();
        em.merge(t);
        em.remove(t);
        em.getTransaction().commit();//comitar ftw
//        em.close();
    }
    
    public Usuario busca(int id) throws RemoteException{
        createEM();
        
        Usuario user = em.find(Usuario.class, id);
        
//        em.close();
        
        return user;
    }
}
