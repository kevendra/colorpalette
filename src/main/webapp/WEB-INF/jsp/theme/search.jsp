<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1><fmt:message key="theme.search.title"/></h1>

<table class="search">
    <tr>
        <th><fmt:message key="theme.form.themeName"/></th>
        <th><fmt:message key="theme.form.description"/></th>
        <th>Action</th>
    </tr>
<c:forEach var="theme" items="${themes}" varStatus="status">
    <tr>
        <c:set var="themeFormId" value="theme${status.index}"/>

        <c:url var="editUrl" value="/theme/form.html">
            <c:param name="id" value="${theme.themeId}" />
        </c:url>
        
        <c:url var="deleteUrl" value="/theme/delete.html"/>        
        <form id="${themeFormId}" action="${deleteUrl}" method="POST">
            <input id="id" name="id" type="hidden" value="${theme.themeId}"/>
        </form>

    	<td> ${theme.themeName} </td>
        <td>${theme.description}</td> 
    	<td>
            <a href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
            <a href="javascript:document.forms['${themeFormId}'].submit();"><fmt:message key="button.delete"/></a> 
        </td>
    </tr>
</c:forEach>
</table>