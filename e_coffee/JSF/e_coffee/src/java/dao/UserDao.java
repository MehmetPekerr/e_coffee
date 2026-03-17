/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Addresses;
import entity.Roles;
import entity.Users;
import util.DBConnect;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class UserDao extends DBConnect implements InterfaceDao<Users> {

    private AddressesDao pcd;
    private RolesDao sd;
   

    public Users getById(Long id) {
        Users pc = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from users where user_id=" + id);
            rs.next();
            while (rs.next()) {
             
                Roles s = this.getSd().getById(rs.getLong("role_id"));
                Addresses p = this.getPcd().getById(rs.getLong("address_id"));

                pc = new Users(rs.getLong("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        s,
                        p);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pc;
    }

    @Override
    public List<Users> getList() {
        List<Users> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                Roles s = this.getSd().getById(rs.getLong("role_id"));
                Addresses p = this.getPcd().getById(rs.getLong("address_id"));

                list.add(new Users(rs.getLong("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        s,
                        p));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void create(Users t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into users(username,password,role_id,address_id) values ('" + t.getUsername()
                    + "','" + t.getPassword()
                    + "','" + t.getRole_id().getRole_id()
                    + "','" + t.getAddress_id().getAddress_id()
                    + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Users t) {
        try {
            Statement st = this.getConnect().createStatement();
            String query = "UPDATE users SET username = '" + t.getUsername()
                    + "', password = '" + t.getPassword()
                    + "', role_id = '" + t.getRole_id().getRole_id()
                    + "', address_id = '" + t.getAddress_id().getAddress_id()
                    + "' WHERE user_id = " + t.getUser_id(); // Assuming product_id is the primary key
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Users t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from users where user_id=" + t.getUser_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public AddressesDao getPcd() {
        if (this.pcd == null) {
            this.pcd = new AddressesDao();
        }
        return pcd;
    }

    public void setPcd(AddressesDao pcd) {
        this.pcd = pcd;
    }

    public RolesDao getSd() {
        if (this.sd == null) {
            this.sd = new RolesDao();
        }
        return sd;
    }

    public void setSd(RolesDao sd) {
        this.sd = sd;
    }
}
