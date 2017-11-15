package com.service;

import com.model.XmlRequest;
import com.model.XmlResponse;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by Edvard Piri on 14.11.2017.
 */

public interface XmlResponseService {
    String marshallXml(XmlResponse response) throws JAXBException;

    XmlResponse getByName(String name);

    XmlResponse saveAndSelect(XmlRequest xmlRequest);
}
