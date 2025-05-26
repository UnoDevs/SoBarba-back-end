package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.exception.InvalidEntityResponseException;
import io.unodevs.SoBarba.mapper.PersonMapper;
import io.unodevs.SoBarba.model.EmployeeData;
import io.unodevs.SoBarba.model.Person;
import io.unodevs.SoBarba.dto.EmployeeDataDTO;
import io.unodevs.SoBarba.dto.PersonDTO;
import io.unodevs.SoBarba.model.enumerator.PersonType;
import io.unodevs.SoBarba.repository.EmployeeDataRepository;
import io.unodevs.SoBarba.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.unodevs.SoBarba.service.util.ValidateEntityService.validateOptional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    public List<PersonDTO> findAll(){
        return personMapper.toPersonDTOList(personRepository.findAll());
    }

    public PersonDTO findById(Long id){
        return personMapper.toPersonDTO(validateOptional(personRepository.findById(id)));
    }

    public PersonDTO create(PersonDTO dto){
        Person entity = personMapper.toPerson(dto);

        if(!entity.getPersonTypes().contains(PersonType.EMPLOYEE)){
            entity.setEmployeeData(null);
        } else if(entity.getEmployeeData() == null) {
            throw new InvalidEntityResponseException("Person with type EMPLOYEE but without EMPLOYEE_DATA filled");
        }

        personRepository.save(entity);

        return personMapper.toPersonDTO(entity);
    }

    public PersonDTO updateById(Long id, PersonDTO dto) {
        Person entity = validateOptional(personRepository.findById(id));
        boolean isEmployee = dto.getPersonTypes().contains(PersonType.EMPLOYEE);

        if(isEmployee && dto.getEmployeeData() == null){
            throw new InvalidEntityResponseException("Person with type EMPLOYEE but without EMPLOYEE_DATA filled");
        }

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setActive(dto.getActive());
        entity.setDocument(dto.getDocument());
        entity.setPersonTypes(dto.getPersonTypes());
        entity.setEmployeeData(updateEmployeeData(
                isEmployee,
                entity.getEmployeeData(),
                dto.getEmployeeData()
        ));

        personRepository.save(entity);

        return personMapper.toPersonDTO(entity);
    }

    public void deleteById(Long id){
        PersonDTO returnPerson = findById(id);
        personRepository.deleteById(returnPerson.getId());
    }

    private EmployeeData updateEmployeeData(boolean isEmployee, EmployeeData entityData, EmployeeDataDTO dataDTO){
        if(!isEmployee){
            return null;
        } else {
            if(entityData == null){
                entityData = new EmployeeData();
            }
            entityData.setHireDate(dataDTO.getHireDate());
            entityData.setTerminationDate(dataDTO.getTerminationDate());
            entityData.setJobTitle(dataDTO.getJobTitle());
            entityData.setSalary(dataDTO.getSalary());
            entityData.setCommission(dataDTO.getCommission());
        }
        return entityData;
    }
}
