/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package util;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;

/**
 *
 * 
 */
@Named(value = "navigationBean")
@RequestScoped
public class NavigationBean implements Serializable{

    /**
     * Creates a new instance of NavigationBean
     */
    public NavigationBean() {
    }
    public String page(String p){
        return "/module/"+p+"?faces-redirect=true" ;
    }
}
