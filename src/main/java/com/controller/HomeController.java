package com.controller;

import com.model.XmlRequest;
import com.service.XmlDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

//    @RequestMapping
//    public String homeController() {
//        return "home";
//    }
    //MainRequest


    @RequestMapping(value = "/save",
            method = RequestMethod.POST, headers = "content-type=application/xml")
    public ResponseEntity<String> deleteMessage(@RequestBody XmlRequest xmlRequest) {

        xmlRequest.getRequestName();
//        String id = xmlDataService.findElemByUri(request);
//        if (id == null)
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        XmlRequest saved = xmlDataService.save(new XmlRequest(request));
//        if (saved == null)
//            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
//
//        XmlRequest result = xmlDataService.getById(saved.getId());
//
//        String response = result.getId() + result.getMessage();
//
//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(new MediaType("application", "xml"));

        if (xmlRequest.getRequestName() == null || xmlRequest.getMessage() == null)
            return null;

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
