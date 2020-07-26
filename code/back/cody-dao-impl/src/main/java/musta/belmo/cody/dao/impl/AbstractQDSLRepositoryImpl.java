package musta.belmo.cody.dao.impl;

import com.querydsl.jpa.impl.JPAQuery;
import musta.belmo.cody.data.model.scheduling.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class AbstractQDSLRepositoryImpl<T> {
	
	@Autowired
	@Qualifier(value = "entityManagerFactory")
	private EntityManager entityManager;
	
	protected JPAQuery<T> getJpaQuery() {
		return new JPAQuery<>(entityManager);
	}
}
