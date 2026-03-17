/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Orders;
import entity.Users;
import util.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class OrdersDao extends DBConnect implements InterfaceDao<Orders> {

    private UserDao pcd;

    public Orders getById(Long id) {

        Orders pc = null;
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from orders where order_id=" + id);
            rs.next();
            while (rs.next()) {
              
                pc = new Orders(rs.getLong("order_id"),
                        rs.getString("order_date"),
                        rs.getString("status"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pc;

    }

    @Override
    public List<Orders> getList() {
        List<Orders> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM orders";
            PreparedStatement ps = this.getConnect().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //  Users p = this.getPcd().getById(rs.getLong("user_id"));
                list.add(new Orders(
                        rs.getLong("order_id"),
                        rs.getString("order_date"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void create(Orders t) {
        try {

            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into orders(order_date,status) values ('"+ t.getOrder_date()
                    + "','" + t.getStatus()
                    + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " sıkıntı burda mı");
        }
    }

    @Override
    public void update(Orders t) {
        try {
            String query = "UPDATE orders SET status=?, order_date=? WHERE order_id=?";
            PreparedStatement ps = this.getConnect().prepareStatement(query);
            ps.setString(1, t.getStatus());
            ps.setString(2, t.getOrder_date());
            
            ps.setLong(4, t.getOrder_id());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Orders t) {
        try {
            String query = "DELETE FROM orders WHERE order_id=?";
            PreparedStatement ps = this.getConnect().prepareStatement(query);
            ps.setLong(1, t.getOrder_id());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public UserDao getPcd() {
        if (this.pcd == null) {
            this.pcd = new UserDao();
        }
        return pcd;
    }

    public void setPcd(UserDao pcd) {
        this.pcd = pcd;
    }

}
