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
public class Permissions implements Serializable{
    private Long permission_id;
    private String permission_name;

    public Permissions() {
    }

    public Permissions(String permission_name) {
        this.permission_name = permission_name;
    }

    public Permissions(Long permission_id, String permission_name) {
        this.permission_id = permission_id;
        this.permission_name = permission_name;
    }

    public Long getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Long permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.permission_id);
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
        final Permissions other = (Permissions) obj;
        return Objects.equals(this.permission_id, other.permission_id);
    }
    
    
}
