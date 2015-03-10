<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Order Report</title>
</head>
<body>

<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>
<h1>Order Report</h1>

<div id="content">
    <table class="datatable" border="0" style="border-spacing: 0;">
        <tbody>
        <tr>
            <th style="width: 50px; text-align: left;">Id</th>
            <th style="width: 150px; text-align: left;">Method</th>
            <th style="width: 100px; text-align: left;">Cost</th>
            <th style="width: 200px; text-align: left;">Original&nbsp;Array</th>
            <th style="width: 100px; text-align: left;">Sorted&nbsp;Array</th>
        </tr>
        <#list orderList as order>
        <tr>
            <td>${order.orderId}</td>
            <td>${order.sortType.name}</td>
            <td>${order.sortType.cost}</td>
            <td>${order.list}</td>
            <td>${order.result}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>

</body>
</html>