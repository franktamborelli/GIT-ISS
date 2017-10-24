
package br.com.websac.bean;

import br.com.websac.dao.WebServiceCep;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Matheus Colares
 */
@ManagedBean(name = "mbService")
@RequestScoped
public class ServiceBean implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private String cep = null;
 
    private String tipoLogradouro;
    private String logradouro;
    private String estado;
    private String cidade;
    private String bairro;
 
    public void encontraCEP() {
        
        WebServiceCep cepWebService = WebServiceCep.searchCep(getCep()); 
        
        if (cepWebService.wasSuccessful()) {
            setTipoLogradouro(cepWebService.getLogradouroType());
            setLogradouro(cepWebService.getLogradouro());
            setEstado(cepWebService.getUf());
            setCidade(cepWebService.getCidade());
            setBairro(cepWebService.getBairro());
        } else {
 
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Servidor não está respondendo",
                            "Servidor não está respondendo"));
        }
 
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
 
        
    
}