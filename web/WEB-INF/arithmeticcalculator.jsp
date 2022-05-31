<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        
        <form method="post" action="arithmetic">
            <div>
                <label>First: </label>
                <input type="text" name="ac_firstv" value="${p_fst_value}">
            </div>
            
            <div>
                <label>Second: </label>
                <input type="text" name="ac_secondv" value="${p_sec_value}">
            </div>
            
            <div>
                <input type="submit" name="ac_calculate" value="+">
                <input type="submit" name="ac_calculate" value="-">
                <input type="submit" name="ac_calculate" value="*">
                <input type="submit" name="ac_calculate" value="%">
            </div>
        </form>
        
        <br>
        
        <div>
            Result: ${ac_result}
        </div>
        
        <div>
            <a href="./age">Age Calculator</a>
        </div>
    </body>
</html>
