package com.dao;

import com.model.XmlRequest;
import com.model.XmlResponse;

import java.util.List;

/**
 * Created by Edvard Piri on 14.11.2017.
 */
public interface XmlResponseDao {
    XmlResponse getByName(String name);

    XmlResponse getById(Long id);
}
