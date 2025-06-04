package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.dto.FinancialRecordDTO;
import io.unodevs.SoBarba.model.FinancialRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FinancialRecordMapper {
    FinancialRecord toFinancialRecord(FinancialRecordDTO dto);
    @Mapping(source = "client.id", target = "clientId")
    FinancialRecordDTO toFinancialRecordDTO(FinancialRecord entity);
    List<FinancialRecord> toFinancialRecordList(List<FinancialRecordDTO> dtos);
    List<FinancialRecordDTO> toFinancialRecordDTOList(List<FinancialRecord> entities);
}
