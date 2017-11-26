package br.com.websac.bean;

import br.com.websac.dao.FilialDao;
import br.com.websac.entity.Filial;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Matheus
 */
@Named(value = "filialBean")
@SessionScoped
public class FilialBean implements Serializable {

    private Filial filial = new Filial();
    private FilialDao filialdao = new FilialDao();
    private List<Filial> listfilial;
     
    
  
    public String adicionarFilial(){
        
        filialdao.addFilial(filial);
        filial.setDescricao(null);
        filial.setTelefone(null);
        
        
       FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "filial adicionado com sucesso"));
        return "tabelaFilial";
    }
    
    public String removerFilial(Filial f){
        this.filial = f;
        filialdao.removerFilial(this.filial);
        filial.setDescricao(null);
        filial.setTelefone(null);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "filial removido com sucesso"));       
        return "tabelaFilial";
    }
    
    public List listarFilial(){
        listfilial = filialdao.getList();
        return this.listfilial;
    }
        
    public String carregarFilial(Filial f){
        filial = f;
        return"editarFilial";
    
    }
    
    public String atualizarFilial(){
        filialdao.atualizarFilial(filial);
        filial.setDescricao(null);
        filial.setTelefone(null);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "filial atualizado com sucesso"));
        return "tabelaFilial";
        
    }
        
    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial Filial) {
        this.filial = Filial;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.filial);
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
        final FilialBean other = (FilialBean) obj;
        if (!Objects.equals(this.filial, other.filial)) {
            return false;
        }
        return true;
    }
    
    
}
