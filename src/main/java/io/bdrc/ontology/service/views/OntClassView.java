package io.bdrc.ontology.service.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonGetter;

import io.bdrc.ontology.service.core.OntClassModel;
import io.dropwizard.views.View;

public class OntClassView extends View {
    static Logger log = LoggerFactory.getLogger(OntClassView.class);
    
    OntClassModel model;
    
    public OntClassView(String uri) {
        super("/assets/ontClass.ftl");
        model = new OntClassModel(uri);
        log.info(">>>> new OntClassView( " + uri + " )");
    }

    @JsonGetter("model")
    public OntClassModel getModel() {
        log.info(">>>>>>>> new OntClassView.getModel()");
        return model;
    }
}
