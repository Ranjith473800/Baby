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
import javax.swing.*;

public class caretakersignup extends javax.swing.JFrame
{
    String s1[]={"male","female","others"};
    String s2[]={"available","not available"};
    JButton regbtn,backbtn;
    JComboBox<String> genderfield= new JComboBox<>(s1);
    JComboBox<String> availabilityfield=new JComboBox<>(s2);
    JTextField idfield,namefield,agefield,placefield,emailfield,expfield,costfield,durationfield,mobilefield;
    JPasswordField confirmfield,createfield;
    JLabel idlabel,namelabel,agelabel,genderlabel,placelabel,passwordlabel,emaillabel,costlabel,explabel,durationlabel,mobilelabel,availlabel,ViewProfilelabel,confirmlbl,createlbl;
    public caretakersignup()
    {
        initialize();
                
    }    
    private void initialize()
    {
	JPanel panel1 = new JPanel();
	panel1.setBounds(0, 0, 230, 1000);
	panel1.setBackground(new Color(102, 205, 170));
	panel1.setBorder(null);
		
	JPanel panel2 = new JPanel();
	panel2.setBounds(229, 0, 753, 124);
	panel2.setBorder(null);
	panel2.setBackground(new Color(102, 205, 170));
	panel2.setLayout(null);
		
	JLabel mainlabel = new JLabel("REGISTER");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(220, 35, 354, 60);
	panel2.add(mainlabel);
        
	namelabel =       new JLabel("NAME");
	namelabel.setBounds(400, 200, 150, 20);
        
	emaillabel =       new JLabel("EMAIL");
	emaillabel.setBounds(400, 240, 150, 20);
        
        createlbl =       new JLabel("CREATE PASSWORD");
	createlbl.setBounds(400, 280, 150, 20);       
        
        confirmlbl =       new JLabel("CONFIRM PASSWORD");
	confirmlbl.setBounds(400, 320, 150, 20);
        
	agelabel =        new JLabel("AGE");
	agelabel.setBounds(400, 360, 150, 20);
        
        placelabel = new JLabel("PLACE");
	placelabel.setBounds(400, 400, 150, 16);
        
	genderlabel =     new JLabel("GENDER");
	genderlabel.setBounds(400, 440, 150, 20);
        
	durationlabel =   new JLabel("DURATION ");
	durationlabel.setBounds(400, 480, 150, 20);
        
	costlabel =       new JLabel("COST");
	costlabel.setBounds(400, 520, 150, 20);
        
	mobilelabel =     new JLabel("MOBILE");
	mobilelabel.setBounds(400, 560, 150, 20);
        
	explabel = new JLabel("EXPERIENCE");
	explabel.setBounds(400, 600, 150, 20);
        
        availlabel =   new JLabel("AVAILABILITY");
        availlabel.setBounds(400, 640, 150, 20);
		
	namefield = new JTextField();
	namefield.setBounds(600, 200, 200, 25);
	namefield.setColumns(10);
		
	emailfield = new JTextField();
	emailfield.setBounds(600,240, 200, 25);
	emailfield.setColumns(10);
        
        createfield = new JPasswordField();
	createfield.setBounds(600,280, 200, 25);
	createfield.setColumns(10);
        
        confirmfield = new JPasswordField();
	confirmfield.setBounds(600,320, 200, 25);
	confirmfield.setColumns(10);
		
	agefield = new JTextField();
	agefield.setBounds(600, 360, 200, 25);
	agefield.setColumns(10);
                
        placefield = new JTextField();
	placefield.setBounds(600, 400, 200, 25);
	placefield.setColumns(10);		
                        
	genderfield.setBounds(600, 440, 200, 25);
                
	durationfield = new JTextField();
	durationfield.setBounds(600, 480, 200, 25);
	durationfield.setColumns(10);
		
	costfield = new JTextField();
	costfield.setBounds(600, 520, 200, 25);
        costfield.setColumns(10);
		
	mobilefield = new JTextField();
	mobilefield.setBounds(600, 560, 200, 25);
	mobilefield.setColumns(10);
		
	expfield = new JTextField();
	expfield.setBounds(600, 600, 200, 25);
	expfield.setColumns(10);

	availabilityfield.setBounds(600, 640, 200, 25);
        
        regbtn=new JButton("REGISTER");
        regbtn.setBounds(600,700,100,25);
        
        backbtn=new JButton("BACK");
        backbtn.setBounds(400,700,100,25);
        
        regbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {                                                       
                String name= namefield.getText();
                int age = 0;
                if(Integer.parseInt(agefield.getText())>=18)
                {
                    age=Integer.parseInt(agefield.getText());
                }
                else
                {
                    JOptionPane.showMessageDialog(caretakersignup.this,"Age should be greater than or equal to 18!");
                }
                String gender=(String)genderfield.getSelectedItem();
                String place=placefield.getText();
                int duration=Integer.parseInt(durationfield.getText());
                int cost=Integer.parseInt(costfield.getText());
                long mobile=Long.parseLong(mobilefield.getText());
                int exp=Integer.parseInt(expfield.getText()); 
                String avail=(String)availabilityfield.getSelectedItem();
                int len=emailfield.getText().length();
                String mail=null;
                if((emailfield.getText().substring(len-10,len)).equals("@gmail.com"))
                {
                    mail=emailfield.getText();
                }
                else
                {
                    JOptionPane.showMessageDialog(caretakersignup.this,"Enter a valid email id!"); 
                }
                String password = null;
                if((String.valueOf(createfield.getPassword())).equals(String.valueOf(confirmfield.getPassword())))
                {
                    password=String.valueOf(confirmfield.getPassword());
                }
                else
                {
                    JOptionPane.showMessageDialog(caretakersignup.this,"Enter the correct password!");
                }
                int a = (int)(Math.random() * (1000 - 100 + 1) + 100);
                caretaker c = new caretaker(a,name,age,gender,place,duration,cost,mobile,exp,avail,mail,password);
                int status=caretakerdata.save(c);
                if(status>0)
                {
                    JOptionPane.showMessageDialog(caretakersignup.this,"Caretaker profile submitted successfully!");
                    new login().setVisible(true);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(caretakersignup.this,"Sorry, Unable to submit user data!");
                }                                        
            }
        });
        backbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            { 
                new selection().setVisible(true);
                dispose();
            }
        });
        
        setVisible(true);
        setSize(1000, 900);
        setLayout(null);
        add(panel1);
        add(panel2);
	add(namelabel);
	add(emaillabel);
        add(createlbl);
        add(confirmlbl);
        add(agelabel);  
	add(placelabel);     
        add(genderlabel);  
	add(durationlabel); 
	add(costlabel);
	add(mobilelabel);        
	add(explabel);
        add(availlabel);
	add(namefield);
	add(emailfield);
        add(createfield);
        add(confirmfield);
	add(agefield);
        add(placefield);
        add(genderfield);
	add(durationfield);
	add(costfield);
	add(mobilefield);
	add(expfield);
        add(availabilityfield);
        add(regbtn);
        add(backbtn);
    }
    public static void main(String args[]){
         
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new caretakersignup().setVisible(true);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}