package com.controller;

import com.exceptions.BadRequestException;
import com.exceptions.BaseException;
import com.model.XmlRequest;
import com.model.XmlResponse;
import com.service.XmlRequestService;
import com.service.XmlResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Edvard Piri on 11.11.2017.
 */
@Controller
public class HomeController {

    @Autowired
    private XmlRequestService xmlRequestService;

    @Autowired
    private XmlResponseService xmlResponseService;

    @RequestMapping("/")
    public ModelAndView homepage() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/request",
            method = RequestMethod.POST, headers = "content-type=application/xml")
    public ResponseEntity<String> XmlRequest(@RequestBody String xmlRequest) throws Exception {
        if (xmlRequest == null) throw new BadRequestException();

        String metaElement = xmlRequestService.getElemByUri(xmlRequest);
        if (metaElement == null) throw new BadRequestException();

        XmlResponse xmlResponse = xmlResponseService.saveAndSelect(new XmlRequest(metaElement, xmlRequest));

        String result = xmlResponseService.marshallXml(xmlResponse);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "xml"));

        return new ResponseEntity<>(result, header, HttpStatus.OK);

    }

    @ExceptionHandler({BaseException.class})
    public ModelAndView handleException(BaseException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("userMessage", e.getUserMessage());
        return modelAndView;
    }
}
