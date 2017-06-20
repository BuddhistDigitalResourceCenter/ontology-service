<#-- @ftlvariable name="" type="io.bdrc.ontology.service.views.OntClassView" -->
<html>
    <head>
      <#-- link rel="stylesheet" href="/assets/pure-min.css" -->
	  <title>Ontology Class</title>
    </head>
    <body>
    	<#setting url_escaping_charset="UTF-8">
        <!-- calls getModel()... in OntClassView -->
        <h3>${model.id}</h3>
    	<p>subclasses:</p>
        <ul>
          <#list model.subclasses as ids >
            <li><a href="/ontology/classes/${ids[0]?url}">${ids[1]}</a></li>
          </#list>
        </ul>
	</body>
</html>