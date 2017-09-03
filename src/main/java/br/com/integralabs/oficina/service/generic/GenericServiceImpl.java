package br.com.integralabs.oficina.service.generic;

import br.com.integralabs.oficina.model.BaseModel;
import br.com.integralabs.oficina.repo.GenericCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by robson on 03/09/17.
 */
public abstract class GenericServiceImpl<T extends BaseModel> implements GenericService<T> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(GenericServiceImpl.class);

    protected abstract GenericCrudRepository getCrudRepository();

    @Override
    public T find(Long id) {
        Optional<T> modelOpt = this.getCrudRepository().findById(id);
        return modelOpt.orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Record not Found"));
    }

    @Override
    public T save(T model) {
        if (model.isNew()) {

            model.setId(null);
            model.setActive(null);

            this.validateCreate(model);

            return (T) this.getCrudRepository().save(model);
        } else {
            model.setCreationDate(null);

            this.validateUpdate(model);

            T updatedModel = (T) this.getCrudRepository().updateNonNullFields(model);

            if (Objects.isNull(updatedModel))
                throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "Record not Found");
            return updatedModel;
        }
    }

    @Override
    public void remove(Long id) {
        try {
            this.validateRemove(id);
            this.getCrudRepository().deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "Record not Found: " + e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        return (List<T>) this.getCrudRepository().findAll();
    }

    @Override
    public void setActive(Long id, Boolean active) throws IllegalAccessException, InstantiationException {
        T model = (T) ((Class)((ParameterizedType)this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
        model.setId(id);
        model.setActive(active);
        this.getCrudRepository().updateNonNullFields(model);
    }

    protected void validateUpdate(T model) {
    }

    protected void validateCreate(T model) {
    }

    protected void validateRemove(Long id) {
    }
}
