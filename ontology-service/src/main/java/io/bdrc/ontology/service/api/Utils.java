package io.bdrc.ontology.service.api;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.Restriction;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.vocabulary.OWL2;

public class Utils {
    
    public static void removeIndividuals(OntModel o) {
        ExtendedIterator<Individual> it = o.listIndividuals();
        while(it.hasNext()) {
            Individual i = it.next();
            if (i.getLocalName().equals("UNKNOWN")) continue;
            i.remove();
        }
    }

    // change Range Datatypes from rdf:PlainLitteral to rdf:langString
    public static void rdf10tordf11(OntModel o) {
        Resource RDFPL = o.getResource("http://www.w3.org/1999/02/22-rdf-syntax-ns#PlainLiteral");
        Resource RDFLS = o.getResource("http://www.w3.org/1999/02/22-rdf-syntax-ns#langString");
        ExtendedIterator<DatatypeProperty> it = o.listDatatypeProperties();
        while(it.hasNext()) {
            DatatypeProperty p = it.next();
            if (p.hasRange(RDFPL)) {
                p.removeRange(RDFPL);
                p.addRange(RDFLS);
            }
        }
        ExtendedIterator<Restriction> it2 = o.listRestrictions();
        while(it2.hasNext()) {
            Restriction r = it2.next();
            Statement s = r.getProperty(OWL2.onDataRange); // is that code obvious? no
            if (s != null && s.getObject().asResource().equals(RDFPL)) {
                s.changeObject(RDFLS);

            }
        }
    }

}
