package controllers;

import in.cdac.db.MySQLConnect;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "DeleteStudent", urlPatterns = {"/DeleteStudent"})
public class DeleteStudent extends HttpServlet {

  private MySQLConnect mysql = null;
  private Connection con = null;
  private PreparedStatement ps = null;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      
      String id = request.getParameter("id");

      mysql = new MySQLConnect();
      con = mysql.getCon();
      if (con == null) {
        throw new Exception("Connection not established!");
      }
      ps = con.prepareStatement("delete from students where student_id="+id);
      int updateCount = ps.executeUpdate();
      if (updateCount < 1) {
        throw new Exception("Record not updated!");
      }

      request.getRequestDispatcher("./info.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("Error", e);
      request.getRequestDispatcher("./error.jsp").forward(request, response);
    } finally {
      try {
        con.close();
      } catch (Exception e) {
        request.setAttribute("Error", e);
        request.getRequestDispatcher("./error.jsp").forward(request, response);
      }
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
  }// </editor-fold>

}
