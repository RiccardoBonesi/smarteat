<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>
    <style>

        .mdl-table-space {
            height: auto;
            padding: 20px;
            background-color: #fafafa;
            text-align: left;
            vertical-align: middle;
        }

        .h1 {
            color: #666666;
            font-style: inherit;
        }

        .h3 {
            color: #999981;
            font-style: inherit;
        }

        .mdl-data-table{
            width: 100%;
        }


    </style>
</head>
<body>
<%--<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">Order List</span>
            <div class="mdl-layout-spacer"></div>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
                    <i class="material-icons">search</i>
                </label>
                <div class="mdl-textfield__expandable-holder">
                    <input class="mdl-textfield__input" type="text" id="search">
                    <label class="mdl-textfield__label" for="search">Enter your query...</label>
                </div>
            </div>
            <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
                <i class="material-icons">more_vert</i>
            </button>
            <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
                <li class="mdl-menu__item">About</li>
                <li class="mdl-menu__item">Contact</li>
                <li class="mdl-menu__item">Legal information</li>
            </ul>
        </div>
    </header>
</div>--%>

<main class="mdl-layout__content mdl-color--grey-100">
    <div class="mdl-table-space">
        <s:iterator value="order" var="res">
            <div class="mdl-grid">
                <div class=" mdl-cell mdl-cell--3-col">
                    <%--<h1>Order <s:property value="#res.orderId"/></h1>--%>
                    <h3>Table <s:property value="#res.tableNumber"/></h3>
                </div>
                <div class="mdl-cell mdl-cell--9-col">
                    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                        <thead>
                        <tr>
                            <th>Quantity</th>
                            <th class="mdl-data-table__cell--non-numeric">Dish</th>
                            <th class="mdl-data-table__cell--non-numeric">Price</th>
                            <th class="mdl-data-table__cell--non-numeric">Notes</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="orderLines" var="line">
                            <tr>
                                <td><s:property value="#line.quantity"/></td>
                                <td class="mdl-data-table__cell--non-numeric"><s:property value="#line.dish.name"/></td>
                                <td class="mdl-data-table__cell--non-numeric"><s:property value="#line.dish.price"/>
                                    &#8364;
                                </td>
                                <td class="mdl-data-table__cell--non-numeric"><s:property value="#line.notes"/></td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
        </s:iterator>

    </div>
    <%--<div class="mdl-grid demo-content">
        <s:iterator value="order" var="res">
            <div class="mdl-cell">
                <div class="demo-card mdl-card mdl-shadow--2dp mdl-grid--spacing">
                    <div class="mdl-card__title">
                        <h2 class="mdl-card__title-text">Order <s:property value="#res.orderId"/></h2>
                    </div>
                    <div class="mdl-card__supporting-text">
                        <table><tr><th>Quantity</th><th>Dish</th><th>Price</th><th>Notes</th></tr>
                        <s:iterator value="orderLines" var="line">
                        <tr><td><s:property value="#line.quantity"/></td>
                            <td><s:property value="#line.dish.name"/></td>
                            <td><s:property value="#line.dish.price"/> &#8364;</td>
                            <td><s:property value="#line.dish.notes"/></td></tr>
                        </s:iterator></table>
                    </div>
                </div>
            </div>
        </s:iterator>
    </div>--%>

    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>