package may09jjh;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;

public class JButtonTest extends JFrame {

	public static void main(String[] args) {
		JButtonTest frame = new JButtonTest("");
		
	}
	
	Container content;
	ImagePanel imgP;
	
	public JButtonTest(String title) {
		super(title);
		imgP = new ImagePanel();
		content = getContentPane();
		content.add(imgP,BorderLayout.CENTER);
		setVisible(true);
	}

}

class ImagePanel extends JPanel{
	Image image;
	JButton b1 = new JButton(new ImageIcon("src\\may09jjh\\img.gif"));
	
	public ImagePanel() {
		b1.setSize(19,19);
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		b1.setFocusPainted(false);
		add(b1);
	}
	
}