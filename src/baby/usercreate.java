/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.lang.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class usercreate extends javax.swing.JFrame {
    JButton submitbutton,backbutton;
    JTextField namefield,agefield,genderfield,placefield,emailfield,timefield,datefield,durationfield,mobilefield;
    JPasswordField passwordfield;
    JLabel tlabel,namelabel,agelabel,genderlabel,placelabel,passwordlabel,emaillabel,timelabel,datelabel,durationlabel,mobilelabel;
    usercreate(){
        tlabel=new JLabel();
        namelabel = new JLabel();
        namefield = new JTextField();
        agelabel = new JLabel();
        genderlabel = new JLabel();
        genderfield = new JTextField();
        placelabel = new JLabel();
        placefield = new JTextField();
        datelabel = new JLabel();
        datefield = new JTextField();
        timelabel = new JLabel();
        timefield = new JTextField();
        durationlabel = new JLabel();
        durationfield = new JTextField();
        mobilelabel = new JLabel();
        mobilefield = new JTextField();
        agefield = new JTextField();
        emaillabel = new JLabel();
        passwordlabel = new JLabel();
        emailfield = new JTextField();
        passwordfield = new JPasswordField();
        
        JPanel panel1 = new JPanel();
	panel1.setBounds(0, 0, 230, 1000);
	panel1.setBackground(new Color(102, 205, 170));
	panel1.setBorder(null);
		
	JPanel panel2 = new JPanel();
	panel2.setBounds(229, 0, 753, 124);
	panel2.setBorder(null);
	panel2.setBackground(new Color(102, 205, 170));
	panel2.setLayout(null);
		
	JLabel mainlabel = new JLabel("REGISTRATION");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(196, 35, 354, 60);
	panel2.add(mainlabel);
        
        tlabel.setText("User Registration");
        tlabel.setFont(new Font("Serif", Font.BOLD, 30));
        namelabel.setText("Name");

        agelabel.setText("Child's Age");

        genderlabel.setText("Child's Gender");

        placelabel.setText("Place");

        datelabel.setText("Date");

        timelabel.setText("Time");

        durationlabel.setText("Duration");

        mobilelabel.setText("Mobile no");
        
        emaillabel.setText("Email");

        passwordlabel.setText("Password");


        submitbutton=new JButton("Submit");
        backbutton=new JButton("Back");
        
        
        emaillabel.setBounds(300,200,100,25);
        namelabel.setBounds(300,250,100,25);
        genderlabel.setBounds(300,300,100,25);
        datelabel.setBounds(300,350,100,25);
        durationlabel.setBounds(300,400,100,25);
        
        emailfield.setBounds(425,200,100,25);
        namefield.setBounds(425,250,100,25);
        genderfield.setBounds(425,300,100,25);
        datefield.setBounds(425,350,100,25);
        durationfield.setBounds(425,400,100,25);
        
        submitbutton.setBounds(600,500,100,25);
        backbutton.setBounds(400,500,100,25);
       
        
        passwordlabel.setBounds(625,200,100,25);
        agelabel.setBounds(625,250,100,25);
        placelabel.setBounds(625,300,100,25);
        timelabel.setBounds(625,350,100,25);
        mobilelabel.setBounds(625,400,100,25);
       
        
        passwordfield.setBounds(750,200,100,25);
        agefield.setBounds(750,250,100,25);
        placefield.setBounds(750,300,100,25);
        timefield.setBounds(750,350,100,25);
        mobilefield.setBounds(750,400,100,25);
        
        setVisible(true);
        setSize(1000, 900);
        setLayout(null);
        add(panel1);
        add(panel2);
        add(tlabel);
        add(namelabel);
        add(agelabel);
        add(genderlabel);
        add(placelabel);
        add(passwordlabel);
        add(emaillabel);
        add(timelabel);
        add(datelabel);
        add(durationlabel);
        add(mobilelabel);
        add(namefield);
        add(agefield);
        add(genderfield);
        add(placefield);
        add(passwordfield);
        add(emailfield);
        add(timefield);
        add(datefield);
        add(durationfield);
        add(mobilefield); 
        add(submitbutton);
        add(backbutton);
    
          submitbutton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e)
              {
            String email=emailfield.getText();
            String password=String.valueOf(passwordfield.getPassword());
            String name=namefield.getText();
            int age=Integer.parseInt(agefield.getText());
            String gender=genderfield.getText();
            String place=placefield.getText();
            String date=datefield.getText();
            String time=timefield.getText();
            int duration=Integer.parseInt(durationfield.getText());
            long mobile=Long.parseLong(mobilefield.getText());
            int a = (int)(Math.random() * (1000 - 100 + 1) + 100);
        
            user u=new user(email,password,a,name,age,gender,place,date,time,duration,mobile);
            int status=userdata.firstsave(u);
            if(status>0){
            JOptionPane.showMessageDialog(usercreate.this,"User profile submitted successfully!");
            new userloginpage().setVisible(true);
            dispose();
					
        }else{
	   JOptionPane.showMessageDialog(usercreate.this,"Sorry, Unable to submit user data!");
	}    
              }
        
         });
         backbutton.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e)
                  {
                      new userlogin().setVisible(true);
                      dispose();
                  }
          });
    }
    public static void main(String args[])
    {
        new usercreate();
    }    
}