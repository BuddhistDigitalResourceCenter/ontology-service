<#-- @ftlvariable name="" type="io.bdrc.ontology.service.views.OntoTopView" -->
<html>
    <head>
      <#-- link rel="stylesheet" href="/assets/pure-min.css" -->
	  <title>Ontology Top</title>
    </head>
    <body>
        <!-- calls getOntology().getName() and sanitizes it -->
        <h3>Ontology: ${ontology.name?html}</h3>
        defines ${ontology.numClasses?html} classes.
    </body>
</html>