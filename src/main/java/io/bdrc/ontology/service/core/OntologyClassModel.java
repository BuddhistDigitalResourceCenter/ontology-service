package io.bdrc.ontology.service.core;

import org.apache.jena.ontology.OntClass;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * This model is based on a URI for an Ontology Class in Ontology.MODEL
 * 
 * @author chris
 *
 */
public class OntologyClassModel {

    OntClass clazz;
    
    public OntologyClassModel(String uri) {
        clazz = Ontology.MODEL.getOntClass(uri);
    }

    @JsonGetter("name")
    public String getName() {
        return clazz.getLocalName();
    }
}
