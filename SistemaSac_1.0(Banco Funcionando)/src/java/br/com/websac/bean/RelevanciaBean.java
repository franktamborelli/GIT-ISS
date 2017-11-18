
package br.com.websac.bean;

import br.com.websac.dao.OrigemDao;
import br.com.websac.dao.RelevanciaDao;
import br.com.websac.entity.Origem;
import br.com.websac.entity.Relevancia;
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
@Named(value = "relevanciaBean")
@SessionScoped
public class RelevanciaBean implements Serializable{
    private String message;
    private Relevancia reles = new Relevancia();
    private RelevanciaDao relevanciadao = new RelevanciaDao();
    private List<Origem> listrelevancia;
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public String adicionarRelevancia(){
        
        relevanciadao.addRelevancia(reles);
        reles.setGrau(null);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro criado com sucesso"));
        return "cadastrarRelevancia";
    }

    public Relevancia getReles() {
        return reles;
    }

    public void setReles(Relevancia reles) {
        this.reles = reles;
    }

    public RelevanciaDao getRelevanciadao() {
        return relevanciadao;
    }

    public void setRelevanciadao(RelevanciaDao relevanciadao) {
        this.relevanciadao = relevanciadao;
    }

    public List<Origem> getListrelevancia() {
        return listrelevancia;
    }

    public void setListrelevancia(List<Origem> listrelevancia) {
        this.listrelevancia = listrelevancia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.reles);
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
        final RelevanciaBean other = (RelevanciaBean) obj;
        if (!Objects.equals(this.reles, other.reles)) {
            return false;
        }
        return true;
    }

    
    
}
