/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.PermissionsDao;
import entity.Permissions;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * 
 */
@FacesConverter ("permissionConverter")
public class PermissionsConverter implements Converter{
        private PermissionsDao pcdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.valueOf(string);
        return this.getPcdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
       Permissions pc = (Permissions) t;
       return String.valueOf(pc.getPermission_id());
    }
    public PermissionsDao getPcdao() {
        if(this.pcdao== null){
            this.pcdao = new PermissionsDao();
        }
        return pcdao;
    }

    public void setPcdao(PermissionsDao pcdao) {
        this.pcdao = pcdao;
    }
}
