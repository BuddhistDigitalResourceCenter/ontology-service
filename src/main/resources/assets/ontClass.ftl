<#ftl encoding="utf-8">
<#-- @ftlvariable name="" type="io.bdrc.ontology.service.views.OntClassView" -->
<html>
    <head>
	  <title>Ontology Class - ${model.id}</title>
      <#-- link rel="stylesheet" href="/assets/pure-min.css" -->
	  <meta charset="UTF-8">
    </head>
    <body>
    	<#setting url_escaping_charset="UTF-8">
        <!-- calls getModel()... in OntClassView -->
        <h3>Ontology Class - ${model.id}</h3>
        <h4>Labels: </h4><p><#list model.labels as label>${label}<#sep>,<br/></#list></p>
        <h4>Comments:</h4>
        <#list model.comments as comment><p>${comment}</p></#list></p>
        <#list model.subclasses>
    	<h4>Subclasses:</h4>
        <ul>
          <#items as sub>
            <li><a href="/ontology/classes/${sub.uri?url}">${sub.id}</a></li>
          </#items>
        </ul>
        <#else>
        </#list>
	</body>
</html>