package Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class Truncate implements ActionListener {
    JFrame jf = new JFrame("Clearing");
    JLabel jl1=new JLabel();

    String sql = null;
    JButton jb1;
    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    JLabel jl5 = new JLabel();
    JLabel jl6 = new JLabel();
    JLabel label2 = new JLabel();
    JTextField text;
    Statement stmt;
    Connection conn;
    String Stdid;
    JButton jb,jb2;

    public Truncate() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Anoop@123");
        stmt = conn.createStatement();
        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setLayout(null);
        jl1.setText("Enter the rollNo");
        jl1.setBounds(10, 10, 500, 50);
        text= new JTextField("");
        text.setBounds(10, 80, 100, 20);
      jb = new JButton("Clear");
      jb.addActionListener(this);
        jb.setBounds(10,270,100,20);
        jb1 = new JButton("Get");
        jb1.setBounds(150, 270, 100, 20);
        jb1.addActionListener(this);
        jb2 = new JButton("Remove");
        jb2.setBounds(90, 300, 100, 20);
        jb2.addActionListener(this);
        jf.add(jb2);
        jf.add(jb1);
        jf.add(jl1);
        jf.add(text);
       jf.add(jb);
        jf.add(jl3);
        jf.add(jl4);
        jf.add(jl5);
        jf.add(jl6);
        jf.add(label2);

        }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jl3.setText(" " );
        jl4.setText(" " );
        jl5.setText(" " );
        jl6.setText(" " );

        if(actionEvent.getSource()==jb) {
            try {
                boolean rs = stmt.execute("SET FOREIGN_KEY_CHECKS = 0;");
                boolean rs1 = stmt.execute("TRUNCATE table Library ;");
                boolean rs2 = stmt.execute("SET FOREIGN_KEY_CHECKS = 1;");
            } catch (Exception e) {
                e.printStackTrace();

            }
            label2.setText("Deleted record");
            label2.setBounds(10,90,500,50);
        }
            else if(actionEvent.getSource()==jb1) {
                try {
                    Stdid = text.getText();
                    sql = "select * from library WHERE lcase(trim(Stdid))='" + Stdid + "'";

/*
            PreparedStatement ps = conn.prepareStatement(sql);


               ps.setString (1,Stdid);*/

                    boolean q = stmt.execute(sql);
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        jl3.setText("Sno of book 1 is : " + rs.getString(3) + " ");
                        jl3.setBounds(10, 90, 500, 50);
                        jl4.setText("SNo of book 2 is : " + rs.getString(4) + " ");
                        jl4.setBounds(10, 110, 500, 50);
                        jl5.setText("SNo of book 3 is : " + rs.getString(5) + " ");
                        jl5.setBounds(10, 130, 500, 50);
                        jl6.setText("SNo of book 4 is : " + rs.getString(6) + " ");
                        jl6.setBounds(10, 150, 500, 50);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


            else if(actionEvent.getSource()==jb2)
        {
            String Stdid=text.getText();
            jl3.setText(" " );
            jl4.setText(" " );
            jl5.setText(" " );
            jl6.setText(" " );

            try {
                boolean rs = stmt.execute("DELETE FROM library WHERE lcase(trim(Stdid))='"+Stdid+"'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            label2.setText("Deleted record");
            label2.setBounds(10,90,500,50);
        }
            else
        {
            System.out.println("Ignore");
        }
        }

    }


