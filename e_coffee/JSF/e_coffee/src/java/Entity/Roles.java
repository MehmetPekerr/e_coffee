/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * 
 */
public class Roles implements Serializable {
    private Long role_id;
    private String role_name;

    public Roles() {
    }

    public Roles(String role_name) {
        this.role_name = role_name;
    }

    public Roles(Long role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }
    

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.role_id);
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
        final Roles other = (Roles) obj;
        return Objects.equals(this.role_id, other.role_id);
    }
    
    
}
