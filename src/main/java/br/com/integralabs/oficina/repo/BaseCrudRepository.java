package br.com.integralabs.oficina.repo;

import br.com.integralabs.oficina.model.BaseModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by a.moreira.rodrigues on 20/08/2017.
 */
public interface BaseCrudRepository<T extends BaseModel, ID> extends CrudRepository <T, ID> {
}