<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1><fmt:message key="theme.form.title"/></h1>

<c:if test="${not empty statusMessageKey}">
    <p><fmt:message key="${statusMessageKey}"/></p>
</c:if>

<c:url var="url" value="/theme/form.html" /> 
<form:form action="${url}" commandName="theme">
    <form:hidden path="themeId" /> 

    <fieldset>
        <div class="form-row">
            <label for="themeName"><fmt:message key="theme.form.themeName"/>:</label>
            <span class="input"><form:input path="themeName" /></span>
        </div>      
        <div class="form-row">
            <label for="description"><fmt:message key="theme.form.description"/>:</label>
            <span class="input"><form:input path="description" /></span>
        </div>            
        <div class="form-buttons">
            <div class="button"><input name="submit" type="submit" value="<fmt:message key="button.save"/>" /></div>
        </div>
    </fieldset>
</form:form>