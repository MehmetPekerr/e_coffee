/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.OrdersDao;
import entity.Orders;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * 
 */
@Named(value = "ordersBean")
@SessionScoped
public class OrdersBean implements Serializable {

    private Orders entity;
    private OrdersDao dao;
    private List<Orders> list;
    /**
     * Creates a new instance of OrdersBean
     */
    
    public void create() {
        this.getDao().create(entity);
        this.entity = new Orders();
    }

    public void clearForm() {
        this.entity = new Orders();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Orders();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Orders();
    }

    public List<Orders> getList() {

        this.list = this.getDao().getList();
        return list;
    }

    public Orders getEntity() {
        if (this.entity == null) {
            this.entity = new Orders();
        }
        return entity;
    }

    public void setEntity(Orders entity) {
        this.entity = entity;
    }

    public OrdersDao getDao() {
        if (this.dao == null) {
            this.dao = new OrdersDao();
        }
        return dao;
    }

    public void setDao(OrdersDao dao) {
        this.dao = dao;
    }

    public void setList(List<Orders> list) {
        this.list = list;
    }
}
