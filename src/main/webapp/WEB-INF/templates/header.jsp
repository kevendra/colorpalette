<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<fmt:message key="site.title"/>
<%--
    <div align="right">
        <fmt:message key="button.locale"/>:
            <c:url var="englishLocaleUrl" value="/index.html">
                <c:param name="locale" value="" />
            </c:url>
            <c:url var="hindiLocaleUrl" value="/index.html">
                <c:param name="locale" value="hi" />
            </c:url>
        
            <a href='<c:out value="${englishLocaleUrl}"/>'><fmt:message key="locale.english"/></a>
            <a href='<c:out value="${hindiLocaleUrl}"/>'><fmt:message key="locale.hindi"/></a>
    </div>
     --%>