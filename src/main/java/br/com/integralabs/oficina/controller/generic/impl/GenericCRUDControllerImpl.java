package br.com.integralabs.oficina.controller.generic.impl;

import br.com.integralabs.oficina.controller.generic.GenericCRUDController;
import br.com.integralabs.oficina.controller.generic.GenericController;
import br.com.integralabs.oficina.model.BaseModel;
import br.com.integralabs.oficina.service.generic.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by robson on 02/09/17.
 */
public abstract class GenericCRUDControllerImpl<T extends BaseModel> extends GenericController implements GenericCRUDController<T> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(GenericCRUDControllerImpl.class);

    protected abstract GenericService getService();

    @Override
    @GetMapping(value = "/{id}")
    public T find(@PathVariable("id") Long id) {
        LOGGER.info("Controller Find id [{}]", id);
        return (T) this.getService().find(id);
    }

    @Override
    @PostMapping
    public T create(@RequestBody T model) {
        LOGGER.info("Controller Create {}: {}", model.getClass().getSimpleName(), model);
        model.setId(null);
        return (T) this.getService().save(model);
    }


    @Override
    @PutMapping("/{id}")
    public T update(
            @PathVariable("id") Long id,
            @RequestBody T model
    ) {
        LOGGER.info("Controller update {} id [{}]: {}", model.getClass().getSimpleName(), id, model);
        model.setId(id);
        return (T) this.getService().save(model);
    }

    @Override
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id) {
        LOGGER.info("Controller remove: {}", id);
        this.getService().remove(id);
    }

    @Override
    @GetMapping
    public List<T> findAll() {
        LOGGER.info("Controller FindAll");
        return this.getService().findAll();
    }

    @Override
    @PutMapping("/{id}/active")
    public void active(@PathVariable("id") Long id) {
        this.getService().setActive(id, Boolean.TRUE);
    }

    @Override
    @PutMapping("/{id}/deactive")
    public void deactive(@PathVariable("id") Long id) {
        this.getService().setActive(id, Boolean.FALSE);
    }
}
