/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.ProductDao;
import entity.Products;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * 
 */
@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {

  
    private Products entity;
    private ProductDao dao;
    private List<Products> list;

    public void create() {
        this.getDao().create(entity);
        this.entity = new Products();
    }
     public void clearForm() {
        this.entity = new Products();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Products();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Products();
    }

    public List<Products> getList() {

        this.list = this.getDao().getList();
        return list;
    }

    public Products getEntity() {
        if (this.entity == null) {
            this.entity = new Products();
        }
        return entity;
    }

    public void setEntity(Products entity) {
        this.entity = entity;
    }

    public ProductDao getDao() {
        if (this.dao == null) {
            this.dao = new ProductDao();
        }
        return dao;
    }

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }

    public void setList(List<Products> list) {
        this.list = list;
    }
    
}
