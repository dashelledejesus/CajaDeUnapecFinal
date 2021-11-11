<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container col-ig-3">
            <form action="Principal">
                <div class="form-group">
                    <img src="img caja unapec/WhatsApp Image 2021-11-11 at 10.15.43 AM(1).jpeg" hidden = "80" width="80"/>
                    <p><STRONG>BIENVENIDOS AL SISTEMA DE CAJA UNAPEC</strong></p>
                </div>
                <div class="form-group"></div>
                <label>Nombre: </label>
                <input class="form-control" type="text" name="txt" placeholder="ingrese nombres">
                <div class="form-group">
                    <label>Email: </label>
                    <input type="email" name="txtCorreo" placeholder="Example@gmail.com" class="form-control">
                    <input type="sumit" name="action" value="ingresar">
                </div>
                  
                
            </form> 
            
            
            
        </div>
   
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>