
package baby;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends javax.swing.JFrame
{
    JLabel loginlbl,maillbl,passlbl;
    JButton loginbtn,backbtn;
    JTextField mailfield;
    JPasswordField passwordfield;
    
    public login()
    {
        loginlbl = new JLabel("CARETAKER LOGIN");
       	loginlbl.setBounds(350, 100, 350, 70);
        loginlbl.setFont(new Font("Serif", Font.BOLD, 30));
        
        maillbl= new JLabel("EMAIL      ");
        maillbl.setBounds(225, 250, 200, 30);
        maillbl.setFont(new Font("Serif", Font.BOLD, 18));
        
        passlbl= new JLabel("PASSWORD   ");
        passlbl.setBounds(225, 350, 200, 25);
        passlbl.setFont(new Font("Serif", Font.BOLD, 18));
        
        mailfield = new JTextField();
	mailfield.setBounds(400, 250, 300, 25);
        mailfield.setColumns(10);
        
        passwordfield = new JPasswordField();
	passwordfield.setBounds(400, 350, 300, 25);
        passwordfield.setColumns(10);
        
        loginbtn=new JButton("LOGIN");
        backbtn=new JButton("BACK");
        backbtn.setBounds(250,500,100,50);
        loginbtn.setBounds(500,500,100,50);
        
        loginbtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {                                     
                caretakerdata ld=new caretakerdata();
                String mail = mailfield.getText();
                String password = String.valueOf(passwordfield.getPassword());  
                int status;
                status=ld.login(mail,password);
                if(status>0)
                {
                    JOptionPane.showMessageDialog(login.this,"Login successfull!");
                    new caretakerview().setVisible(true);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(login.this,"Sorry, Unable to Login!");
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
        add(loginlbl);
        add(maillbl);
        add(passlbl);
        add(mailfield);
        add(passwordfield);
        add(loginbtn);
        add(backbtn);        
    }
    public static void main(String args[]){
         
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                    new login().setVisible(true);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}