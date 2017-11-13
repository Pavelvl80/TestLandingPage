package com.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Edvard Piri on 11.11.2017.
 */
@Entity
//@Table(name = "XML_REQUEST)
public class XmlRequest extends BaseEntity {
    private Long id;
    private String requestName;
    private String message;

    public XmlRequest() {
    }

    public XmlRequest(String data) {
        this.message = data;
    }

//    @Id
//    @SequenceGenerator(name = "XML_REQUEST", sequenceName = "XML_REQUEST", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XML_REQUEST")
    public Long getId() {
        return id;
    }

//    @NotNull
    @XmlElement(name = "request")
//    @Column(name = "request")
    public String getMessage() {
        return message;
    }

//    @NotNull
    @XmlElement(name = "message")
//    @Column(name = "SPEC_ELEMENT")
    public String getRequestName() {
        return requestName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
