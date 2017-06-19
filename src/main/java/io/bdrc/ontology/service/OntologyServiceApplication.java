package io.bdrc.ontology.service;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.bdrc.ontology.service.core.Ontology;
import io.bdrc.ontology.service.resources.OntologyClassResource;
import io.bdrc.ontology.service.resources.OntologyResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

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
        bootstrap.addBundle(new ViewBundle<OntologyServiceConfiguration>());
    }

    @Override
    public void run(final OntologyServiceConfiguration config, final Environment env) {
        Ontology.init(config);
        env.jersey().register(new OntologyResource());
        env.jersey().register(new OntologyClassResource());
    }

}
