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
public class Suppliers implements Serializable {

    private Long supplier_id;
    private String supplier_name;
    private String contact_name;
    private String email;
    private String phone_number;
    private String address;

    public Suppliers() {
    }

    public Suppliers(String supplier_name, String contact_name, String email, String phone_number, String address) {
        this.supplier_name = supplier_name;
        this.contact_name = contact_name;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
    }

    public Suppliers(Long supplier_id, String supplier_name, String contact_name, String email, String phone_number, String address) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.contact_name = contact_name;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
    }

    public Long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.supplier_id);
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
        final Suppliers other = (Suppliers) obj;
        return Objects.equals(this.supplier_id, other.supplier_id);
    }

}
