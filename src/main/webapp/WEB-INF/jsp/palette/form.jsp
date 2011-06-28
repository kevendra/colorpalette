<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1><fmt:message key="palette.form.title"/></h1>

<c:if test="${not empty statusMessageKey}">
    <p><fmt:message key="${statusMessageKey}"/></p>
</c:if>

<c:url var="url" value="/palette/form.html" /> 
<form:form action="${url}" commandName="palette">
    <form:hidden path="paletteId" /> 

    <fieldset>
        <div class="form-row">
			<label for="themeId"><fmt:message key="palette.form.themeId"/>:</label>
			<span class="input"><form:select path="themeId" items="${themeList}"  /></span>
        </div>       
    
        <div class="form-row">
            <label for="name"><fmt:message key="palette.form.name"/>:</label>
            <span class="input"><form:input path="name"/></span>
        </div>       
        <div class="form-row">
            <label for="value"><fmt:message key="palette.form.value"/>:</label>


            <span class="input"><form:input cssClass="color" path="value" onchange="
	document.getElementById('red').value = this.color.rgb[0]*100 + '%';
	document.getElementById('grn').value = this.color.rgb[1]*100 + '%';
	document.getElementById('blu').value = this.color.rgb[2]*100 + '%';
	document.getElementById('hue').value = this.color.hsv[0]* 60 + '&deg;';
	document.getElementById('sat').value = this.color.hsv[1]*100 + '%';
	document.getElementById('val').value = this.color.hsv[2]*100 + '%';"/></span>
	<!-- 
<span>R<input id="red" size="5"> </span><span> G<input id="grn" size="5"> </span> B<input id="blu" size="5">  - - -
H<input id="hue" size="5">  S<input id="sat" size="5">  V<input id="val" size="5">
                <script type="text/javascript">

     			</script>	     -->
            
        </div>
        <div class="form-buttons">
            <div class="button"><input name="submit" type="submit" value="<fmt:message key="button.save"/>" /></div>
        </div>
    </fieldset>
</form:form>