/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * 
 */
public class Orders implements Serializable{
    private Long order_id;
    private Users user_id;
    private String order_date;
    private String status;

    public Orders() {
    }

    public Orders(Long order_id, String order_date, String status) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.status = status;
    }
    

    public Orders(Users user_id, String order_date, String status) {
        this.user_id = user_id;
        this.order_date = order_date;
        this.status = status;
    }

    public Orders(Long order_id, Users user_id, String order_date, String status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.status = status;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Users getUser_id() {
        
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.order_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Orders other = (Orders) obj;
        return Objects.equals(this.order_id, other.order_id);
    }
    
    
    
     
}
