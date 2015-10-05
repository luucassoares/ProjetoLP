/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.DAO;

import com.br.melhor.model.Servidor;
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
public class ServidorDAO  extends UnicastRemoteObject implements GenericDAO<Servidor>{
    
    public EntityManagerFactory emf;
    public EntityManager em;
    
    public ServidorDAO() throws RemoteException{
        emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        em = emf.createEntityManager();
    }

    
    
    @Override
    public void create(Servidor t) throws RemoteException{
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();//comitar ftw
//        em.close();
    }

    @Override
    public List<Servidor> read() throws RemoteException {
        List<Servidor> users ;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Usuario.findAll");
        
        em.getTransaction().begin();
        
        users = query.getResultList();
        
        em.getTransaction().commit();//comitar ftw
//        em.close();
        return users;
    }

    @Override
    public void update(Servidor t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(t);
        
  
        em.getTransaction().commit();//comitar ftw
//        em.close();
    }

    @Override
    public void delete(Servidor t)  throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();//comitar ftw
//        em.close();
    }
    
    public Servidor busca(int id) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        EntityManager em = emf.createEntityManager();
        
        Servidor server = em.find(Servidor.class, id);
        
//        em.close();
        
        return server;
    }
}
