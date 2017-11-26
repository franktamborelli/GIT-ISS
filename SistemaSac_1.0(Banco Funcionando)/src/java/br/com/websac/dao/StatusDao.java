/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.dao;

import br.com.websac.entity.Status;
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
public class StatusDao {
    private Session sessao;
    private Transaction trans;
    private List<Status> list;

    public List<Status> getList() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Status.class);
        this.list = cri.list();
                
        return list;
    }
    
    public void addStatus(Status o){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            Status status = new Status();
            status.setDescricao(o.getDescricao());
            
            sessao.save(status);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
}
