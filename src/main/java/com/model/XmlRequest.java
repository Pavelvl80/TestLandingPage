package com.model;

import javax.persistence.*;

/**
 * Created by Edvard Piri on 11.11.2017.
 */
@Entity
//@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "XML_REQUEST")
public class XmlRequest extends BaseEntity {
    private Long id;
    private String metaElementValue;
    private String fullRequest;

    public XmlRequest() {
    }

    public XmlRequest(String metaElementValue, String fullRequest) {
        this.metaElementValue = metaElementValue;
        this.fullRequest = fullRequest;
    }

    @Id
    @SequenceGenerator(name = "XML_REQUEST_SEQ", sequenceName = "XML_REQUEST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XML_REQUEST_SEQ")
    public Long getId() {
        return id;
    }

    @Column(name = "META_ELEMENT_VALUE")
    public String getMetaElementValue() {
        return metaElementValue;
    }

    @Column(name = "FULL_REQUEST")
    public String getFullRequest() {
        return fullRequest;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMetaElementValue(String metaElementValue) {
        this.metaElementValue = metaElementValue;
    }

    public void setFullRequest(String fullRequest) {
        this.fullRequest = fullRequest;
    }
}
