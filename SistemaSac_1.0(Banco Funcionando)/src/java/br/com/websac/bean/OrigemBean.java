/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.bean;

import br.com.websac.dao.ClientesDao;
import br.com.websac.dao.OrigemDao;
import br.com.websac.entity.Clientes;
import br.com.websac.entity.Origem;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Frank
 */
@Named(value = "origemBean")
@SessionScoped
public class OrigemBean implements Serializable{
    
    private String message;
    private Origem origens = new Origem();
    private OrigemDao origemdao = new OrigemDao();
    private List<Origem> listorigem;
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public String adicionarOrigem(){
        
        origemdao.addOrigem(origens);
        origens.setDescricao(null);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro criado com sucesso"));
        return "cadastrarOrigem";
    }

    public Origem getOrigens() {
        return origens;
    }

    public void setOrigens(Origem origens) {
        this.origens = origens;
    }

    public OrigemDao getOrigemdao() {
        return origemdao;
    }

    public void setOrigemdao(OrigemDao origemdao) {
        this.origemdao = origemdao;
    }

    public List<Origem> getListorigem() {
        return listorigem;
    }

    public void setListorigem(List<Origem> listorigem) {
        this.listorigem = listorigem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.origens);
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
        final OrigemBean other = (OrigemBean) obj;
        if (!Objects.equals(this.origens, other.origens)) {
            return false;
        }
        return true;
    }
    
    
    
}
