/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;

public class caretakeredit extends javax.swing.JFrame
{
    String s1[]={"male","female","others"};
    String s2[]={"available","not available"};
    JButton editbutton;
    JComboBox<String> genderfield= new JComboBox<>(s1);
    JComboBox<String> availabilityfield=new JComboBox<>(s2);
    JTextField idfield,namefield,agefield,placefield,emailfield,expfield,costfield,durationfield,mobilefield;
    JPasswordField passwordfield;
    JLabel idlabel,namelabel,agelabel,genderlabel,placelabel,passwordlabel,emaillabel,costlabel,explabel,durationlabel,mobilelabel,availlabel,EditProfilelabel;
    public caretakeredit()
    {
        initialize();
        caretakerdata ob=new caretakerdata();
        ob.display();
        String id1=ob.id;
        String name1=ob.name;
        String age1=ob.age;
        String gender1=ob.gender;
        String place1=ob.place;
        String duration1=ob.duration;
        String cost1=ob.cost;
        String mobile1=ob.mobile;
        String exp1=ob.exp;
        String avail1=ob.avail;
        String mail1=ob.mail;
        String password1=ob.password;
        
        idfield.setText(id1);
        namefield.setText(name1);
        agefield.setText(age1);
        placefield.setText(place1);
        durationfield.setText(duration1);
        expfield.setText(exp1);
        mobilefield.setText(mobile1);
        emailfield.setText(mail1);
        costfield.setText(cost1);
        passwordfield.setText(password1);
        genderfield.setSelectedItem(gender1);
        availabilityfield.setSelectedItem(avail1);
    }    
    private void initialize()
    {
        
        JPanel panel1 = new JPanel();
	panel1.setBounds(0, 0, 230, 1000);
	panel1.setBackground(new Color(102, 205, 170));
	panel1.setBorder(null);
		
	JButton editprofilebtn = new JButton("           Edit Profile");
	editprofilebtn.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\edit profile.png"));
	editprofilebtn.setBounds(0, 175, 230, 50);
	editprofilebtn.setHorizontalAlignment(SwingConstants.LEFT);
	editprofilebtn.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
                    new caretakeredit().setVisible(true);
                    dispose();
		}
	});
	panel1.setLayout(null);
	editprofilebtn.setBackground(new Color(102, 205, 170));
	panel1.add(editprofilebtn);
	JButton myprofilebtn = new JButton("          My profile");
	myprofilebtn.setBackground(new Color(102, 205, 170));
	myprofilebtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    new caretakerview().setVisible(true);
                    dispose();
		}
	});
	myprofilebtn.setBounds(0, 125, 230, 50);
	myprofilebtn.setHorizontalAlignment(SwingConstants.LEFT);
	panel1.add(myprofilebtn);
	myprofilebtn.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\my profile.png"));
		
	JButton reqrebtn = new JButton("     Requests Received");
	reqrebtn.setBackground(new Color(102, 205, 170));
	reqrebtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    new caretakerrequestlist().setVisible(true);
                    dispose();
		}
	});
        
	reqrebtn.setBounds(0, 225, 230, 50);
	reqrebtn.setHorizontalAlignment(SwingConstants.LEFT);
	reqrebtn.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\requests.png"));
	panel1.add(reqrebtn);
		
	JButton workstodobtn = new JButton("          Works to do");
	workstodobtn.setBackground(new Color(102, 205, 170));
	workstodobtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    new workstodo().setVisible(true);
                    dispose();
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
                            dispose();
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
	mainlabel.setBounds(196, 35, 400, 60);
	panel2.add(mainlabel);
        
        idlabel =       new JLabel("ID");
	idlabel.setBounds(400, 200, 150, 20);
	
	namelabel =       new JLabel("NAME");
	namelabel.setBounds(400, 240, 150, 20);
        
	emaillabel =       new JLabel("EMAIL");
	emaillabel.setBounds(400, 280, 150, 20);
        
	agelabel =        new JLabel("AGE");
	agelabel.setBounds(400, 320, 150, 20);
        
        placelabel = new JLabel("PLACE");
	placelabel.setBounds(400, 360, 123, 16);
        
	genderlabel =     new JLabel("GENDER");
	genderlabel.setBounds(400, 400, 150, 20);
        
	durationlabel =   new JLabel("DURATION");
	durationlabel.setBounds(400, 440, 150, 20);
        
	costlabel =       new JLabel("COST");
	costlabel.setBounds(400, 480, 150, 20);
        
	mobilelabel =     new JLabel("MOBILE");
	mobilelabel.setBounds(400, 520, 150, 20);
        
	explabel = new JLabel("EXPERIENCE");
	explabel.setBounds(400, 560, 150, 20);
        
        availlabel =   new JLabel("AVAILABILITY");
        availlabel.setBounds(400, 600, 150, 20);
        
        passwordlabel =   new JLabel("PASSWORD");
        passwordlabel.setBounds(400, 640, 150, 20);
        
        idfield = new JTextField();
	idfield.setBounds(600, 200, 200, 25);
	idfield.setColumns(10);
        idfield.setEditable(false);        
		
	namefield = new JTextField();
	namefield.setBounds(600, 240, 200, 25);
	namefield.setColumns(10);
		
	emailfield = new JTextField();
	emailfield.setBounds(600, 280, 200, 25);
	emailfield.setColumns(10);
		
	agefield = new JTextField();
	agefield.setBounds(600, 320, 200, 25);
	agefield.setColumns(10);
                
        placefield = new JTextField();
	placefield.setBounds(600, 360, 200, 25);
	placefield.setColumns(10);		
                        
	genderfield.setBounds(600, 400, 200, 25);
                
	durationfield = new JTextField();
	durationfield.setBounds(600, 440, 200, 25);
	durationfield.setColumns(10);
		
	costfield = new JTextField();
	costfield.setBounds(600, 480, 200, 25);
        costfield.setColumns(10);
		
	mobilefield = new JTextField();
	mobilefield.setBounds(600, 520, 200, 25);
	mobilefield.setColumns(10);
		
	expfield = new JTextField();
	expfield.setBounds(600, 560, 200, 25);
	expfield.setColumns(10);

	availabilityfield.setBounds(600, 600, 200, 25);

        passwordfield = new JPasswordField();
	passwordfield.setBounds(600, 640, 200, 25);
	passwordfield.setColumns(10);
        
        editbutton=new JButton("SUBMIT");
        editbutton.setBounds(550,750,100,25);
        
        
        editbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String name= namefield.getText();
                int age = parseInt(agefield.getText());
                if(Integer.parseInt(agefield.getText())>=18)
                {
                    age=Integer.parseInt(agefield.getText());
                }
                else
                {
                    JOptionPane.showMessageDialog(caretakeredit.this,"Age should be greater than or equal to 18!");
                }
                String gender=(String)genderfield.getSelectedItem();
                String place=placefield.getText();
                int duration=Integer.parseInt(durationfield.getText());
                int cost=Integer.parseInt(costfield.getText());
                long mobile=Long.parseLong(mobilefield.getText());
                int exp=Integer.parseInt(expfield.getText());
                String avail=(String)availabilityfield.getSelectedItem();
                int len=emailfield.getText().length();
                String mail=emailfield.getText();
                String password = String.valueOf(passwordfield.getPassword());
                int id=Integer.parseInt(idfield.getText());
                caretaker c = new caretaker(id,name,age,gender,place,duration,cost,mobile,exp,avail,mail,password);
                int status=caretakerdata.update(c);
                if(status>0)
                {
                    JOptionPane.showMessageDialog(caretakeredit.this,"Caretaker profile updated successfully!");
                }
                else
                {
                    JOptionPane.showMessageDialog(caretakeredit.this,"Sorry, Unable to update data!");
                }               
            }
        });
        setVisible(true);
        setSize(1000, 900);
        setLayout(null);
        add(panel1);
        add(panel2);
        add(idlabel);
	add(namelabel);
	add(emaillabel);  
        add(agelabel);  
	add(placelabel);     
        add(genderlabel);  
	add(durationlabel); 
	add(costlabel);
	add(mobilelabel);        
	add(explabel);
        add(availlabel);
        add(passwordlabel);
	add(idfield);
	add(namefield);
	add(emailfield);
	add(agefield);
        add(placefield);
        add(genderfield);
	add(durationfield);
	add(costfield);
	add(mobilefield);
	add(expfield);
        add(availabilityfield);
        add(passwordfield);
        add(editbutton);
    }
    public static void main(String args[])
    { 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new caretakeredit().setVisible(true);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
}
}