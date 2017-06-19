<#-- @ftlvariable name="" type="io.bdrc.ontology.service.views.OntoTopView" -->
<html>
    <head>
      <#-- link rel="stylesheet" href="/assets/pure-min.css" -->
	  <title>Ontology Top</title>
    </head>
    <body>
        <!-- calls getOntology().getName() and sanitizes it -->
        <h3>Ontology: ${ontology.name?html}</h3>
        <p>Retrieved from <a href="${ontology.rootURL}">${ontology.rootURL?html}</a></p>
        <p>Defines ${ontology.numClasses?html} Classes,
                   ${ontology.numObjectProperties?html} ObjectProperties,
                   ${ontology.numDatatypeProperties?html} DatatypeProperties,
                   ${ontology.numAnnotationProperties?html} AnnotationProperties.</p>
        <p>There are a total of ${ontology.numRootClasses?html} Root Classes.
        The ${ontology.numRootClasses - ontology.numBlankRootClasses} explicit classes are:</p>
        <ul>
          <#list ontology.rootClasses as clazz >
            <li><a href="/ontology/class/${clazz?html}">${clazz}</a></li>
          </#list>
        </ul>
    </body>
</html>