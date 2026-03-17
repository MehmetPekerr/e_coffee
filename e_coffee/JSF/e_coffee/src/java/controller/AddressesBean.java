/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.AddressesDao;
import entity.Addresses;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 *
 */
@Named(value = "addressesBean")
@SessionScoped
public class AddressesBean implements Serializable {

    private Addresses entity;
    private AddressesDao dao;
    private List<Addresses> list;
    private List<Addresses> list2;

    public List<Addresses> getList2() {

        this.list2 = this.getDao().getListttt(this.hangiSayfa,this.gorunenVeri);
        return list2;
    }

    public void setList2(List<Addresses> list2) {
        this.list2 = list2;
    }

    
    
    public void create() {
        this.getDao().create(entity);
        this.entity = new Addresses();
    }

    public void clearForm() {
        this.entity = new Addresses();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Addresses();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Addresses();
    }

    public List<Addresses> getList() {

        this.list = this.getDao().getList();
        return list;
    }

    public Addresses getEntity() {
        if (this.entity == null) {
            this.entity = new Addresses();
        }
        return entity;
    }

    public void setEntity(Addresses entity) {
        this.entity = entity;
    }

    public AddressesDao getDao() {
        if (this.dao == null) {
            this.dao = new AddressesDao();
        }
        return dao;
    }

    public void setDao(AddressesDao dao) {
        this.dao = dao;
    }

    public void setList(List<Addresses> list) {
        this.list = list;
    }
    protected int gorunenVeri=5;
    protected int hangiSayfa=1;
    
    public void prev(){
        hangiSayfa--;
    }

      public void next(){
        hangiSayfa++;
    }

    public int getGorunenVeri() {
        return gorunenVeri;
    }

    public void setGorunenVeri(int gorunenVeri) {
        this.gorunenVeri = gorunenVeri;
    }

    public int getHangiSayfa() {
        return hangiSayfa;
    }

    public void setHangiSyfa(int hangiSyfa) {
        this.hangiSayfa = hangiSyfa;
    }
}
