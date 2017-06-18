package io.bdrc.ontology.service.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OntologyTop {

    @JsonProperty
    public String getName() {
        return Ontology.MODEL.listOntologies().toList().get(0).getLabel(null);
    }
    
    @JsonProperty
    public int getNumClasses() {
        return Ontology.MODEL.listClasses().toList().size();
    }
}
