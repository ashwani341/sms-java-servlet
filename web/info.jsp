<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Management App</title>
    <%-- Bootstrap CDN --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  </head>
  <body>
    <%@include file="nav.jsp" %>
    <div class="container-fluid text-bg-light min-vh-100">
      <h1 class="text-center text-bg-primary p-5 mb-5">Student Management System</h1>
      <div class="col-5 mx-auto">
        <h1 class="text-success">Record updated successfully!</h1>
      </div>
    </div>
  </body>
</html>
