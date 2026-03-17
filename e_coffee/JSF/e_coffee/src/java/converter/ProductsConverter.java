/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.ProductDao;
import entity.Products;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 *
 */
@FacesConverter("productCoonverter")
public class ProductsConverter implements Converter {

    private ProductDao sdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.valueOf(string);
        return this.getSdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Products s = (Products) t;
        return String.valueOf(s.getProduct_id());
    }

    private ProductDao getSdao() {
        if (this.sdao == null) {
            this.sdao = new ProductDao();
        }
        return sdao;
    }

    public void setSdao(ProductDao sdao) {
        this.sdao = sdao;
    }

}
