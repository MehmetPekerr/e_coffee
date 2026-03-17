/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Suppliers;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * 
 */
public class SuppliersDao extends DBConnect implements InterfaceDao<Suppliers> {

    public Suppliers getById(Long id) {
        Suppliers sp = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from suppliers where supplier_id=" + id);
            rs.next();

            sp = new Suppliers(rs.getLong("supplier_id"),
                    rs.getString("supplier_name"),
                    rs.getString("contact_name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("address"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sp;
    }

    @Override
    public List<Suppliers> getList() {
        List<Suppliers> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from suppliers");
            while (rs.next()) {
                list.add(new Suppliers(rs.getLong("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("contact_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void create(Suppliers t) {
        try {
            // PreparedStatement kullanarak SQL enjeksiyonu riskini azaltma
            String query = "INSERT INTO suppliers (supplier_name, contact_name, email, phone_number, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.getConnect().prepareStatement(query);

            // Parametreleri ayarla
            preparedStatement.setString(1, t.getSupplier_name());
            preparedStatement.setString(2, t.getContact_name());
            preparedStatement.setString(3, t.getEmail());
            preparedStatement.setString(4, t.getPhone_number());
            preparedStatement.setString(5, t.getAddress());

            // Sorguyu çalıştır
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    @Override
    public void update(Suppliers t) {
        try {
            // PreparedStatement kullanarak SQL enjeksiyonu riskini azaltma
            String query = "UPDATE suppliers SET supplier_name = ?, contact_name = ?, email = ?, phone_number = ?, address = ? WHERE supplier_id = ?";
            PreparedStatement preparedStatement = this.getConnect().prepareStatement(query);

            // Parametreleri ayarla
            preparedStatement.setString(1, t.getSupplier_name());
            preparedStatement.setString(2, t.getContact_name());
            preparedStatement.setString(3, t.getEmail());
            preparedStatement.setString(4, t.getPhone_number());
            preparedStatement.setString(5, t.getAddress());
            preparedStatement.setLong(6, t.getSupplier_id()); // Varsayalım ki tedarikçiye bir kimlik veritabanında var

            // Sorguyu çalıştır
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }

    @Override
    public void delete(Suppliers t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from suppliers where supplier_id=" + t.getSupplier_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
