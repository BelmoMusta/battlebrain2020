package musta.belmo.cody.service.api;

import musta.belmo.cody.data.model.common.AbstractDataModel;

import java.util.Optional;
import java.util.Set;

@Deprecated
public interface AbstractDomainCrudService<T extends AbstractDataModel> {

    T create(T t);

    Optional<T> findOne(Long id);

    Set<T> findAll();

    T update(T t);

    T update(Long id, T t);

    void delete(T t);

    default void delete(Long id){
        findOne(id).ifPresent(this::delete);
    }

}
