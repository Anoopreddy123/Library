package Library;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*;
import java.util.Scanner;

public class Student1 implements ActionListener {
   Statement stmt;
    Connection conn;
    String sql=" null";
    PreparedStatement ps;

    JFrame jf = new JFrame("Student Data");
    JLabel jl1 = new JLabel();
    JLabel jl2 = new JLabel();
    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    JLabel jl5 = new JLabel();
    JLabel jl6 = new JLabel();
    JButton jb1 = new JButton();
    JTextField text1,text2,text3,text4,text5,text6;
    String Section ;
    String Fname,Lname,RollNo;
    String Year;
    String Phonenumber;
    JLabel  label1 = new JLabel();
    JLabel  label2 = new JLabel();





    public Student1() throws SQLException  {
     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Anoop@123");
        stmt = conn.createStatement();



        jl1.setText("enter RollNo:");
        jl1.setBounds(10, 10, 500, 50);
        text1 = new JTextField(" ");
        text1.setBounds(100, 27, 100, 20);
        jl2.setText("enter Fname:");
        jl2.setBounds(10, 50, 500, 50);
        text2 = new JTextField("");
        text2.setBounds(100, 70, 100, 20);
        jl3.setText("enter Lname:");
        jl3.setBounds(10, 80, 500, 50);
        text3 = new JTextField("");
        text3.setBounds(100, 100, 100, 20);
        jl4.setText("enter year:");
        jl4.setBounds(10, 120, 500, 50);
        text4 = new JTextField("");
        text4.setBounds(100, 140, 100, 20);
        jl5.setText("enter Section:");
        jl5.setBounds(10, 160, 500, 50);

        text5 = new JTextField("");
        text5.setBounds(100, 180, 100, 20);
        jl6.setText("enter  phno:");
        jl6.setBounds(10, 200, 500, 50);

        text6= new JTextField("");
        text6.setBounds(100, 220, 100, 20);
        jf.setSize(500, 500);
        jb1 = new JButton("OK");
        jb1.setBounds(10,270,70,30);

        jf.setLayout(null);
        jf.setVisible(true);

        jf.add(jl1);
        jf.add(jl2);
        jf.add(jl3);
        jf.add(jl4);
        jf.add(jl5);
        jf.add(jl6);
        jf.add(text1);
        jf.add(text2);
        jf.add(text3);
        jf.add(text4);
        jf.add(text5);
        jf.add(text6);
        jf.add(jb1);
        jf.add(label1);
        jf.add(label2);




        jb1.addActionListener(this);



    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {

            sql= "insert into Student (RollNo,Fname,Lname,Year,Section,Phonenumber) values (  ? , ? , ? , ? , ? , ?)";
        }catch(Exception e){
            e.printStackTrace();

        }
        try {
            ps = conn.prepareStatement(sql);
        }catch (Exception e ){
            e.printStackTrace();
        }


        // set param values
        RollNo = text1.getText();
        Fname = text2.getText();
        Lname = text3.getText();
        Year = text4.getText();
        Section = text5.getText();
        Phonenumber = text6.getText();
        try {
            ps.setString(1, RollNo);
            ps.setString(2, Fname);
            ps.setString(3, Lname);
            ps.setString(4, Year);
            ps.setString(5, Section);
            ps.setString(6, Phonenumber);
        }catch(Exception e ){
            e.printStackTrace();
        }
        try{
            ps.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
        label1.setText("Inserted!");
        label1.setBounds(10,290,100,25);

    }
}

