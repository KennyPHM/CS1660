import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI implements ActionListener {
	
	private JLabel label;
	private JLabel label2;
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JCheckBox c1;
	private JCheckBox c2;
	private JCheckBox c3;
	
	
	public GUI() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height * 1 / 3;
		int width = screenSize.width * 1 / 4;
		
		frame = new JFrame("Kenneth Choo Search Engine");
		frame.setPreferredSize(new Dimension(width, height));
		button = new JButton("Load Engine");
		button.addActionListener(this);
		label = new JLabel("No files selected");
		label2 = new JLabel("Choose Files: ");
		panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		frame.setLayout(new FlowLayout()); 
        c1 = new JCheckBox("Hugo"); 
        c2 = new JCheckBox("Shakespeare");
        c3 = new JCheckBox("Tolstoy");
		panel.add(label2);
        panel.add(c1); 
        panel.add(c2); 
        panel.add(c3); 
        frame.add(panel); 
		panel.add(button);
		panel.add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str = "";
		if(c1.isSelected()) str += "Hugo, ";
		if(c2.isSelected()) str += "Shakespeare, ";
		if(c3.isSelected()) str += "Tolstoy, ";
		if(str.compareTo("") == 0) {
			label.setText("No files selected");
		} else {
			label.setText("Processing Files: "+str);
			label2.setVisible(false);
			button.setVisible(false);
			c1.setVisible(false);
			c2.setVisible(false);
			c3.setVisible(false);
			// TODO send GCP request
		}
		
	}
}
