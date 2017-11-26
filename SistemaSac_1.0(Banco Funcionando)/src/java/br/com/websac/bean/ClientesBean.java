package br.com.websac.bean;

import br.com.websac.dao.ClientesDao;
import br.com.websac.entity.Clientes;
import br.com.websac.dao.WebServiceCep;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author Matheus Colares
 */
@Named(value = "clientesBean")
@SessionScoped
public class ClientesBean implements Serializable {
    
    private String message;
    private Clientes clientes = new Clientes();
    private ClientesDao clientesdao = new ClientesDao();
    private List<Clientes> listclientes;
    private String cep = null;
    private String tipoLogradouro;
    private String logradouro;
    private String estado;
    private String cidade;
    private String bairro;
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public String adicionarCliente(){
        
        clientesdao.addCliente(clientes);
        clientes.setCelular(null);
        clientes.setComplemento(null);
        clientes.setDatancto(null);
        clientes.setEmail(null);
        clientes.setEndereco(null);
        clientes.setNome(null);
        clientes.setNumero(null);
        clientes.setTelefone(null);
        clientes.setBairro(null);
        clientes.setCep(null);
        clientes.setCidade(null);
        clientes.setUf(null);
        clientes.setCpf(null);
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro criado com sucesso"));
        return "tabelaCliente";
    }
    
    public String removerCliente(Clientes c){
        this.clientes = c;
        clientesdao.removerCliente(this.clientes);
        clientes.setCelular(null);
        clientes.setComplemento(null);
        clientes.setDatancto(null);
        clientes.setEmail(null);
        clientes.setEndereco(null);
        clientes.setNome(null);
        clientes.setNumero(null);
        clientes.setTelefone(null);
        clientes.setBairro(null);
        clientes.setCep(null);
        clientes.setCidade(null);
        clientes.setUf(null);
        clientes.setCpf(null);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro removido com sucesso"));       
        return "tabelaCliente";
    }
    
    public List listarClientes(){
        listclientes = clientesdao.getList();
        return this.listclientes;
    }
        
    public String carregarCliente(Clientes c){
        clientes = c;
        
        return"editarCliente";
    
    }
    
    public String atualizarCliente(){
        clientesdao.atualizarCliente(clientes);
        clientes.setCelular(null);
        clientes.setComplemento(null);
        clientes.setDatancto(null);
        clientes.setEmail(null);
        clientes.setEndereco(null);
        clientes.setNome(null);
        clientes.setNumero(null);
        clientes.setTelefone(null);
        clientes.setBairro(null);
        clientes.setCep(null);
        clientes.setCidade(null);
        clientes.setUf(null);
        clientes.setCpf(null);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro atualizado com sucesso"));
        return "tabelaCliente";
    }
    
    public void encontraCEP() {
        
        WebServiceCep cepWebService = WebServiceCep.searchCep(getCep()); 
        
        if (cepWebService.wasSuccessful()) {
            setTipoLogradouro(cepWebService.getLogradouroType());
            setLogradouro(cepWebService.getLogradouro());
            setEstado(cepWebService.getUf());
            setCidade(cepWebService.getCidade());
            setBairro(cepWebService.getBairro());
            
            clientes.setCep(getCep());
            clientes.setCidade(getCidade());
            clientes.setEndereco(getLogradouro());
            clientes.setUf(getEstado());
            clientes.setBairro(getBairro());
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
    
    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.clientes);
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
        final ClientesBean other = (ClientesBean) obj;
        if (!Objects.equals(this.clientes, other.clientes)) {
            return false;
        }
        return true;
    }
    
    
}
