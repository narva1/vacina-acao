package br.com.vaptzupt.vacinacao.services;

import br.com.vaptzupt.vacinacao.models.Clientes;
import br.com.vaptzupt.vacinacao.repositories.IClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final IClienteRepository repository;

    public ClienteService(IClienteRepository repository) {
        this.repository = repository;
    }

    public List<Clientes> buscarTodos() {
        return null;
    }
}
