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

@Entity
public class Aplicacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal idAplicacoes;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes cliente;

    @NotNull
    private String nomVacina;


    @NotNull
    private Date datAplicacao;

    // === CONSTRUTORES ===
    public Aplicacoes() {
    }

    public Aplicacoes(Clientes cliente, String nomVacina, Date datAplicacao) {
        this.cliente = cliente;
        this.nomVacina = nomVacina;
        this.datAplicacao = datAplicacao;
    }

    // === GETTERS & SETTERS ===
    public BigDecimal getIdAplicacoes() {
        return idAplicacoes;
    }

    public void setNomVacina(String nomVacina) {
        this.nomVacina = nomVacina;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
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
        Aplicacoes that = (Aplicacoes) o;
        return idAplicacoes.equals(that.idAplicacoes) && Objects.equals(cliente, that.cliente)
            && Objects.equals(nomVacina, that.nomVacina) && Objects
            .equals(datAplicacao, that.datAplicacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAplicacoes, cliente, nomVacina, datAplicacao);
    }
}
