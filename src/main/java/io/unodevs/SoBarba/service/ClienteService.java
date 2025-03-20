package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.model.Cliente;
import io.unodevs.SoBarba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        Optional<Cliente> clienteOpcional = clienteRepository.findById(id);
        return clienteOpcional.orElse(null);
    }

    public Cliente create(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
