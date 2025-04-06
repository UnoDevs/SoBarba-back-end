package io.unodevs.SoBarba.service;

import io.unodevs.SoBarba.model.Person;
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

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        return validateOptional(personRepository.findById(id));
    }

    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person updateById(Long id, Person person) {
        Person personData = findById(id);

        personData.setNome(person.getNome());
        personData.setDescricao(person.getDescricao());
        personData.setDataNascimento(person.getDataNascimento());

        return personRepository.save(personData);
    }

    public void deleteById(Long id){
        Person returnPerson = findById(id);
        personRepository.deleteById(returnPerson.getId());
    }
}
