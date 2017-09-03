package br.com.integralabs.oficina.test;

import br.com.integralabs.oficina.model.BaseModel;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

/**
 * Created by robson on 03/09/17.
 */
@Component
public class CustomCrudRepositoryImpl<T extends BaseModel, ID extends Long> implements CustomCrudRepository<T, ID> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public T merge(T model) {
        return em.merge(model);
    }

    @Override
    public T findFirst(ID id, Class<T> clazz) {
        return em.find(clazz, id);
    }
}
