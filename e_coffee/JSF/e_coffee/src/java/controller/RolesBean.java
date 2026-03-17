/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.RolesDao;
import entity.Roles;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


/**
 *
 * 
 */
@Named(value = "rolesBean")
@SessionScoped
public class RolesBean implements Serializable {
    
    private Roles entity;
    private RolesDao dao;
    private List<Roles> list;

    public RolesBean() {
        super();
    }
    
    public void clearForm() {
        this.entity = new Roles();
    }

    public void create() {

        this.getDao().create(entity);
        this.entity = new Roles();
    }


    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Roles();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Roles();
    }

    public Roles getEntity() {
        if (this.entity == null) {
            this.entity = new Roles();
        }
        return entity;
    }

    public void setEntity(Roles entity) {
        this.entity = entity;
    }

    public List<Roles> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public RolesDao getDao() {
        if (this.dao == null) {
            this.dao = new RolesDao();
        }
        return dao;
    }

    public void setDao(RolesDao dao) {
        this.dao = dao;
    }

    public void setList(List<Roles> list) {
        this.list = list;
    }

  

}
