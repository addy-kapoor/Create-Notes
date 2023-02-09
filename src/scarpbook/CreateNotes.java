package scarpbook;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import java.awt.SystemColor;
public class CreateNotes extends JFrame{
	private JTextField textField;
CreateNotes(){
	
	setSize(550,600);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.activeCaption);
	getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(null);
	
	textField = new JTextField("    Enter subject");
	textField.setBackground(new Color(204, 204, 255));
	textField.setFont(new Font("Times New Roman", Font.BOLD, 25));
	textField.setBounds(32, 59, 459, 50);
	panel.add(textField);
	textField.setColumns(10);
	
	JTextArea textArea = new JTextArea(" Enter notes");
	textArea.setBackground(new Color(204, 204, 255));
	textArea.setWrapStyleWord(true);
	textArea.setLineWrap(true);
	textArea.setFont(new Font("Monospaced", Font.BOLD, 25));
	textArea.setBounds(32, 145, 469, 335);
	panel.add(textArea);
	
	JButton btnNewButton = new JButton("SAVE");
	btnNewButton.setForeground(new Color(0, 0, 0));
	btnNewButton.setBackground(new Color(204, 204, 255));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scrapbook","root","root");
                Statement sta = con.createStatement();
                String heading = "'"+textField.getText()+"'";
                String notes = "'"+textArea.getText()+"'";
                String date="'"+Notes.notes_date1+"'";
                String username="'"+Session.userDetails.getUsername() +"'";
                System.out.println(date);
                String q="Insert into createnotes values"+"("+heading+","+notes+","+date+","+username+")";
                sta.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"record saved");
			}
			catch(Exception ep) {
				JOptionPane.showMessageDialog(null,ep.getMessage());
			}
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
	btnNewButton.setBounds(343, 501, 158, 41);
	panel.add(btnNewButton);
	
	JLabel lblNewLabel = new JLabel("No duplicate entries allowed for subject");
	lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
	lblNewLabel.setBounds(63, 24, 301, 25);
	panel.add(lblNewLabel);
	 setLocationRelativeTo(null);
	setVisible(true);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           new CreateNotes();
	}
}
