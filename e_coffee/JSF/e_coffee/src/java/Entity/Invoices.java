/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * 
 */
public class Invoices implements Serializable{
    private Long invoice_id;
    private Orders order_id;
    private int amount;
    private Date invoice_date;

    public Invoices() {
    }

    public Invoices(Orders order_id, int amount, Date invoice_date) {
        this.order_id = order_id;
        this.amount = amount;
        this.invoice_date = invoice_date;
    }

    public Invoices(Long invoice_id, Orders order_id, int amount, Date invoice_date) {
        this.invoice_id = invoice_id;
        this.order_id = order_id;
        this.amount = amount;
        this.invoice_date = invoice_date;
    }

    public Long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Long invoice_id) {
        this.invoice_id = invoice_id;
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

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }
    
    
    
}
