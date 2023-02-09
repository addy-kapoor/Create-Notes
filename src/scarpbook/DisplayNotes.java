package scarpbook;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.SystemColor;
public class DisplayNotes extends JFrame {
      DisplayNotes(){
      	getContentPane().setBackground(SystemColor.activeCaption);
      	  
          setSize(600,600);
          getContentPane().setLayout(null);
          
          JLabel lblNewLabel = new JLabel("subject");
          lblNewLabel.setForeground(new Color(0, 0, 0));
          lblNewLabel.setBackground(Color.LIGHT_GRAY);
          lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
          lblNewLabel.setBounds(126, 78, 378, 53);
          getContentPane().add(lblNewLabel);
          
          JTextArea textArea = new JTextArea();
          textArea.setLineWrap(true);
          textArea.setBackground(new Color(204, 204, 255));
          textArea.setFont(new Font("Monospaced", Font.BOLD, 25));
          textArea.setBounds(0, 131, 586, 432);
          getContentPane().add(textArea);
          
          JLabel lblNewLabel_1 = new JLabel("date");
          lblNewLabel_1.setForeground(new Color(0, 0, 0));
          lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
          lblNewLabel_1.setBounds(72, 24, 201, 47);
          getContentPane().add(lblNewLabel_1);
          
          try {
        	  Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scrapbook","root","root");
              Statement sta = con.createStatement();
              System.out.println(Notes.selectedHeading);
              ResultSet results = sta.executeQuery("SELECT heading,notes,notes_date FROM createnotes where heading =" +"'"+Notes.selectedHeading+"'");
              String head,note,notedate;
              results.next();
//              while(results.next())
//              {
            	  head = results.getString("heading");
            	  note = results.getString("notes");
            	  notedate = results.getString("notes_date");
//              }
            	  System.out.println(head);
            	  System.out.println(note);
            	  System.out.println(notedate);
            	  
            	  lblNewLabel.setText(head);
            	  lblNewLabel_1.setText(notedate);
            	  textArea.setText(note);
            	  
            	  JLabel lblNewLabel_2 = new JLabel("Date-");
            	  lblNewLabel_2.setForeground(Color.BLUE);
            	  lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
            	  lblNewLabel_2.setBounds(0, 24, 100, 47);
            	  getContentPane().add(lblNewLabel_2);
            	  
            	  JLabel lblNewLabel_3 = new JLabel("Heading-");
            	  lblNewLabel_3.setForeground(Color.BLUE);
            	  lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
            	  lblNewLabel_3.setBounds(0, 78, 135, 53);
            	  getContentPane().add(lblNewLabel_3);
          }
          catch (Exception e) {
        	  System.out.println(e);
          }
          setLocationRelativeTo(null);
          setVisible(true);
      }
	public static void main(String[] args) {
         new DisplayNotes();

	}
}
