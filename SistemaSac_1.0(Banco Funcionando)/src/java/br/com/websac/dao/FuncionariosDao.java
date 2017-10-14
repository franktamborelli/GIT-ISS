package br.com.websac.dao;

import br.com.websac.entity.Funcionarios;
import br.com.websac.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Frank
 */
public class FuncionariosDao {
    
    private Session sessao;
    private Transaction trans;
    private List<Funcionarios> list;

    public List<Funcionarios> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Funcionarios.class);
        this.list = cri.list();
                
        return list;
    }
    
    public void addFuncionarios(Funcionarios f){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Funcionarios fun = new Funcionarios();
            fun.setNome(f.getNome());
            fun.setCargo(f.getCargo());
            fun.setSenha(f.getSenha());
            fun.setEmail(f.getEmail());
            fun.setCelular(f.getCelular());
                        
            sessao.save(fun);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houe conexão com o HibernateUtil");
              
        } 
    }
    public void removerFuncionarios(Funcionarios f){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            sessao.delete(f);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
     public void atualizarFuncionarios(Funcionarios f){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            sessao.update(f);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
}
