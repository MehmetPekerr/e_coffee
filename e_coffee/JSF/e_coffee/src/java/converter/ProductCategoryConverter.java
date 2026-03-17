/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.ProductCategoriesDAO;
import entity.ProductCategories;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * 
 */
@FacesConverter ("categoryConverter")
public class ProductCategoryConverter implements Converter{
    
    private ProductCategoriesDAO pcdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.valueOf(string);
        return this.getPcdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
       ProductCategories pc = (ProductCategories) t;
       return String.valueOf(pc.getCategory_id());
    }

    public ProductCategoriesDAO getPcdao() {
        if(this.pcdao== null){
            this.pcdao = new ProductCategoriesDAO();
        }
        return pcdao;
    }

    public void setPcdao(ProductCategoriesDAO pcdao) {
        this.pcdao = pcdao;
    }
    
}
