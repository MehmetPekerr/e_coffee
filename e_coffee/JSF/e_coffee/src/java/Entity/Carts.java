/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * 
 */
public class Carts implements Serializable{
    private Long cart_id;
    private Users user_id;
    private Products product_id;
    private int quantity;

    public Carts() {
    }

    public Carts(Users user_id, Products product_id, int quantity) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Carts(Long cart_id, Users user_id, Products product_id, int quantity) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public Products getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Products product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
        
   
    
            
            

   }
