package br.com.integralabs.oficina.repo;

import br.com.integralabs.oficina.model.BaseModel;
import br.com.integralabs.oficina.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by a.moreira.rodrigues on 20/08/2017.
 */
public interface BaseCrudRepository<T extends BaseModel, ID extends Long> extends CrudRepository<T, ID>, CustomCrudRepository<T, ID> {
}