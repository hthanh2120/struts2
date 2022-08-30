<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <style type="text/css">
        *, *:before, *:after {
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
        }

        body {
            font-family: 'Nunito', sans-serif;
            color: #384047;
        }

        table {
            width: 100%;
            margin: 10px auto;
            text-align: center;
        }

        th {
            font-weight: 400;
            background: #8a97a0;
            color: #FFF;
        }

        tr {
            background: #f4f7f8;
            border-bottom: 1px solid #FFF;
            margin-bottom: 5px;
        }

        tr:nth-child(even) {
            background: #e8eeef;
        }

        .container {
            text-align: center;
        }
    </style>
    <s:head />
</head>
<body>
<s:actionmessage/>
<s:actionerror/>
<table>
    <tr>
        <th>ID</th>
        <th>Client</th>
        <th>Amount</th>
        <th>Actions</th>
    </tr>
    <s:iterator value="lst">
        <tr>
            <td>${id}</td>
            <td><s:property value="clientName"/></td>
            <td>${amount}</td>
            <td class="button">
                <a href="order/${id}/edit">Edit</a> |
                <a href="order/${id}/del">Delete</a>
            </td>
        </tr>
    </s:iterator>
</table>
<div class="container">
    <a href="order/new">Create a new order</a>
</div>
</body>
</html>
