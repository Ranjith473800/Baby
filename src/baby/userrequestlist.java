
package baby;
import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class userrequestlist extends javax.swing.JFrame
{
    JLabel idlabel,namelabel,agelabel,genderlabel,placelabel,costlabel,explabel,durationlabel,mobilelabel,emaillabel,availlabel,statuslabel;
    JTextField idfield,namefield,agefield,genderfield,placefield,costfield,expfield,durationfield,mobilefield,emailfield,availfield,statusfield;
    
    userrequestlist()
    {
      
        userdata obj=new userdata();
        userdata.urequest(obj.id);
        String id=obj.cid;
        String name=obj.cname;
        String age=obj.cage;
        String gender=obj.cgender;
        String place=obj.cplace;
        String duration=obj.cduration;
        String cost=obj.ccost;
        String exp=obj.cexp;
        String mobile=obj.cmobile;
        String email=obj.cemail;
        String avail=obj.cavail;
        String status=obj.cstatus;
        
        idlabel=new JLabel();
        idfield=new JTextField();
        namelabel = new JLabel();
        namefield = new JTextField();
        agelabel = new JLabel();
        genderlabel = new JLabel();
        genderfield = new JTextField();
        placelabel = new JLabel();
        placefield = new JTextField();
        costlabel = new JLabel();
        costfield = new JTextField();
        explabel = new JLabel();
        expfield = new JTextField();
        durationlabel = new JLabel();
        durationfield = new JTextField();
        mobilelabel = new JLabel();
        mobilefield = new JTextField();
        agefield = new JTextField();
        emaillabel = new JLabel();
        availlabel=new JLabel();
        availfield=new JTextField();
        emailfield = new JTextField();
        statuslabel=new JLabel();
        statusfield=new JTextField();
        
        idfield.setText(id);
        namefield.setText(name);
        agefield.setText(age);
        genderfield.setText(gender);
        placefield.setText(place);
        durationfield.setText(duration);
        costfield.setText(cost);
        mobilefield.setText(mobile);
        expfield.setText(exp);
        availfield.setText(avail);
        emailfield.setText(email);
        statusfield.setText(status);
        
        idlabel.setText("Caretaker ID");
        namelabel.setText("Name");
        agelabel.setText("Caretaker's Age");
        genderlabel.setText("Caretaker's Gender");
        placelabel.setText("Place");
        durationlabel.setText("Duration");
        costlabel.setText("Cost");
        mobilelabel.setText("Mobile no");
        explabel.setText("Experience");
        availlabel.setText("Available");
        emaillabel.setText("Email");
        statuslabel.setText("Status");
        
        idfield.setEditable(false);
        namefield.setEditable(false);
        agefield.setEditable(false);
        genderfield.setEditable(false);
        placefield.setEditable(false);
        durationfield.setEditable(false);
        costfield.setEditable(false);
        statusfield.setEditable(false);
        mobilefield.setEditable(false);
        emailfield.setEditable(false);
        expfield.setEditable(false);
        availfield.setEditable(false);
        
        
        
        idlabel.setBounds(300,200,100,25);
        namelabel.setBounds(300,250,100,25);
        genderlabel.setBounds(300,300,100,25);
        durationlabel.setBounds(300,350,250,25);
        mobilelabel.setBounds(300,400,100,25);
        availlabel.setBounds(300,450,100,25);
        
        idfield.setBounds(425,200,150,25);
        namefield.setBounds(425,250,150,25);
        genderfield.setBounds(425,300,150,25);
        durationfield.setBounds(425,350,150,25);
        mobilefield.setBounds(425,400,150,25);
        availfield.setBounds(425,450,150,25);
        
        emaillabel.setBounds(625,200,100,25);
        agelabel.setBounds(625,250,100,25);
        placelabel.setBounds(625,300,100,25);
        costlabel.setBounds(625,350,100,25);
        explabel.setBounds(625,400,100,25);
        statuslabel.setBounds(625,450,100,25);
        
        emailfield.setBounds(750,200,150,25);
        agefield.setBounds(750,250,150,25);
        placefield.setBounds(750,300,150,25);
        costfield.setBounds(750,350,150,25);
        expfield.setBounds(750,400,150,25);
        statusfield.setBounds(750,450,150,25);
		
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
		
	JLabel mainlabel = new JLabel("REQUEST");
	mainlabel.setForeground(new Color(0, 0, 0));
	mainlabel.setFont(new Font("Tahoma", Font.BOLD, 36));
	mainlabel.setBounds(196, 35, 354, 60);
	panel2.add(mainlabel);
        
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
        add(emaillabel);
        add(costlabel);
        add(explabel);
        add(durationlabel);
        add(mobilelabel);
        add(availlabel);
        add(idfield);
        add(namefield);
        add(agefield);
        add(genderfield);
        add(placefield);
        add(emailfield);
        add(costfield);
        add(expfield);
        add(durationfield);
        add(mobilefield);
        add(statusfield);
        add(statuslabel);
        add(availfield);
        
    }
    public static void main(String args[])
    {
        userrequestlist ur= new userrequestlist();
    }
}