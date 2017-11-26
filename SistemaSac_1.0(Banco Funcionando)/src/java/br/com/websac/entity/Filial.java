package br.com.websac.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Matheus Colares
 */
@Entity
@Table(name="FILIAL")
public class Filial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String descricao;
    //private String endereco;
    //private String cidade;
    //private String uf;
    private String telefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

  //  public String getEndereco() {
//        return endereco;
   // }

  // public void setEndereco(String endereco) {
     //   this.endereco = endereco;
   // }

  //  public String getCidade() {
    //    return cidade;
   // }

  //  public void setCidade(String cidade) {
  //      this.cidade = cidade;
  //  }

   // public String getUf() {
   //     return uf;
   // }

   // public void setUf(String uf) {
    //    this.uf = uf;
    //}

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filial other = (Filial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
   
}
