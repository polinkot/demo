<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="demo.domain.OrderCreateForm" -->
<#-- @ftlvariable name="currentUser" type="demo.domain.CurrentUser" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create Order</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>
<h1>Create Order</h1>

<h2 id="savedText"></h2>

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
            <td><input type="text" name="sortType" id="sortType" value="${form.sortType}" required/> (1,2 or 3)</td>
        </tr>
        <tr>
            <td><label for="result">Result</label></td>
            <td><input type="text" id="result" value="" disabled/></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="button" onclick="processOrder();">Save</button>
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
    function getXmlHttp(){
        var xmlhttp;
        try {
            xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (E) {
                xmlhttp = false;
            }
        }
        if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
            xmlhttp = new XMLHttpRequest();
        }
        return xmlhttp;
    }

    function processOrder() {
        var j = {
            "list": document.getElementById("list").value,
            "sortType": document.getElementById("sortType").value,
            "userId": document.getElementById("userId").value
        };
        var f = JSON.stringify(j); // alert(f);

        var xmlhttp = getXmlHttp();
        xmlhttp.open('POST', '/order/process', true);
        xmlhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
                    var parsed = JSON.parse(xmlhttp.responseText);
                    document.getElementById("result").value = parsed.result;
                    document.getElementById("list").readOnly = true;
                    document.getElementById("sortType").readOnly = true;
                    document.getElementById("savedText").innerText = "Order processed!";
                }
            }
        };
        xmlhttp.send(f);
    }
</script>


