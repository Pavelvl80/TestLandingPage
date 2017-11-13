package com.dao;

import com.model.XmlRequest;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Edvard Piri on 12.11.2017.
 */

@Repository
@Transactional
public class XmlDataDaoImpl extends AbstractDAOImpl<XmlRequest> implements XmlDataDao {
//
//    @Override
//    public XmlRequest getById(long id) {
//        String hql = "from Xml_storage t where t.id = :id";
//        Query query = getSession().createQuery(hql);
//        query.setParameter("id", id);
//        return (XmlRequest) query.uniqueResult();
//    }
//
//    @Override
//    public XmlRequest getByName() {
//        return null;
//    }
//
//    @Override
//    public XmlRequest getAll() {
//        return null;
//    }
}
