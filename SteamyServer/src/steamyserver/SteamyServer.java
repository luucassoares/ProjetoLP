/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamyserver;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import steamyserver.model.Usuario;
import steamyserver.model.UsuarioDAO;

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
        UsuarioDAO dao = new UsuarioDAO();
        
        Usuario user = new Usuario();
        user.setUsuarioNome("Teste 1");
        user.setUsuarioSenha("Teste 2");
        
        dao.create(user);
//        
//        List<Usuario> users = dao.read();
//        for (Usuario user : users) {
//            System.out.println(user.getUsuarioNome());
//            System.out.println(user.getUsuarioId());
//            user.setUsuarioNome("bob");
//            dao.update(user);
//        }
        dao.em.close();
            
            
    }
    
}
