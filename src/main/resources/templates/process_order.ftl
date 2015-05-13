<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="demo.domain.OrderCreateForm" -->
<#-- @ftlvariable name="currentUser" type="demo.domain.CurrentUser" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create Order</title>
    <script src="/webjars/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>
<h1>Create Order</h1>

<h2 id="savedText"></h2>

<form role="form" name="form" action="" method="post" onsubmit="processOrder(); return false;">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="userId" id="userId" value="${currentUser.id}" required/>

    <table>
        <tr>
            <td><label for="list">List</label></td>
            <td><input type="text" name="list" id="list" value="${form.list}" required autofocus/></td>
        </tr>
        <tr>
            <td><label for="sortType">Sort Type</label></td>
            <td><input type="text" name="sortType" id="sortType" value="${form.sortType}" required/> (1,2 or 3)</td>
        </tr>
        <tr>
            <td><label for="result">Result</label></td>
            <td><input type="text" id="result" value="" disabled/></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit" id="save">Save</button>
            </td>
        </tr>
    </table>
</form>

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

<script language="JavaScript">
    function processOrder() {
        $.ajax({
            url: "/order/process",
            method: "POST",
            dataType: "JSON",
            Accept : "application/json",
            contentType: "application/json",
            data: JSON.stringify({
                list: $("#list").val(),
                sortType: $("#sortType").val(),
                userId: $("#userId").val()
            }),
            success: function (data) {
                $("#result").val(data.result);
                $("#list").prop("readonly", true);
                $("#sortType").prop("readonly", true);
                $("#sortType").prop("readonly", true);
                $("#save").prop("disabled", true);
            },
            error: function (data) {
                alert('Failed to load data!');
            }
        });
    }
</script>


