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
        <h4>Labels: </h4><p><#list model.labels as label>${label}<#sep>,<br/><#else><p>No labels found.</#list></p>
        <h4>Comments:</h4>
        <#list model.comments as comment><p>${comment}</p><#else><p>No comments found.</#list></p>
        <#list model.otherProperties>
            <h4>Other Properties:</h4>
            <#items as property><p>${property.propertyId} ${property.object}</p></#items>
          <#else><p>No properties found.</p>
        </#list>
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