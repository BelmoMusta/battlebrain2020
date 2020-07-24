package musta.belmo.cody.dao.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public class EqualsSpecification<T> extends ComparisionSpecification<T> {

    public EqualsSpecification(String path, Object rightOperand) {
        super(path, rightOperand);
    }

    @Override
    protected Predicate constructPredicate(final CriteriaBuilder criteriaBuilder, final Path<T> path, Object rightOperand) {
        return criteriaBuilder.equal(path, rightOperand);
    }
}
