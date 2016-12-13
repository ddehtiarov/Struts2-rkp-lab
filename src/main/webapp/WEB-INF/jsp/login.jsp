<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="title" value="%{'Login'}"/>

<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td{ white-space:nowrap; }</style>
    <title>
        <s:property value="#title"/>
    </title>
</head>
<body>
<div class="titleDiv">
    <s:text name="application.title"/>
</div>
<h1>
    <s:property value="#title"/>
</h1>
<s:actionerror/>
<s:actionmessage/>
<s:form action="login" method="post">
    <s:textfield name="user.login" value="%{user.login}" label="%{getText('label.login')}" size="20"/>
    <s:textfield name="user.password" value="%{user.password}" label="%{getText('label.password')}" size="20"/>
    <s:submit value="%{getText('button.label.login')}"/>
    <s:submit value="%{getText('button.label.register')}" action="register"/>

    <s:hidden name="currentUser.employeeId" value="%{currentUser.employeeId}"/>
</s:form>
</body>
</html>