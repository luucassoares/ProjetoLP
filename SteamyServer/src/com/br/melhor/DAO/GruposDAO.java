/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.DAO;

import com.br.melhor.model.Grupos;
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
public class GruposDAO  extends UnicastRemoteObject implements GenericDAO<Grupos>{
    
    public EntityManagerFactory emf;
    public EntityManager em;
    
    public GruposDAO() throws RemoteException{
        emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        em = emf.createEntityManager();
    }

    
    
    @Override
    public void create(Grupos t) throws RemoteException{
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();//comitar ftw
//        em.close();
    }

    @Override
    public List<Grupos> read() throws RemoteException {
        List<Grupos> users ;
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
    public void update(Grupos t) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(t);
        
  
        em.getTransaction().commit();//comitar ftw
//        em.close();
    }

    @Override
    public void delete(Grupos t)  throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();//comitar ftw
//        em.close();
    }
    
    public Grupos busca(int id) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        EntityManager em = emf.createEntityManager();
        
        Grupos grupo = em.find(Grupos.class, id);
        
//        em.close();
        
        return grupo;
    }
}
