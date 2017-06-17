package io.bdrc.ontology.service;

import java.io.IOException;

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

import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.jena.atlas.logging.Log;
import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;    
import io.bdrc.ontology.service.api.HttpFile;
import io.bdrc.ontology.service.api.Utils;

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

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class OntologyServiceApplication extends Application<OntologyServiceConfiguration> {

    Logger log;
    
    public static void main(final String[] args) throws Exception {
        new OntologyServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "BDRC Ontology Service";
    }

    @Override
    public void initialize(final Bootstrap<OntologyServiceConfiguration> bootstrap) {
        log = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void run(final OntologyServiceConfiguration config, final Environment env) {
        try {
            InputStream stream = HttpFile.stream(config.getOwlURL());

            log.info("got stream for " + config.getOwlURL());
            
            Model m = ModelFactory.createDefaultModel();
            m.read(stream, "", "RDF/XML");
            stream.close();
            OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, m);
            Utils.removeIndividuals(ontModel);
            Utils.rdf10tordf11(ontModel);
            
            log.info("got OntModel for " + config.getOwlURL());

        } catch (IOException io) {

        }
    }

}
