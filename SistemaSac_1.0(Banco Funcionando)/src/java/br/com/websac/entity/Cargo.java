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
@Table(name="CARGO")
public class Cargo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String descricao;
    private int cadcli;
    private int cadfun;
    private int cadori;
    private int cadrel;
    private int cadsta;
    private int cadfil;
    private int abriocorr;
    private int gerarrelatorio;

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

    public boolean getCadcli() {
        
        boolean b = (cadcli != 0);
        return b;
    }

    public void setCadcli(int cadcli) {
        this.cadcli = cadcli;
    }

    public boolean getCadfun() {
        
        boolean b = (cadfun != 0);
        return b;
    }

    public void setCadfun(int cadfun) {
        this.cadfun = cadfun;
    }

    public boolean getCadori() {
        
         boolean b = (cadori != 0);
         return b;
    }

    public void setCadori(int cadori) {
        this.cadori = cadori;
    }

    public boolean getCadrel() {
        
        boolean b = (cadrel != 0);
        return b;
    }

    public void setCadrel(int cadrel) {
        this.cadrel = cadrel;
    }

    public boolean getCadsta() {
        
        boolean b = (cadsta != 0);
        return b;
    }

    public void setCadsta(int cadsta) {
        this.cadsta = cadsta;
    }

    public boolean getCadfil() {
        
        boolean b = (cadfil != 0);
        return b;
    }

    public void setCadfil(int cadfil) {
        this.cadfil = cadfil;
    }

    public boolean getAbriocorr() {
        
        boolean b = (abriocorr != 0);
        return b;
    }

    public void setAbriocorr(int abriocorr) {
        this.abriocorr = abriocorr;
    }

    public boolean getGerarrelatorio() {
        
        boolean b = (gerarrelatorio != 0);
        return b;
    }

    public void setGerarrelatorio(int gerarrelatorio) {
        this.gerarrelatorio = gerarrelatorio;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Cargo other = (Cargo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


   
    
    
    
    
    
   
}
