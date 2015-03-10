<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="demo.domain.CurrentUser" -->
<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<nav role="navigation">
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
        <li><a href="/user/create">Register</a></li>
    </#if>
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <li><a href="/orders">View orders</a></li>
        <li><a href="/order/process">New order</a></li>
    </#if>
    <#if currentUser?? && currentUser.role == "ADMIN">
    </#if>
    </ul>
</nav>
</body>
</html>