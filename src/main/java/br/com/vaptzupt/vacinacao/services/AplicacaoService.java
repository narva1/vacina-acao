package br.com.vaptzupt.vacinacao.services;

import br.com.vaptzupt.vacinacao.models.Aplicacao;
import br.com.vaptzupt.vacinacao.repositories.IAplicacaoRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class AplicacaoService {
    private static final Log LOG = LogFactory.getLog(AplicacaoService.class);

    private final IAplicacaoRepository repository;

    public AplicacaoService(IAplicacaoRepository repository) {
        this.repository = repository;
    }

    public List<Aplicacao> buscarTodas() {
        LOG.trace("buscando todas as aplicações...");
        return repository.findAll();
    }

    public Optional<Aplicacao> buscarPeloId(BigDecimal id) throws IllegalArgumentException{
        LOG.trace("buscando aplicação com o id " + id);

        if (id == null)
            throw new IllegalArgumentException("Não é possível buscar uma entidade com valor null!");

        return repository.findById(id);
    }

    public int salvar(Aplicacao aplicacao) {
        LOG.trace("salvando aplicacao do cliente " + aplicacao.getCliente().getIdCliente());

        repository.save(aplicacao);

        return 1;
    }

    public int atualizar(Aplicacao aplicacao) {
        LOG.trace("atualizando aplicacao id " + aplicacao.getIdAplicacao());

        repository.save(aplicacao);

        return 1;
    }

    public void deletar(BigDecimal id) {

        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Não existe entidade com o id informado!");
        }
    }
}
