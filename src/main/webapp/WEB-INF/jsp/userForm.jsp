<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="user==null || user.employeeId == null">
    <s:set name="title" value="%{'Add new user'}"/>
</s:if>
<s:else>
    <s:set name="title" value="%{'Update user'}"/>
</s:else>

<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title>
        <s:property value="#title"/>
    </title>
</head>
<body>
<div class="titleDiv">
    <s:text name="application.title"/>
</div>
<span> You are logged as <s:text name="currentUser.role"/> <s:text name="currentUser.fullName"/> ,</span>
<s:url id="url" action="goaway" />
<a href="<s:property value="#url"/>">logout</a>
<h1>
    <s:property value="#title"/>
</h1>
<s:actionerror/>
<s:actionmessage/>
<s:form action="saveUser" method="post">
    <s:textfield name="user.fullName" value="%{user.fullName}" label="%{getText('label.fullName')}" size="40"/>
    <s:textfield name="user.email" value="%{user.email}" label="%{getText('label.email')}" size="40"/>
    <s:textfield name="user.password" value="%{user.password}" label="%{getText('label.password')}" size="20"/>
    <s:textfield name="user.age" value="%{user.age}" label="%{getText('label.age')}" size="20"/>
    <s:if test='currentUser.role.toString() == "ADMIN"'>
        <s:textfield name="user.role" value="%{user.role}" label="%{getText('label.role')}" size="20"/>
        <s:textfield name="user.login" value="%{user.login}" label="%{getText('label.login')}" size="20"/>
    </s:if>
    <s:hidden name="user.employeeId" value="%{user.employeeId}"/>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" action="index"/>
</s:form>
</body>
</html>