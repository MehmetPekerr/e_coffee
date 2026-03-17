/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ProductCategories;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * 
 */
public class ProductCategoriesDAO extends DBConnect implements InterfaceDao<ProductCategories> {
     public ProductCategories getById(Long id) {
        ProductCategories pc = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from productcategories where category_id=" + id);
            rs.next();
            
            pc = new ProductCategories(rs.getLong("category_id"), rs.getString("category_name"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pc;
    }

    @Override
    public List<ProductCategories> getList() {
        List<ProductCategories> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from productcategories");
            while (rs.next()) {
                list.add(new ProductCategories(rs.getLong("category_id"), rs.getString("category_name")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void create(ProductCategories t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into productcategories(category_name) values ('" + t.getCategory_name() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(ProductCategories t) {
        try {
            String query = "UPDATE productcategories SET category_name = ? WHERE category_id = ?";
            PreparedStatement ps = this.getConnect().prepareStatement(query);
            ps.setString(1, t.getCategory_name());
            ps.setLong(2, t.getCategory_id());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(ProductCategories t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from productcategories where category_id=" + t.getCategory_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
