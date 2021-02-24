package br.com.vaptzupt.vacinacao.models;

import com.sun.istack.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal idCliente;

    @NotNull
    private String email;

    @NotNull
    private String cpf;

    @NotNull
    private Date datNascimento;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
    private List<Aplicacao> aplicacoes;

    // === CONSTRUTORES ===
    public Cliente() {
    }

    public Cliente(String email, String cpf, Date datNascimento) {
        this.email = email;
        this.cpf = cpf;
        this.datNascimento = datNascimento;
    }

    public Cliente(BigDecimal idCliente, String email, String cpf, Date datNascimento) {
        this.idCliente = idCliente;
        this.email = email;
        this.cpf = cpf;
        this.datNascimento = datNascimento;
    }

    public Cliente(BigDecimal idCliente, String email, String cpf, Date datNascimento, List<Aplicacao> aplicacoes) {
        this.idCliente = idCliente;
        this.email = email;
        this.cpf = cpf;
        this.datNascimento = datNascimento;
        this.aplicacoes = aplicacoes;
    }

    // === GETTERS E SETTERS ===
    public BigDecimal getIdCliente() {
        return idCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(Date datNascimento) {
        this.datNascimento = datNascimento;
    }

    public List<Aplicacao> getAplicacoes() {
        return aplicacoes;
    }

    // === EQUALS E HASHCODE ===
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return idCliente.equals(cliente.idCliente) && Objects.equals(email, cliente.email)
            && Objects.equals(cpf, cliente.cpf) && Objects
            .equals(datNascimento, cliente.datNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, email, cpf, datNascimento);
    }
}
