<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf"%>

<div class="container">
  Add Todo Page for ${name}
  <form:form method="post" modelAttribute="todo">
    <form:hidden path="id"/>
    <fieldset class="form-group">
      <form:label path="desc">Description</form:label>
      <input:input path="desc" class="form-control" name="desc" type="text" required="required"/>
      <form:errors path="desc" cssClass="text-warning"/>
    </fieldset>

    <fieldset class="form-group">
      <form:label path="targetDate">Target Date</form:label>
      <input:input path="targetDate" class="form-control" name="targetDate" type="text" required="required"/>
      <form:errors path="targetDate" cssClass="text-warning"/>
    </fieldset>
    <button class="btn btn-success" type="submit">Add</button>
  </form:form>
</div>

<%@include file="common/footer.jspf"%>

