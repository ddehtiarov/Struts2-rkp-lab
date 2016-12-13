<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title>
        <s:text name="label.employees"/>
    </title>
</head>
<body>
<div class="titleDiv">
    <s:text name="application.title"/>
</div>
<br/>
<span> You are logged as <s:text name="currentUser.role"/> <s:text name="currentUser.fullName"/> ,</span>
<s:url id="url" action="goaway"/>
<a href="<s:property value=" #url"/>">logout</a>


<h1>
    <s:text name="label.employees"/>
</h1>
<s:if test='currentUser.role.toString() =="ADMIN"'>
    <s:url id="url" action="inputUser"/>
    <a href="<s:property value=" #url"/>">Add New User</a>
</s:if>
<br/>
<table class="borderAll">
    <tr>
        <th>
            <s:text name="label.login"/>
        </th>
        <th>
            <s:text name="label.fullName"/>
        </th>
        <th>
            <s:text name="label.email"/>
        </th>
        <th>
            <s:text name="label.age"/>
        </th>
        <th>
            <s:text name="label.role"/>
        </th>
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="users" status="status">
        <tr class="<s:if test=" #status.even
        ">even</s:if>
        <s:else>odd</s:else>
        ">
        <td class="nowrap">
            <s:property value="login"/>
        </td>
        <td class="nowrap">
            <s:property value="fullName"/>
        </td>
        <td class="nowrap">
            <s:property value="email"/>
        </td>
        <td class="nowrap">
            <s:property value="age"/>
        </td>
        <td class="nowrap">
            <s:property value="role"/>
        </td>
        <s:if test='currentUser.role.toString() =="ADMIN" || currentUser.login==login'>
            <td class="nowrap">
                <s:url action="inputUser" id="url">
                    <s:param name="user.employeeId" value="employeeId"/>
                </s:url>
                <a href="<s:property value=" #url"/>">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <s:if test='currentUser.role.toString() =="ADMIN" && currentUser.login!=login'>
                    <s:url action="deleteUser" id="url">
                        <s:param name="user.employeeId" value="employeeId"/>
                    </s:url>
                    <a href="<s:property value=" #url"/>">Delete</a>
                </s:if>
            </td>
        </s:if>
        </tr>
    </s:iterator>
</table>
</body>
</html>