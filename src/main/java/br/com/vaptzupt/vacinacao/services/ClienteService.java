package br.com.vaptzupt.vacinacao.services;

import br.com.vaptzupt.vacinacao.models.Cliente;
import br.com.vaptzupt.vacinacao.repositories.IClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final IClienteRepository repository;

    public ClienteService(IClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> buscarTodos() {
        return null;
    }
}
