package com.dao;

import com.model.XmlResponse;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edvard Piri on 14.11.2017.
 */
@Repository
public class XmlResponseDaoImpl extends AbstractDAOImpl<XmlResponse> implements XmlResponseDao {
    @Override
    public XmlResponse getByName(String name) {
        String request = "from XmlResponse t where t.responseName = :name";
        Query query = getSession().createQuery(request);
        query.setParameter("name", name);
        return (XmlResponse) query.uniqueResult();
    }

    @Override
    public XmlResponse getById(Long id) {
        String request = "from XmlResponse t where t.id = :id";
        Query query = getSession().createQuery(request);
        query.setParameter("id", id);
        return (XmlResponse) query.uniqueResult();
    }
}
