/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Permissions;
import entity.RolePermissions;
import entity.Roles;
import util.DBConnect;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * 
 */

public class RolePermissionsDao extends DBConnect implements InterfaceDao<RolePermissions> {

    private PermissionsDao pcd; 
    private RolesDao sd;

    @Override
    public void create(RolePermissions t) {
       try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into rolepermissions(role_id,permission_id) values ('" 
                    + t.getRole_id().getRole_id()
                    + "','" + t.getPermission_id().getPermission_id()
                    +  "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(RolePermissions t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(RolePermissions t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RolePermissions> getList() {
        List<RolePermissions> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from rolepermissions");
            while (rs.next()) {
                Permissions p = this.getPcd().getById(rs.getLong("permission_id"));
                Roles s = this.getSd().getById(rs.getLong("role_id"));
                list.add(new RolePermissions(p, s));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public PermissionsDao getPcd() {
        if (pcd == null) {
            this.pcd = new PermissionsDao();
        }
        return pcd;
    }

    public void setPcd(PermissionsDao pcd) {
        this.pcd = pcd;
    }

    public RolesDao getSd() {
        if (sd == null) {
            this.sd = new RolesDao();
        }
        return sd;
    }

    public void setSd(RolesDao sd) {
        this.sd = sd;
    }

}
