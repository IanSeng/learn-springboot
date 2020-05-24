<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<heat>
  <title>First Web Application</title>
  <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
</heat>

<body>
<div class="container">
  Add Todo Page for ${name}
  <form:form method="post" modelAttribute="todo">
    <fieldset class="form-group">
      <form:label path="desc">Description</form:label>
      <input:input path="desc" class="form-control" name="desc" type="text" required="required"/>
      <form:errors path="desc" cssClass="text-warning"/>
    </fieldset>
    <button class="btn btn-success" type="submit">Add</button>
  </form:form>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
