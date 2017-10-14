package br.com.websac.bean;

import br.com.websac.dao.ClientesDao;
import br.com.websac.entity.Clientes;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import static org.primefaces.component.contextmenu.ContextMenu.PropertyKeys.event;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

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
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro criado com sucesso"));
        return "cadastrarCliente";
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
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro removido com sucesso"));       
        return "cadastroCliente";
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
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage ("Sucesso", "Cadastro atualizado com sucesso"));
        return "cadastrarCliente";
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
