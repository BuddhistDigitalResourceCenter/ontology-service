package io.bdrc.ontology.service.core;

/*******************************************************************************
 * Copyright (c) 2017 Buddhist Digital Resource Center (BDRC)
 * 
 * If this file is a derivation of another work the license header will appear below; 
 * otherwise, this work is licensed under the Apache License, Version 2.0 
 * (the "License"); you may not use this file except in compliance with the License.
 * 
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.ontology.OntClass;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * A model class for the top-level of the ontology(s). The idea is to provide an entry point
 * to the ontology that provides some basic information and navigational links into to ontology
 * 
 * @author chris
 *
 */
public class OntologyTop {

    @JsonGetter("name")
    public String getName() {
        return Ontology.MODEL.listOntologies().toList().get(0).getLabel(null);
    }

    @JsonGetter("numOntologies")
    public int getNumOntologies() {
        return Ontology.MODEL.listOntologies().toList().size();
    }
    
    @JsonGetter
    public String getRootURL() {
        return Ontology.CONFIG.getOwlURL();
    }
    
    @JsonGetter
    public int getNumClasses() {
        return Ontology.MODEL.listClasses().toList().size();
    }
    
    @JsonGetter
    public int getNumAnnotationProperties() {
        return Ontology.MODEL.listAnnotationProperties().toList().size();
    }
    
    @JsonGetter
    public int getNumObjectProperties() {
        return Ontology.MODEL.listObjectProperties().toList().size();
    }
    
    @JsonGetter
    public int getNumDatatypeProperties() {
        return Ontology.MODEL.listDatatypeProperties().toList().size();
    }
    
    @JsonGetter
    public int getNumRootClasses() {
        return Ontology.MODEL.listHierarchyRootClasses().toList().size();
    }
    
    @JsonGetter
    public int getNumBlankRootClasses() {
        int blanks = 0;
        List<OntClass> classes = Ontology.MODEL.listHierarchyRootClasses().toList();
        for (OntClass oc : classes) {
            String id = oc.getURI();
            if (id == null) {
                blanks++;
            }
        }
        return blanks;
    }
    
    @JsonGetter
    public List<String> getRootClasses() {
        List<OntClass> classes = Ontology.MODEL.listHierarchyRootClasses().toList();
        List<String> classNames = new ArrayList<String>();
        for (OntClass oc : classes) {
            String id = oc.getURI();
            if (id != null) {
                classNames.add(id);
            }
        }
        
        return classNames;
    }
}
