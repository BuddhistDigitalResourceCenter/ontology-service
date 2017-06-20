package io.bdrc.ontology.service.core;

import org.apache.jena.ontology.OntClass;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * This model is based on a URI for an OntAccess Class in OntAccess.MODEL
 * 
 * @author chris
 *
 */
public class OntClassModel {

    OntClass clazz;
    
    public OntClassModel(String uri) {
        clazz = OntAccess.MODEL.getOntClass(uri);
    }

    @JsonGetter("name")
    public String getName() {
        return clazz.getLocalName();
    }
}
