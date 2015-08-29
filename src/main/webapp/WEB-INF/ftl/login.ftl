<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>Login</title>
    </head>
<body>
    <h1>Login</h1>

    <form role="form" name="form" action="/login" method="post">
        <input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}" />

        <div>
            <label>Email: </label>
            <input type="text" name="email"/>
        </div>
        <div>
            <label>Password: </label>
            <input type="password" name="password"/>
        </div>

        <button type="submit">Login</button>
    </form>

    <#if error?? >
        <p>The email or password is invalid.</p>
    </#if>
</body>

</html>