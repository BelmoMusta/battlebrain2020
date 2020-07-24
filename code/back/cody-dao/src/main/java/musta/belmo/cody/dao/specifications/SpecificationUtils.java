package musta.belmo.cody.dao.specifications;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationUtils {


    public static <T> Specification<T> and(Specification<T> left, Specification<T> right) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.and(right.toPredicate(root,
                        criteriaQuery, criteriaBuilder), left.toPredicate(root,
                        criteriaQuery, criteriaBuilder));
    }

    public <T> Specification<T> or(Specification<T> left, Specification<T> right) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.or(right.toPredicate(root,
                        criteriaQuery, criteriaBuilder), left.toPredicate(root,
                        criteriaQuery, criteriaBuilder));

    }
}
