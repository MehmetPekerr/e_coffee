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
public class RolePermissions implements Serializable{
    private Permissions permission_id;
    private Roles role_id;

    public RolePermissions() {
    }

    public RolePermissions(Roles role_id) {
        this.role_id = role_id;
    }

    public RolePermissions(Permissions permission_id, Roles role_id) {
        this.permission_id = permission_id;
        this.role_id = role_id;
    }

    public Permissions getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Permissions permission_id) {
        this.permission_id = permission_id;
    }

    public Roles getRole_id() {
        return role_id;
    }

    public void setRole_id(Roles role_id) {
        this.role_id = role_id;
    }
 
    
}
