package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.mapper.PersonMapper;
import io.unodevs.SoBarba.model.Person;
import io.unodevs.SoBarba.model.dto.PersonDTO;
import io.unodevs.SoBarba.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static io.unodevs.SoBarba.service.util.ValidateEntityService.validateOptional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

    public List<PersonDTO> findAll(){
        return personMapper.toPersonDTOList(personRepository.findAll());
    }

    public PersonDTO findById(Long id){
        return personMapper.toPersonDTO(validateOptional(personRepository.findById(id)));
    }

    public PersonDTO create(PersonDTO person){
        Person response = personRepository.save(personMapper.toPerson(person));
        return personMapper.toPersonDTO(response);
    }

    public PersonDTO updateById(Long id, PersonDTO person) {
        PersonDTO personDataDTO = findById(id);

        personDataDTO.setName(person.getName());
        personDataDTO.setDescription(person.getDescription());
        personDataDTO.setEmail(person.getEmail());
        personDataDTO.setPhone(person.getPhone());
        personDataDTO.setActive(person.getActive());
        personDataDTO.setPersonTypes(person.getPersonTypes());

        personRepository.save(personMapper.toPerson(personDataDTO));
        return personDataDTO;
    }

    public void deleteById(Long id){
        PersonDTO returnPerson = findById(id);
        personRepository.deleteById(returnPerson.getId());
    }
}
