<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Order List</title>
    <script src="/webjars/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            loadList();
//            $('th').animate({
//                fontSize: '48px'
//            }, "slow");
        });
    </script>
</head>
<body>

<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>
<h1>Order List</h1>

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
    function loadList() {
        var url = "${userId}" ? '/order/list/${userId}' : '/order/list'; //alert(url);

        $.ajax({
            url: url,
            dataType: "JSON",
            Accept: "application/json",
            contentType: "application/json",
            success: function (data) {
                addRows(data);
            },
            error: function (data) {
                alert('Failed to load data!');
            }
        });
    }

    function addRows(rows) {
        for (i = 0; i < rows.length; i++) {
            var tr = "<tr><td>" + rows[i].orderId + "</td><td>" + rows[i].sortType.name + "</td><td>" + rows[i].sortType.cost + "</td><td>" + rows[i].list + "</td><td>" + rows[i].result + "</td></tr>";
            $('#orders').append(tr);
        }
    }
</script>