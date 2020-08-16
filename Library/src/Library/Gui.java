package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Gui  {
    JTextField text;
    JLabel jlabel = new JLabel();
    JButton jb1;

    JLabel jl = new JLabel();
    JLabel jl2 = new JLabel();
    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    JLabel jl5 = new JLabel();
    JLabel jl6 = new JLabel();

    Gui() {
        JFrame jf = new JFrame("Sphoorthy Engg College. ");
       jf.setSize(1200, 720);

        jf.setLayout(null);
        jf.setVisible(true);
  jf.getContentPane().setBackground(Color.WHITE);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        jl.setText("Choose your action :");
        jl.setBounds(10, 10, 500, 30);

        jl2.setText("1. Enter a new student profile : ");
        jl2.setBounds(10, 30, 500, 30);
        jl2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    new Student1();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jl3.setText("2. Enter the data of books taken by student :");
        jl3.setBounds(10, 50, 500, 30);
        jl3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    new Library();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jl4.setText("3. Clear out the student data : ");
        jl4.setBounds(10, 70, 500, 30);
        jl4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    new Truncate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jl5.setText("4. Getting serialNo of books : ");
        jl5.setBounds(10, 90, 500, 30);
        jl5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    new Truncate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
     /*   text = new JTextField(" ");
        text.setBounds(20, 145, 200, 20);
        jb1 = new JButton("OK");
        jb1.setBounds(40, 180, 100, 25);
        String input = text.getText();
        jb1.addActionListener(this);
        jlabel.setText(input);
        jlabel.setBounds(10, 200, 500, 30);*/


        jf.add(jl);
        jf.add(jl2);
        jf.add(jl3);
        jf.add(jl4);
        jf.add(jl5);
      /*  jf.add(text);*/
        jf.add(jl6);
       /* jf.add(jb1);*/
        jf.add(jlabel);

    }

    /*public void actionPerformed(ActionEvent e) {
        String input = text.getText();
      if(input.equals(" "+ 1)) {
             try {
                 new Student1();
             }catch (Exception e1){
                 e1.printStackTrace();
             }
             text.setText(" ");
      }
       else  if(input.equals(" "+ 2)) {
          try {
              new Library();
          }catch (Exception e2){
              e2.printStackTrace();
          }
          text.setText(" ");
        }
        else if(input.equals(" "+ 3)) {
          try {
              new Truncate();
          }catch (Exception e2){
              e2.printStackTrace();
          }
          text.setText(" ");
        }
        else if(input.equals(" "+ 4)) {
          try {
              new Library();
          }catch (Exception e2){
              e2.printStackTrace();
          }
          text.setText(" ");
        }
      else{
          jlabel.setText("denied");

          jlabel.setBounds(10, 250, 500, 30);
          text.setText(" ");
      }
*/
    }



