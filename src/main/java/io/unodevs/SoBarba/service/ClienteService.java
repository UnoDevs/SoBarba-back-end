package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.model.Cliente;
import io.unodevs.SoBarba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente create(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
