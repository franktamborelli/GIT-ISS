/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.bean;

import br.com.websac.dao.ClientesDao;
import br.com.websac.dao.StatusDao;
import br.com.websac.entity.Clientes;
import br.com.websac.entity.Status;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Matheus
 */
@Named(value = "statusBean")
@SessionScoped
public class StatusBean implements Serializable{
    
    private String message;
    private Status status = new Status();
    private StatusDao statusdao = new StatusDao();
    private List<Status> liststatus;
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public String adicionarStatus(){
        
        statusdao.addStatus(status);
        status.setDescricao(null);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro criado com sucesso"));
        return "cadastrarStatus";
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StatusDao getStatusdao() {
        return statusdao;
    }

    public void setStatusdao(StatusDao statusdao) {
        this.statusdao = statusdao;
    }

    public List<Status> getListstatus() {
        return liststatus;
    }

    public void setListstatus(List<Status> liststatus) {
        this.liststatus = liststatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StatusBean other = (StatusBean) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }
    
    
    
}
