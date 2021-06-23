/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class caretakerrequestlist extends javax.swing.JFrame 
{
     
JTable table; 
JLabel slabel,loginlbl;
JTextField sfield;
String[][] data=new String[10][6];
int r=0;
   
caretakerrequestlist()
{
caretakerdata c=new caretakerdata();
try
{
        Class.forName("com.mysql.jdbc.Driver");
        Connection co;
        co =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
                    Statement st=(Statement) co.createStatement();
PreparedStatement pss = co.prepareStatement("select * from c_requestlist where c_id=?");
pss.setInt(1,Integer.parseInt(c.id));
ResultSet rss = pss.executeQuery();
while(rss.next())
{
    data[r][0]=rss.getString(2);
    data[r][1]=rss.getString(3);
    data[r][2]=rss.getString(6);
    data[r][3]=rss.getString(7);
    data[r][4]=rss.getString(8);
    data[r][5]=rss.getString(9);
  r+=1;
}
   String[] colnames={"  User      ID","Name","Place","Date","Time","Duration"};
   table= new JTable(data,colnames); 
   JScrollPane s=new JScrollPane(table);
   s.getViewport().setViewPosition(new Point(230,200));
   loginlbl = new JLabel("         ID           Name               Place              Date             Time            Duration");
   loginlbl.setBounds(250,180,500,20);
   loginlbl.setFont(new Font("Serif", Font.BOLD, 14));
   table.setBounds(250,200,500,160);
   slabel=new JLabel("Enter ID");
   sfield=new JTextField("");
   JButton b=new JButton("SUBMIT");
   slabel.setBounds(300,450,80,25);
   sfield.setBounds(350,450,100,25);
   b.setBounds(500,450,80,25);
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
		
	JLabel mainlabel = new JLabel("REQUESTS RECEIVED");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(150, 35, 500, 60);
	panel2.add(mainlabel);
   
  
  b.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                      String str=sfield.getText();
                      if(str!=null){
                      JFrame f1 = new JFrame();
                     
                      JLabel tlabel,idlabel,namelabel,agelabel,genderlabel,placelabel,datelabel,timelabel,durationlabel,mobilelabel,emaillabel;
                      JTextField idfield,namefield,agefield,genderfield,placefield,datefield,timefield,durationfield,mobilefield,emailfield;
                      JButton acceptbutton,rejectbutton,backbutton;
                      int str1=Integer.parseInt(sfield.getText());
                      try
                          {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection co;
                    co =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
                    Statement st=(Statement) co.createStatement();
PreparedStatement ps = co.prepareStatement("select * from c_requestlist where c_id=? AND u_id=?");
ps.setInt(1,Integer.parseInt(c.id));
ps.setInt(2,str1);
ResultSet rs = ps.executeQuery();
if(rs.next())
{
         
       tlabel=new JLabel("Request Details");
        tlabel.setFont(new Font("Serif", Font.BOLD, 30));
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
        
        emailfield = new JTextField();
      
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
        
        int k=Integer.parseInt(rs.getString(2));
        c.uid=String.valueOf(k);
        idfield.setText(rs.getString(2));
        namefield.setText(rs.getString(3));
        agefield.setText(rs.getString(4));
        genderfield.setText(rs.getString(5));
        placefield.setText(rs.getString(6));
        datefield.setText(rs.getString(7));
        timefield.setText(rs.getString(8));
        durationfield.setText(rs.getString(9));
        mobilefield.setText(rs.getString(10));
        emailfield.setText(rs.getString(11));
        idfield.setEditable(false);
        namefield.setEditable(false);
        agefield.setEditable(false);
        genderfield.setEditable(false);
        placefield.setEditable(false);
        datefield.setEditable(false);
        timefield.setEditable(false);
        durationfield.setEditable(false);
        mobilefield.setEditable(false);
        emailfield.setEditable(false);

        acceptbutton=new JButton("Accept");
        rejectbutton=new JButton("Reject");
        backbutton=new JButton("Back");
        
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
		
	JButton reqrebtn = new JButton("     Requests Recieved");
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
		
	JLabel mainlabel = new JLabel(" PARENT DETAILS");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(250, 35, 400, 60);
       
        tlabel.setBounds(300,25,200,30);
        idlabel.setBounds(300,200,100,25);
        namelabel.setBounds(300,250,100,25);
        genderlabel.setBounds(300,300,100,25);
        datelabel.setBounds(300,350,250,25);
        durationlabel.setBounds(300,400,100,25);
        
        idfield.setBounds(425,200,100,25);
        namefield.setBounds(425,250,100,25);
        genderfield.setBounds(425,300,100,25);
        datefield.setBounds(425,350,100,25);
        durationfield.setBounds(425,400,100,25);
        
        acceptbutton.setBounds(400,500,100,25);
        
        emaillabel.setBounds(625,200,100,25);
        agelabel.setBounds(625,250,100,25);
        placelabel.setBounds(625,300,100,25);
        timelabel.setBounds(625,350,100,25);
        mobilelabel.setBounds(625,400,100,25);
       
        emailfield.setBounds(750,200,100,25);
        agefield.setBounds(750,250,100,25);
        placefield.setBounds(750,300,100,25);
        timefield.setBounds(750,350,100,25);
        mobilefield.setBounds(750,400,100,25);
        
        rejectbutton.setBounds(600,500,100,25);
        backbutton.setBounds(350,500,100,25);
        
        f1.setVisible(true);
        f1.setSize(1000, 900);
        f1.setLayout(null);
        f1.add(mainlabel);
        f1.add(panel1);
        f1.add(panel2);
        f1.add(idlabel);
        f1.add(namelabel);
        f1.add(agelabel);
        f1.add(genderlabel);
        f1.add(placelabel);
        f1.add(emaillabel);
        f1.add(timelabel);
        f1.add(datelabel);
        f1.add(durationlabel);
        f1.add(mobilelabel);
         f1.add(idfield);
         
         f1.add(namefield);
         f1.add(agefield);
         f1.add(genderfield);
         f1.add(placefield);
         f1.add(emailfield);
         f1.add(timefield);
         f1.add(datefield);
         f1.add(durationfield);
         f1.add(mobilefield);
         f1.add(acceptbutton);
         f1.add(rejectbutton);
         
         acceptbutton.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                      int status=0,stat=0;
                      try{
                          String mail=null;
                          Class.forName("com.mysql.jdbc.Driver");
                          Connection co;
                          co=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
                          PreparedStatement ps1=co.prepareStatement("update u_requestlist set status=? where c_id=? AND u_id=?");
                          PreparedStatement p=co.prepareStatement("update c_requestlist set status=? where c_id=? AND u_id=?");
                          PreparedStatement p2=co.prepareStatement("select u_email from user where u_id=?");
                          ps1.setString(1,"Accepted");
                          ps1.setInt(2,Integer.parseInt(c.id));
                          ps1.setInt(3,k);
                          p.setString(1,"Accepted");
                          p.setInt(2,Integer.parseInt(c.id));
                          p.setInt(3,k);
                          p2.setInt(1,k);
                          ResultSet rs=p2.executeQuery();
                          while(rs.next())
                          {   
                              mail=rs.getString(1);
                          }
                          stat=p.executeUpdate();
                          status=ps1.executeUpdate();
                          if(status>0 && stat>0)
                          {
                              JOptionPane.showMessageDialog(caretakerrequestlist.this,"You accepted a request!");
                              JavaMail j=new JavaMail();
                              if(mail!=null)
                              {
                                j.accept(mail,"Your Request is accepted");
                              }
                          }
                          else{
                              JOptionPane.showMessageDialog(caretakerrequestlist.this,"Unable to accept the request!");
                          }
                      }
                      catch(Exception et){
                          System.out.print(et);
                      }
                  }
          });
        rejectbutton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int status=0,stat=0;
            try{
                String mail=null;
                Class.forName("com.mysql.jdbc.Driver");
                          Connection co;
                          co=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
                          PreparedStatement ps2=co.prepareStatement("update u_requestlist set status=? where c_id=? AND u_id=?");
                          PreparedStatement p2=co.prepareStatement("delete from c_requestlist where c_id=? AND u_id=?");
                          PreparedStatement p3=co.prepareStatement("select u_email from user where u_id=?");
                          ps2.setString(1,"Rejected");
                          ps2.setInt(2,Integer.parseInt(c.id));
                          ps2.setInt(3,k);
                          p2.setInt(1,Integer.parseInt(c.id));
                          p2.setInt(2,k);
                          p3.setInt(1,k);
                          status=ps2.executeUpdate();
                          stat=p2.executeUpdate();
                          ResultSet rs=p3.executeQuery();
                          while(rs.next())
                          {   
                              mail=rs.getString(1);
                          }
                          
                          if(status>0 && stat>0)
                          {
                              JOptionPane.showMessageDialog(caretakerrequestlist.this,"You rejected a request!");
                              new caretakerrequestlist().setVisible(true);
                              JavaMail j=new JavaMail();
                              if(mail!=null)
                              {
                                j.reject(mail,"Your Request is rejected");
                              }
                          }
                          else{
                              JOptionPane.showMessageDialog(caretakerrequestlist.this,"Unable to accept the request!");
                          }
                          c.uname=c.uid=c.uage=c.ugender=c.uplace=c.udate=c.utime=c.uduration=c.umobile=c.uemail="";
            }
            catch(Exception e1){
                System.out.print(e1);
            }
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
                      else{
                          JOptionPane.showMessageDialog(null,"Enter an UserID to view profile");

                      }
                      
  }
});
      
  setSize(1000,900);
  setVisible(true);
  add(panel1);
  add(panel2);
  add(table);
  add(slabel);
  add(loginlbl);
   add(sfield);
   add(b);
   add(s);

}
catch(Exception e3){
    System.out.print(e3);
}

}

 public static void main(String args[])
    {
     new caretakerrequestlist();
    }


}