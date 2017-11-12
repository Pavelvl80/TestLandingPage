package com.controller;

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


    @RequestMapping(value = "/send",
            method = RequestMethod.POST)
    public ResponseEntity<String> deleteMessage(@RequestBody String request) {
        String someCase = xmlDataService.findElemByUri(request);
        if (someCase == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        //save

        //xmlDataService.findByID(id)

        return new ResponseEntity<>("good", HttpStatus.OK);
    }
}
