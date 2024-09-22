package services;

import entities.Autor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServices implements BaseServicio<Autor>{

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    public AutorServices(AutorRepository personaRepository){
         this.autorRepository = autorRepository;
    }


    @Override
    @Transactional
    public List<Autor> findAll() throws Exception {
        try{
            List<Autor> entities = autorRepository.findAll();
            return  entities;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Autor findByid(long id) throws Exception {
        try{
            Optional<Autor> entitiesOpcional = autorRepository.findById(id);
            return entitiesOpcional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor save(Autor entity) throws Exception {
        try{
            entity = autorRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Autor update(long id, Autor entity) throws Exception {
        try{
            Optional<Autor> entityOptional = autorRepository.findById(id);
           Autor autor = entityOptional.get();
            autor = autorRepository.save(autor);
            return autor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(long id) throws Exception {
        try{
            if (autorRepository.existsById(id)){
                autorRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
