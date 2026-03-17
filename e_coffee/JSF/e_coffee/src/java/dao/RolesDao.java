/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ProductCategories;
import entity.Roles;
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
public class RolesDao extends DBConnect implements InterfaceDao<Roles> {

    public Roles getById(Long id) {
        Roles pc = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from roles where role_id=" + id);
            rs.next();
            
            pc = new Roles(rs.getLong("role_id"), rs.getString("role_name"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pc;
    }
    @Override
    public List<Roles> getList() {
        List<Roles> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from roles");
            while (rs.next()) {
                list.add(new Roles(rs.getLong("role_id"), rs.getString("role_name")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void create(Roles t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into roles(role_name) values ('" + t.getRole_name() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Roles t) {
        try {
            String query = "UPDATE roles SET role_name = ? WHERE role_id = ?";
            PreparedStatement ps = this.getConnect().prepareStatement(query);
            ps.setString(1, t.getRole_name());
            ps.setLong(2, t.getRole_id());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Roles t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from roles where role_id=" + t.getRole_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
