package br.com.websac.dao;

import br.com.websac.entity.Cargo;
import br.com.websac.entity.Funcionarios;
import br.com.websac.util.HibernateUtil;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Frank
 */
public class FuncionariosDao {
    
    private Session sessao;
    private Transaction trans;
    private List<Funcionarios> list;
    private List<Cargo> listcargo;

    public List<Funcionarios> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Funcionarios.class);
        this.list = cri.list();
                
        return list;
    }
    
        public List<Cargo> getListCargo() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Cargo.class);
        this.listcargo = cri.list();
                
        return listcargo;
    }
        
    public Funcionarios getFuncionario(String funEmail, String funSenha) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        //Funcionarios funcionario = new Funcionarios();
        try {
        Criteria log = sessao.createCriteria(Funcionarios.class);
        log.add(Restrictions.eq("email", funEmail));
        log.add(Restrictions.eq("senha", funSenha));
        this.list = log.list();
        
        
                
        return list.get(0);
        
    } catch (IndexOutOfBoundsException e) {
                    return null;
              }
        
        
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
