<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>

</head>
<body>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">Menu management</span>
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

<style>
    .mdl-card--horizontal {
        /* 1 */
        padding-left: 150px;
        padding-top: 0px;
        width: 100%;
        display: flex;
        flex-wrap: wrap;
        flex-direction: row;

        background-color: white;
    }



</style>

<main class="mdl-layout__content mdl-color--grey-100">
    <div class="demo-list-action mdl-list">
        <s:iterator value="result" var="res">

            <div class="mdl-list__item">
                <div class="mdl-card--horizontal mdl-shadow--2dp">
                    <div class="mdl-card__title">
                        <h2 class="mdl-card__title-text">Dish <s:property value="#res.dishId"/></h2>
                        <h6 class="mdl-card__supporting-text"> <s:property value="#res.name"/></h6>
                    </div>
                </div>
            </div>
        </s:iterator>
    </div>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>