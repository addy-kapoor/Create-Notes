package scarpbook;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Container;
public class label extends JFrame{
		Container c;
		
        label(){
        	setVisible(true);
        	setSize(400,400);
        	getContentPane().setLayout(null);
        	c = getContentPane();
        	JButton btnNewButton = new JButton("New button");
        	btnNewButton.addActionListener(new ActionListener()
        	{
        		
        		public void actionPerformed(ActionEvent e) {
        			System.out.println(e);
        			JLabel l1 = new JLabel("xyz");
        			l1.setBounds(97,140,85,21);
                	c.add(l1);
                	
        		}
        	});
        	btnNewButton.setBounds(97, 111, 85, 21);
        	getContentPane().add(btnNewButton);
        	
//        	JLabel lblNewLabel = new JLabel("New label");
//        	lblNewLabel.setBounds(137, 173, 45, 13);
//        	getContentPane().add(lblNewLabel);
        	
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               new label();
	}
}
