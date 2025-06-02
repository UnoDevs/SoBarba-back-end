package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.dto.SchedulingDTO;
import io.unodevs.SoBarba.exception.InvalidEntityRequestException;
import io.unodevs.SoBarba.mapper.SchedulingMapper;
import io.unodevs.SoBarba.model.Person;
import io.unodevs.SoBarba.model.Scheduling;
import io.unodevs.SoBarba.model.enumerator.PersonType;
import io.unodevs.SoBarba.repository.PersonRepository;
import io.unodevs.SoBarba.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.unodevs.SoBarba.service.util.ValidateEntityService.validateOptional;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SchedulingMapper schedulingMapper;

    public List<SchedulingDTO> findAll(){
        return schedulingMapper.toSchedulingDTOList(schedulingRepository.findAllWithPersons());
    }

    public SchedulingDTO findById(Long id){
        return schedulingMapper.toSchedulingDTO(validateOptional(schedulingRepository.findByIdWithPersons(id)));
    }

    public SchedulingDTO create(SchedulingDTO dto){
        Scheduling scheduling = schedulingMapper.toScheduling(dto);

        Person client = validateOptional(personRepository.findById(dto.getClientId()));
        validateType(client,PersonType.CUSTOMER);
        client.addClientSchedulings(scheduling);
        Person barber = validateOptional(personRepository.findById(dto.getBarberId()));
        validateType(barber,PersonType.EMPLOYEE);
        client.addBarberSchedulings(scheduling);

        personRepository.save(client);
        personRepository.save(barber);
        schedulingRepository.save(scheduling);

        SchedulingDTO response = schedulingMapper.toSchedulingDTO(scheduling);
        response.setBarberId(barber.getId());
        response.setClientId(client.getId());

        return response;
    }

    public SchedulingDTO updateById(Long id,SchedulingDTO dto){
        Scheduling scheduling = validateOptional(schedulingRepository.findByIdWithPersons(id));

        scheduling.setEndDate(dto.getEndDate());
        scheduling.setStartDate(dto.getStartDate());

        Person client = validateOptional(personRepository.findById(dto.getClientId()));
        validateType(client,PersonType.CUSTOMER);
        client.addClientSchedulings(scheduling);
        Person barber = validateOptional(personRepository.findById(dto.getBarberId()));
        validateType(barber,PersonType.EMPLOYEE);
        client.addBarberSchedulings(scheduling);

        personRepository.save(client);
        personRepository.save(barber);
        schedulingRepository.save(scheduling);

        return schedulingMapper.toSchedulingDTO(scheduling);
    }

    public void delete(Long id){
        Scheduling scheduling = schedulingMapper.toScheduling(findById(id));
        schedulingRepository.deleteById(id);
    }

    private boolean validateType(Person person, PersonType type){
        if (!person.getPersonTypes().contains(type)){
            throw new InvalidEntityRequestException("Pessoa "+ person.getName() +" informada não está vinculada como "+type+"!");
        }
        return true;
    }
}
