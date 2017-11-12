package com.service;

import com.model.XmlData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
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
public class XmlDataServiceImpl implements XmlDataService {

    @Value("${pathToElement}")
    private String path;

    public String findElemByUri(String xml) {

        DocumentBuilder db;
        Document doc = null;
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = db.parse(is);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
//        InputSource is = new InputSource();
//        is.setCharacterStream(new StringReader(xml));
//        Document doc = db.parse(is);
        XPathExpression expr;
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        String result = null;
        try {
            expr = xpath.compile(path);
            if (doc == null) return null;
            result = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        return result;
    }

    @Override
    public XmlData save(XmlData xmlData) {
        return null;
    }

    @Override
    public XmlData getById(long id) {
        return null;
    }
}
