package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.dto.FinancialRecordDTO;
import io.unodevs.SoBarba.model.FinancialRecord;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "string")
public interface FinancialRecordMapper {
    FinancialRecord toFinancialRecord(FinancialRecordDTO dto);
    FinancialRecordDTO toFinancialRecordDTO(FinancialRecord entity);
    List<FinancialRecord> toFinancialRecordList(List<FinancialRecordDTO> dtos);
    List<FinancialRecordDTO> toFinancialRecordDTOList(List<FinancialRecord> entities);
}
