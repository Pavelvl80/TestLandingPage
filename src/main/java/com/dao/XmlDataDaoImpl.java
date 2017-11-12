package com.dao;

import com.model.XmlData;
import org.hibernate.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Edvard Piri on 12.11.2017.
 */

@Repository
@Transactional
public class XmlDataDaoImpl extends AbstractDAOImpl<XmlData> implements XmlDataDao {

    @Override
    public XmlData getById(long id) {
        String hql = "from Xml_storage t where t.id = :id";
        Query query = getSession().createQuery(hql);
        query.setParameter("id", id);
        return (XmlData) query.uniqueResult();
    }
}
