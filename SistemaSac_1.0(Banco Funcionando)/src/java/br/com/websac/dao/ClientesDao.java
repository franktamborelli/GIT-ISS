package br.com.websac.dao;

import br.com.websac.entity.Clientes;
import br.com.websac.entity.Funcionarios;
import br.com.websac.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Matheus Colares
 */
public class ClientesDao {
    
    private Session sessao;
    private Transaction trans;
    private List<Clientes> list;

    public List<Clientes> getList() {
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Clientes.class);
        this.list = cri.list();
                
        return list;
    }
    
    public void addCliente(Clientes c){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            Clientes cli = new Clientes();
            cli.setNome(c.getNome());
            cli.setNumero(c.getNumero());
            cli.setEndereco(c.getEndereco());
            cli.setComplemento(c.getComplemento());
            cli.setUf(c.getUf());
            cli.setCidade(c.getCidade());
            cli.setBairro(c.getBairro());
            cli.setCep(c.getCep());
            cli.setTelefone(c.getTelefone());
            cli.setEmail(c.getEmail());
            cli.setCelular(c.getCelular());
            cli.setDatancto(c.getDatancto());
            cli.setCpf(c.getCpf());
            cli.setStatus("Ativo");
            
           
            
            sessao.save(cli);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
    
    
    public void removerCliente(Clientes c){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            c.setStatus("Inativo");
            sessao.update(c);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
     public void atualizarCliente(Clientes c){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            sessao.update(c);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houve conexão com o HibernateUtil");
              
        } 
    }
    
}
