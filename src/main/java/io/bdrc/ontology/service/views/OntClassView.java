package io.bdrc.ontology.service.views;

import io.bdrc.ontology.service.core.OntClassModel;
import io.dropwizard.views.View;

public class OntClassView extends View {
    
    public OntClassView(String uri) {
        super("/assets/ontClass.ftl");
        // build OntClassModel from uri in OntAccess.MODEL
    }

}
