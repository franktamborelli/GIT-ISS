package br.com.websac.bean;

import br.com.websac.dao.FuncionariosDao;
import br.com.websac.entity.Funcionarios;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Frank
 */
@Named(value = "funcionariosBean")
@SessionScoped
public class FuncionariosBean implements Serializable {

    private Funcionarios funcionario = new Funcionarios();
    private FuncionariosDao funcionariodao = new FuncionariosDao();
    private List<Funcionarios> listfuncionario;
     
    public String adicionarFuncionarios(){
        
        funcionariodao.addFuncionarios(funcionario);
        return "index";
    }
    
    public String removerFuncionario(Funcionarios f){
        this.funcionario = f;
        funcionariodao.removerFuncionarios(this.funcionario);
               
        return "cadastroFuncionario";
    }
    
    public List listarFuncionarios(){
        listfuncionario = funcionariodao.getList();
        return this.listfuncionario;
    }
        
    public String carregarFuncionarios(Funcionarios f){
        funcionario = f;
        return"editarFuncionario";
    
    }
    
    public String atualizarFuncionarios(){
        funcionariodao.atualizarFuncionarios(funcionario);
        return "cadastrarFuncionario";
    }
        
    public Funcionarios getFuncionarios() {
        return funcionario;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionario = funcionarios;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.funcionario);
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
        final FuncionariosBean other = (FuncionariosBean) obj;
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }
    
    
}
