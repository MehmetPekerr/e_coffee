/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Addresses;
import java.util.List;
import util.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * 
 */
public class AddressesDao extends DBConnect implements InterfaceDao<Addresses> {

    
    
      public Addresses getById(Long id) {
        Addresses pc = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from addresses where address_id=" + id);
            rs.next();
            
            pc = new Addresses(rs.getLong("address_id"), rs.getString("address_line1"), rs.getString("address_line2"), rs.getString("city"), rs.getString("state"), rs.getString("postal_code"), rs.getString("country"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pc;
    }
    @Override
    public List<Addresses> getList() {
        List<Addresses> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from addresses");
            while (rs.next()) {
                list.add(new Addresses(rs.getLong("address_id"), rs.getString("address_line1"), rs.getString("address_line2"), rs.getString("city"), rs.getString("state"), rs.getString("postal_code"), rs.getString("country")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
     public List<Addresses> getListttt(int hangiSayfa, int gorunenVeri) {
        List<Addresses> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from addresses  LIMIT " + gorunenVeri + " OFFSET " + (hangiSayfa - 1) * gorunenVeri);
            while (rs.next()) {
                list.add(new Addresses(rs.getLong("address_id"), rs.getString("address_line1"), rs.getString("address_line2"), rs.getString("city"), rs.getString("state"), rs.getString("postal_code"), rs.getString("country")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void create(Addresses t) {
        try {
            String query = "INSERT INTO addresses (address_line1, address_line2, city, state, postal_code, country) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.getConnect().prepareStatement(query);
            ps.setString(1, t.getAddress_line1());
            ps.setString(2, t.getAddress_line2());
            ps.setString(3, t.getCity());
            ps.setString(4, t.getState());
            ps.setString(5, t.getPostal_code());
            ps.setString(6, t.getCountry());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error while creating address: " + e.getMessage());
        }
    }

    @Override
    public void update(Addresses t) {
        try {
            String query = "UPDATE addresses SET address_line1=?, address_line2=?, city=?, state=?, postal_code=?, country=? WHERE address_id=?";
            PreparedStatement ps = this.getConnect().prepareStatement(query);
            ps.setString(1, t.getAddress_line1());
            ps.setString(2, t.getAddress_line2());
            ps.setString(3, t.getCity());
            ps.setString(4, t.getState());
            ps.setString(5, t.getPostal_code());
            ps.setString(6, t.getCountry());
            ps.setLong(7, t.getAddress_id());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error while updating address: " + e.getMessage());
        }
    }

    @Override
    public void delete(Addresses t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from addresses where address_id=" + t.getAddress_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
