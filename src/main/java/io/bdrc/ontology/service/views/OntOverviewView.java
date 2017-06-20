package io.bdrc.ontology.service.views;

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

import io.bdrc.ontology.service.core.OntOverviewModel;
import io.dropwizard.views.View;

public class OntOverviewView extends View {

    private OntOverviewModel top;
    
    public OntOverviewView(OntOverviewModel top) {
        super("/assets/ontOverview.ftl");
        this.top = top;
    }

    public OntOverviewModel getOntology() {
        return top;
    }
}
