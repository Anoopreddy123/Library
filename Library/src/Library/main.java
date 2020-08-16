package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.Thread;
import java.awt.event.InputEvent;
import javax.swing.*;
import java.util.Scanner;



public class main {
        public static void main(String args[]) throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Anoop@123");
                Statement stmt = conn.createStatement();
            }catch(Exception e){
                System.out.println(e);
            }
             //main window
            Gui gui = new Gui();
        // Student1 s = new Student1();
          //Library l = new Library();
            //  Truncate t  = new Truncate();



        }
    }


