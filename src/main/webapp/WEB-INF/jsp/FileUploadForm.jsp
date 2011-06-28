<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>
</head>

<body>
<h2>Color Palette upload</h2>

<form:form method="POST" commandName="fileUploadForm" enctype="multipart/form-data">

<form:errors path="*" cssClass="errorblock" element="div"/>
    <fieldset>
   

Please select a file to upload : <input type="file" name="file" /> <input type="submit" value="upload" />
   
	</fieldset>
<span><form:errors path="file" cssClass="error" /></span>


<%--
    <fieldset>
        <div class="form-row">
			<label for="themeId"><fmt:message key="palette.form.themeId"/>:</label>
			<span class="input"><form:select path="themeId" items="${themeList}"  /></span>
        </div>  
        <div class="form-buttons">
            <div class="button"><input name="submit" type="submit" value="<fmt:message key="button.search"/>" /></div>
        </div>
    </fieldset>
 --%>
</form:form>

</body>
</html>