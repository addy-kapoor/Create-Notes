package scarpbook;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
public class Welcome extends JFrame{
	Welcome()
	{
		setSize(700,500);
		 setLocationRelativeTo(null);
		setVisible(true);
		
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.setBounds(516, 364, 130, 68);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Notes();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(0, 0, 19, 463);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(255, 240, 245));
		panel_2.setBounds(22, 0, 19, 463);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 215, 0));
		panel_3.setBounds(40, 0, 19, 463);
		panel.add(panel_3);
		
		Canvas canvas = new MyCanvas("C:\\Users\\Aditi\\Downloads\\Welcome.jfif");
		canvas.setBounds(220, 21, 250, 232);
		panel.add(canvas);
		
		JLabel lblNewLabel = new JLabel("Keep Notes takes your privacy and security into account");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(142, 259, 467, 29);
		panel.add(lblNewLabel);
		
		setSize(700,500);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	public static void main(String[] args) {
		new Welcome();
	}
}
