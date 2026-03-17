/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.UserDao;
import entity.Users;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * 
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

  
    private Users entity;
    private UserDao dao;
    private List<Users> list;

    public void create() {
        this.getDao().create(entity);
        this.entity = new Users();
    }
     public void clearForm() {
        this.entity = new Users();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Users();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Users();
    }

    public List<Users> getList() {

        this.list = this.getDao().getList();
        return list;
    }

    public Users getEntity() {
        if (this.entity == null) {
            this.entity = new Users();
        }
        return entity;
    }

    public void setEntity(Users entity) {
        this.entity = entity;
    }

    public UserDao getDao() {
        if (this.dao == null) {
            this.dao = new UserDao();
        }
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public void setList(List<Users> list) {
        this.list = list;
    }
    
    
}
