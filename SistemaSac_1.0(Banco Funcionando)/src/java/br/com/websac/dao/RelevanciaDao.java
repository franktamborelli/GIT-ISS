/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.dao;


import br.com.websac.entity.Relevancia;
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
public class RelevanciaDao {
    private Session sessao;
    private Transaction trans;
    private List<Relevancia> list;

    public List<Relevancia> getList() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Relevancia.class);
        this.list = cri.list();
                
        return list;
    }
    
    public void addRelevancia(Relevancia r){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            Relevancia relevancia = new Relevancia();
            relevancia.setGrau(r.getGrau());
            
            sessao.save(relevancia);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
}
