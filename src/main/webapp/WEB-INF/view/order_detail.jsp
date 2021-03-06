<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>
    <style>

        #promos {
            margin-top: 30px;
        }

        th {
            width: 25%;
        }

        .mdl-table-space {
            height: auto;
            padding: 20px;
            background-color: #fafafa;
            text-align: left;
            vertical-align: middle;
        }

        .mdl-data-table {
            width: 100%;
        }

        .allwhite:hover {
            background-color: unset !important;
        }

        #sposta_parent {
            position: relative;
        }


    </style>
</head>
<body>

<main class="mdl-layout__content mdl-color--grey-100">
    <div class="mdl-table-space">
        <s:iterator value="order" var="res">
            <div class="mdl-grid">
                <div id="sposta_parent" class=" mdl-cell mdl-cell--3-col">
                    <div>
                        <h3>Table <s:property value="#res.tableNumber"/></h3>
                    </div>
                    <div>
                        <h4>Total: <s:property value="#res.amount"/> &#8364; </h4>
                    </div>
                    <s:url var="orderCheckout" action="checkout">
                        <s:param name="orderId" value="%{orderId}"/>
                    </s:url>
                    <div>
                        <a class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-color--green-600 mdl-color-text--white"
                           href="${orderCheckout}">
                            Checkout
                        </a>
                    </div>

                </div>
                <div class="mdl-cell mdl-cell--9-col">
                    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp table-hover">
                            <%--<s:if test="%{orderLines != null && !orderLines.isEmpty()}">--%>
                        <s:if test="%{dishes}">
                            <thead>
                            <tr>
                                <th>Quantity</th>
                                <th class="mdl-data-table__cell--non-numeric">Dish</th>
                                <th class="mdl-data-table__cell--non-numeric">Price</th>
                                <th class="mdl-data-table__cell--non-numeric">Notes</th>
                            </tr>
                            </thead>
                            <s:iterator value="orderLines" var="line">
                                <s:if test="%{#line.promotion == null}">
                                    <tbody>
                                    <tr class="allwhite">
                                        <td><s:property value="#line.quantity"/></td>
                                        <td class="mdl-data-table__cell--non-numeric"><s:property
                                                value="#line.dish.name"/></td>
                                        <td class="mdl-data-table__cell--non-numeric">
                                            <s:property value="#line.dish.price"/> &#8364;
                                        </td>
                                        <td class="mdl-data-table__cell--non-numeric"><s:property
                                                value="#line.notes"/></td>
                                    </tr>

                                    </tbody>
                                </s:if>
                            </s:iterator>
                        </s:if>
                    </table>
                    <!-- table for promotions -->
                    <table id="promos" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp table-hover">
                        <s:if test="%{resultPromos != null && !resultPromos.isEmpty()}">
                            <thead>
                            <tr>
                                <th>Quantity</th>
                                <th class="mdl-data-table__cell--non-numeric">Promo</th>
                                <th class="mdl-data-table__cell--non-numeric">Price</th>
                                <th class="mdl-data-table__cell--non-numeric">Description</th>
                            </tr>
                            </thead>
                            <s:iterator value="resultPromos" var="promo">
                                <tbody>

                                <tr class="allwhite">
                                    <td><s:property value="#promo.quantity"/></td>
                                    <td class="mdl-data-table__cell--non-numeric ">
                                        <s:property value="#promo.name"/>
                                    </td>
                                    <td class="mdl-data-table__cell--non-numeric">
                                        <s:property value="#promo.price"/> &#8364;
                                    </td>
                                    <td class="mdl-data-table__cell--non-numeric ">
                                        <s:property value="#promo.description"/>
                                    </td>
                                </tr>
                                </tbody>
                            </s:iterator>
                        </s:if>
                    </table>
                </div>
            </div>
        </s:iterator>
    </div>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>