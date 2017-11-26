package br.com.websac.dao;

import br.com.websac.entity.Clientes;
import br.com.websac.entity.Filial;
import br.com.websac.entity.Funcionarios;
import br.com.websac.entity.Ocorrencia;
import br.com.websac.entity.Origem;
import br.com.websac.entity.Relevancia;
import br.com.websac.entity.Status;
import br.com.websac.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class OcorrenciaDao {
    
    private Session sessao;
    private Transaction trans;
    private List<Ocorrencia> list;
    private List<Clientes> listclientes;
    private List<Funcionarios> listfuncionarios;
    private List<Origem> listorigem;
    private List<Filial> listfilial;
    private List<Status> liststatus;
    private List<Relevancia> listrelevancia;

    public List<Ocorrencia> getList() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Ocorrencia.class);
        this.list = cri.list();
                
        return list;
    }
    
    public List<Clientes> getListClientes() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        
        Criteria cri = sessao.createCriteria(Clientes.class);
        cri.add(Restrictions.eq("status", "Ativo"));
        this.listclientes = cri.list();
        
        return listclientes;
    }

    public List<Funcionarios> getListFuncionarios() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Funcionarios.class);
        this.listfuncionarios = cri.list();
                
        return listfuncionarios;
    }
 
        public List<Origem> getListOrigem() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Origem.class);
        this.listorigem = cri.list();
                
        return listorigem;
    }
  
        public List<Filial> getListFilial() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Filial.class);
        this.listfilial = cri.list();
                
        return listfilial;
    }
  
        public List<Status> getListStatus() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Status.class);
        cri.add(Restrictions.eq("descricao", "Aberta"));
        this.liststatus = cri.list();
                
        return liststatus;
    }

    public List<Relevancia> getListRelevancia() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Relevancia.class);
        this.listrelevancia = cri.list();
                
        return listrelevancia;
    }
                               
    public void addOcorrencia(Ocorrencia o){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            Ocorrencia oc = new Ocorrencia();
            
            oc.setId_cliente(o.getId_cliente());
            oc.setId_filial(o.getId_filial());
            oc.setId_funcionario(o.getId_funcionario());
            oc.setData(o.getData());
            oc.setId_origem(o.getId_origem());
            oc.setId_relevancia(o.getId_relevancia());
            oc.setId_status(o.getId_status());
            oc.setDescricao(o.getDescricao());
            oc.setResposta(o.getResposta());
            
            sessao.save(oc);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
    public void removerOcorrencia(Ocorrencia o){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            sessao.update(o);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
     public void atualizarOcorrencia(Ocorrencia o){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            sessao.update(o);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
}
