package io.unodevs.SoBarba.mapper;

import io.unodevs.SoBarba.model.Person;
import io.unodevs.SoBarba.model.dto.PersonDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toPerson(PersonDTO dto);
    PersonDTO toPersonDTO(Person entity);
    List<Person> toPersonList(List<PersonDTO> dtos);
    List<PersonDTO> toPersonDTOList(List<Person> entities);
}
