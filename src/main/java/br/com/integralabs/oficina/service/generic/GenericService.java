package br.com.integralabs.oficina.service;

import java.util.List;

/**
 * Created by robson on 03/09/17.
 */
public interface GenericService <T> {

    T find(Long id);

    T create(T model);

    T update(Long id, T model);

    void delete(Long id);

    List<T> findAll();
}
