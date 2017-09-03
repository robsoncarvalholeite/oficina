package br.com.integralabs.oficina.repo;

import br.com.integralabs.oficina.model.BaseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.beans.FeatureDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

        this.mergeNonNullField(baseModelFromDB, model);

        return this.merge(baseModelFromDB);
    }

    /**
     * Copy All non null fields from source Entity to target entity.
     *
     * @param target to Object fields.
     * @param source from Object fields.
     */
    private void mergeNonNullField(T target, T source) {

        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        List<String> nullFieldsName = Arrays.asList(beanWrapper.getPropertyDescriptors())
                .stream()
                .map(FeatureDescriptor::getName)
                .filter(fieldName -> (Objects.isNull(beanWrapper.getPropertyValue(fieldName))))
                .collect(Collectors.toList());

        BeanUtils.copyProperties(source, target, nullFieldsName.toArray(new String[]{}));
    }
}
