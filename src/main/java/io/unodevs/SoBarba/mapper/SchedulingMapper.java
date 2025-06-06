package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.dto.SchedulingDTO;
import io.unodevs.SoBarba.model.Scheduling;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchedulingMapper {
    Scheduling toScheduling(SchedulingDTO dto);
    @Mapping(source = "client.id",target = "clientId")
    @Mapping(source = "barber.id",target = "barberId")
    SchedulingDTO toSchedulingDTO(Scheduling entity);
    List<Scheduling> toSchedulingList(List<SchedulingDTO> dtos);
    List<SchedulingDTO> toSchedulingDTOList(List<Scheduling> entities);
}
