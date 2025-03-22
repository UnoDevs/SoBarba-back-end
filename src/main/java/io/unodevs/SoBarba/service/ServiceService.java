package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.exception.ServiceNotFoundException;
import io.unodevs.SoBarba.model.Service;
import io.unodevs.SoBarba.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository servicoRepository;

    public List<Service> findAll() {
        return servicoRepository.findAll();
    }

    public Service findById(Long id) {
        return validateOptional(servicoRepository.findById(id));
    }

    public Service create(Service servico) {
        return servicoRepository.save(servico);
    }

    public Service update(Service servico, Long id) {

        Service serviceUpdated = validateOptional(
            servicoRepository.findById(id).map(val -> {
                val.setNome(servico.getNome());
                val.setDescricao(servico.getDescricao());
                val.setValor(servico.getValor());
                val.setTempo(servico.getTempo());
                val.setStatus(servico.isStatus());
                return val;
            })
        );
        servicoRepository.save(serviceUpdated);

        return serviceUpdated;

    }

    public Service delete(Long id) {
        Service servicoDeleted = validateOptional(servicoRepository.findById(id));
        servicoRepository.deleteById(id);
        return servicoDeleted;
    }

    private Service validateOptional(Optional<Service> opt){
        if(opt.isPresent()){
            return opt.get();
        }
        throw new ServiceNotFoundException("Serviço pesquisado não encontrado!");
    }
}
