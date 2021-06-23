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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class selection extends javax.swing.JFrame
{
    JButton logbtn,signbtn;
    JLabel mainlbl;
    public selection()
    {
        JLabel mainlbl = new JLabel("       SELECT");
        mainlbl.setBounds(350, 100,800, 70);
        mainlbl.setFont(new Font("Tahoma", Font.BOLD, 36));
                
        JPanel panel = new JPanel();
	panel.setBounds(184, 258, 668, 144);
	panel.setLayout(null);
		
	JButton btnnewuser = new JButton("NEW USER");
	btnnewuser.setBounds(200, 300, 250, 120);
	panel.add(btnnewuser);
	btnnewuser.setFont(new Font("Tahoma", Font.BOLD, 20));
	btnnewuser.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\SIGNUP.png"));
		
	JButton btnlogin = new JButton("LOGIN");
	btnlogin.setBounds(500, 300, 250, 120);
	panel.add(btnlogin);
	btnlogin.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\LOGIN.png"));
	btnlogin.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnnewuser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new caretakersignup().setVisible(true);
                dispose();
            }
        });
        btnlogin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new login().setVisible(true);
                dispose();
            }
        });
        setVisible(true);
        setSize(1000, 900);
        setLayout(null);
        add(btnlogin);
        add(btnnewuser);
        add(mainlbl);
        add(panel);
    }
    public static void main(String args[]){
         
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try{
                new selection().setVisible(true);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
}
    
}