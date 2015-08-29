<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8"/>
        <title>New User</title>

    </head>

    <body>
        <h1>Register User</h1>

        <form role="form" name="form" action="/register" method="post">
            <input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}" />
            <div>
                <label>Email: </label>
                <input type="email" name="email" id="email" value="${form.email}"/>
            </div>

            <div>
                <label>Password:</label>
                <input type="password" name="password" id="password" value="${form.password}"/>
            </div>

            <div>
                <label>Confirm Password</label>
                <input type="password" name="confirmPassword" id="confirmPassword" value="${form.confirmPassword}"/>
            </div>

            <button type="submit">Submit</button>

        </form>

        <@spring.bind "form" />
        <#if spring.status.error>
            <ul>
                <#list spring.status.errorMessages as error>
                    <li>${error}</li>
                </#list>
            </ul>
        </#if>


        </body>

</html>
