package br.com.integralabs.oficina.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by a.moreira.rodrigues on 19/08/2017.
 */
@Entity
@Table(name = "CUSTOMERS")
@DynamicInsert
@DynamicUpdate
public class Customer extends BaseModel {

    private static final long serialVersionUID = 9185372497422510361L;

    private String name;

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }
}
