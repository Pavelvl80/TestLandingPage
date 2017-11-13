package com.model;

import javax.persistence.Entity;

/**
 * Created by Edvard Piri on 14.11.2017.
 */
@Entity
//@Table(XML_RESPONSE)
public class XmlResponse {
    private Long id;
    private String responseName;
    private String message;

    public XmlResponse() {
    }

    public XmlResponse(String name, String message) {
        this.responseName = name;
        this.message = message;
    }

    //    @Id
    //    @SequenceGenerator(request = "XML_RESPONSE", sequenceName = "XML_RESPONSE", allocationSize = 1)
    //    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XML_RESPONSE")
    public Long getId() {
        return id;
    }

//    @Column(name = "NAME")
    public String getResponseName() {
        return responseName;
    }

//    @Column(name = "MESSAGE")
    public String getMessage() {
        return message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResponseName(String responseName) {
        this.responseName = responseName;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
