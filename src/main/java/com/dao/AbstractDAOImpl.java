package com.dao;

import com.model.BaseEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Edvard Piri on 12.11.2017.
 */

@Repository
public class AbstractDAOImpl<T extends BaseEntity> implements AbstractDAO<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public T save(T t) {
        if (t.getId() == null)
            entityManager.persist(t);
        else
            t = entityManager.merge(t);
        return t;
    }

    //    @Override
//    public T remove(T t) {
//        entityManager.remove(t);
//        return t;
//    }
//
//    @Override
//    public T clear(T t) {
//        entityManager.clear();
//        return t;
//    }
}
