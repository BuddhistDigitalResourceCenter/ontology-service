<#-- @ftlvariable name="" type="io.bdrc.ontology.service.views.OntClassView" -->
<html>
    <head>
      <#-- link rel="stylesheet" href="/assets/pure-min.css" -->
	  <title>Ontology Class - ${model.id}</title>
    </head>
    <body>
    	<#setting url_escaping_charset="UTF-8">
        <!-- calls getModel()... in OntClassView -->
        <h3>Ontology Class - ${model.id}</h3>
    	<p>subclasses:</p>
        <ul>
          <#list model.subclasses as sub >
            <li><a href="/ontology/classes/${sub.uri?url}">${sub.id}</a></li>
          </#list>
        </ul>
	</body>
</html>