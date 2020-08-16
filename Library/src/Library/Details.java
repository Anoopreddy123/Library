package Library;

import java.sql.*;
import java.util.Scanner;

public class Details {
    Statement stmt;
    Connection conn;
    ResultSet rs;
    PreparedStatement ps;
    Scanner scanner = new Scanner(System.in);
    public Details() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Anoop@123");
        stmt = conn.createStatement();
    }


    public void Reset() throws  SQLException{

        String stdid;

        System.out.println("Enter Id :");
        stdid = scanner.nextLine();
        String sql = null;

        sql = "select * from library where stid = "+stdid;


          /*  PreparedStatement ps = conn.prepareStatement(sql);



            ps.setString(1, stdid);*/

        boolean q= stmt.execute(sql);
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()) {
            System.out.println("Sno of book 1 is : " + rs.getString(3) + " ");
            System.out.println("SNo of book 2 is : " + rs.getString(4) + " ");
            System.out.println("SNo of book 3 is : " + rs.getString(5) + " ");
            System.out.println("SNo of book 4 is : " + rs.getString(6) + " ");
        }


        System.out.println("Done");
    }
}