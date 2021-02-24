package br.com.vaptzupt.vacinacao.repositories;

import br.com.vaptzupt.vacinacao.models.Aplicacao;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAplicacaoRepository extends JpaRepository<Aplicacao, BigDecimal> {

}
