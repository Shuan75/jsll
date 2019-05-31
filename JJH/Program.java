package JJH;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;



public class Program extends JPanel {

	
		
	JButton prev,next,adbance;
	JPanel buttons;	
	JPanel Program;	
	JPanel[] items_intro4, item4, desc,buton;	
	
	JTable[] d;
	CardLayout card;
	ManagerMode mm;
	
	void inIt() {
		card = new CardLayout();
		Program = new JPanel(card);
		items_intro4 = new JPanel[6];
		item4= new JPanel[6];
		desc = new JPanel[10];
		for(int i = 0; i < items_intro4.length; i++) {
			items_intro4[i] = new JPanel();	
		
			items_intro4[i].setLayout(new GridLayout(1,2));
			
			desc[i] = new JPanel(new GridLayout(7,1));

			switch(i) {
			case 0:
				item4[i] = new ProgramImage("src\\hhj\\1-1.jpg"); break;
			case 1:
				item4[i] = new ProgramImage("src\\hhj\\1-2.jpg"); break;
			case 2:
				item4[i] = new ProgramImage("src\\hhj\\1-3.jpg"); break;
			case 3:
				item4[i] = new ProgramImage("src\\hhj\\1-4.jpg"); break;
			case 4:
				item4[i] = new ProgramImage("src\\hhj\\1-5.jpg"); break;
			case 5:
				item4[i] = new ProgramImage("src\\hhj\\1-6.jpg"); break;
			}

			items_intro4[i].add(item4[i]);	
			items_intro4[i].add(desc[i]);	
		} //end of for
		desc[0].add(new JLabel("       ?”„ë¡œê·¸?ž¨ ?„¤ëª?"));	
		desc[0].add(new JLabel("       ê¸°ê°„ :   2019.05.01 ~ 2019.05.31"));	
		desc[0].add(new JLabel( "      ê°?ê²? ?…£ 15,000?›. "));
		desc[0].add(new JLabel("       ?‹œê°? : ?˜¤? „ 09?‹œ~12?‹œê¹Œì?"));			
		desc[0].add(new JLabel("        	 ?˜¤?›„13?‹œ~18?‹œê¹Œì?" ));
		desc[0].add(new JLabel( "       ?¸?›: 15ëª? "));
		desc[0].add(new JLabel( "       1544-7744. "));
		
	
		desc[1].add(new JLabel("       ?”„ë¡œê·¸?ž¨ ?„¤ëª?"));	
		desc[1].add(new JLabel("       ê¸°ê°„ :   2019.05.01 ~ 2019.05.31"));	
		desc[1].add(new JLabel( "      ê°?ê²? ?…£ 15,000?›. "));
		desc[1].add(new JLabel("       ?‹œê°? : ?˜¤? „ 09?‹œ~12?‹œê¹Œì?"));			
		desc[1].add(new JLabel("        	 ?˜¤?›„13?‹œ~18?‹œê¹Œì?" ));
		desc[1].add(new JLabel( "       ?¸?›: 15ëª? "));
		desc[1].add(new JLabel( "       1544-7744. "));
		
	
		desc[2].add(new JLabel("       ?”„ë¡œê·¸?ž¨ ?„¤ëª?"));	
		desc[2].add(new JLabel("       ê¸°ê°„ :   2019.05.01 ~ 2019.05.31"));	
		desc[2].add(new JLabel( "      ê°?ê²? ?…£ 15,000?›. "));
		desc[2].add(new JLabel("       ?‹œê°? : ?˜¤? „ 09?‹œ~12?‹œê¹Œì?"));			
		desc[2].add(new JLabel("        	 ?˜¤?›„13?‹œ~18?‹œê¹Œì?" ));
		desc[2].add(new JLabel( "       ?¸?›: 15ëª? "));
		desc[2].add(new JLabel( "       1544-7744. "));
		
	
		desc[3].add(new JLabel("       ?”„ë¡œê·¸?ž¨ ?„¤ëª?"));	
		desc[3].add(new JLabel("       ê¸°ê°„ :   2019.05.01 ~ 2019.05.31"));	
		desc[3].add(new JLabel( "      ê°?ê²? ?…£ 15,000?›. "));
		desc[3].add(new JLabel("       ?‹œê°? : ?˜¤? „ 09?‹œ~12?‹œê¹Œì?"));			
		desc[3].add(new JLabel("        	 ?˜¤?›„13?‹œ~18?‹œê¹Œì?" ));
		desc[3].add(new JLabel( "       ?¸?›: 15ëª? "));
		desc[3].add(new JLabel( "       1544-7744. "));
		
	
		desc[4].add(new JLabel("       ?”„ë¡œê·¸?ž¨ ?„¤ëª?"));	
		desc[4].add(new JLabel("       ê¸°ê°„ :   2019.05.01 ~ 2019.05.31"));	
		desc[4].add(new JLabel( "      ê°?ê²? ?…£ 15,000?›. "));
		desc[4].add(new JLabel("       ?‹œê°? : ?˜¤? „ 09?‹œ~12?‹œê¹Œì?"));			
		desc[4].add(new JLabel("        	 ?˜¤?›„13?‹œ~18?‹œê¹Œì?" ));
		desc[4].add(new JLabel( "       ?¸?›: 15ëª? "));
		desc[4].add(new JLabel( "       1544-7744. "));
		
	
		desc[5].add(new JLabel("       ?”„ë¡œê·¸?ž¨ ?„¤ëª?"));	
		desc[5].add(new JLabel("       ê¸°ê°„ :   2019.05.01 ~ 2019.05.31"));	
		desc[5].add(new JLabel( "      ê°?ê²? ?…£ 15,000?›. "));
		desc[5].add(new JLabel("       ?‹œê°? : ?˜¤? „ 09?‹œ~12?‹œê¹Œì?"));			
		desc[5].add(new JLabel("        	 ?˜¤?›„13?‹œ~18?‹œê¹Œì?" ));
		desc[5].add(new JLabel( "       ?¸?›: 15ëª? "));
		desc[5].add(new JLabel( "       1544-7744. "));
		
		Program.add(items_intro4[0],"ê·¸ë¦¼1");
		Program.add(items_intro4[1],"ê·¸ë¦¼2");
		Program.add(items_intro4[2],"ê·¸ë¦¼3");
		Program.add(items_intro4[3],"ê·¸ë¦¼4");
		Program.add(items_intro4[4],"ê·¸ë¦¼5");
		Program.add(items_intro4[5],"ê·¸ë¦¼6");
		
		
		adbance =new JButton("ì°¸ì—¬?•˜ê¸?");
		adbance.addActionListener(new MyButtonListener4(this));
				
		prev = new JButton("?´? „");
		prev.addActionListener(new MyButtonListener4(this));
		next = new JButton("?‹¤?Œ");
		next.addActionListener(new MyButtonListener4(this));
	
		buttons = new JPanel();	//ë²„íŠ¼?„ ?‹´?„ ?Œ¨?„ ?ƒ?„±
		// buttons.add(last);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(adbance);
		
	}

		public Program(ManagerMode mm) {
			
		inIt();
		this.setLayout(new BorderLayout());
		this.add("Center",Program);
		this.add("South",buttons);
		
		
		
	}
	
	public static void main(String[] args) {

	}

}	//end of fruitsShopping class

class ProgramEnd extends WindowAdapter{		

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}								

class ProgramExit implements WindowListener{
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
}

class ProgramImage extends JPanel{
	Image img;
	ProgramImage(String path){		//path = ê²½ë¡œë¥? ë°›ê¸° ?œ„?•´
		img = Toolkit.getDefaultToolkit().getImage(path);
		
	}
	
	@Override
	public void paint(Graphics g) {

		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	//?Œ¨?„?˜ ?¬ê¸°ì— ë§žê²Œ ?‚¬?´ì¦? ì¡°ì •?•˜ê¸?
	}
			
}

 class MyButtonListener4 implements ActionListener{
	 Program fs;
//		
		MyButtonListener4(Program fs){
			this.fs = fs;
//		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
	
		if(obj == fs.prev) {
			fs.card.previous(fs.Program);
		} else if(obj == fs.next) {
			fs.card.next(fs.Program);
		} 
		
	}
	
}


