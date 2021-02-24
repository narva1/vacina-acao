package br.com.vaptzupt.vacinacao.services;

import br.com.vaptzupt.vacinacao.models.Cliente;
import br.com.vaptzupt.vacinacao.repositories.IClienteRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final IClienteRepository repository;

    // === CONSTRUCTOR INJECTION ===
    public ClienteService(IClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> buscarTodos() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarPeloId(BigDecimal id) {
        if (id == null) {
            throw new IllegalArgumentException("não é possível buscar um cliente de id null!");
        }

        return repository.findById(id);
    }


}
