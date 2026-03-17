/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SuppliersDao;
import entity.Suppliers;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * 
 */
@FacesConverter("suppliersConverter")
public class SuppliersConverter implements Converter{
    private SuppliersDao sdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       Long id = Long.valueOf(string);
        return this.getSdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Suppliers s = (Suppliers) t;
       return String.valueOf(s.getSupplier_id());
    }

    public SuppliersDao getSdao() {
         if(this.sdao== null){
            this.sdao = new SuppliersDao();
        }
        return sdao;
    }

    public void setSdao(SuppliersDao sdao) {
        this.sdao = sdao;
    }
    
}
