package br.com.websac.dao;

import br.com.websac.entity.Funcionarios;
import br.com.websac.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Matheus Colares
 */
public class FuncionariosDao {
    
    private Session sessao;
    private Transaction trans;
    
    public void addFuncionarios(Funcionarios f){
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Funcionarios cli = new Funcionarios();
            cli.setNome(f.getNome());
            cli.setCargo(f.getCargo());
            cli.setSenha(f.getSenha());
            cli.setEmail(f.getEmail());
            cli.setCelular(f.getCelular());
                        
            sessao.save(cli);
            trans.commit();
        }
          catch (HibernateException e) {
                          
              System.out.println("Não houe conexão com o HibernateUtil");
              
        } 
    }
}
