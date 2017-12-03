/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.dao;

import br.com.websac.entity.TipoOcorrencia;
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
public class TipoOcorrenciaDao {
    private Session sessao;
    private Transaction trans;
    private List<TipoOcorrencia> list;

    public List<TipoOcorrencia> getList() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(TipoOcorrencia.class);
        this.list = cri.list();
                
        return list;
    }
    
    public void addTipoOcorrencia(TipoOcorrencia o){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            TipoOcorrencia tpc = new TipoOcorrencia();
            tpc.setDescricao(o.getDescricao());
            
            sessao.save(tpc);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
}
