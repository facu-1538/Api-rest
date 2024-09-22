package services;

import entities.Persona;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServices implements BaseServicio<Persona> {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServices(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }


    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try{
            List<Persona> entities = personaRepository.findAll();
            return  entities;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Persona findByid(long id) throws Exception {
        try{
            Optional<Persona> entitiesOpcional = personaRepository.findById(id);
            return entitiesOpcional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try{
            entity = personaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(long id, Persona entity) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona = personaRepository.save(persona);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(long id) throws Exception {
        try{
            if (personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
