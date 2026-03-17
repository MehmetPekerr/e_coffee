/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.AddressesDao;
import entity.Addresses;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * 
 */
@FacesConverter("addressesConverter")
public class AddressesConverter implements Converter  {
     private AddressesDao sdao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       Long id = Long.valueOf(string);
        return this.getSdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Addresses s = (Addresses) t;
        return String.valueOf(s.getAddress_id());
    }
        private AddressesDao getSdao() {
        if (this.sdao == null) {
            this.sdao = new AddressesDao();
        }
        return sdao;
    }

    public void setSdao(AddressesDao sdao) {
        this.sdao = sdao;
    }
}
