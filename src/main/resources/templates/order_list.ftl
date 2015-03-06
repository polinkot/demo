<div id="header">
    <h2>
        Order Report
    </h2>
</div>

<div id="content">
    <table class="datatable" border="0" style="border-spacing: 0;">
        <tbody>
        <tr>
            <th style="width: 50px; text-align: left;">Id</th>
            <th style="width: 150px; text-align: left;">Method</th>
            <th style="width: 100px; text-align: left;">Cost</th>
            <th style="width: 100px; text-align: left;">Original Array</th>
        </tr>
        <#list orderList as order>
        <tr>
            <td>${order.orderId}</td>
            <td>${order.sortType.name}</td>
            <td>${order.sortType.cost}</td>
            <td>
                <#list order.list as item>
                ${item},
                </#list>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>