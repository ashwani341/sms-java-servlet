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
        <h5 class="mb-3">Enter the details of student :</h5>
        <form action="./HandleStudents" method="post">
          <div class="mb-3">
            <input class="form-control" type="number" placeholder="Roll No." name="rollNo" />
          </div>
          <div class="mb-3">
            <input class="form-control" type="text" placeholder="Name" name="name" />
          </div>
          <div class="mb-3">
            <input class="form-control" type="text" placeholder="Course" name="course" />
          </div>
          <button type="submit" class="btn btn-primary w-100">Add</button>
        </form>
      </div>
    </div>
  </body>
</html>
