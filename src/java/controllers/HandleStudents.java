package controllers;

import in.cdac.db.MySQLConnect;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import utils.Validator;

/**
 *
 * @author Lenovo
 */
@WebServlet(urlPatterns = {"/HandleStudents"})
public class HandleStudents extends HttpServlet {

  private MySQLConnect mysql = null;
  private Connection con = null;
  private PreparedStatement ps = null;
  private Validator validator = null;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    try {
      int rollNo = Integer.parseInt(request.getParameter("rollNo"));
      String name = request.getParameter("name");
      String course = request.getParameter("course");
      
      // initializing validator utility class object and validating the data comming form the form-
      validator = new Validator();
      if(!validator.validateName(name)) throw new Exception("Name validation failed!");

      mysql = new MySQLConnect();
      con = mysql.getCon();
      if (con == null) {
        throw new Exception("Connection not established!");
      }
      ps = con.prepareStatement("insert into students values (?, ?, ?)");
      ps.setInt(1, rollNo);
      ps.setString(2, name);
      ps.setString(3, course);

      int updateCount = ps.executeUpdate();
      if (updateCount < 1) {
        throw new Exception("Record not updated!");
      }

      request.getRequestDispatcher("./info.jsp").forward(request, response);

      ps.close();
      con.close();

      return;

    } catch (Exception e) {
      request.setAttribute("Error", e.getMessage());
      request.getRequestDispatcher("./error.jsp").forward(request, response);
      return;
    }

  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
