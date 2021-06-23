package baby;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class searchcaretaker extends javax.swing.JFrame {
     
     JLabel l1;
     JComboBox tf5;
   JButton btn1;
   
searchcaretaker()
{

setTitle(" Search Caretaker");

l1 = new JLabel("ENTER YOUR LOCATION : ");
tf5 = new JComboBox();

btn1 = new JButton("SEARCH");
try
{
    Class.forName("com.mysql.jdbc.Driver");
    Connection co;
    co =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
    Statement st=(Statement) co.createStatement();
    PreparedStatement pss1 = co.prepareStatement("select DISTINCT c_place from caretaker");
    ResultSet rs = pss1.executeQuery();
    while(rs.next())
    {
        tf5.addItem(rs.getString("c_place"));
    }
}   
catch(Exception e)
{
    System.out.println("combo box"+e);
}

l1.setBounds(300, 300, 200, 30);
tf5.setBounds(500, 300, 200, 30);


btn1.setBounds(520,400, 100, 30);

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
                    dispose();
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
                    dispose();
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
                    dispose();
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
		
	JLabel mainlabel = new JLabel("SEARCH");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(196, 35, 354, 60);
	panel2.add(mainlabel);
    setVisible(true);
    setSize(1000, 900);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(panel1);
    add(panel2);
    add(l1);
    add(tf5);
    add(btn1);
btn1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
{
JFrame f= new JFrame();
JTable table; 
JLabel slabel;
JTextField sfield;
   String[][] data=new String[2][5];
int r=0;
String str1 = (String) tf5.getSelectedItem();
try
{
        Class.forName("com.mysql.jdbc.Driver");
                    Connection co;
                        co =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
                    Statement st=(Statement) co.createStatement();
                    PreparedStatement pss = co.prepareStatement("select * from caretaker where c_place=? AND c_avail=?");
pss.setString(1,str1);
pss.setString(2,"available");
ResultSet rs = pss.executeQuery();
while(rs.next())
{
 data[r][0]=rs.getString(1);
 data[r][1]=rs.getString(2);
 data[r][2]=rs.getString(7);
data[r][3]=rs.getString(8);
data[r][4]=rs.getString(9);
  r+=1;
    
}
String[] colnames={"Caretaker ID","Name","Cost","Mobile","Experience"};
   table= new JTable(data,colnames); 
   JScrollPane s=new JScrollPane(table);
   table.setBounds(50,60,400,400);
   slabel=new JLabel("Enter ID");
   sfield=new JTextField("");
   JButton b=new JButton("View");
   slabel.setBounds(80,450,80,25);
   sfield.setBounds(200,450,100,25);
   b.setBounds(350,450,80,25);
   f.add(slabel);
   f.add(sfield);
   f.add(b);
    f.add(s);
    
   f.setSize(500,600);
  f.setVisible(true);
  
  b.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                      JFrame f1 = new JFrame();
                     JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11;
                      JButton but,back;
                      int str=Integer.parseInt(sfield.getText());
                      try
                          {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection co;
                                co =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
                                Statement st=(Statement) co.createStatement();
                                PreparedStatement pss = co.prepareStatement("select * from caretaker where c_id=?");
pss.setInt(1,str);
ResultSet rs = pss.executeQuery();
if(rs.next())
{

f1.setVisible(true);
f1.setSize(1000,900);
f1.setLayout(null);
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
		
	JLabel mainlabel = new JLabel("CARETAKER DETAILS ");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(300, 35, 500, 60);
	panel2.add(mainlabel);
k1 = new JLabel();
k2=new JLabel();
k3=new JLabel();
k4=new JLabel();
k5=new JLabel();
k6=new JLabel();
k7=new JLabel();
k8=new JLabel();
k9=new JLabel();
k10=new JLabel();
k11=new JLabel();
l1 = new JLabel();
l2=new JLabel();
l3=new JLabel();
l4=new JLabel();
l5=new JLabel();
l6=new JLabel();
l7=new JLabel();
l8=new JLabel();
l9=new JLabel();
l10=new JLabel();
l11=new JLabel();
but=new JButton("Send Request");
back=new JButton("Back");
k1.setBounds(400,200,200, 30);
k2.setBounds(400,250,200,30);
k3.setBounds(400,300,200,30);
k4.setBounds(400,350,200,30);
k5.setBounds(400,400,200,30);
k6.setBounds(400,450,200,30);
k7.setBounds(400,500,200,30);
k8.setBounds(400,550,200,30);
k9.setBounds(400,600,200,30);
k10.setBounds(400,650,200,30);
k11.setBounds(400,700,200,30);
l1.setBounds(550, 200, 200, 30);
l2.setBounds(550,250,200,30);
l3.setBounds(550,300,200,30);
l4.setBounds(550,350,200,30);
l5.setBounds(550,400,200,30);
l6.setBounds(550,450,200,30);
l7.setBounds(550,500,200,30);
l8.setBounds(550,550,200,30);
l9.setBounds(550,600,200,30);
l10.setBounds(550,650,200,30);
l11.setBounds(550,700,200,30);
back.setBounds(350,800,150,25);
but.setBounds(550,800,150,25);
f1.add(l1);
f1.add(l2);
f1.add(l3);
f1.add(l4);
f1.add(l5);
f1.add(l6);
f1.add(l7);
f1.add(l8);
f1.add(l9);
f1.add(l10);
f1.add(l11);
f1.add(k1);
f1.add(k2);
f1.add(k3);
f1.add(k4);
f1.add(k5);
f1.add(k6);
f1.add(k7);
f1.add(k8);
f1.add(k9);
f1.add(k10);
f1.add(k11);
f1.add(but);
f1.add(back);
f1.add(mainlabel);
f1.add(panel1);
f1.add(panel2);
k1.setText("Caretaker ID");
k2.setText("Name");
k3.setText("Age");
k4.setText("Gender");
k5.setText("Place");
k6.setText("Duration");
k7.setText("Cost");
k8.setText("Mobile no");
k9.setText("Experience");
k10.setText("Available");
k11.setText("Email");
int id=Integer.parseInt(rs.getString(1));
l1.setText(rs.getString(1));
String name=rs.getString(2);
l2.setText(rs.getString(2));
int age=Integer.parseInt(rs.getString(3));
l3.setText(rs.getString(3));
String gender=rs.getString(4);
l4.setText(rs.getString(4));
String place=(rs.getString(5));
l5.setText(rs.getString(5));
int duration=Integer.parseInt(rs.getString(6));
l6.setText(rs.getString(6));
int cost=Integer.parseInt(rs.getString(7));
l7.setText(rs.getString(7));
long mobile=Long.parseLong(rs.getString(8));
l8.setText(rs.getString(8));
int exp=Integer.parseInt(rs.getString(9));
l9.setText(rs.getString(9));
String avail=rs.getString(10);
l10.setText(rs.getString(10));
String email=rs.getString(11);
l11.setText(rs.getString(11));

but.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent e){
        f.dispose();
        userdata obj=new userdata();
        int id1=Integer.parseInt(obj.id);
        String email1=obj.email;
        String name1=obj.name;
        int age1=Integer.parseInt(obj.age);
        String gender1=obj.gender;
        String place1=obj.place;
        String date1=obj.date;
        String time1=obj.time;
        int duration1=Integer.parseInt(obj.duration);
        Long mobile1=Long.parseLong(obj.mobile);
        int sa=0,sm=0;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection co;
           co =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
           PreparedStatement ps1 = co.prepareStatement("insert into c_requestlist(c_id,u_id,u_name,u_age,u_gender,u_place,u_date,u_time,u_duration,u_mobile,u_email,status)values(?,?,?,?,?,?,?,?,?,?,?,?)");
           ps1.setInt(1,id);
           ps1.setInt(2,id1);
            ps1.setString(3,name1);
            ps1.setInt(4,age1);
            ps1.setString(5,gender1);
            ps1.setString(6,place1);
            ps1.setString(7,date1);
            ps1.setString(8,time1);
            ps1.setInt(9,duration1);
            ps1.setLong(10,mobile1);
            ps1.setString(11,email1);
            ps1.setString(12,"null");
            sa=ps1.executeUpdate();
            if(sa>0){
                JOptionPane.showMessageDialog(null,"Valid Request");
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid Request");
            }
           
            PreparedStatement ps=co.prepareStatement("insert into u_requestlist(u_id,c_id,c_name,c_age,c_gender,c_place,c_duration,c_cost,c_mobile,c_exp,c_avail,c_mail,status)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(3,name);
            ps.setInt(4,age);
            ps.setString(5,gender);
            ps.setString(6,place);
            ps.setInt(7,duration);
            ps.setInt(8,cost);
            ps.setLong(9,mobile);
            ps.setInt(10,exp);
            ps.setString(11,avail);
            ps.setString(12,email);
            ps.setInt(1,id1);
            ps.setInt(2,id);
            ps.setString(13,"null");
            sm=ps.executeUpdate();
            if(sm>0){
               JOptionPane.showMessageDialog(null,"Request Sent");
               f1.dispose();
            }
            else{
               JOptionPane.showMessageDialog(null,"Unable to send Request");
            }
            co.close();
            obj.cid=String.valueOf(id);
            obj.cname=name;
            obj.cage=String.valueOf(age);
            obj.cgender=gender;
            obj.cduration=String.valueOf(duration);
            obj.cplace=place;
            obj.ccost=String.valueOf(cost);
            obj.cmobile=String.valueOf(mobile);
            obj.cexp=String.valueOf(exp);
            obj.cavail=avail;
            obj.cemail=email;
            obj.cstatus="null";
            
       }
       catch(Exception evt){
           System.out.print(evt);
       }
      
   }
});
back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new searchcaretaker().setVisible(true);
                dispose();
            }
        });
} 
else
{
JOptionPane.showMessageDialog(null,
"Incorrect value entered...Try Again with correct detail");
}
}
catch (Exception ex)
{
System.out.println(ex);
}
}

});
}
catch(Exception e2){
    System.out.print(e2);
}     
                  }
          });
  
}



    public static void main(String args[])
    {
     searchcaretaker s=new searchcaretaker();
    }


}