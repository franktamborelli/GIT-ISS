/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.bean;

import br.com.websac.dao.FuncionariosDao;
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
    private FuncionariosDao funciDao = new FuncionariosDao();
    private List<Funcionarios> listfuncionarios;
    
    

      public String envia() {
              funci = funciDao.getFuncionario(funci.getEmail(), funci.getSenha());
              
              //funci = funciDao.getFuncionario(funci.getEmail(), funci.getSenha());
              
              if (funci == null) {
                    funci = new Funcionarios();
                    FacesContext.getCurrentInstance().addMessage(
                               null,
                               new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                           "Erro no Login!"));
                    return null;
              } else {
                    System.out.println(funci.getNome());
                    return "/index";
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

    public FuncionariosDao getFunciDao() {
        return funciDao;
    }

    public void setFunciDao(FuncionariosDao funciDao) {
        this.funciDao = funciDao;
    }
      
      
}
