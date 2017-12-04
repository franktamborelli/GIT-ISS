package br.com.websac.dao;

import br.com.websac.entity.Filial;
import br.com.websac.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Matheus
 */
public class FilialDao {
    
    private Session sessao;
    private Transaction trans;
    private List<Filial> list;

    public List<Filial> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Filial.class);
        this.list = cri.list();
                
        return list;
    }
    
    public void addFilial(Filial f){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Filial fil = new Filial();
            fil.setDescricao(f.getDescricao());
            fil.setTelefone(f.getTelefone());
                        
            sessao.save(fil);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houe conexão com o HibernateUtil");
              
        } 
    }
    public void removerFilial(Filial f){
        
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
    
     public void atualizarFilial(Filial f){
        
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
