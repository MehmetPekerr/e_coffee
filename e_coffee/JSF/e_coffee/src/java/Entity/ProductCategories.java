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
public class ProductCategories implements Serializable {
    private Long category_id;
    private String category_name;

    public ProductCategories() {
    }

    public ProductCategories(String category_name) {
        this.category_name = category_name;
    }

    public ProductCategories(Long category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.category_id);
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
        final ProductCategories other = (ProductCategories) obj;
        return Objects.equals(this.category_id, other.category_id);
    }
    
    
}
