package com.service;

import com.model.XmlData;

/**
 * Created by Edvard Piri on 12.11.2017.
 */
public interface XmlDataService {
    String findElemByUri(String xml);

    XmlData save(XmlData xmlData);

    XmlData getById(long id);
}
