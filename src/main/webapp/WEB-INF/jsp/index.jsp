<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Index</title>
</head>
<body>

<p><a href="<s:url action='helloWorld'/>">Vai alla dashboard</a></p>




<div align="center">
    <h2>Please login</h2>
    <s:form action="login" method="post">
        <s:textfield name="userEntity.username" label="username" />
        <s:textfield name="userEntity.password" label="Password" />
        <s:submit value="Login" />
    </s:form>
</div>


</body>
</html>
	