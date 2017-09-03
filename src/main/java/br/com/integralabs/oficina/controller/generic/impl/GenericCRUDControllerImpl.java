package br.com.integralabs.oficina.controller.crud;

import br.com.integralabs.oficina.controller.GenericController;
import br.com.integralabs.oficina.model.BaseModel;
import br.com.integralabs.oficina.repo.BaseCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by robson on 02/09/17.
 */
public abstract class GenericCRUDControllerImpl<T extends BaseModel> extends GenericController implements GenericCRUDController<T>{

    protected static final Logger LOGGER = LoggerFactory.getLogger(GenericCRUDControllerImpl.class);

    protected abstract BaseCrudRepository getCrudRepository();

    @Override
    @GetMapping(value = "/{id}")
    public T find(@PathVariable("id") Long id) {
        LOGGER.info("Controller Find id [{}]", id);

        Optional<T> modelOpt = this.getCrudRepository().findById(id);
        return modelOpt.orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Record not Found"));
    }

    @Override
    @PostMapping
    public T create(@RequestBody T model) {
        LOGGER.info("Controller Create {}: {}", model.getClass().getSimpleName(), model);
        model.setId(null);
        T createdModel = (T) this.getCrudRepository().save(model);

        if (Objects.isNull(createdModel))
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "Record not created");

        return createdModel;
    }


    @Override
    @PutMapping("/{id}")
    public T update(
            @PathVariable("id") Long id,
            @RequestBody T model
    ) {
        LOGGER.info("Controller update {} id [{}]: {}", model.getClass().getSimpleName(), id, model);
        model.setId(id);
        T updatedModel = (T) this.getCrudRepository().save(model);

        if (Objects.isNull(updatedModel))
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "Record not Found");

        return updatedModel;
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Controller delete: {}", id);
        try {
            this.getCrudRepository().deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, "Record not Found: " + e.getMessage());
        }
    }

    @GetMapping
    @Override
    public List<T> findAll () {
        LOGGER.info("Controller FindAll");
        return (List<T>) this.getCrudRepository().findAll();
    }

}
