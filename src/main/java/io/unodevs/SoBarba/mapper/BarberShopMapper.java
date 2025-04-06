package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.model.BarberShop;
import io.unodevs.SoBarba.model.dto.BarberShopDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BarberShopMapper {
    BarberShop toBarberShop(BarberShopDTO dto);
    BarberShopDTO toBarberShopDTO(BarberShop entity);
    List<BarberShop> toBarberShopList(List<BarberShopDTO> dtos);
    List<BarberShopDTO> toBarberShopDTOList(List<BarberShop> entities);
}
