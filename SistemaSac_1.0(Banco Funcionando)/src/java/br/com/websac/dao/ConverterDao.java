/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.dao;

import br.com.websac.entity.Clientes;
import br.com.websac.entity.Filial;
import br.com.websac.entity.Funcionarios;
import br.com.websac.entity.Origem;
import br.com.websac.entity.Relevancia;
import br.com.websac.entity.Status;
import br.com.websac.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Frank
 */
public class ConverterDao {
    
    private Session sessao;
    private Transaction trans;
    private List<Clientes> list;
    private List<Filial> listFilial;
    private List<Funcionarios> listFuncionario;
    private List<Relevancia> listRelevancia;
    private List<Origem> listOrigem;
    private List<Status> listStatus;
    
    public Clientes buscaNomeCliente(String name){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria buscaCliente = sessao.createCriteria(Clientes.class);
        buscaCliente.add(Restrictions.eq("nome", name));
        
        this.list = buscaCliente.list();
        
        
        return list.get(0);
    }
    
    public Filial buscaNomeFilial(String name){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria buscaFilial = sessao.createCriteria(Filial.class);
        buscaFilial.add(Restrictions.eq("descricao", name));
        
        this.listFilial = buscaFilial.list();
        
        return listFilial.get(0);
    }
    
    public Funcionarios buscaNomeFuncionario(String name){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria buscaFuncionario = sessao.createCriteria(Funcionarios.class);
        buscaFuncionario.add(Restrictions.eq("nome", name));
        
        this.listFuncionario = buscaFuncionario.list();
        
        return listFuncionario.get(0);
    }
    
    public Origem buscaNomeOrigem(String name){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria buscaOrigem = sessao.createCriteria(Origem.class);
        buscaOrigem.add(Restrictions.eq("descricao", name));
        
        this.listOrigem = buscaOrigem.list();
        
        return listOrigem.get(0);
    }
    
    public Relevancia buscaRelevancia(String name){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria buscaRelevancia = sessao.createCriteria(Relevancia.class);
        buscaRelevancia.add(Restrictions.eq("grau", name));
        
        this.listRelevancia = buscaRelevancia.list();
        
        return listRelevancia.get(0);
    }
    
    public Status buscaStatus(String name){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria buscaStatus = sessao.createCriteria(Status.class);
        buscaStatus.add(Restrictions.eq("descricao", name));
        
        this.listStatus = buscaStatus.list();
        
        return listStatus.get(0);
    }
}
