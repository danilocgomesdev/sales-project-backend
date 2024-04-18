package com.project.sales.interfaces;

import java.util.List;

public interface IGenericOperations<T, N>{
    T create(T entity);
    T read( N id);
    List<T> readAll();

    //PATCH
    T updatePart(N id, T entity);

    //PUT
    T updateAll(N id, T entity);

    void delete(N id);
}
