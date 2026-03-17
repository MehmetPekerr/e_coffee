/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.RolesDao;
import entity.Roles;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * 
 */
@FacesConverter ("rolesConverter")
public class RolesConverter implements Converter{
        private RolesDao pcdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.valueOf(string);
        return this.getPcdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
       Roles pc = (Roles) t;
       return String.valueOf(pc.getRole_id());
    }
    public RolesDao getPcdao() {
        if(this.pcdao== null){
            this.pcdao = new RolesDao();
        }
        return pcdao;
    }

    public void setPcdao(RolesDao pcdao) {
        this.pcdao = pcdao;
    }
}


