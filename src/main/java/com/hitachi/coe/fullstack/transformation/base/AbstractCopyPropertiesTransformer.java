package com.hitachi.coe.fullstack.transformation.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import org.springframework.beans.BeanUtils;

import lombok.SneakyThrows;

/**
 * This abstract class is to copy properties from one to other.
 *
 * @param <Origin>
 * @param <Destination>
 * @author thovo
 */
public abstract class AbstractCopyPropertiesTransformer<Origin, Destination> { //NOSONAR

    protected final Class<Destination> destinationClass;

    @SuppressWarnings("unchecked")
    protected AbstractCopyPropertiesTransformer() {
        super();
        this.destinationClass = (Class<Destination>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @SneakyThrows
    public Destination apply(final Origin orig) {
        try {
            final Destination dest = destinationClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(orig, dest);
            return dest;
        } catch (Exception e) {
            return null;
        }

    }

    @SneakyThrows
    public List<Destination> applyList(List<Origin> origins) {
        if (null == origins || origins.isEmpty()) {
            return Collections.emptyList();
        }

        return origins.stream().map(this::apply)
                .collect(Collectors.toList());
    }
}
