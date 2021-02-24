package br.com.vaptzupt.vacinacao.repositories;

import br.com.vaptzupt.vacinacao.models.Clientes;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Clientes, BigDecimal> {

}
