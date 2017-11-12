package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Edvard Piri on 11.11.2017.
 */
@Entity
@Table(name = "XML_STORAGE")
public class XmlData extends BaseEntity {
    private Long id;
    private String xml;

    public XmlData() {
    }

    public XmlData(String data) {
        this.xml = data;
    }

    @Id
    @SequenceGenerator(name = "XML_SEQ", sequenceName = "XML_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "XML_SEQ")
    public Long getId() {
        return id;
    }


    @Column(name = "XML")
    @NotNull
    public String getXml() {
        return xml;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
