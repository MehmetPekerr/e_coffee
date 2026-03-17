/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.ProductCategoriesDAO;
import entity.ProductCategories;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * 
 */
@Named(value = "productCategoriesBean")
@SessionScoped
public class ProductCategoriesBean implements Serializable {

    private ProductCategories entity;
    private ProductCategoriesDAO dao;
    private List<ProductCategories> list;

    public void create() {
        this.getDao().create(entity);
        this.entity = new ProductCategories();
    }
     public void clearForm() {
        this.entity = new ProductCategories();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new ProductCategories();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new ProductCategories();
    }

    public List<ProductCategories> getList() {

        this.list = this.getDao().getList();
        return list;
    }

    public ProductCategories getEntity() {
        if (this.entity == null) {
            this.entity = new ProductCategories();
        }
        return entity;
    }

    public void setEntity(ProductCategories entity) {
        this.entity = entity;
    }

    public ProductCategoriesDAO getDao() {
        if (this.dao == null) {
            this.dao = new ProductCategoriesDAO();
        }
        return dao;
    }

    public void setDao(ProductCategoriesDAO dao) {
        this.dao = dao;
    }

    public void setList(List<ProductCategories> list) {
        this.list = list;
    }

}
