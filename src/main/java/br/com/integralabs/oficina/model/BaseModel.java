package br.com.integralabs.oficina.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Created by a.moreira.rodrigues on 20/08/2017.
 */

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true, value = {"new", "active"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseModel implements Serializable {

    /**
     * Logger.
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseModel.class);

    private static final long serialVersionUID = 8237074293760093051L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ACTIVE", nullable = false)
    protected Boolean active;

    @Column(name = "CREATION_DATE", nullable = false)
    protected Date creationDate;

    @Column(name = "MODIFICATION_DATE", nullable = true)
    protected Date modificationDate;

    public BaseModel() {
        this.active = true;
    }

    @PrePersist
    public void prePersist() {
        // Set now for create date.
        if (this.isNew()) {
            this.setCreationDate(Calendar.getInstance().getTime());
        }
    }

    @PreUpdate
    public void preUpdate() {
        // Set now for modification date
        this.setModificationDate(Calendar.getInstance().getTime());
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public Boolean isNew() {
        return Objects.isNull(this.getId());
    }

    public Long getId() {
        return id;
    }

    public BaseModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public BaseModel setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public BaseModel setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public BaseModel setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }
}

