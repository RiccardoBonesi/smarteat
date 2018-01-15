<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>

        #addbutton {
            position: absolute;
            margin: auto;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            height: 75px;
            width: 75px;
        }

        .mdl-cell--stretch {
            height: 250px;
        }

        #piu {
            font-size: 60px;
        }

        .mdl-data-table {
            background-color: rgb(64, 196, 255);
        }

        .center-div {
            position: absolute;
            margin: auto;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            width: 25%;
            height: 21%;

        }

        .material-icons.mdl-48 {
            position: absolute;
            margin: auto;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            font-size: 72px;
        }

        .child {
            position: absolute;
            bottom: 0px;
            padding: 15px;
        }

        .mdl-card-wide {
            width: 100%;
            height: 100%;
            padding: 15px;
            background-color: #fafafa;
            text-align: left;
            position: relative;
        }

        .mdl-sheet__container {
            position: fixed;
            right: 32px;
            bottom: 32px;
            transform: rotate(0deg);
            height: auto;
            z-index: 900;
        }

        .setAlign {

            align-content: center;
            height: auto;
        }

        .header {
            position: relative;
        }

        /* positions header-content at the bottom of header's context */
        .header-content {
            position: absolute;
            bottom: 0;
        }

        .aParent {
            float: left;
            clear: none;
        }

        #addDishpromo {
            align-content: center;
        }

    </style>
    <script type="text/javascript">
        if (${show}) {
            r(function () {
                var notification = document.querySelector('.mdl-js-snackbar');
                notification.MaterialSnackbar.showSnackbar(
                    {
                        message: 'You can\'t delete this promotion! A ordination is using it!'
                    }
                );
            });

            function r(f) {
                /in/.test(document.readyState) ? setTimeout('r(' + f + ')', 9) : f()
            }


            //alert("Cannot delete promotion since there are some orders linked to that promotion. Please delete that orders and retry. ")
        }
    </script>


</head>
<body>

<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">Active Promotion</span>
            <div class="mdl-layout-spacer"></div>

            <s:form action="search_promotion" method="post">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                    <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
                        <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                        <input class="mdl-textfield__input" type="text" id="search" name="promotionName"
                               placeholder="Search promotion">
                        <label class="mdl-textfield__label"></label>
                    </div>
                </div>
            </s:form>

        </div>
    </header>
</div>


<main class="mdl-layout__content">


    <div class="mdl-sheet__container">
        <%--create promo--%>
        <s:form action="create_promotion" method="post">
        <button id="show-dialog"
                class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored  mdl-button--raised mdl-color-text--white">
            <i class="material-icons">add</i>
            </s:form>

        </button>
    </div>


    <%--<s:if test="show">--%>
    <div id="demo-snackbar-example" class="mdl-js-snackbar mdl-snackbar">
        <div class="mdl-snackbar__text"></div>
        <button class="mdl-snackbar__action" type="button"></button>
    </div>


    <%--</s:if>--%>
    <%--<div class="demo-list-icon mdl-list">--%>
    <div class="mdl-grid">
        <s:iterator value="result" var="resPromotion">
            <div class="mdl-card-wide mdl-shadow--2dp mdl-color-text--white mdl-color--light-blue-A200"
                 style="width: 100%; background-color: #999999">
                <s:url var="promotionDelete" action="deletePromotion">
                    <s:param name="promotionId" value="%{promotionId}"/>
                </s:url>
                <table class="mdl-data-table mdl-js-data-table " style="border: none">
                    <thead>
                    <tr>
                        <th style="padding-bottom: 18px;">

                            <a class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-color-text--white"
                               href="${promotionDelete}">
                                <i class="material-icons">clear</i></a>
                        </th>

                        <th>
                            <h3><s:property value="#resPromotion.name"/></h3>
                        </th>
                    </tr>
                    </thead>
                </table>
                    <%--<s:textfield name="some_name" value="%{show}"/>--%>

            </div>

            <s:iterator value="dishes" var="resDish" status="incr">

                <div class="mdl-cell--stretch mdl-cell mdl-cell--4-col">

                    <div class="mdl-card-wide mdl-shadow--2dp">

                        <s:url var="dishDelete" action="deleteDishPromotion">
                            <s:param name="dishId" value="%{dishId}"/>
                            <s:param name="promotionId" value="%{promotionId}"/>
                        </s:url>

                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text"><s:property value="#resDish.name"/></h2>
                        </div>

                        <div class="mdl-card__supporting-text">
                            <s:property value="#resDish.description"/>
                        </div>

                        <div class="child" align="right">
                            <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                               href="${dishDelete}">
                                <i class="material-icons">delete</i>
                            </a>
                        </div>
                    </div>
                </div>
            </s:iterator>

            <div id="addDishpromo" class="mdl-cell--stretch mdl-cell mdl-cell--4-col">
                <div class="mdl-card-wide mdl-shadow--2dp">
                    <div class="center-div" style="display: inline-block">
                        <s:url var="addButton" action="addDishPromotion">
                            <s:param name="promotionId" value="%{promotionId}"/>
                        </s:url>
                        <a id="addbutton" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
                           style="display: inline-block"
                           href="${addButton}">
                            <i class="material-icons mdl-48">add</i>
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