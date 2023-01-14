<%@page import="in.cdac.db.DB" %>
<%@page import="java.util.List" %>
<%@page import="in.cdac.db.Student" %>

<%
  DB database = new DB();
  List<Student> sList = database.getStudents();
  String api = request.getContextPath();
%>

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
        <h5 class="p-2 text-bg-info">Students List :</h5>
        <table class="table table-bordered table-hover">
          <thead>
            <tr class="text-bg-dark">
              <th>Roll No.</th>
              <th>Name</th>
              <th>Course</th>
              <th>Options</th>
            </tr>
          </thead>
          <tbody>
            <% for(Student student: sList) { %>
            <tr>
              <td><%= student.getRollNo() %></td>
              <td><%= student.getName() %></td>
              <td><%= student.getCourse() %></td>
              <td class="text-center">
                <form action="./DeleteStudent" method="post">
                  <input type="hidden" name="id" value="<%= student.getRollNo() %>" />
                  <button type="submit" class="btn btn-outline-danger">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                    </svg>
                  </button>
                </form>
              </td>
            </tr>
            <% } %>            
          </tbody>
        </table>
        <a class="btn btn-primary" href="<%= request.getContextPath() %>/new.jsp">Add New</a>
      </div>
    </div>
  </body>
</html>
