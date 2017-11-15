package com.service;

import com.dao.XmlResponseDao;
import com.exceptions.BadRequestException;
import com.exceptions.DataBaseConnectionLostException;
import com.model.XmlRequest;
import com.model.XmlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.xml.bind.JAXBException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * Created by Edvard Piri on 14.11.2017.
 */
@Service
public class XmlResponseServiceImpl implements XmlResponseService {

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Autowired
    private XmlResponseDao xmlResponseDao;

    @Autowired
    private XmlRequestService xmlRequestService;

    public String marshallXml(XmlResponse response) throws JAXBException {
        StringWriter wr = new StringWriter();
        Result result = new StreamResult(wr);
        marshaller.marshal(response, result);
        return wr.toString();
    }

    @Override
    @Transactional(rollbackFor = DataBaseConnectionLostException.class)
    public XmlResponse getByName(String name) {
        if (name == null)
            throw new BadRequestException();
        XmlResponse xmlResponse = xmlResponseDao.getByName(name);
        if (xmlResponse == null)
            xmlResponse = xmlResponseDao.getById(1000L);
        if (xmlResponse == null)
            throw new DataBaseConnectionLostException();
        return xmlResponse;
    }

    @Override
    @Transactional(rollbackFor = DataBaseConnectionLostException.class)
    public XmlResponse saveAndSelect(XmlRequest xmlRequest) {
        xmlRequestService.save(xmlRequest);
        return getByName(xmlRequest.getMetaElementValue());
    }
}
