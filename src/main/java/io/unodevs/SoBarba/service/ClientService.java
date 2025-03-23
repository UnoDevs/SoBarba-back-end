package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.exception.ClientNotFoundException;
import io.unodevs.SoBarba.model.Client;
import io.unodevs.SoBarba.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(Long id){
        return validateOptional(clientRepository.findById(id));
    }

    public Client create(Client client){
        return clientRepository.save(client);
    }

    public Client updateById(Long id, Client client) {
        Client clientData = findById(id);

        clientData.setNome(client.getNome());
        clientData.setDescricao(client.getDescricao());
        clientData.setDataNascimento(client.getDataNascimento());

        return clientRepository.save(clientData);
    }

    public void deleteById(Long id){
        Client returnClient = findById(id);
        clientRepository.deleteById(returnClient.getId());
    }

    public Client validateOptional(Optional<Client> opt){
        if(opt.isPresent()){
            return opt.get();
        }
        throw new ClientNotFoundException("Cliente pesquisado não encontrado!");
    }


}
