<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
    <title>Smart Eat</title>
</head>
<body>
    <s:form action="login" method="post">

        <s:label for="userText">Username</s:label>
        <s:textfield  id="userText" name="userEntity.username"/>

        <s:textfield  id="userPass" name="userEntity.password"/>
        <s:label  for="userPass">Password</s:label>

        <s:submit value="Login"/>
    </s:form>

</body>
</html>
