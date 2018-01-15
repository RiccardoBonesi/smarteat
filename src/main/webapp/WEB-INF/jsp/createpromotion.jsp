<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        .mdl-sheet__container {
            position: fixed;
            right: 32px;
            bottom: 32px;
            transform: rotate(0deg);
        }
    </style>


    <script type="javascript">
        var table = document.querySelector('table');
        var headerCheckbox = table.querySelector('thead .mdl-data-table__select input');
        var boxes = table.querySelectorAll('tbody .mdl-data-table__select');
        var headerCheckHandler = function (event) {
            if (event.target.checked) {
                for (var i = 0, length = boxes.length; i < length; i++) {
                    boxes[i].MaterialCheckbox.check();
                    boxes[i].MaterialCheckbox.updateClasses();
                }
            } else {
                for (var i = 0, length = boxes.length; i < length; i++) {
                    boxes[i].MaterialCheckbox.uncheck();
                    boxes[i].MaterialCheckbox.updateClasses();
                }
            }
        };
        headerCheckbox.addEventListener('change', headerCheckHandler);
    </script>

</head>
<body>

<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span class="mdl-layout-title">Dish List</span>
            <div class="mdl-layout-spacer"></div>
        </div>
    </header>
</div>


<main class="mdl-layout__content mdl-color--grey-100">

    <s:form action="create_promotion_confirmation" method="post" id="form-id">


        <label class="mdl-button mdl-button--icon" for="search">
            <i class="material-icons">search</i>
        </label>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
            <input class="mdl-textfield__input" type="text" id="search" name="dishName"
                   placeholder="Search dish">
            <input type="submit" style="display: none; visibility: hidden">
            <label class="mdl-textfield__label"></label>
        </div>


        <div class="mdl-sheet__container">
            <button id="show-dialog" type="submit"
                    class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored"
                    onclick="msg()">
                <i class="material-icons  mdl-color-text--white">done</i>
            </button>
        </div>


        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
            <input class="mdl-textfield__input" id="text_dish_name" type="text" name="promotionEntity.name"
                   value="${promotionEntity.name}"/>
            <label class="mdl-textfield__label" for="text_dish_name">Name</label>
        </div>

        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
            <input class="mdl-textfield__input" id="text_dish_description" type="text"
                   name="promotionEntity.description"
                   value="${promotionEntity.description}"/>
            <label class="mdl-textfield__label" for="text_dish_description">Description</label>
        </div>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
            <input class="mdl-textfield__input" id="text_dish_price" type="number" name="promotionEntity.price"
                   value="${promotionEntity.price}"/>
            <label class="mdl-textfield__label" for="text_dish_price">Price</label>
        </div>
        <input type="hidden" id="action_value_id" value="search_dish" name="action_value">

        <s:iterator value="resultCategory" var="resCategory">

            <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect">


                <s:if test="%{categoryEntity.categoryId == #resCategory.categoryId}">
                    <input type="radio" class="mdl-radio__button" name="categoryEntity.categoryId"
                           value="${resCategory.categoryId}" checked>
                </s:if>
                <s:else>
                    <input type="radio" class="mdl-radio__button" name="categoryEntity.categoryId"
                           value="${resCategory.categoryId}">
                </s:else>
                <span class="mdl-radio__label"><s:property value="#resCategory.name"/></span>
            </label>
        </s:iterator>


        <div class="mdl-cell mdl-cell--9-col">
            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                <thead>
                <tr>
                    <th class="mdl-data-table__cell--non-numeric">Abilitato</th>
                    <th class="mdl-data-table__cell--non-numeric">Ingredient</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="resultDish" var="resDish">
                <tr>
                    <s:if test="%{checkboxDish.contains(#resDish)}">

                        <td><s:checkbox styleClass="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" theme="simple"
                                        name="checkBoxes" value="true" fieldValue="%{dishId}"/></td>
                    </s:if>
                    <s:else>

                        <td><s:checkbox styleClass="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" theme="simple"
                                        name="checkBoxes" value="false" fieldValue="%{dishId}"/></td>
                    </s:else>
                    <td><s:property value="#resDish.name"/></td>


                </tr>
                </s:iterator>

            </table>
        </div>


    </s:form>


    <script type="text/javascript">

        function msg() {
            document.getElementById("action_value_id").value = "not_search_dish";
            document.getElementById("form-id").submit();
        }

    </script>

    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</main>
</body>

</html>