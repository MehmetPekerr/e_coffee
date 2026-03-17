/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;


import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@FacesConverter ("dateConverter")
public class DateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(value);
        } catch (ParseException e) {
            throw new ConverterException("Geçersiz tarih formatı!", e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format((Date) value);
    }
}
