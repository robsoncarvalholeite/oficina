package br.com.integralabs.oficina.controller.generic;

import br.com.integralabs.oficina.model.BaseModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by robson on 02/09/17.
 */
public interface GenericCRUDController<T extends BaseModel> {

    T find(Long id);

    T create(T model);

    T update(Long id, T model);

    void remove(Long id);

    List<T> findAll();
}
