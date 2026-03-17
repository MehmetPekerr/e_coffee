/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.PermissionsDao;
import entity.Permissions;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * 
 */
@Named(value = "permissionsBean")
@SessionScoped
public class PermissionsBean implements Serializable {

   
    private Permissions entity;
    private PermissionsDao dao;
    private List<Permissions> list;

    public void create() {
        this.getDao().create(entity);
        this.entity = new Permissions();
    }

    public void clearForm() {
        this.entity = new Permissions();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Permissions();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Permissions();
    }

    public List<Permissions> getList() {

        this.list = this.getDao().getList();
        return list;
    }

    public Permissions getEntity() {
        if (this.entity == null) {
            this.entity = new Permissions();
        }
        return entity;
    }

    public void setEntity(Permissions entity) {
        this.entity = entity;
    }

    public PermissionsDao getDao() {
        if (this.dao == null) {
            this.dao = new PermissionsDao();
        }
        return dao;
    }

    public void setDao(PermissionsDao dao) {
        this.dao = dao;
    }

    public void setList(List<Permissions> list) {
        this.list = list;
    }
    
}
