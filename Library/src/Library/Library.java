package Library;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*;


public class Library implements ActionListener {
    Statement stmt;
    Connection conn;
    String sql=" null";
    PreparedStatement ps;

   JFrame jf = new JFrame("Library information");

    JLabel jl1 = new JLabel();
    JLabel  label1 = new JLabel();
    JLabel jl2 = new JLabel();
    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    JLabel jl5 = new JLabel();
    JLabel jl6 = new JLabel();
    JButton jb;
    String book1,book2,book3,book4;
    String Libid,Stid;
    JTextField text1,text2,text3,text4,text5,text6;

    public Library() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Anoop@123");
        stmt = conn.createStatement();
         jf.setLayout(null);
         jf.setVisible(true);
         jf.setSize(500,500);

        jl1.setText("enter RollNo:");
        jl1.setBounds(10,10,500,50);
        text1=new JTextField(" ");
        text1.setBounds(135,25,100,20);
        jl2.setText("enter LibId");
        jl2.setBounds(10,40,500,50);
        text2=new JTextField(" ");
        text2.setBounds(135,55,100,20);
        jl3.setText("enter Sno of Book1");
        jl3.setBounds(10,70,500,50);
        text3=new JTextField(" ");
        text3.setBounds(135,85,100,20);
        jl4.setText("enter Sno of book2");
        jl4.setBounds(10,100,500,50);
        text4=new JTextField(" ");
        text4.setBounds(135,115,100,20);
        jl5.setText("enter sno of book3:");
        jl5.setBounds(10,130,500,50);
        text5=new JTextField(" ");
        text5.setBounds(135,150,100,20);
        jl6.setText("enter Sno of book4");
        jl6.setBounds(10,170,500,50);
        text6=new JTextField(" ");
        text6.setBounds(135,190,100,20);
        jb = new JButton("OK");
        jb.setBounds(10,220,70,30);
        jb.addActionListener(this);
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
        jf.add(jb);
        jf.add(label1);
     // 2. Create a statement




    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        try {
            sql= "insert into Library (Stdid,Libid,book1,book2,book3,book4) values (  ? , ? , ? , ? , ? , ?)";
        }catch(Exception e){
            e.printStackTrace();

        }
        try {
             ps = conn.prepareStatement(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        Stid = text1.getText();
        Libid = text2.getText();
        try {
            book1 = (text3.getText());
            book2 = (text4.getText());
            book3 = (text5.getText());
            book4 = (text6.getText());
        }catch (Exception e ){
            e.printStackTrace();
        }
        try {

            ps.setString(1, Stid);
            ps.setString(2, Libid);
            ps.setString(3, book1);
            ps.setString(4, book2);
            ps.setString(5, book3);
            ps.setString(6, book4);
        }catch(Exception e){
            e.printStackTrace();
        }


try {
    ps.executeUpdate();
}catch (Exception e){
    e.printStackTrace();
}
        label1.setText("Inserted!");
        label1.setBounds(10,290,100,25);text1.setText(" " );
        text2.setText(" " );
        text3.setText(" " );
        text4.setText(" " );
        text5.setText(" " );
        text6.setText(" " );



    }
}

