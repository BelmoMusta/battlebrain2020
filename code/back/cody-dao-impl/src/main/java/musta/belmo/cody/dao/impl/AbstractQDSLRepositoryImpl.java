package musta.belmo.cody.dao.impl;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import musta.belmo.cody.data.model.scheduling.QReservation;
import musta.belmo.cody.data.model.scheduling.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public abstract class AbstractQDSLRepositoryImpl<T> {
	
	@Autowired
	@Qualifier(value = "entityManagerFactory")
	private EntityManager entityManager;
	
	protected JPAQuery<T> getJpaQuery() {
		return new JPAQuery<>(entityManager);
	}
	
	protected JPADeleteClause getJpaDeleteQuery() {
		return new JPADeleteClause(entityManager, getEntityPathBase());
		
	}
	
	protected abstract EntityPathBase<T> getEntityPathBase();
}
