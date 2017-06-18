package io.bdrc.ontology.service.resources;

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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.bdrc.ontology.service.core.OntologyTop;
import io.bdrc.ontology.service.views.OntoTopView;

@Path("/ontology")
@Produces(MediaType.APPLICATION_JSON)
public class OntologyResource {
    
    Logger log;
    
    OntologyTop ontology;
    
    public OntologyResource(OntologyTop top) {
        log = LoggerFactory.getLogger(this.getClass());
        this.ontology = top;
    }

    @GET
    public OntologyTop getOntology() {
        log.info("getOntology called");
        return ontology;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public OntoTopView getOntologyView() {
        log.info("getOntologyView called");
        return new OntoTopView(ontology);
    }
}
