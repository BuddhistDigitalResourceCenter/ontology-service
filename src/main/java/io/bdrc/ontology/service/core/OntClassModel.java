package io.bdrc.ontology.service.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.ontology.OntClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * This model is based on a URI for an OntClass in OntAccess.MODEL
 * 
 * @author chris
 *
 */
public class OntClassModel {
    static Logger log = LoggerFactory.getLogger(OntClassModel.class);

    protected String uri;
    protected OntClass clazz;
    
    public OntClassModel(String uri) {
        this.uri = uri;
        clazz = OntAccess.MODEL.getOntClass(uri);
        log.info("#### new OntClassModel( " + uri + " )");
    }
    
    public OntClassModel(OntClass c) {
        this.uri = c.getURI();;
        clazz = c;
    }

    @JsonGetter("id")
    public String getId() {
        log.info("######## OntClassModel.getId()");
        return OntAccess.MODEL.shortForm(uri);
    }

    @JsonGetter("ids")
    public List<String> getIds() {
        return OntAccess.getIds(uri);
    }
    
    @JsonGetter("subclasses")
    public List<OntClassModel> getSubclasses() {
        List<OntClass> subs = clazz.listSubClasses(true).toList();
        List<OntClassModel> models = new ArrayList<OntClassModel>();
        
        for (OntClass c : subs) {
            models.add(new OntClassModel(c));
        }
        
        return models;
    }
}
