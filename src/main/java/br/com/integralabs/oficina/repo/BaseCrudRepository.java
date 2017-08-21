package br.com.integralabs.oficina.repo;

import br.com.integralabs.oficina.model.BaseModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by a.moreira.rodrigues on 20/08/2017.
 */
public interface BaseCrudRepository<T extends BaseModel, T1> extends CrudRepository <T, T1> {
}