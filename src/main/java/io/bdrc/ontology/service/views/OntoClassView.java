package io.bdrc.ontology.service.views;

import io.bdrc.ontology.service.core.OntologyClassModel;
import io.dropwizard.views.View;

public class OntoClassView extends View {

    OntologyClassModel ocm;
    
    public OntoClassView(String uri) {
        super("/assets/ontoClass.ftl");
        // build OntologyClassModel from uri in Ontology.MODEL
    }

}
