<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="demo.domain.OrderCreateForm" -->
<#-- @ftlvariable name="currentUser" type="demo.domain.CurrentUser" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<#if !form.saved>
<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="userId" id="userId" value="${currentUser.id}" required/>

    <table>
        <tr>
            <td><label for="list">List</label></td>
            <td><input type="text" name="list" id="list" value="${form.list}" required autofocus/></td>
        </tr>
        <tr>
            <td><label for="sortType">Sort Type</label></td>
            <td><input type="text" name="sortType" id="sortType" value="${form.sortType}" required/></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Save</button>
            </td>
        </tr>
    </table>
</form>
<#else>
<table>
    <tr>
        <td><label for="list">List</label></td>
        <td><input type="text" name="list" id="list" value="${form.list}" readonly/></td>
    </tr>
    <tr>
        <td><label for="sortType">Sort Type</label></td>
        <td><input type="text" name="sortType" id="sortType" value="${form.sortType}" readonly/></td>
    </tr>
    <tr>
        <td><label for="result">Result</label></td>
        <td><input type="text" name="result" id="result" value="${form.result}" readonly/></td>
    </tr>
</table>
</#if>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>