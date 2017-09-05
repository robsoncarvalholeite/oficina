package br.com.integralabs.oficina.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by robson on 05/09/17.
 */
public abstract class CloneObjectUtils {

    /**
     * Copy All non null fields from source Entity to target Entity.
     *
     * @param target to Object fields.
     * @param source from Object fields.
     */
    public static <T> void mergeNonNullFields(T target, T source) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        List<String> nullFieldsName = Arrays.asList(beanWrapper.getPropertyDescriptors())
                .stream()
                .map(FeatureDescriptor::getName)
                .filter(fieldName -> (Objects.isNull(beanWrapper.getPropertyValue(fieldName))))
                .collect(Collectors.toList());

        BeanUtils.copyProperties(source, target, nullFieldsName.toArray(new String[]{}));
    }
}
