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
            margin-left: 20px;

        }

        .mdl-sheet__container {
            position: fixed;
            right: 32px;
            bottom: 32px;
            transform: rotate(0deg);

            z-index: 900;
        }

        .demo-card mdl-card mdl-shadow--2dp {
            padding-left: 15px;
            height: auto;
        }

        .setAlign {
            padding-left: 15px;
            align-content: center;
        }


    </style>


</head>
<body>

<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">Promotion List</span>
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

    <%--<div class="mdl-sheet__container">

        <s:form action="create_dish" method="post">
        <button id="show-dialog"
                class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored  mdl-button--raised">
            <i class="material-icons">add</i>
            </s:form>

        </button>
    </div>--%>
    <%--<div class="demo-list-icon mdl-list">--%>
    <div class="mdl-grid">
        <s:iterator value="result" var="resPromotion">
        <div class="mdl-cell">
            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card mdl-card mdl-shadow--2dp">
                    <div class="mdl-card__title">
                        <h2 class="mdl-card__title-text">Promotion <s:property value="#resPromotion.name"/></h2>
                    </div>
                    <s:iterator value="dishes" var="resDish">
                        <div class="mdl-card__supporting-text">
                            <b><s:property value="#resDish.name"/></b>
                            <s:property value="#resDish.description"/>
                        </div>
                    </s:iterator>
                    <div class="mdl-card__actions mdl-card--border">
                        <s:url var="promoDelete" action="delete_promotion">
                            <s:param name="promotionId" value="%{resPromotion}"/>
                        </s:url>
                        <a class="mdl-button mdl-js-button mdl-button--icon mdl-color-text--blue-grey-400"
                           href="${promoDelete}">
                            <i class="material-icons">delete</i>
                        </a>

                    </div>
                </div>
            </div>
        </div>

        </s:iterator>
        <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>