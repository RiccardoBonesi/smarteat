<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<% String user = (String) request.getSession().getAttribute("user"); %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>Smarteat</title>

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <link rel="shortcut icon" href="images/favicon.png">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
    <link rel="stylesheet" href="styles.css">
    <decorator:head/>

    <style>
        .mdl-layout__header {
            height: fit-content;
        }

        .avatar {
            border-radius: 50%;
        }
    </style>


</head>
<body>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600"></header>


    <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        <header class="demo-drawer-header">
            <img style="background: white" src="images/account.png" height="100" width="100" class="avatar">
            <% out.print(user);%>
        </header>
        <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
            <a class="mdl-navigation__link" href="<s:url action='orderlist'/>"><i
                    class="mdl-color-text--blue-grey-400 material-icons" role="presentation">shopping_cart</i>Order List</a>
            <a class="mdl-navigation__link" href="<s:url action='dishlist'/>"><i
                    class="mdl-color-text--blue-grey-400 material-icons" role="presentation">list</i>Dish List</a>
            <a class="mdl-navigation__link" href="<s:url action='promotion'/>"><i
                    class="mdl-color-text--blue-grey-400 material-icons"
                    role="presentation">local_offer</i>Promotion</a>
            <a class="mdl-navigation__link" href="<s:url action='logout'/>"><i
                    class="mdl-color-text--blue-grey-400 material-icons"
                    role="presentation">exit_to_app</i>Logout</a>

        </nav>
    </div>
    <decorator:body/>
</div>
</body>