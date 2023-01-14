package in.cdac.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect {

  private String url;
  private String username;
  private String password;

  public MySQLConnect() {
    url = "jdbc:mysql://localhost:3306/cdac";
    username = "root";
    password = "root";
  }

  public Connection getCon() {
    try {

      Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection(url, username, password);

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
