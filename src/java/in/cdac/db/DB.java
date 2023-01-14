package in.cdac.db;

import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DB {

  private MySQLConnect mysql = null;
  private Connection con = null;
  private PreparedStatement ps = null;
  private String query = null;
  private ResultSet rs = null;
  private Student student = null;
  private List<Student> studentList = null;

  public List getStudents() {
    try {

      mysql = new MySQLConnect();
      con = mysql.getCon();
      query = "select * from students";
      ps = con.prepareStatement(query);
      rs = ps.executeQuery();
      studentList = new ArrayList<>();
      while (rs.next()) {
        student = new Student();
        student.setRollNo(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setCourse(rs.getString(3));
        studentList.add(student);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        rs.close();
        ps.close();
        con.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    return studentList;
  }

//  public boolean inserStudent(int rollNo, String name, String course) {
//    try {
//
//      mysql = new MySQLConnect();
//      con = mysql.getCon();
//      if (con == null) {
//        throw new Exception("Connection not established!");
//      }
//      ps = con.prepareStatement("insert into students values (?, ?, ?)");
//      ps.setInt(1, rollNo);
//      ps.setString(2, name);
//      ps.setString(3, course);
//
//      int updateCount = ps.executeUpdate();
//      if (updateCount < 1) {
//        throw new Exception("Record not updated!");
//      }
//
//      ps.close();
//      con.close();
//
//      return true;
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      return false;
//    }
//  }
}
