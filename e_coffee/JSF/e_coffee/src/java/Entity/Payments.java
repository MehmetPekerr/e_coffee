/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 *
 */
public class Payments implements Serializable{

    private Long payment_id;
    private Orders order_id;
    private int amount;
    private String paymentDate;

    public Payments() {
    }
    

    public Payments(Orders order_id, int amount, String paymentDate) {
        this.order_id = order_id;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payments(Long payment_id, Orders order_id, int amount, String paymentDate) {
        this.payment_id = payment_id;
        this.order_id = order_id;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Orders order_id) {
        this.order_id = order_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.payment_id);
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
        final Payments other = (Payments) obj;
        return Objects.equals(this.payment_id, other.payment_id);
    }
    
    
}
