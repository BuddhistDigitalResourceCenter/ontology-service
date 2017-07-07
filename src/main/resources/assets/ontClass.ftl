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
        <!-- calls getModel() in OntClassView which returns OntClassModel -->
        <h3>Ontology Class - <a href="/ontology/classes/${model.uri?url}">${model.id}</a></h3>
   		<#if model.isPresent()>
	        <#if model.hasParent()><h4>Parent class: <a href="/ontology/classes/${model.parent.uri?url}">${model.parent.id}</a></h4></#if>
	        <h4>Labels: </h4><p><#list model.labels as label>${label}<#sep>,<br/><#else><p>No labels found.</#list></p>
	        <h4>Comments:</h4>
	        <#list model.comments as comment><div style="white-space: pre-wrap;">${comment}</div><#sep><hr/><#else><p>No comments found.</#list></p>
	        <#list model.otherProperties>
	            <h4>Other Properties:</h4>
	            <#items as stmt><p>${stmt.propertyId} 
					<#if stmt.objectHasUri()>
						<a href="/ontology/classes/${stmt.objectUri?url}">${stmt.object}</a>
					<#else>${stmt.object}</p>
					</#if>
				</#items>
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
		<#else>
			<p>This class is defined external to this ontology.</p>
		</#if>
	</body>
</html>