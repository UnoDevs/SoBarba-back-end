package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.model.EmployeeData;
import io.unodevs.SoBarba.model.dto.EmployeeDataDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeDataMapper {
    EmployeeData toEmployeeData(EmployeeDataDTO dto);
    EmployeeDataDTO toEmployeeDataDTO(EmployeeData entity);
    List<EmployeeData> toEmployeeDataList(List<EmployeeDataDTO> dtos);
    List<EmployeeDataDTO> toEmployeeDataDTOList(List<EmployeeData> entities);
}
