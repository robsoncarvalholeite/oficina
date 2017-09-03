package br.com.integralabs.oficina.service.generic;

import br.com.integralabs.oficina.model.BaseModel;
import br.com.integralabs.oficina.repo.BaseCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by robson on 03/09/17.
 */
public abstract class GenericServiceImpl<T extends BaseModel> implements GenericService<T> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(GenericServiceImpl.class);

    protected abstract BaseCrudRepository getCrudRepository();

    @Override
    public T find(Long id) {
        Optional<T> modelOpt = this.getCrudRepository().findById(id);
        return modelOpt.orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Record not Found"));
    }

    @Override
    public T save(T model) {

        if (model.isNew()) {
            this.validateCreate(model);
            model.setId(null);
            return (T) this.getCrudRepository().save(model);
        } else {
            this.validateUpdate(model);
            T updatedModel = (T) this.getCrudRepository().save(model);

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
    public void setActive(Long id, Boolean active) {
        T model = find(id);
        model.setActive(active);
        save(model);
    }

    protected void validateUpdate(T model) {
    }

    protected void validateCreate(T model) {
    }

    protected void validateRemove(Long id) {
    }
}
