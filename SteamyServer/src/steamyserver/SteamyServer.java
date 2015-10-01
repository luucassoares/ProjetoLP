/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamyserver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import steamyserver.model.Usuario;

/**
 *
 * @author felipemramos
 */
public class SteamyServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SteamyServerPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Usuario user = new Usuario();
        user.setUsuarioNome("Felipe");
        user.setUsuarioSenha("123");
        em.persist(user);
        em.getTransaction().commit();//comitar ftw
        em.close();
        
    }
    
}
