package com.service;

import com.model.XmlRequest;
import com.model.XmlResponse;

/**
 * Created by Edvard Piri on 12.11.2017.
 */
public interface XmlRequestService {
     String getElemByUri(String xml);

//    String findElemByUri(String xml);

    XmlRequest save(XmlRequest xmlData);
//
//    XmlRequest getById(long id);
}
