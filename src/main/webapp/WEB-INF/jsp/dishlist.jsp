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
            text-align: left;

            height: auto;
        }

        .mdl-sheet__container {
            position: fixed;
            right: 32px;
            bottom: 32px;
            transform: rotate(0deg);
            height: auto;
            z-index: 900;
        }

        .demo-card mdl-card mdl-shadow--2dp {

            height: auto;
        }

        .setAlign {

            align-content: center;
            height: auto;
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


<main class="mdl-layout__content mdl-color--grey-100">

    <div class="mdl-sheet__container">

        <s:form action="create_dish" method="post">
        <button id="show-dialog"
                class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored  mdl-button--raised">
            <i class="material-icons">add</i>
            </s:form>

        </button>
    </div>
    <%--<div class="demo-list-icon mdl-list">--%>
    <div class="mdl-grid">
        <s:iterator value="resultCategory" var="resCategory">


        <div class="mdl-card-wide mdl-shadow--2dp" style="width: 100%; background-color: #999999">
            <h3><s:property value="#resCategory.name"/></h3>
        </div>

        <s:iterator value="resultDish" var="resDish" status="incr">
        <s:if test="%{#resDish.category.categoryId == #resCategory.categoryId && #resDish.enabled}">
        <div class="mdl-cell">

            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card mdl-card mdl-shadow--2dp">
                    <div class="setAlign">
                        <s:url var="dishDelete" action="delete_dish">
                            <s:param name="dishId" value="%{dishId}"/>
                        </s:url>

                        <div class="mdl-card__title">
                            <s:property value="#resDish.name"/>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <s:property value="#resDish.description"/>
                        </div>
                        <a class="mdl-button mdl-js-button mdl-button--icon mdl-color-text--blue-grey-400"
                           href="${dishDelete}">
                            <i class="material-icons">delete</i>
                        </a>
                    </div>
                </div>
            </div>

                <%--<div class="mdl-cell mdl-cell--4-col">
                    <div class="demo-card mdl-card mdl-shadow--2dp">
                        <div class="setAlign">
                            <s:url var="dishDelete" action="delete_dish">
                                <s:param name="dishId" value="%{dishId}"/>
                            </s:url>
                            <a class="mdl-button mdl-js-button mdl-button--icon mdl-color-text--blue-grey-400"
                               href="${dishDelete}">
                                <i class="material-icons">delete</i>
                            </a>
                            <s:property value="#resDish.name"/>
                            <s:property value="%{#incr.index}"/>
                            <h6><s:property value="#resDish.description"/></h6>
                        </div>
                    </div>
                </div>--%>

        </div>


        </s:if>
        </s:iterator>

        </s:iterator>
        <%--</div>--%>


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


        <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>