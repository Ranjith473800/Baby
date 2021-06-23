
package baby;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userworkassign extends javax.swing.JFrame{
    JLabel tlabel,caretakeridlabel,work1label,work2label,work3label,workstatuslabel;
    JTextField caretakeridfield,work1field,work2field,work3field,workstatusfield;
    JButton submitbutton;
    
    userworkassign(){
        userdata u=new userdata();
        userdata.work();
        tlabel=new JLabel("Assign Works");
        tlabel.setFont(new Font("Serif", Font.BOLD, 30));
        caretakeridlabel=new JLabel();
        work1label=new JLabel();
        work2label=new JLabel();
        work3label=new JLabel();
        workstatuslabel=new JLabel();
        
        caretakeridfield=new JTextField();
        work1field=new JTextField();
        work2field=new JTextField();
        work3field=new JTextField();
        workstatusfield=new JTextField();
        submitbutton=new JButton("Submit");
        
        
        caretakeridlabel.setText("Caretaker ID");
        work1label.setText("Work 1");
        work2label.setText("Work 2");
        work3label.setText("Work 3");
        workstatuslabel.setText("Work Status");
        caretakeridfield.setText(u.cid);
        work1field.setText(u.w1);
        work2field.setText(u.w2);
        work3field.setText(u.w3);
        workstatusfield.setText(u.workstatus);
        caretakeridfield.setEditable(false);
        
        caretakeridlabel.setBounds(400,250,100,25);
        work1label.setBounds(400,300,100,25);
        work2label.setBounds(400,350,100,25);
        work3label.setBounds(400,400,100,25);
        workstatuslabel.setBounds(400,450,100,25);
        
        caretakeridfield.setBounds(600,250,100,25);
        work1field.setBounds(600,300,225,25);
        work2field.setBounds(600,350,225,25);
        work3field.setBounds(600,400,225,25);
        workstatusfield.setBounds(600,450,100,25);
        
        submitbutton.setBounds(400,500,100,25);
        
        workstatusfield.setEditable(false);
        submitbutton.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                      userdata ld=new userdata();
                     String wo1=work1field.getText();
                     String wo2=work2field.getText();
                     String wo3=work3field.getText();
                     int status=0;
                      status =ld.userwork(wo1,wo2,wo3);
                      if(status>0)
                  {
                     JOptionPane.showMessageDialog(userworkassign.this,"Work Assigned Successfully!");
                   }
        else{
            JOptionPane.showMessageDialog(userworkassign.this,"Sorry, Unable to assign work");
        }             
        
                  }
          });
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
		
	JLabel mainlabel = new JLabel("ASSIGN WORKS");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(196, 35, 354, 60);
	panel2.add(mainlabel);
        
        setVisible(true);
        setSize(1000, 900);
        setLayout(null);
        add(panel1);
        add(panel2);
        
        add(tlabel);
        add(caretakeridfield);
        add(caretakeridlabel);
        add(work1label);
        add(work2field);
        add(work3field);
        add(work1field);
        add(work2label);
        add(work3label);
        add(workstatuslabel);
        add(workstatusfield);
        add(submitbutton);
        
    }
    public static void main(String args[]){
        new userworkassign();
    }
}