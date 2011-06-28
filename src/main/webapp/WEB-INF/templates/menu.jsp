<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="side-bar">
    <a href="<c:url value="/"/>">Home</a>
    
    
    <p><fmt:message key="palette.form.title"/></p>
        <a href="<c:url value="/palette/form.html"/>"><fmt:message key="button.create"/></a> 
        <a href="<c:url value="/palette/advanceSearch.html"/>"><fmt:message key="button.search.adv"/></a>
        <a href="<c:url value="/palette/search.html"/>"><fmt:message key="button.search"/></a>
        <a href="<c:url value="/fileupload.html"/>"><fmt:message key="button.upload"/></a>
    <p><fmt:message key="theme.form.title"/></p>
        <a href="<c:url value="/theme/form.html"/>"><fmt:message key="button.create"/></a> 
        <a href="<c:url value="/theme/search.html"/>"><fmt:message key="button.search"/></a>
            
    
</div>
