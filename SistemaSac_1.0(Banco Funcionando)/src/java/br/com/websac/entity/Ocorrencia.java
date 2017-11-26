package br.com.websac.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Matheus Colares
 */
@Entity
@Table(name="OCORRENCIA")
public class Ocorrencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long protocolo;
   
    @OneToOne
    @JoinColumn(name="status")
    private Status id_status;
    
    private Date data;
    
    @OneToOne
    @JoinColumn(name="filial")
    private Filial id_filial;
    
    @OneToOne
    @JoinColumn(name="origem")
    private Origem id_origem;
    
    @OneToOne
    @JoinColumn(name="cliente")
    private Clientes id_cliente;
    
    @OneToOne
    @JoinColumn(name="responsavel")
    private Funcionarios id_funcionario;
    
    private String descricao;
    
    private String resposta;
    
    @OneToOne
    @JoinColumn(name="relevancia")
    private Relevancia id_relevancia;
    //private String relevancia;

    public Long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
    }

    public Status getId_status() {
        return id_status;
    }

    public void setId_status(Status id_status) {
        this.id_status = id_status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

   

    public Filial getId_filial() {
        return id_filial;
    }

    public void setId_filial(Filial id_filial) {
        this.id_filial = id_filial;
    }

    public Origem getId_origem() {
        return id_origem;
    }

    public void setId_origem(Origem id_origem) {
        this.id_origem = id_origem;
    }

    public Clientes getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Clientes id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Relevancia getId_relevancia() {
        return id_relevancia;
    }

    public void setId_relevancia(Relevancia id_relevancia) {
        this.id_relevancia = id_relevancia;
    }

//    public String getRelevancia() {
//        return relevancia;
//    }

//    public void setRelevancia(String relevancia) {
//        this.relevancia = relevancia;
//    }
    
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public Funcionarios getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Funcionarios id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.protocolo);
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
        final Ocorrencia other = (Ocorrencia) obj;
        if (!Objects.equals(this.protocolo, other.protocolo)) {
            return false;
        }
        return true;
    }
    
        
}
