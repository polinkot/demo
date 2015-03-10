<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<ul>
    <li><a href="/">Home</a></li>
</ul>

<h1>Log in</h1>

<form role="form" action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table>
        <tr>
            <td><label for="email">Email address</label></td>
            <td><input type="email" name="email" id="email" required autofocus/></td>
        </tr>
        <tr>
            <td><label for="password">Password</label></td>
            <td><input type="password" name="password" id="password" required/></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Sign in</button></td>
        </tr>
    </table>
</form>

<#if error.isPresent()>
<p>The email or password you have entered is invalid, try again.</p>
</#if>
</body>
</html>