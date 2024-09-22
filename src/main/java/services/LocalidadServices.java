package services;

import entities.Localidad;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LocalidadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadServices implements BaseServicio<Localidad>{

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServices(LocalidadRepository localidadRepository){
        this.localidadRepository = localidadRepository;
    }

    @Override
    @Transactional
    public List<Localidad> findAll() throws Exception {
        try{
            List<Localidad> entities = localidadRepository.findAll();
            return  entities;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Localidad findByid(long id) throws Exception {
        try{
            Optional<Localidad> entitiesOpcional = localidadRepository.findById(id);
            return entitiesOpcional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad save(Localidad entity) throws Exception {
        try{
            entity = localidadRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Localidad update(long id, Localidad entity) throws Exception {
        try{
            Optional<Localidad> entityOptional = localidadRepository.findById(id);
            Localidad localidad = entityOptional.get();
            localidad = localidadRepository.save(localidad);
            return localidad;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(long id) throws Exception {
        try{
            if (localidadRepository.existsById(id)){
                localidadRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
