/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SuppliersDao;
import entity.Suppliers;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * 
 */
@Named(value = "suppliersBean")
@SessionScoped
public class SuppliersBean implements Serializable {

    private Suppliers entity;
    private SuppliersDao dao;
    private List<Suppliers> list;

    public void create() {
        this.getDao().create(entity);
        this.entity = new Suppliers();
    }

    public void clearForm() {
        this.entity = new Suppliers();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Suppliers();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Suppliers();
    }

    public List<Suppliers> getList() {

        this.list = this.getDao().getList();
        return list;
    }

    public Suppliers getEntity() {
        if (this.entity == null) {
            this.entity = new Suppliers();
        }
        return entity;
    }

    public void setEntity(Suppliers entity) {
        this.entity = entity;
    }

    public SuppliersDao getDao() {
        if (this.dao == null) {
            this.dao = new SuppliersDao();
        }
        return dao;
    }

    public void setDao(SuppliersDao dao) {
        this.dao = dao;
    }

    public void setList(List<Suppliers> list) {
        this.list = list;
    }
}
