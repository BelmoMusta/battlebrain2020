package musta.belmo.cody.dao.specifications;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public abstract class ComparisionSpecification<T> implements Specification<T> {
    private final String dottedPath;
    private final Object rightOperand;
    private Predicate predicate;

    public ComparisionSpecification(String path, Object rightOperand) {
        this.dottedPath = path;
        this.rightOperand = rightOperand;
    }

    public ComparisionSpecification(String path, Object rightOperand, Predicate predicate) {
        this(path, rightOperand);
        this.predicate = predicate;
    }

    public ComparisionSpecification(Predicate predicate) {
        this(null, null, predicate);
    }

    protected abstract Predicate constructPredicate(CriteriaBuilder criteriaBuilder, Path<T> path, Object rightOperand);

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (predicate == null) {
            final Path<T> path = calculatePath(this.dottedPath, root);
            predicate = constructPredicate(criteriaBuilder, path, rightOperand);
        }
        return predicate;
    }


    private Path<T> calculatePath(String path, Root<T> root) {
        final String[] pathElements = path.split("\\.");
        return Stream.of(pathElements)
                .reduce(root, (rootPath, s) -> {
                    rootPath.alias(s);
                    return rootPath.get(s);
                }, (BinaryOperator<Path<T>>) (pathA, pathB) -> pathA.get(pathB.getAlias()));

    }

}
