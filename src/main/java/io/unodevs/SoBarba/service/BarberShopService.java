package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.BarberShopMapper;
import io.unodevs.SoBarba.model.BarberShop;
import io.unodevs.SoBarba.model.dto.BarberShopDTO;
import io.unodevs.SoBarba.repository.BarberShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.unodevs.SoBarba.service.util.ValidateEntityService.validateOptional;

@Service
public class BarberShopService {

    @Autowired
    private BarberShopRepository barberShopRepository;
    @Autowired
    private BarberShopMapper barberShopMapper;

    public List<BarberShopDTO> findAll() {
        return barberShopMapper.toBarberShopDTOList(barberShopRepository.findAll());
    }

    public BarberShopDTO findById(Long id) {
        return barberShopMapper.toBarberShopDTO(validateOptional(barberShopRepository.findById(id)));
    }

    public BarberShopDTO create(BarberShopDTO barberShop) {
        BarberShop response = barberShopRepository.save(barberShopMapper.toBarberShop(barberShop));
        return barberShopMapper.toBarberShopDTO(response);
    }

    public BarberShopDTO updateById(BarberShopDTO barberShop, Long id) {
        BarberShopDTO barberShopDataDTO = findById(id);

        barberShopDataDTO.setName(barberShop.getName());
        barberShopDataDTO.setCnpj(barberShop.getCnpj());
        barberShopDataDTO.setDescription(barberShop.getDescription());
        barberShopDataDTO.setActive(barberShop.getActive());

        barberShopRepository.save(barberShopMapper.toBarberShop(barberShopDataDTO));
        return barberShopDataDTO;
    }

    public void delete(Long id) {
        BarberShopDTO barberShopDeleted = findById(id);
        barberShopRepository.deleteById(barberShopDeleted.getId());
    }
}
