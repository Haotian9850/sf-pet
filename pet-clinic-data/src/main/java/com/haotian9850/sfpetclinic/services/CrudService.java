package com.haotian9850.sfpetclinic.services;

import java.util.Set;

/*mimicing Spring's built-in CrudService*/
public interface CrudService<T, ID> {
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
