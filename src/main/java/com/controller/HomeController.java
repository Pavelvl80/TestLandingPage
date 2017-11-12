package com.controller;

import com.model.XmlData;
import com.service.XmlDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Edvard Piri on 11.11.2017.
 */
@RequestMapping("/index")
@Controller
public class HomeController {

    @Autowired
    XmlDataServiceImpl xmlDataService;


    @RequestMapping(value = "/send",
            method = RequestMethod.POST)
    public ResponseEntity<String> deleteMessage(@RequestBody String request) {
        String id = xmlDataService.findElemByUri(request);
        if (id == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        XmlData saved = xmlDataService.save(new XmlData(request));
        if (saved == null)
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);

        XmlData result = xmlDataService.getById(saved.getId());

        String response = result.getId() + result.getXml();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "xml"));

        return new ResponseEntity<>(response, header, HttpStatus.OK);
    }
}
