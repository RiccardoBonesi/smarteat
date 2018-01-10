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
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
                    <i class="material-icons">search</i>
                </label>
                <div class="mdl-textfield__expandable-holder">
                    <input class="mdl-textfield__input" type="text" id="search">
                    <label class="mdl-textfield__label" for="search">Enter your query...</label>
                </div>
            </div>

        </div>
    </header>
</div>


<main class="mdl-layout__content mdl-color--grey-100">
    <s:form action="create_dish_confirmation" method="post">
        <div class="mdl-sheet__container">


            <button id="show-dialog"
                    class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
                <i class="material-icons">done</i>


            </button>
        </div>


        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
            <input class="mdl-textfield__input" id="text_dish_name" type="text" name="dishEntity.name"/>
            <label class="mdl-textfield__label" for="text_dish_name">Name</label>
        </div>

        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
            <input class="mdl-textfield__input" id="text_dish_description" type="text" name="dishEntity.description"/>
            <label class="mdl-textfield__label" for="text_dish_description">Description</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
            <input class="mdl-textfield__input" id="text_dish_price" type="number" name="dishEntity.price"/>
            <label class="mdl-textfield__label" for="text_dish_price">Price</label>
        </div>


        <s:iterator value="resultCategory" var="resCategory">

            <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect">
                <input type="radio" class="mdl-radio__button" name="categoryEntity.categoryId"
                       value="${resCategory.categoryId}">
                <span class="mdl-radio__label"><s:property value="#resCategory.name"/></span>
            </label>
        </s:iterator>


    </s:form>
    <div class="demo-list-icon mdl-list">

        <s:iterator value="resultIngredient" var="resIngredient">

            <li class="mdl-list__item">
                <span class="mdl-list__item-primary-content">
                    <div class="mdl-card-wide mdl-shadow--2dp">

                        <s:property value="#resIngredient.name"/>

                    </div>

                </span>
            </li>

        </s:iterator>
    </div>


    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>