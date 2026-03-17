/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.RolePermissionsDao;
import entity.RolePermissions;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * 
 */
@Named(value = "rolePermissionsBean")
@SessionScoped
public class RolePermissionsBean implements Serializable {

    private RolePermissions entity;
    private RolePermissionsDao dao;
    private List<RolePermissions> list;

    public RolePermissionsBean() {
    }
      public void create() {
        this.getDao().create(entity);
        this.entity = new RolePermissions();
    }
     public void clearForm() {
        this.entity = new RolePermissions();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new RolePermissions();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new RolePermissions();
    }


    public List<RolePermissions> getList() {

        this.list = this.getDao().getList();
        return list;
    }

    public RolePermissions getEntity() {
        if (this.entity == null) {
            this.entity = new RolePermissions();
        }
        return entity;
    }

    public void setEntity(RolePermissions entity) {
        this.entity = entity;
    }

    public RolePermissionsDao getDao() {
        if (this.dao == null) {
            this.dao = new RolePermissionsDao();
        }
        return dao;
    }

    public void setDao(RolePermissionsDao dao) {
        this.dao = dao;
    }

    public void setList(List<RolePermissions> list) {
        this.list = list;
    }
}
