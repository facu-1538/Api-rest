package services;

import java.util.List;

public interface BaseServicio<E> {


    public List<E> findAll () throws  Exception;
    public E findByid(long id) throws Exception;
    public  E save(E entity) throws Exception;
    public E update(long id, E entity) throws Exception;
    public boolean delete(long id) throws Exception;
}
