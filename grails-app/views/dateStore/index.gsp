
<%@ page import="date_tests.DateStore" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dateStore.label', default: 'DateStore')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dateStore" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-dateStore" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="fromClient" title="${message(code: 'dateStore.fromClient.label', default: 'From Client')}" />
					
						<g:sortableColumn property="fromClientUTC" title="${message(code: 'dateStore.fromClientUTC.label', default: 'From Client UTC')}" />
					
						<g:sortableColumn property="toUTC" title="${message(code: 'dateStore.toUTC.label', default: 'To UTC')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${dateStoreInstanceList}" status="i" var="dateStoreInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${dateStoreInstance.id}">${fieldValue(bean: dateStoreInstance, field: "fromClient")}</g:link></td>
					
						<td><g:formatDate date="${dateStoreInstance.fromClientUTC}" /></td>
					
						<td><g:formatDate date="${dateStoreInstance.toUTC}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${dateStoreInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
