/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamyserver.model;

import java.util.List;

/**
 *
 * @author felipemramos
 */
public interface GenericDao<T> {
    
    public void create(T t);
    public List<T>  read();
    public void update(T t);
    public void delete(T t);
    
}
