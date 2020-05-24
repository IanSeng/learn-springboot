<html>
<heat>
  <title>First Web Application</title>
  <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
</heat>

<body>
<div class="container">
  <h3 style="color: red">${errorMessage}</h3>
  <form method="post">
    Name : <input type="text" name="name" />
    Password: <input type="password" name="password" />
    <input type="submit"/>
  </form>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
