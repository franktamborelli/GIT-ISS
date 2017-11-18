/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.dao;

import br.com.websac.entity.Origem;
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
public class OrigemDao {
    private Session sessao;
    private Transaction trans;
    private List<Origem> list;

    public List<Origem> getList() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Origem.class);
        this.list = cri.list();
                
        return list;
    }
    
    public void addOrigem(Origem o){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            Origem origem = new Origem();
            origem.setDescricao(o.getDescricao());
            
            sessao.save(origem);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
}
