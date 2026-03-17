/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ProductCategories;
import entity.Products;
import entity.Suppliers;
import java.util.List;
import util.DBConnect;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * 
 */
public class ProductDao extends DBConnect implements InterfaceDao<Products> {

   private ProductCategoriesDAO pcd;
   private SuppliersDao sd;
   
 public Products getById(Long id) {
        Products pc = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from products where product_id=" + id);
            rs.next();
              while (rs.next()) {
                ProductCategories p = this.getPcd().getById(rs.getLong("category_id"));
                Suppliers s         = this.getSd().getById(rs.getLong("supplier_id"));
                pc= new Products(rs.getLong("product_id"),
                        rs.getString("product_name"),
                        p,
                        s,
                        rs.getInt("price"),
                        rs.getInt("stock_quantity"),
                        rs.getString("description"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pc;
    }
   
   
   
    @Override
    public List<Products> getList() {
        List<Products> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from products");
            while (rs.next()) {
                ProductCategories p = this.getPcd().getById(rs.getLong("category_id"));
                Suppliers s         = this.getSd().getById(rs.getLong("supplier_id"));
                list.add(new Products(rs.getLong("product_id"),
                        rs.getString("product_name"),
                        p,
                        s,
                        rs.getInt("price"),
                        rs.getInt("stock_quantity"),
                        rs.getString("description")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void create(Products t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into products(product_name,category_id,supplier_id,price,stock_quantity,description) values ('" + t.getProduct_name() + "','"
                    + t.getCategory_id().getCategory_id()
                    + "','" + t.getSupplier_id().getSupplier_id()
                    + "','" + t.getPrice()
                    + "','" + t.getStock_quantity()
                    + "','" + t.getDescription() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Products t) {
        try {
            Statement st = this.getConnect().createStatement();
            String query = "UPDATE products SET product_name = '" + t.getProduct_name()
                    + "', category_id = '" + t.getCategory_id().getCategory_id()
                    + "', supplier_id = '" + t.getSupplier_id().getSupplier_id()
                    + "', price = '" + t.getPrice()
                    + "', stock_quantity = '" + t.getStock_quantity()
                    + "', description = '" + t.getDescription()
                    + "' WHERE product_id = " + t.getProduct_id(); // Assuming product_id is the primary key
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Products t) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from products where product_id=" + t.getProduct_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ProductCategoriesDAO getPcd() {
        if(this.pcd==null){
            this.pcd = new ProductCategoriesDAO() ;
        }
        return pcd;
    }

    public void setPcd(ProductCategoriesDAO pcd) {
        this.pcd = pcd;
    }

    public SuppliersDao getSd() {
         if(this.sd==null){
            this.sd = new SuppliersDao() ;
        }
        return sd;
    }

    public void setSd(SuppliersDao sd) {
        this.sd = sd;
    }

}
