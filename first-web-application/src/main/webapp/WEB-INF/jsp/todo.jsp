<html>
<heat>
  <title>First Web Application</title>
  <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
</heat>

<body>
<div class="container">
  Add Todo Page for ${name}
  <form method="post">
    <fieldset class="form-group">
      <label>Description</label>
      <input class="form-control" name="desc" type="text" required="required"/>
    </fieldset>
    <button class="btn btn-success" type="submit">Add</button>
  </form>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
