package br.com.integralabs.oficina.service.generic;

import br.com.integralabs.oficina.model.BaseModel;

import java.util.List;

/**
 * Created by robson on 03/09/17.
 */
public interface GenericService <T extends BaseModel> {

    T find(Long id);

    T save(T model);

    void remove(Long id);

    List<T> findAll();

    void setActive(Long id, Boolean active) throws IllegalAccessException, InstantiationException;
}
