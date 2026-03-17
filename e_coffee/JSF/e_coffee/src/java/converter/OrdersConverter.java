/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.OrdersDao;
import entity.Orders;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Gokce
 */
@FacesConverter("ordersConverter")
public class OrdersConverter implements Converter {

    private OrdersDao sdao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.valueOf(string);
        return this.getSdao().getById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Orders s = (Orders) t;
        return String.valueOf(s.getOrder_id());
    }

    private OrdersDao getSdao() {
        if (this.sdao == null) {
            this.sdao = new OrdersDao();
        }
        return sdao;
    }

    public void setSdao(OrdersDao sdao) {
        this.sdao = sdao;
    }

}
