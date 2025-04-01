package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.exception.BarberShopNotFoundException;
import io.unodevs.SoBarba.exception.TaskNotFoundException;
import io.unodevs.SoBarba.model.BarberShop;
import io.unodevs.SoBarba.model.Product;
import io.unodevs.SoBarba.repository.BarberShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarberShopService {

    @Autowired
    private BarberShopRepository barberShopRepository;

    public List<BarberShop> findAll() {
        return barberShopRepository.findAll();
    }

    public BarberShop findById(Long id) {
        BarberShop barberShop = validateOptional(barberShopRepository.findById(id));
        return barberShop;
    }

    public BarberShop create(BarberShop barberShop) {
        return barberShopRepository.save(barberShop);
    }

    public BarberShop update(BarberShop barberShop, Long id) {
        BarberShop barberShopUpdated = validateOptional(
                barberShopRepository.findById(id).map(val -> {
                    val.setName(barberShop.getName());
                    val.setDescription(barberShop.getDescription());
                    val.setCnpj(barberShop.getCnpj());
                    val.setActive(barberShop.isActive());
                    return val;
                })
        );

        barberShopRepository.save(barberShopUpdated);

        return barberShopUpdated;
    }

    public BarberShop delete(Long id) {
        BarberShop barberShopDeleted = validateOptional(barberShopRepository.findById(id));
        barberShopRepository.delete(barberShopDeleted);
        return barberShopDeleted;
    }

    private BarberShop validateOptional(Optional<BarberShop> opt){
        if(opt.isPresent()){
            return opt.get();
        }
        throw new BarberShopNotFoundException("Barbearia pesquisada não encontrado!");
    }
}
