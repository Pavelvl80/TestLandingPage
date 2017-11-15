package com.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Created by Edvard Piri on 14.11.2017.
 */
@Entity
@Table(name = "XML_RESPONSE")
@XmlType(propOrder = {"responseName", "message"})
@XmlRootElement(name = "response")
public class XmlResponse extends BaseEntity {
    private Long id;
    private String responseName;
    private String message;

    public XmlResponse() {
    }

    public XmlResponse(String name, String message) {
        this.responseName = name;
        this.message = message;
    }

    @Id
    @SequenceGenerator(name = "XML_RESPONSE_SEQ", sequenceName = "XML_RESPONSE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XML_RESPONSE_SEQ")
    @XmlTransient
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    @XmlElement(name = "name")
    public String getResponseName() {
        return responseName;
    }

    @Column(name = "MESSAGE")
    @XmlElement(name = "message")
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
