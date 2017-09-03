package br.com.integralabs.oficina.repo;

import br.com.integralabs.oficina.model.BaseModel;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;

/**
 * Created by robson on 03/09/17.
 */
@NoRepositoryBean
public interface CustomCrudRepository<T extends BaseModel, ID extends Long> {
    T merge(T model);

    T updateNonNullFields(T model);
}