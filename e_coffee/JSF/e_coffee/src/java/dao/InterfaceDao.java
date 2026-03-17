/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * 
 */
public interface InterfaceDao<T> {
    
    public List<T> getList();

    public void create(T t);

    public void update(T t);

    public void delete(T t);

}
