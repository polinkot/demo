<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Order Report</title>
</head>
<body onload="loadList();">

<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>
<h1>Order Report</h1>

<div id="content">
    <table class="datatable" id="orders" border="0" style="border-spacing: 0;">
        <tbody>
        <tr>
            <th style="width: 50px; text-align: left;">Id</th>
            <th style="width: 150px; text-align: left;">Method</th>
            <th style="width: 100px; text-align: left;">Cost</th>
            <th style="width: 200px; text-align: left;">Original&nbsp;Array</th>
            <th style="width: 200px; text-align: left;">Sorted&nbsp;Array</th>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>

<script language="JavaScript">
    function addRows(rows) {
        var table = document.getElementById("orders");
        for (i = 0; i < rows.length; i++) {
            var row = table.insertRow(table.rows.length);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            var cell4 = row.insertCell(3);
            var cell5 = row.insertCell(4);

            cell1.innerHTML = rows[i].orderId;
            cell2.innerHTML = rows[i].sortType.name;
            cell3.innerHTML = rows[i].sortType.cost;
            cell4.innerHTML = rows[i].list;
            cell5.innerHTML = rows[i].result;
        }
    }

    function getXmlHttp() {
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
        if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
            xmlhttp = new XMLHttpRequest();
        }
        return xmlhttp;
    }

    function loadList() {
        var url = "${userId}" ? '/order/list/${userId}' : '/order/list'; //alert(url);

        var xmlhttp = getXmlHttp();
        xmlhttp.open('GET', url, true);
        xmlhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
//                    alert(xmlhttp.responseText);
                    var parsed = JSON.parse(xmlhttp.responseText);
                    addRows(parsed);
                }
            }
        };
        xmlhttp.send(null);
    }
</script>