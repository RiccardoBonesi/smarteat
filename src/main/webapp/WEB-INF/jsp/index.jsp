<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
    <title>Smarteat</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Helvetica;
            background-image: url(/images/bgimage.jpeg);

            background-repeat: no-repeat;

            background-size: cover;

        }

        hgroup {
            text-align: center;
            margin-top: 4em;
        }

        h1, h3 {
            font-weight: 300;
        }

        h1 {
            color: #636363;
        }

        h3 {
            color: #4a89dc;
        }

        form {
            width: 380px;
            margin: 4em auto;
            padding: 3em 2em 2em 2em;
            background: #fafafa;
            border: 1px solid #ebebeb;
            box-shadow: rgba(0, 0, 0, 0.14902) 0px 1px 1px 0px, rgba(0, 0, 0, 0.09804) 0px 1px 2px 0px;
        }

        .group {
            position: relative;
            margin-bottom: 45px;

        }

        input {
            font-size: 18px;
            padding: 10px 10px 10px 5px;
            -webkit-appearance: none;
            display: block;
            background: #fafafa;
            color: #636363;
            width: 100%;
            border: none;
            border-radius: 0;
            border-bottom: 1px solid #757575;
        }

        input:focus {
            outline: none;
        }

        /* Label */

        label {
            color: #999;
            font-size: 18px;
            font-weight: normal;
            position: absolute;
            pointer-events: none;
            left: 5px;
            top: 10px;
            transition: all 0.2s ease;
        }


        /* active */

        input:focus ~ .highlight {
            animation: inputHighlighter 0.3s ease;
        }

        /* Animations */

        @keyframes inputHighlighter {
            from {
                background: #4a89dc;
            }
            to {
                width: 0;
                background: transparent;
            }
        }

        /* Button */

        .button {
            position: relative;
            display: inline-block;
            padding: 12px 24px;
            margin: .3em 0 1em 0;
            width: 100%;
            vertical-align: middle;
            color: #fff;
            font-size: 16px;
            line-height: 20px;
            -webkit-font-smoothing: antialiased;
            text-align: center;
            letter-spacing: 1px;
            background: transparent;
            border: 0;
            border-bottom: 2px solid #3160B6;
            cursor: pointer;
            transition: all 0.15s ease;
        }

        .button:focus {
            outline: 0;
        }

        /* Button modifiers */

        .buttonBlue {
            background: #4a89dc;
            text-shadow: 1px 1px 0 rgba(39, 110, 204, .5);
        }

        .buttonBlue:hover {
            background: #357bd8;
        }

        /* Ripples container */

        .ripples {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
            background: transparent;
        }

        /* Ripples circle */

        .ripplesCircle {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            opacity: 0;
            width: 0;
            height: 0;
            border-radius: 50%;
            background: rgba(255, 255, 255, 0.25);
        }

        .ripples.is-active .ripplesCircle {
            animation: ripples .4s ease-in;
        }

        /* Ripples animation */

        @keyframes ripples {
            0% {
                opacity: 0;
            }

            25% {
                opacity: 1;
            }

            100% {
                width: 200%;
                padding-bottom: 200%;
                opacity: 0;
            }
        }

        footer {
            text-align: center;
        }

        footer p {
            color: #888;
            font-size: 13px;
            letter-spacing: .4px;
        }

        footer a {
            color: #4a89dc;
            text-decoration: none;
            transition: all .2s ease;
        }

        footer a:hover {
            color: #666;
            text-decoration: underline;
        }

        footer img {
            width: 80px;
            transition: all .2s ease;
        }

        footer img:hover {
            opacity: .83;
        }

        footer img:focus, footer a:focus {
            outline: none;
        }

        .mdl-textfield--floating-label input[type=password]:-webkit-autofill ~ label {
            transform: translate3d(0, -20px, 0);
            visibility: hidden;
        }

        .mdl-textfield--floating-label input[type=password]:-webkit-autofill ~ label:after {
            content: 'Password';
            visibility: visible;
            left: 0;
            transform: translate3d(0, -20px, 0);
            background: transparent;
            color: inherit;
        }

    </style>


</head>
<body background="images/bgimage.jpeg">
<main>

    <hgroup>
        <h1 style="color:white">Smarteat</h1>
    </hgroup>
    <script src="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js"></script>
    <link rel="stylesheet" href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-pink.min.css">
    <!-- Material Design icon font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <s:form action="login" method="post">

        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label textfield-demo">
            <input class="mdl-textfield__input" value="Lars" type="text" id="userText2" name="username"/>
            <label class="mdl-textfield__label" for="userText2">Username</label>
        </div>

        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="password" id="userText3" name="password"/>
            <label class="mdl-textfield__label" for="userText3">Password</label>
        </div>

        <button type="submit" class="button buttonBlue">Login
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>


    </s:form>
</main>
</body>
</html>
