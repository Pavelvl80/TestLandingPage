package com.dao;

import com.model.XmlData;

/**
 * Created by Edvard Piri on 12.11.2017.
 */
public interface XmlDataDao {

    XmlData save(XmlData xmlData);

    XmlData getById(long id);
}
