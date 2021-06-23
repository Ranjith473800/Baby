/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby;
import java.awt.Color;
import java.awt.Font;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import java.awt.event.*;

public class useredit extends javax.swing.JFrame 
{
    JButton editbutton;
    JTextField idfield,namefield,agefield,genderfield,placefield,emailfield,timefield,datefield,durationfield,mobilefield;
    JPasswordField passwordfield;
    JLabel idlabel,namelabel,agelabel,genderlabel,placelabel,passwordlabel,emaillabel,timelabel,datelabel,durationlabel,mobilelabel;
    
    public useredit(){
        
    
        userdata obj=new userdata();
        obj.display(obj.email);
        String id1=obj.id;
        String email1=obj.email;
        String password1=obj.password;
        String name1=obj.name;
        String age1=obj.age;
        String gender1=obj.gender;
        String place1=obj.place;
        String date1=obj.date;
        String time1=obj.time;
        String duration1=obj.duration;
        String mobile1=obj.mobile;
        
        idlabel=new JLabel();
        idfield=new JTextField();
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
		
	JButton editprofilebtn = new JButton("           Edit Profile");
	editprofilebtn.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\edit profile.png"));
	editprofilebtn.setBounds(0, 125, 230, 50);
	editprofilebtn.setHorizontalAlignment(SwingConstants.LEFT);
	editprofilebtn.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
                    new useredit().setVisible(true);
		}
	});
	panel1.setLayout(null);
	editprofilebtn.setBackground(new Color(102, 205, 170));
	panel1.add(editprofilebtn);
	JButton searchbtn = new JButton("     Search Caretaker");
	searchbtn.setBackground(new Color(102, 205, 170));
	searchbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    new searchcaretaker().setVisible(true);
		}
	});
	searchbtn.setBounds(0, 175, 230, 50);
	searchbtn.setHorizontalAlignment(SwingConstants.LEFT);
	panel1.add(searchbtn);
	searchbtn.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\search.png"));
		
	JButton reqrebtn = new JButton("     Requests Status");
	reqrebtn.setBackground(new Color(102, 205, 170));
	reqrebtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    new userrequestlist().setVisible(true);
		}
	});
        
	reqrebtn.setBounds(0, 225, 230, 50);
	reqrebtn.setHorizontalAlignment(SwingConstants.LEFT);
	reqrebtn.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\requests.png"));
	panel1.add(reqrebtn);
		
	JButton workstodobtn = new JButton("          Work Assigning");
	workstodobtn.setBackground(new Color(102, 205, 170));
	workstodobtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		      new userworkassign().setVisible(true);
                }
	});
	workstodobtn.setBounds(0, 275, 230, 50);
	workstodobtn.setHorizontalAlignment(SwingConstants.LEFT);
	workstodobtn.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\works to do.png"));
	panel1.add(workstodobtn);
		
	JButton logoutbtn = new JButton("            Log Out");
	logoutbtn.setBackground(new Color(102, 205, 170));
	logoutbtn.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
                           new decisionpage().setVisible(true);
			}
		});
	logoutbtn.setBounds(0, 325, 230, 50);
	logoutbtn.setHorizontalAlignment(SwingConstants.LEFT);
	logoutbtn.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\log out.png"));
	panel1.add(logoutbtn);
		
	JPanel panel2 = new JPanel();
	panel2.setBounds(229, 0, 753, 124);
	panel2.setBorder(null);
	panel2.setBackground(new Color(102, 205, 170));
	panel2.setLayout(null);
		
	JLabel mainlabel = new JLabel("EDIT PROFILE");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(196, 35, 354, 60);
	panel2.add(mainlabel);
        
        idlabel.setText("User ID");
        
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
        idfield.setText(id1);
        emailfield.setText(email1);
        passwordfield.setText(password1);
        namefield.setText(name1);
        agefield.setText(age1);
        genderfield.setText(gender1);
        placefield.setText(place1);
        datefield.setText(date1);
        timefield.setText(time1);
        durationfield.setText(duration1);
        mobilefield.setText(mobile1);
        idfield.setEditable(false);

        editbutton=new JButton("Submit");
        
        idlabel.setBounds(300,200,150,25);
        emaillabel.setBounds(300,250,150,25);
        namelabel.setBounds(300,300,150,25);
        genderlabel.setBounds(300,350,150,25);
        datelabel.setBounds(300,400,150,25);
        durationlabel.setBounds(300,450,150,25);
        
        idfield.setBounds(425,200,150,25);
        emailfield.setBounds(425,250,150,25);
        namefield.setBounds(425,300,150,25);
        genderfield.setBounds(425,350,150,25);
        datefield.setBounds(425,400,150,25);
        durationfield.setBounds(425,450,150,25);
        
        editbutton.setBounds(500,600,100,25);
        
        passwordlabel.setBounds(625,250,150,25);
        agelabel.setBounds(625,300,150,25);
        placelabel.setBounds(625,350,150,25);
        timelabel.setBounds(625,400,150,25);
        mobilelabel.setBounds(625,450,150,25);
        
        passwordfield.setBounds(750,250,150,25);
        agefield.setBounds(750,300,150,25);
        placefield.setBounds(750,350,150,25);
        timefield.setBounds(750,400,150,25);
        mobilefield.setBounds(750,450,150,25);
        
        setVisible(true);
        setSize(1000, 900);
        setLayout(null);
        add(panel1);
        add(panel2);
        
        add(idlabel);
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
         add(idfield);
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
         
         add(editbutton);
    
          editbutton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 String email=emailfield.getText();
        int len=emailfield.getText().length();
        if((emailfield.getText().substring(len-10,len)).equals("@gmail.com"))
        {
            email=emailfield.getText();
        }
        else
        {
            JOptionPane.showMessageDialog(useredit.this,"Enter a valid email id!");
        }
        obj.email=email;
        String password=String.valueOf(passwordfield.getText());
        obj.password=password;
        String name=namefield.getText();
        obj.name=name;
        int age=Integer.parseInt(agefield.getText());
        obj.age=String.valueOf(age);
        String gender=genderfield.getText();
        obj.gender=gender;
        String place=placefield.getText();
        obj.place=place;
        String date=datefield.getText();
        obj.date=date;
        String time=timefield.getText();
        obj.time=time;
        int duration=Integer.parseInt(durationfield.getText());
        obj.duration=String.valueOf(duration);
        long mobile=Long.parseLong(mobilefield.getText());
        obj.mobile=String.valueOf(mobile);
        user u=new user(email,password,name,age,gender,place,date,time,duration,mobile);
        int status=userdata.edit(u);
        if(status>0){
            JOptionPane.showMessageDialog(useredit.this,"User profile has been edited successfully!");
					
        }else{
	   JOptionPane.showMessageDialog(useredit.this,"Sorry, Unable to edit user profile!");
	}    
        
              }
        
         });
          
    }
    
    public static void main(String args[]){
         
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new useredit().setVisible(true);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
}
}