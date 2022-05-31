<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        
        <form method="post" action="age">
            <div>
                <label>Enter your age: </label>
                <input type="number" name="user_age" value="">
            </div>
        
            <div>
                <input type="submit" value="Age next birthday">
            </div>
        </form>
        
        <div>
            ${output_message}
        </div>
        
        <div>
            <a href="./arithmetic"> Arithmetic Calculator</a>
        </div>
    </body>
</html>
