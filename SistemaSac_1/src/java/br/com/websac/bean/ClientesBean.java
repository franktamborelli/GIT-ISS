package br.com.websac.bean;

import br.com.websac.dao.ClientesDao;
import br.com.websac.entity.Clientes;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Matheus Colares
 */
@Named(value = "clientesBean")
@SessionScoped
public class ClientesBean implements Serializable {

    private Clientes clientes = new Clientes();
    private ClientesDao clientesdao = new ClientesDao();
     
    public String adicionarCliente(){
        
        clientesdao.addCliente(clientes);
        return "Sucesso";
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
