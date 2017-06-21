<#-- @ftlvariable name="" type="io.bdrc.ontology.service.views.OntOverviewView" -->
<html>
    <head>
      <#-- link rel="stylesheet" href="/assets/pure-min.css" -->
	  <title>Ontology - ${ontology.name?html}</title>
    </head>
    <body>
    	<#setting url_escaping_charset="UTF-8">
        <!-- calls getOntology()... in OntOverviewView -->
        <h3>Ontology - ${ontology.name?html}</h3>
        <p>Retrieved from <a href="${ontology.rootURL}">${ontology.rootURL?html}</a></p>
        <p>Defines ${ontology.numPrefixes} prefixes,
                   ${ontology.numClasses} Classes
                   ${ontology.numObjectProperties} ObjectProperties,
                   ${ontology.numDatatypeProperties} DatatypeProperties,
                   ${ontology.numAnnotationProperties} AnnotationProperties.</p>
        <p>There are ${ontology.numRootClasses} simple root OntClass(es):</p>
        <ul>
          <#list ontology.rootClasses as root >
            <li><a href="/ontology/classes/${root.uri?url}">${root.id}</a></li>
          </#list>
        </ul>
    </body>
</html>