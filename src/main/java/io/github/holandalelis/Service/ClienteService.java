package io.github.holandalelis.Service;

import io.github.holandalelis.Model.Cliente;
import io.github.holandalelis.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void saveCliente(Cliente cliente){
        validaCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validaCliente(Cliente cliente){
        //aplica validações
    }

}
