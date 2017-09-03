package br.com.integralabs.oficina.repo;

import br.com.integralabs.oficina.model.BaseModel;
import br.com.integralabs.oficina.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by a.moreira.rodrigues on 20/08/2017.
 */
public interface GenericCrudRepository<T extends BaseModel> extends CrudRepository<T, Long>, CustomCrudRepository<T, Long> {
}