package scarpbook;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import java.awt.Canvas;
import java.awt.Color;
public class Login extends JFrame {
	JPanel p1;
	JLabel l1,l2;
	JTextField tf1;
	JPasswordField pf1;
	JButton b1;
    JPanel gridHolder = new JPanel();

      Login()
      {
      	getContentPane().setBackground(new Color(204, 204, 255));
    	  setTitle("login");
    	  p1 = new JPanel();
    	  l1 = new JLabel("username");
    	  l2 = new JLabel("password");
    	  tf1 = new JTextField();
    	  tf1.setFont(new Font("Tahoma", Font.ITALIC, 15));
    	  pf1 = new JPasswordField();
    	  b1 = new JButton("Login");
    	  b1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
    	  l1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
    	  l2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
    	  
    	  l1.setBounds(100,308,80,40);
    	  l2.setBounds(100,363,80,40);
    	  tf1.setBounds(195,309,400,40);
    	  pf1.setBounds(195,366,400,40);
    	  b1.setBounds(163,449,400,40);
 
    	  getContentPane().add(l1);
    	  getContentPane().add(l2);
    	  getContentPane().add(tf1);
    	  getContentPane().add(pf1);
    	  getContentPane().add(b1);
    	  
    	  setSize(700,600);
    	  getContentPane().setLayout(null);
    	  
    	  JLabel lblNewLabel = new JLabel("Keep Notes");
    	  lblNewLabel.setBackground(new Color(0, 0, 0));
    	  lblNewLabel.setFont(new Font("Vani", Font.BOLD | Font.ITALIC, 28));
    	  lblNewLabel.setBounds(254, 233, 203, 47);
    	  getContentPane().add(lblNewLabel);
    	  
    	  Canvas canvas = new MyCanvas("C:\\Users\\Aditi\\Downloads\\notes.png");
    	  canvas.setBounds(254, 35, 165, 181);
    	  getContentPane().add(canvas);
    	  
    	  
    	  b1.addActionListener(new ActionListener() {
    		  public void actionPerformed(ActionEvent e) {
    			  try{
                      Class.forName("com.mysql.cj.jdbc.Driver");
                      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scrapbook","root","root");
                      Statement sta = con.createStatement();
                      ResultSet results = sta.executeQuery("SELECT * FROM login");
                      String u,p;
                      String u1,p1;
                      int flag=0;
                      u1=tf1.getText();
                      p1=new String(pf1.getPassword());
                      while(results.next())
                      {
                    	  u=results.getString("username");
                    	  p=results.getString("password");
                    	  if( u1.equals(u) && p1.equals(p) )
                    	  {
                    		  flag=1;
                    	  }  
                      }
                      if(flag==0)
                    	  JOptionPane.showMessageDialog(null,"incorrect credentials");
                      else
                      {	  
                    	  Session.userDetails = new User();
                    	  Session.userDetails.setUsername(u1);
                    	  new Welcome();
                    	  setVisible(false);
                      }
                  }
                  catch(Exception ep){
                      System.out.println(ep);
                  }
    		  }
    	  });
    	  setLocationRelativeTo(null);
    	  setVisible(true); 
      }

	public static void main(String[] args) {
		new Login();
	}
}
