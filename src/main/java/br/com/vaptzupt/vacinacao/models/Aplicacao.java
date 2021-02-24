package br.com.vaptzupt.vacinacao.models;

import com.sun.istack.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APLICACOES")
public class Aplicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal idAplicacao;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @NotNull
    private String nomVacina;

    @NotNull
    private Date datAplicacao;

    // === CONSTRUTORES ===
    public Aplicacao() {
    }

    public Aplicacao(Cliente cliente, String nomVacina, Date datAplicacao) {
        this.cliente = cliente;
        this.nomVacina = nomVacina;
        this.datAplicacao = datAplicacao;
    }

    public Aplicacao(BigDecimal idAplicacao, Cliente cliente, String nomVacina,
        Date datAplicacao) {
        this.idAplicacao = idAplicacao;
        this.cliente = cliente;
        this.nomVacina = nomVacina;
        this.datAplicacao = datAplicacao;
    }

    // === GETTERS & SETTERS ===
    public BigDecimal getIdAplicacao() {
        return idAplicacao;
    }

    public void setNomVacina(String nomVacina) {
        this.nomVacina = nomVacina;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNomVacina() {
        return nomVacina;
    }

    public Date getDatAplicacao() {
        return datAplicacao;
    }

    public void setDatAplicacao(Date datAplicacao) {
        this.datAplicacao = datAplicacao;
    }

    // === EQUALS & HASHCODE ===
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Aplicacao that = (Aplicacao) o;
        return idAplicacao.equals(that.idAplicacao) && Objects.equals(cliente, that.cliente)
            && Objects.equals(nomVacina, that.nomVacina) && Objects
            .equals(datAplicacao, that.datAplicacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAplicacao, cliente, nomVacina, datAplicacao);
    }
}
