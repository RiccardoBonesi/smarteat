<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>


<html lang="en">
<head>
    <style>
        .mdl-sheet__container {
            position: fixed;
            right: 32px;
            bottom: 32px;
            transform: rotate(0deg);
        }

        .mdl-card-wide {
            background: white;
            height: 40px;
            padding-left: 15px;
            padding-top: 18px;
            font-size: larger;

        }

        .mdl-textfield__label {
            font-size: larger;
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
            <span class="mdl-layout-title">New Dish</span>
            <div class="mdl-layout-spacer"></div>
        </div>
    </header>
</div>


<main class="mdl-layout__content mdl-color--grey-100">
    <s:form action="create_dish_confirmation" method="post" id="form-id">


        <div class="mdl-grid">
            <div class="mdl-cell mdl-cell--6-col">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
                    <input class="mdl-textfield__input" id="text_dish_name" type="text" name="dishEntity.name"
                           value="${dishEntity.name}"/>
                    <label class="mdl-textfield__label" for="text_dish_name">Name</label>
                </div>
            </div>

            <div class="mdl-cell mdl-cell--6-col">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
                    <input class="mdl-textfield__input" id="text_dish_price" type="number" name="dishEntity.price"
                           value="${dishEntity.price}" step="0.01"/>
                    <label class="mdl-textfield__label" for="text_dish_price">Price</label>
                </div>
            </div>
        </div>


        <div class="mdl-grid">

            <div class="mdl-cell mdl-cell--6-col">
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
            </div>

        </div>


        <input type="hidden" id="action_value_id" value="search_ing" name="action_value">


        <label class="mdl-button mdl-button--icon" for="search">
            <i class="material-icons">search</i>
        </label>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
            <input class="mdl-textfield__input" type="text" id="search" name="ingredientName"
                   placeholder="Search ingredient">
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


        <div class="mdl-grid">

            <s:iterator value="resultIngredient" var="resIngredient">

                <div class="mdl-cell--stretch mdl-cell mdl-cell--3-col">

                    <div class="mdl-card-wide mdl-shadow--2dp">
                            <%--<tr>--%>
                        <s:if test="%{checkboxIngredient != null && checkboxIngredient.contains(#resIngredient)}">

                            <s:checkbox styleClass="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect"
                                        theme="simple"
                                        name="checkBoxes" value="true" fieldValue="%{ingredientId}"/>
                        </s:if>
                        <s:else>

                            <s:checkbox styleClass="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect"
                                        theme="simple"
                                        name="checkBoxes" value="false" fieldValue="%{ingredientId}"/>
                        </s:else>
                        <s:property value="#resIngredient.name"/>

                    </div>
                </div>
            </s:iterator>


        </div>


    </s:form>
    <div id="demo-snackbar-example" class="mdl-js-snackbar mdl-snackbar">
        <div class="mdl-snackbar__text"></div>
        <button class="mdl-snackbar__action" type="button"></button>
    </div>

    <s:if test="%{loginFailed==true}">

        <script>
            r(function () {
                var notification = document.querySelector('.mdl-js-snackbar');
                notification.MaterialSnackbar.showSnackbar(
                    {
                        message: 'One or more fields are not filled'
                    }
                );
            });

            function r(f) {
                /in/.test(document.readyState) ? setTimeout('r(' + f + ')', 9) : f()
            }

        </script>
    </s:if>

    <script type="text/javascript">

        function msg() {
            document.getElementById("action_value_id").value = "not_search_ing";
            document.getElementById("form-id").submit();
        }

    </script>

    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</main>
</body>

</html>