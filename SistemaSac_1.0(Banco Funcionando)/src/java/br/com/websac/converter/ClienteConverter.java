/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.converter;

import br.com.websac.dao.ClientesDao;
import br.com.websac.dao.ConverterDao;
import br.com.websac.entity.Clientes;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Frank
 */
@FacesConverter(value = "clienteConverter", forClass=Clientes.class)
public class ClienteConverter implements Converter{

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
           return null;
       }
       return null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null){
            return null;
        }
        String nomeCli = String.valueOf(value);
        return new ConverterDao().buscaNomeCliente(nomeCli);
    }

   
}

