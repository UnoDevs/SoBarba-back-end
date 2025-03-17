package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.model.Servico;
import io.unodevs.SoBarba.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Servico findById(Long id) {
        return servicoRepository.findById(id).get();
    }

    public Servico create(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico update(Servico servico, Long id) {
        Optional<Servico> servicoUpdated = servicoRepository.findById(id);
        servicoUpdated.map(val -> {
            val.setNome(servico.getNome());
            val.setDescricao(servico.getDescricao());
            val.setValor(servico.getValor());
            val.setTempo(servico.getTempo());
            val.setStatus(servico.isStatus());
            return val;
        });

        return servicoUpdated.get();
    }

    public Servico delete(Long id) {
        Optional<Servico> servicoDeleted = servicoRepository.findById(id);
        servicoRepository.deleteById(id);
        return servicoDeleted.get();
    }
}
