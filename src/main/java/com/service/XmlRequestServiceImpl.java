package com.service;

import com.dao.XmlRequestDao;
import com.dao.XmlResponseDao;
import com.exceptions.CustomXPathException;
import com.exceptions.DataBaseConnectionLostException;
import com.model.XmlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Edvard Piri on 11.11.2017.
 */
@Service
@Transactional(rollbackFor = DataBaseConnectionLostException.class, propagation = Propagation.REQUIRED)
public class XmlRequestServiceImpl implements XmlRequestService {

    @Value("${pathToElement}")
    private String path;

    @Autowired
    private XmlRequestDao xmlDataDao;

    @Autowired
    private XmlResponseDao xmlResponseDao;

    public String getElemByUri(String xml) {
        if(xml == null)
            return null;

        DocumentBuilder db;
        Document doc;
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = db.parse(is);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new CustomXPathException();
        }
        XPathExpression expr;
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        String result;
        try {
            expr = xpath.compile(path);
            if (doc == null) return null;
            result = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            throw new CustomXPathException();
        }
        return result;
    }


    @Override
    @Transactional(rollbackFor = DataBaseConnectionLostException.class)
    public XmlRequest save(XmlRequest xmlData) {
        if (xmlData == null)
            throw new DataBaseConnectionLostException();
        return xmlDataDao.save(xmlData);
    }
}
