package io.bdrc.ontology.service.core;

import java.io.IOException;
import java.io.InputStream;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.bdrc.ontology.service.OntologyServiceConfiguration;

public class Ontology {

    public static void init(final OntologyServiceConfiguration config) {
        Logger log = LoggerFactory.getLogger(Ontology.class);
        
        OntModel ontModel = null;
        
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
}
