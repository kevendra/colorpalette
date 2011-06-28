<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1><fmt:message key="palette.search.title"/></h1>

<table >
    <tr>
        <th><fmt:message key="palette.form.themeId"/></th>
        <th><fmt:message key="palette.form.name"/></th>
        <th><fmt:message key="palette.form.value"/></th>
        <th><fmt:message key="palette.form.color"/></th> 
        <th>Action</th>       
    </tr>
<c:forEach var="palette" items="${palettes}" varStatus="status">
    <tr>
        <c:set var="paletteFormId" value="palette${status.index}"/>

        <c:url var="editUrl" value="/palette/form.html">
            <c:param name="id" value="${palette.paletteId}" />
        </c:url>
        
        <c:url var="deleteUrl" value="/palette/delete.html"/>        
        <form id="${paletteFormId}" action="${deleteUrl}" method="POST">
            <input id="id" name="id" type="hidden" value="${palette.paletteId}"/>
        </form>

    	<td> ${palette.themeId} </td>
    	<td> ${palette.name} </td>
        <td>${palette.value}</td> 
        <td bgcolor="#${palette.value}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
    	<td>
            <a href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
            <a href="javascript:document.forms['${paletteFormId}'].submit();"><fmt:message key="button.delete"/></a> 
        </td>
    </tr>
</c:forEach>
</table>