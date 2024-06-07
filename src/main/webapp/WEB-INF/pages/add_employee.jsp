<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add Student</h2>
<form:form action="/employee/add" method="post" modelAttribute="employee">

    <fieldset class="form-group">
        <form:label path="name">Name</form:label>
        <form:input path="name" type="text" class="form-control" required="required" />
        <form:errors path="name" cssClass="text-warning" />
    </fieldset>

    <fieldset class="form-group">
        <form:label path="username">Username</form:label>
        <form:input path="username" type="text" class="form-control" required="required" />
        <form:errors path="username" cssClass="text-warning" />
    </fieldset>

    <fieldset class="form-group">
        <form:label path="cni">CNI</form:label>
        <form:input path="cni" type="text" class="form-control" required="required" />
        <form:errors path="cni" cssClass="text-warning" />
    </fieldset>

    <div class="form-group">
        <form:label path="cni">Project</form:label>
        <form:select class="form-control" id="skills" value="#{projects}" layout="pageDirection" required="true">
            <f:selectItems value="#{addEmployeeBean.availableSkills}" />
        </form:select>
    </div>

    <button type="submit" class="btn btn-success">Save</button>
</form:form>
</body>
</html>