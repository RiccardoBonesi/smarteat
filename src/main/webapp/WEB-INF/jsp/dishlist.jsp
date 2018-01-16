<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>
    <style>

        .mdl-cell--stretch {
            height: 250px;
        }

        .child {
            position: absolute;
            bottom: 0px;
            padding: 15px;
        }

        .mdl-card-wide {
            width: 100%;
            height: 100%;
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
                    <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
                        <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                        <input class="mdl-textfield__input" type="text" id="search" name="dishName"
                               placeholder="Search dish">
                        <label class="mdl-textfield__label"></label>
                    </div>
                </div>
            </s:form>

        </div>
    </header>
</div>


<main class="mdl-layout__content">

    <div class="mdl-sheet__container">

        <s:form action="create_dish" method="post">
            <button id="show-dialog"
                    class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored  mdl-button--raised mdl-color-text--white">
                <i class="material-icons">add</i>
            </button>
        </s:form>
    </div>

    <div class="mdl-grid">
        <s:iterator value="resultCategory" var="resCategory">


        <div class="mdl-card-wide mdl-shadow--2dp mdl-color-text--white mdl-color--light-blue-A200"
             style="height: 80px;margin-left: 8px; margin-right: 8px; padding-left: 15px; width: 100%; background-color: #999999">
        <h4><s:property value="#resCategory.name"/></h4>
    </div>

    <s:iterator value="resultDish" var="resDish" status="incr">
        <s:if test="%{#resDish.category.categoryId == #resCategory.categoryId && #resDish.enabled}">

            <div class="mdl-cell--stretch mdl-cell mdl-cell--4-col">

                <div class="mdl-card-wide mdl-shadow--2dp">

                    <s:url var="dishDelete" action="delete_dish">
                        <s:param name="dishId" value="%{dishId}"/>
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
        </s:if>
    </s:iterator>

    </s:iterator>


    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>