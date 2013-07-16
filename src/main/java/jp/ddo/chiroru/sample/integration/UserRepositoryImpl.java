package jp.ddo.chiroru.sample.integration;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import jp.ddo.chiroru.sample.domain.User;

@Repository
public class UserRepositoryImpl
        implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    public List<User> myCustomBatchOperation() {

        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

}
