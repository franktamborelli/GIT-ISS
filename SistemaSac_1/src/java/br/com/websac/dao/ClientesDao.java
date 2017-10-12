package br.com.websac.dao;

import br.com.websac.entity.Clientes;
import br.com.websac.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Matheus Colares
 */
public class ClientesDao {
    
    private Session sessao;
    private Transaction trans;
    
    public void addCliente(Clientes c){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();
            
            Clientes cli = new Clientes();
            cli.setNome(c.getNome());
            cli.setEndereco(c.getEndereco());
            cli.setNumero(c.getNumero());
            cli.setComplemento(c.getComplemento());
            cli.setTelefone(c.getTelefone());
            cli.setEmail(c.getEmail());
            cli.setCelular(c.getCelular());
            cli.setDatancto(c.getDatancto());
            
            sessao.save(cli);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houe conexão com o HibernateUtil");
              
        } 
    }
}
