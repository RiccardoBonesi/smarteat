<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>
    <style>

        .mdl-card {
            width: 100%;
            height: 100%;
            color: white;
        }

    </style>
</head>
<body>

<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">Order List</span>

        </div>
    </header>
</div>

<main class="mdl-layout__content mdl-color--grey-100">
    <div class="mdl-grid demo-content">
        <s:iterator value="result" var="res">
            <div class="mdl-cell">
                <div class="demo-card mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title">
                        <h2 class="mdl-card__title-text">Table <s:property value="#res.tableNumber"/></h2>

                    </div>
                    <div class="mdl-card__supporting-text">
                        <b><h2 class="mdl-card__title-text">Date <s:date name="#res.date" format="dd/MM/yyyy"/></h2></b>
                        <s:iterator value="orderLines" var="line">
                            <s:property value="#line.quantity"/>
                            <s:property value="#line.dish.name"/><br>
                        </s:iterator>
                    </div>

                    <div class="mdl-card__actions mdl-card--border">
                        <s:url var="orderDetail" action="view_detail">
                            <s:param name="orderId" value="%{orderId}"/>
                        </s:url>
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                           href="${orderDetail}">
                            View Details
                        </a>
                    </div>
                </div>
            </div>
        </s:iterator>
    </div>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>