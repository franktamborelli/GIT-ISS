/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.bean;

import br.com.websac.dao.ClientesDao;
import br.com.websac.dao.TipoOcorrenciaDao;
import br.com.websac.entity.Clientes;
import br.com.websac.entity.TipoOcorrencia;
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
@Named(value = "tpcBean")
@SessionScoped
public class TipoOcorrenciaBean implements Serializable{
    
    private String message;
    private TipoOcorrencia tpc = new TipoOcorrencia();
    private TipoOcorrenciaDao tpcdao = new TipoOcorrenciaDao();
    private List<TipoOcorrencia> listtpc;
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public String adicionarTipoOcorrencia(){
        
        tpcdao.addTipoOcorrencia(tpc);
        tpc.setDescricao(null);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro criado com sucesso"));
        return "cadastrarTipoOcorrencia";
    }

    public TipoOcorrencia getTpc() {
        return tpc;
    }

    public void setTpc(TipoOcorrencia tpc) {
        this.tpc = tpc;
    }

    public TipoOcorrenciaDao getTpcdao() {
        return tpcdao;
    }

    public void setTpcdao(TipoOcorrenciaDao tpcdao) {
        this.tpcdao = tpcdao;
    }

    public List<TipoOcorrencia> getListtpc() {
        return listtpc;
    }

    public void setListtpc(List<TipoOcorrencia> listtpc) {
        this.listtpc = listtpc;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.tpc);
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
        final TipoOcorrenciaBean other = (TipoOcorrenciaBean) obj;
        if (!Objects.equals(this.tpc, other.tpc)) {
            return false;
        }
        return true;
    }
    
    
    
}
