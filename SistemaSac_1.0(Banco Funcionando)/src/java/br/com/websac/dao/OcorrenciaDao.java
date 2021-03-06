package br.com.websac.dao;

import br.com.websac.bean.LoginFunBean;
import br.com.websac.entity.Clientes;
import br.com.websac.entity.Filial;
import br.com.websac.entity.Funcionarios;
import br.com.websac.entity.Ocorrencia;
import br.com.websac.entity.Origem;
import br.com.websac.entity.Relevancia;
import br.com.websac.entity.Status;
import br.com.websac.entity.TipoOcorrencia;
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
    private List<Status> liststatuseditar;
    private List<Status> liststatustotal;
    private List<Relevancia> listrelevancia;
    private List<TipoOcorrencia> listtpocorrencia;
    private List<Ocorrencia> listocorrenciaclientelogado;
    private TipoOcorrencia tpocorrenciaprocura;
    private List<Ocorrencia> listtpocorrenciaprocura;

    public List<Ocorrencia> getList() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Ocorrencia.class);
        this.list = cri.list();
                
        return list;
    }
    
    public List<Ocorrencia> listPorCliente() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Ocorrencia.class);
        cri.add(Restrictions.eq("id_cliente.id", LoginFunBean.getIdClienteLogado()));
       // cri.add(Restrictions.eq("id_status.id", 3));
        
        this.listocorrenciaclientelogado = cri.list();
        
        return listocorrenciaclientelogado;
    }

    public List<Ocorrencia> procurarOcorrenciaTipo(TipoOcorrencia tp) {
        
        tpocorrenciaprocura = tp;
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Ocorrencia.class);
        cri.add(Restrictions.eq("id_tipo.id", tpocorrenciaprocura.getId()));
       // cri.add(Restrictions.eq("id_status.id", 3));
        
        this.listtpocorrenciaprocura = cri.list();
        
        return listtpocorrenciaprocura;
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
        cri.add(Restrictions.eq("descricao", "Aberto"));
        this.liststatus = cri.list();
                
        return liststatus;
    }
    
     public List<Status> getListStatusEditar() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Status.class);
        cri.add(Restrictions.ne("descricao", "Aberto"));
        this.liststatuseditar = cri.list();
                
        return liststatuseditar;
    }
    
     public List<Status> getListStatusTotal() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Status.class);
        this.liststatustotal = cri.list();
                
        return liststatustotal;
    }
     
    public List<Relevancia> getListRelevancia() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Relevancia.class);
        this.listrelevancia = cri.list();
                
        return listrelevancia;
    }
     
    public List<TipoOcorrencia> getListTpOcorrencia() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(TipoOcorrencia.class);
        this.listtpocorrencia = cri.list();
                
        return listtpocorrencia;
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
            oc.setId_tipo(o.getId_tipo());
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
            
            sessao.delete(o);
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
