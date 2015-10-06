/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.melhor.DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author felipemramos
 */
public interface GenericDAO<T> extends Remote{
    public boolean insert(T t) throws RemoteException;
    public List<T> read() throws RemoteException;
    public boolean update(T t) throws RemoteException;
    public boolean delete(T t) throws RemoteException;
}
