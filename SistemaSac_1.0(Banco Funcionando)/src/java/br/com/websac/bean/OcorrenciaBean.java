package br.com.websac.bean;

import br.com.websac.dao.OcorrenciaDao;
import br.com.websac.entity.Ocorrencia;
import br.com.websac.dao.WebServiceCep;
import br.com.websac.entity.Clientes;
import br.com.websac.entity.Filial;
import br.com.websac.entity.Funcionarios;
import br.com.websac.entity.Origem;
import br.com.websac.entity.Relevancia;
import br.com.websac.entity.Status;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author Matheus Colares
 */
@Named(value = "OcorrenciaBean")
@SessionScoped
public class OcorrenciaBean implements Serializable {
    
    private String message;
    private Clientes cliO = new Clientes();
    private Ocorrencia ocorrencia = new Ocorrencia();
    private OcorrenciaDao ocorrenciadao = new OcorrenciaDao();
    private List<Ocorrencia> listocorrencia;
    private List<Clientes> listclientes;
    private List<Funcionarios> listfuncionarios;
    private List<Origem> listorigem;
    private List<Filial> listfilial;
    private List<Status> liststatus;
    private List<Relevancia> listrelevancia;
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public String adicionarOcorrencia(){
        
        ocorrenciadao.addOcorrencia(ocorrencia);        
        
        //Ocorrencia.setCelular(null);
        //Ocorrencia.setComplemento(null);
        //Ocorrencia.setDatancto(null);
        ocorrencia.setDescricao(null);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro criado com sucesso"));
        return "cadastrarOcorrencia";
    }
    
    public String removerOcorrencia(Ocorrencia o){
        this.ocorrencia = o;
        ocorrenciadao.removerOcorrencia(this.ocorrencia);
        
        //Ocorrencia.setCelular(null);
        //Ocorrencia.setComplemento(null);
        //Ocorrencia.setDatancto(null);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro removido com sucesso"));       
        return "tabelaOcorrencia";
    }
    
    public List listarOcorrencia(){
        listocorrencia = ocorrenciadao.getList();
        return this.listocorrencia;
    }
    
     public List listarClientes(){
        listclientes = ocorrenciadao.getListClientes();
        return this.listclientes;
    }
     
    public List listarFuncionarios(){
        listfuncionarios = ocorrenciadao.getListFuncionarios();
        return this.listfuncionarios;
    }
       
    public List listarOrigem(){
        listorigem = ocorrenciadao.getListOrigem();
        return this.listorigem;
    }
    
    public List listarFilial(){
        listfilial = ocorrenciadao.getListFilial();
        return this.listfilial;
    }
     
    public List listarStatus(){
        liststatus = ocorrenciadao.getListStatus();
        return this.liststatus;
    }
  
    public List listarRelevancia(){
        listrelevancia = ocorrenciadao.getListRelevancia();
        return this.listrelevancia;
    }
     
    public String carregarOcorrencia(Ocorrencia o){
        ocorrencia = o;
        
        return"editarOcorrencia";
    
    }
    
    public String atualizarOcorrecia(){
        ocorrenciadao.atualizarOcorrencia(ocorrencia);
        
        //Ocorrencia.setCelular(null);
        //Ocorrencia.setComplemento(null);
        //Ocorrencia.setDatancto(null);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro atualizado com sucesso"));
        return "tabelaOcorrencia";
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public OcorrenciaDao getOcorrenciadao() {
        return ocorrenciadao;
    }

    public void setOcorrenciadao(OcorrenciaDao ocorrenciadao) {
        this.ocorrenciadao = ocorrenciadao;
    }

    public Clientes getCliO() {
        return cliO;
    }

    public void setCliO(Clientes cliO) {
        this.cliO = cliO;
    }
    
    
   
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.ocorrencia);
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
        final OcorrenciaBean other = (OcorrenciaBean) obj;
        if (!Objects.equals(this.ocorrencia, other.ocorrencia)) {
            return false;
        }
        return true;
    }
    
    
}
