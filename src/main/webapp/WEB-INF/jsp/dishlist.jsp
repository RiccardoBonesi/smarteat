<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>


        .mdl-card-wide {
            width: 100%;
            height: auto;
            padding: 15px;
            background-color: #fafafa;
            text-align: center;
            vertical-align: center;
        }

        .mdl-sheet__container {
            position: fixed;
            right: 32px;
            bottom: 32px;
            transform: rotate(0deg);
        }

        .mdl-sheet {
            position: absolute;
            right: 0;
            bottom: 0;
            width: 60px;
            height: 60px;
            border-radius: 50%;

            cursor: pointer;
            transition: all 180ms;

        .mdl-sheet__content {
            display: none;
        }

        }

        .mdl-sheet__icon {
            color: #fff;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-12px, -12px);
            font-size: 24px;
            width: 24px;
            height: 24px;
            line-height: 24px;
        }


    </style>

</head>
<body>

<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">Dish List</span>
            <div class="mdl-layout-spacer"></div>

            <s:form action="search_dish" method="post">

            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                <button type="submit" class="mdl-button mdl-js-button mdl-button--icon" for="search">
                    <i class="material-icons">search</i>
                </button>
                <div class="mdl-textfield">
                    <input class="mdl-textfield__input" type="text" id="search" name="dishName">
                </div>
            </div>

            </s:form>
        </div>
    </header>
</div>


<main class="mdl-layout__content mdl-color--grey-100">

    <div class="mdl-sheet__container">

        <s:form action="create_dish" method="post">
        <button id="show-dialog" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
            <i class="material-icons">add</i>
            </s:form>

        </button>
    </div>


    <div class="demo-list-icon mdl-list">
        <s:iterator value="resultCategory" var="resCategory">

        <span class="mdl-list__item-primary-content">
        <div class="mdl-card-wide mdl-shadow--2dp" style="width: 100%; background-color: #999999">
            <h3><s:property value="#resCategory.name"/></h3>
        </div>
    </span>


        <s:iterator value="resultDish" var="resDish">
        <s:if test="%{#resDish.category.categoryId == #resCategory.categoryId && #resDish.enabled}">
        <li class="mdl-list__item">
                <span class="mdl-list__item-primary-content">
        <div class="mdl-card-wide mdl-shadow--2dp">
            <s:url var="dishDelete" action="delete_dish">
                <s:param name="dishId" value="%{dishId}"/>
            </s:url>
            <a class="mdl-button mdl-js-button mdl-button--icon mdl-color-text--blue-grey-400" href="${dishDelete}">
               <i class="material-icons">delete</i>
            </a>
            <s:property value="#resDish.name"/>
        </div>
    </span>
            </s:if>
            </s:iterator>
            </s:iterator>


          <%--  <s:iterator value="result" var="dish">
        <li class="mdl-list__item">
    <span class="mdl-list__item-primary-content">
        <div class="mdl-card-wide mdl-shadow--2dp">
            <s:url var="dishDelete" action="delete_dish">
                <s:param name="dishId" value="%{dishId}"/>
            </s:url>
            <a class="mdl-button mdl-js-button mdl-button--icon mdl-color-text--blue-grey-400" href="${dishDelete}">
               <i class="material-icons">delete</i>
            </a>
            <s:property value="#dish.name"/>

        </div>
    </span>
            </s:iterator>--%>


    </div>


    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>