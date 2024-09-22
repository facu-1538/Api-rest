package services;

import entities.Libro;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LibroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServices implements BaseServicio<Libro>{

    @Autowired
    private LibroRepository libroRepository;

    public LibroServices(LibroRepository libroRepository){
        this.libroRepository = libroRepository;
    }


    @Override
    @Transactional
    public List<Libro> findAll() throws Exception {
        try{
            List<Libro> entities = libroRepository.findAll();
            return  entities;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Libro findByid(long id) throws Exception {
        try{
            Optional<Libro> entitiesOpcional = libroRepository.findById(id);
            return entitiesOpcional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro save(Libro entity) throws Exception {
        try{
            entity = libroRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Libro update(long id, Libro entity) throws Exception {
        try{
            Optional<Libro> entityOptional = libroRepository.findById(id);
            Libro libro = entityOptional.get();
            libro = libroRepository.save(libro);
            return libro;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(long id) throws Exception {
        try{
            if (libroRepository.existsById(id)){
                libroRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
