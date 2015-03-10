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

    <div>
        <label for="list">List</label>
        <input type="text" name="list" id="list" value="${form.list}" required autofocus/>
    </div>
    <div>
        <label for="sortType">Sort Type</label>
        <input type="text" name="sortType" id="sortType" value="${form.sortType}" required/>
    </div>
    <input type="hidden" name="userId" id="userId" value="${currentUser.id}" required/>
    <button type="submit">Save</button>
</form>
<#else>
<div>
    <label for="list">List</label>
    <input type="text" name="list" id="list" value="${form.list}" readonly/>
</div>
<div>
    <label for="sortType">Sort Type</label>
    <input type="text" name="sortType" id="sortType" value="${form.sortType}" readonly/>
</div>
<div>
    <label for="result">Result</label>
    <input type="text" name="result" id="result" value="${form.result}" readonly/>
</div>
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