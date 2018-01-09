<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>


        .mdl-card-wide {
            height: auto;
            padding: 15px;
            background-color: #fafafa;
            text-align: center;
            vertical-align: center;
        }

    </style>

</head>
<body>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">Dish List</span>
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
</div>
<main class="mdl-layout__content mdl-color--grey-100">



    <%--W3 CARD--%>
    <%--            <div class="demo-list-icon mdl-list">
                    <s:iterator value="result" var="res">
                    <li class="mdl-list__item">
        <span class="mdl-list__item-primary-content">

            <div class="w3-card">
                <p>
                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
            <input type="checkbox" id="<s:property value="#res.orderId"/>" class="mdl-checkbox__input"/>
        <s:property value="#res.name"/>
                </p>

            </div>
    </span>
                        </s:iterator>
                </div>--%>





    <div class="demo-list-icon mdl-list">
        <s:iterator value="result" var="res">
        <li class="mdl-list__item">
    <span class="mdl-list__item-primary-content">
        <div class="mdl-card-wide mdl-shadow--2dp" style="width: 100%">

                    <s:property value="#res.name"/>
            <button class="mdl-button mdl-js-button mdl-button--icon mdl-color-text--blue-grey-400"><i class="material-icons">delete</i></button>
        </div>
    </span>
            </s:iterator>
    </div>








    <%--<div class="demo-card-wide mdl-card mdl-shadow--2dp">
        <div class="mdl-card__supporting-text">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Mauris sagittis pellentesque lacus eleifend lacinia...
        </div>
    </div>--%>




    <%--<div class="demo-list-icon mdl-list">
         <s:iterator value="result" var="res">
         <li class="mdl-list__item">
        <span class="mdl-list__item-primary-content">
            <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect">
            <input type="checkbox" id="<s:property value="#res.orderId"/>"  class="mdl-checkbox__input" />
            <s:property value="#res.name"/>
        </span>
        </s:iterator>
    </div>--%>

    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>