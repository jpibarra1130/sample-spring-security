<html>
<head>
    <title>User List</title>
</head>
</html>

<h1>User List</h1>
<ul>
<#list users as user>
    <li>
        ${user.email}
    </li>
</#list>
</ul>