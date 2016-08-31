
<%@ page import="date_tests.DateStore" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dateStore.label', default: 'DateStore')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-dateStore" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-dateStore" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list dateStore">
			
				<g:if test="${dateStoreInstance?.fromClient}">
				<li class="fieldcontain">
					<span id="fromClient-label" class="property-label"><g:message code="dateStore.fromClient.label" default="From Client" /></span>
					<span class="property-value" aria-labelledby="fromClient-label">
                 <g:formatDate date="${dateStoreInstance?.fromClient}" format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" />
                 (${dateStoreInstance?.fromClient})
               </span>
				</li>
				</g:if>
			
				<g:if test="${dateStoreInstance?.fromClientUTC}">
				<li class="fieldcontain">
					<span id="fromClientUTC-label" class="property-label"><g:message code="dateStore.fromClientUTC.label" default="From Client UTC" /></span>
					<span class="property-value" aria-labelledby="fromClientUTC-label">
                 <g:formatDate date="${dateStoreInstance?.fromClientUTC}" format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" />
                 (${dateStoreInstance?.fromClientUTC})
               </span>
				</li>
				</g:if>
			
				<g:if test="${dateStoreInstance?.toUTC}">
				<li class="fieldcontain">
					<span id="toUTC-label" class="property-label"><g:message code="dateStore.toUTC.label" default="To UTC" /></span>
					<span class="property-value" aria-labelledby="toUTC-label">
                 <g:formatDate date="${dateStoreInstance?.toUTC}" format="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" />
                 (${dateStoreInstance?.toUTC})
               </span>
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:dateStoreInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${dateStoreInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
