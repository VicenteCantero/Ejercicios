package com.bosonit.CRUDMongo.application.generico;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> obj= getDao().findById(id);
        if (obj.isPresent()){
            return obj.get();
        }
        return null;
    }

    @Override
    public List<T> getall() {
        List<T> lista= new ArrayList<>();
        getDao().findAll().forEach(obj -> lista.add(obj));
        return lista;
    }

    public abstract MongoRepository<T, ID> getDao();
}
