/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.UserDao;
import entity.Users;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * 
 */
@FacesConverter("userConverter")
public class UserConverter implements Converter {

    private UserDao sdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.valueOf(string);
        return this.getSdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Users s = (Users) t;
        return String.valueOf(s.getUser_id());
    }

    private UserDao getSdao() {
        if (this.sdao == null) {
            this.sdao = new UserDao();
        }
        return sdao;
    }

    public void setSdao(UserDao sdao) {
        this.sdao = sdao;
    }

}
