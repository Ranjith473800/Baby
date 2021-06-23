package baby;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Event.*;
public class decisionpage extends javax.swing.JFrame
{
    JButton b1,b2;
decisionpage()
{
    JLabel s1 = new JLabel("Welcome to Baby Sitter Hiring Management");
   
    JPanel panel = new JPanel();
		panel.setBounds(184, 258, 668, 144);
		panel.setLayout(null);
                
                JLabel loginlbl = new JLabel("BABYSITTER HIRING MANAGEMENT");
                loginlbl.setBounds(175, 100,800, 70);
                loginlbl.setFont(new Font("Tahoma", Font.BOLD, 36));
		
		JButton btnCaretaker = new JButton("CARETAKER");
		btnCaretaker.setBounds(200, 300, 250, 120);
		panel.add(btnCaretaker);
		btnCaretaker.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCaretaker.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\icons8-nanny-50.png"));
		
		JButton btnParent = new JButton("PARENT");
		btnParent.setBounds(500, 300, 250, 120);
		panel.add(btnParent);
		btnParent.setIcon(new ImageIcon("C:\\Users\\Home\\Downloads\\icons8-parenting-50.png"));
		btnParent.setFont(new Font("Tahoma", Font.BOLD, 20));
    setVisible(true);
    setSize(1000, 900);
    setLayout(null);
    add(loginlbl);
    add(btnCaretaker);
    add(btnParent);
    add(panel);
    
    btnParent.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new userlogin().setVisible(true);
                dispose();
            }
        });
    btnCaretaker.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new selection().setVisible(true);
                dispose();
            }
        });
    
}
    

public static void main(String args[])
{
    decisionpage s = new decisionpage();
}
    
}