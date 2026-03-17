/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Permissions;
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
public class PermissionsDao extends DBConnect implements InterfaceDao<Permissions> {
    
     public Permissions getById(Long id) {
        Permissions pc = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from permissions where permission_id=" + id);
            rs.next();
            
            pc = new Permissions(rs.getLong("permission_id"), rs.getString("permission_name"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pc;
    }
    @Override
    public List<Permissions> getList() {
        List<Permissions> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from permissions");
            while (rs.next()) {
                list.add(new Permissions(rs.getLong("permission_id"), rs.getString("permission_name")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void create(Permissions t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into permissions(permission_name) values ('" + t.getPermission_name() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Permissions t) {
        try {
            String query = "UPDATE permissions SET permission_name = ? WHERE permission_id = ?";
            PreparedStatement ps = this.getConnect().prepareStatement(query);
            ps.setString(1, t.getPermission_name());
            ps.setLong(2, t.getPermission_id());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Permissions t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from permissions where permission_id=" + t.getPermission_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
