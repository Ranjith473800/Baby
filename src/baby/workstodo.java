
package baby;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class workstodo extends javax.swing.JFrame {
     
JTable table; 
JLabel slabel;
JTextField sfield;
String[][] data=new String[10][4];
int r=0;
   
workstodo()
{
    caretakerdata c=new caretakerdata();
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection co;
        co =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
        Statement st=(Statement) co.createStatement();
        PreparedStatement pss = co.prepareStatement("select * from c_workstodo where c_id=?");
        pss.setInt(1,Integer.parseInt(c.id));
        ResultSet rss = pss.executeQuery();
        while(rss.next())
        {
            data[r][0]=rss.getString(2);
            data[r][1]=rss.getString(3);
            data[r][2]=rss.getString(4);
            data[r][3]=rss.getString(5);
            r+=1;
        }
        String[] colnames={"User ID","Work 1","Work 2","Work 3"};
        table= new JTable(data,colnames); 
        JScrollPane s=new JScrollPane(table);
        table.setBounds(50,60,400,400);
        slabel=new JLabel("Enter ID");
        sfield=new JTextField("");
        JButton b=new JButton("View");
        slabel.setBounds(80,450,80,25);
        sfield.setBounds(200,450,100,25);
        b.setBounds(350,450,80,25);
        add(slabel);
        add(sfield);
        add(b);
        add(s);
        setSize(500,600);
        setVisible(true);
        b.addActionListener(new ActionListener()
        {
                  public void actionPerformed(ActionEvent e){
                      String str=sfield.getText();
                      if(str!=""){
                      JFrame f1 = new JFrame();
                     
                      JLabel tlabel,useridlabel,work1label,work2label,work3label,workstatuslabel;
                      JTextField useridfield,work1field,work2field,work3field,workstatusfield;
                      JButton submitbutton,backbutton;
                      int str1=Integer.parseInt(sfield.getText());
                      try
                          {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection co;
                                co =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull","root","");
                                Statement st=(Statement) co.createStatement();
                                PreparedStatement ps = co.prepareStatement("select * from c_workstodo where c_id=? AND u_id=?");
                                ps.setInt(1,Integer.parseInt(c.id));
                                ps.setInt(2,str1);
                                ResultSet rs = ps.executeQuery();
                                if(rs.next())
                                {
                                    tlabel=new JLabel("Your works");
                                    tlabel.setFont(new Font("Serif", Font.BOLD, 30));
                                    useridlabel=new JLabel();
                                    work1label=new JLabel();
                                    work2label=new JLabel();
                                    work3label=new JLabel();
                                    workstatuslabel=new JLabel();   
                                    useridfield=new JTextField();
                                    work1field=new JTextField();
                                    work2field=new JTextField();
                                    work3field=new JTextField();
                                    workstatusfield=new JTextField();
                                    submitbutton=new JButton("Submit");
                                    backbutton=new JButton("Back");
                                    useridlabel.setText("User ID");
                                    work1label.setText("Work 1");
                                    work2label.setText("Work 2");
                                    work3label.setText("Work 3");
                                    workstatuslabel.setText("Work Status");
                                    c.uid=rs.getString(2);
                                    useridfield.setText(rs.getString(2));
                                    work1field.setText(rs.getString(3));
                                    work2field.setText(rs.getString(4));
                                    work3field.setText(rs.getString(5));
                                    workstatusfield.setText(rs.getString(6));
                                    useridlabel.setBounds(400,300,100,25);
                                    work1label.setBounds(400,350,100,25);
                                    work2label.setBounds(400,400,100,25);
                                    work3label.setBounds(400,450,100,25);
                                    workstatuslabel.setBounds(400,500,100,25);
                                    useridfield.setBounds(600,300,100,25);
                                    work1field.setBounds(600,350,150,25);
                                    work2field.setBounds(600,400,150,25);
                                    work3field.setBounds(600,450,150,25);
                                    workstatusfield.setBounds(600,500,100,25);
                                    submitbutton.setBounds(500,600,100,25);
                                    useridfield.setEditable(false);
                                    work1field.setEditable(false);
                                    work2field.setEditable(false);
                                    work3field.setEditable(false);
                                    submitbutton.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        String wost=workstatusfield.getText();
                                        caretakerdata ct=new caretakerdata();
                                        int status=0;
                                        status = ct.workupdate(wost);
                                        if(status>0){
                                                String mail=null;
                                                JOptionPane.showMessageDialog(workstodo.this,"Status updated!");
                                                try
                                                {
                                                PreparedStatement p2=co.prepareStatement("select u_email from user where u_id=?");
                                                p2.setInt(1,str1);
                                                ResultSet rs=p2.executeQuery();
                                                while(rs.next())
                                                {   
                                                    mail=rs.getString(1);
                                                }
                                                JavaMail j=new JavaMail();
                                                if(mail!=null)
                                                {
                                                    j.accept(mail,"The work you assigned is completed");
                                                }
                                                }
                                                catch(SQLException e2)
                                                {
                                                    System.out.println(e2);
                                                }
                                            }
                                        }
                                    });
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
		
	JLabel mainlabel = new JLabel("YOUR WORKS");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(250, 35, 400, 60);
	panel2.add(mainlabel);
        
        f1.setVisible(true);
        f1.setSize(1000,900);
        f1.setLayout(null);
        f1.add(useridfield);
        f1.add(useridlabel);
        f1.add(work1label);
        f1.add(work2field);
        f1.add(work3field);
        f1.add(work1field);
        f1.add(work2label);
        f1.add(work3label);
        f1.add(workstatuslabel);
        f1.add(workstatusfield);
        f1.add(submitbutton);
        f1.add(panel1);
        f1.add(panel2);
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
}
catch(Exception e3){
    System.out.print(e3);
}

}

 public static void main(String args[])
    {
     new workstodo();
    }


}