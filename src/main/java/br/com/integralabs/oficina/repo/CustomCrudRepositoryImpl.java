package br.com.integralabs.oficina.repo;

import br.com.integralabs.oficina.model.BaseModel;
import br.com.integralabs.oficina.utils.CloneObjectUtils;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Objects;

/**
 * Created by robson on 03/09/17.
 */
@Component
public class CustomCrudRepositoryImpl<T extends BaseModel, ID extends Long> implements CustomCrudRepository<T, ID> {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public T merge(T model) {
        return this.em.merge(model);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public T updateNonNullFields(T model) {
        T baseModelFromDB = this.em.find((Class<T>) model.getClass(), model.getId());

        if (Objects.isNull(baseModelFromDB))
            return null;

        // Apply only filled fields in clone.
        CloneObjectUtils.mergeNonNullFields(baseModelFromDB, model);

        return this.merge(baseModelFromDB);
    }
}
