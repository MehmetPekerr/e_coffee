/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 *
 */
public class Products implements Serializable{

    private Long product_id;
    private String product_name;
    private ProductCategories category_id;
    private Suppliers supplier_id;
    private int price;
    private int stock_quantity;
    private String description;

    public Products() {
    }

    public Products(String product_name, ProductCategories category_id, Suppliers supplier_id, int price, int stock_quantity, String description) {
        this.product_name = product_name;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.description = description;
    }

    public Products(Long product_id, String product_name, ProductCategories category_id, Suppliers supplier_id, int price, int stock_quantity, String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.description = description;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public ProductCategories getCategory_id() {
        return category_id;
    }

    public void setCategory_id(ProductCategories category_id) {
        this.category_id = category_id;
    }

    public Suppliers getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Suppliers supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.product_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Products other = (Products) obj;
        return Objects.equals(this.product_id, other.product_id);
    }
    
    

}
