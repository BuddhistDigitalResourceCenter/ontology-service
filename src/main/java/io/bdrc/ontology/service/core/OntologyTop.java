package io.bdrc.ontology.service.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OntologyTop {

    @JsonProperty
    public String getName() {
        return Ontology.MODEL.getProfile().getLabel();
    }
    
    @JsonProperty
    public int getNumClasses() {
        return Ontology.MODEL.listClasses().toList().size();
    }
}
