package io.bdrc.ontology.service.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.bdrc.ontology.service.OntologyServiceConfiguration;

public class OntAccess {

    public static void init(final OntologyServiceConfiguration config) {
        Logger log = LoggerFactory.getLogger(OntAccess.class);
        
        OntModel ontModel = null;
        CONFIG = config;
        
        try {
            InputStream stream = HttpFile.stream(config.getOwlURL());

            log.info("got stream for " + config.getOwlURL());
            
            Model m = ModelFactory.createDefaultModel();
            m.read(stream, "", "RDF/XML");
            stream.close();
            ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, m);
            Utils.removeIndividuals(ontModel);
            Utils.rdf10tordf11(ontModel);
            
            log.info("got OntModel for " + config.getOwlURL());

        } catch (IOException io) {
            log.error("Error initializing OntModel", io);
        }
        
        MODEL = ontModel;
    }
    
    public static OntModel MODEL;
    public static OntologyServiceConfiguration CONFIG;
    
    /**
     * Answer the prefix for the given URI, or null if there isn't one. If there is more than one, 
     * one of them will be picked. If possible, it will be the most recently added prefix. 
     * (The cases where it's not possible is when a binding has been removed.)
     * 
     * @param uri
     * @return
     */
    public static String getNsURIPrefix(String uri) {
        return MODEL.getNsURIPrefix(uri);
    }
    
    /**
     * Get the URI bound to a specific prefix, null if there isn't one.
     * 
     * @param pfx
     * @return
     */
    public static String getNsPrefixURI(String pfx) {
        return MODEL.getNsPrefixURI(pfx);
    }
    
    /**
     * List of all of the root OntClass(es) in the ontology - includes unions and so on that may have
     * been defined for object property domain or range purposes. These latter are blank nodes.
     * 
     * @return list of all of the root OntClass(es)
     */
    public static List<OntClass> getRootClasses() {
        List<OntClass> classes = MODEL.listHierarchyRootClasses().toList();
        return classes;
    }
    
    /**
     * Returns a list of simple root OntClass(es). Simple means not defined as a Union or Restriction
     * and so on. The purpose is to provide the roots of a traversal of classes defined in the ontology.
     * 
     * @return list of simple root OntClass(es)
     */    
    public static List<OntClass> getSimpleRootClasses() {
        List<OntClass> classes = MODEL.listHierarchyRootClasses().toList();
        List<OntClass> rez = new ArrayList<OntClass>();
        for (OntClass oc : classes) {
            if (oc.getURI() != null) {
                rez.add(oc);
            }
        }
        
        return rez;
    }
}
