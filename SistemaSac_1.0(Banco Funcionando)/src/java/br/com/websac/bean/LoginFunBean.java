/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.bean;

import br.com.websac.dao.ClientesDao;
import br.com.websac.dao.FuncionariosDao;
import br.com.websac.entity.Clientes;
import br.com.websac.entity.Funcionarios;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Frank
 */
@Named(value = "LoginBean")
@SessionScoped
public class LoginFunBean implements Serializable {

    private Funcionarios funci = new Funcionarios();
    private Clientes client = new Clientes();
    private ClientesDao clientDao = new ClientesDao();
    private FuncionariosDao funciDao = new FuncionariosDao();
    private List<Funcionarios> listfuncionarios;

    private String email;
    private String senha;
    static Integer idClienteLogado;

    public String envia() {
        try {
            funci = funciDao.getFuncionario(email, senha);
            System.out.println(funci.getNome());
            return "/index";
            //funci = funciDao.getFuncionario(funci.getEmail(), funci.getSenha());

        } catch (NullPointerException e) {
        }
        try {
            client = clientDao.getCliente(email, senha);
            System.out.println(client.getNome());
            idClienteLogado = client.getId();
            return "/telaCliente";

        } catch (NullPointerException error) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        }

    }

    public String voltar() {
        
        return "/telaLogin";
    }

    public Funcionarios getFunci() {
        return funci;
    }

    public void setFunci(Funcionarios funci) {
        this.funci = funci;
    }

    public Clientes getClient() {
        return client;
    }

    public void setClient(Clientes client) {
        this.client = client;
    }

    public FuncionariosDao getFunciDao() {
        return funciDao;
    }

    public void setFunciDao(FuncionariosDao funciDao) {
        this.funciDao = funciDao;
    }

    public ClientesDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientesDao clientDao) {
        this.clientDao = clientDao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static Integer getIdClienteLogado() {
        return idClienteLogado;
    }

    public static void setIdClienteLogado(Integer idClienteLogado) {
        LoginFunBean.idClienteLogado = idClienteLogado;
    }

    
}
