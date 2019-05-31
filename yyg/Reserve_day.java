package yyg;	//2019.04.22 ?´ë¯¸ì?/?Œ¨?„ ê³µë?.

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



public class Reserve_day extends JPanel {

	JButton prev,next,adbance;
	JPanel buttons;	//ë²„íŠ¼?„ ?‹´?„ ?Œ¨?„
	JPanel Reserve_day;	
	JPanel[] items_intro2, item2, desc,buton;	
	
	JTable[] d;
	CardLayout card;	
	
	void inIt() {
		card = new CardLayout();	//ë°°ì¹˜ê´?ë¦¬ì ?ƒ?„±
		Reserve_day = new JPanel(card);	//?Œ¨?„?„ ?ƒ?„±?•˜ë©´ì„œ ë°°ì¹˜ê´?ë¦¬ì ?„¤? •
		items_intro2 = new JPanel[6];
		item2= new JPanel[6];
		desc = new JPanel[10];
	//	buton=new JPanel[1];//ëª¨ë‘ ?¬ê¸? 6?˜ ë°°ì—´ ?ƒ?„±
		for(int i = 0; i < items_intro2.length; i++) {	//6?šŒ ë°˜ë³µ
			items_intro2[i] = new JPanel();	//?Œ¨?„ ?ƒ?„±
		
			items_intro2[i].setLayout(new GridLayout(1,2));
			
			desc[i] = new JPanel(new GridLayout(7,1));

			switch(i) {
			case 0:
				item2[i] = new Reserve_dayImage("src\\hhj\\07.jpg"); break;
			case 1:
				item2[i] = new Reserve_dayImage("src\\hhj\\08.jpg"); break;
			case 2:
				item2[i] = new Reserve_dayImage("src\\hhj\\09.jpg"); break;
			case 3:
				item2[i] = new Reserve_dayImage("src\\hhj\\10.jpg"); break;
			case 4:
				item2[i] = new Reserve_dayImage("src\\hhj\\11.jpg"); break;
			case 5:
				item2[i] = new Reserve_dayImage("src\\hhj\\12.jpg"); break;
			}

			items_intro2[i].add(item2[i]);	//?´ë¯¸ì?ë¥? ë¶™ì„
			items_intro2[i].add(desc[i]);	
		//	items_intro[i].add(buton[i]);
			//ê³¼ì¼ ?„¤ëª…ì„ ë¶™ì„
		} //end of for
		
		desc[0].add(new JLabel("    *     asd"));	
		desc[0].add(new JLabel("    *     ?‹œê°? : ?›”~ëª?| 10:30~20:00"));			
		desc[0].add(new JLabel("          ê¸?~?¼ | 10:30~20:30\" "));
		desc[0].add(new JLabel( "   *     ?¥?†Œ | ?•ˆ?‚° ?•˜ì§? ë¯¸ìˆ ê´?ì¸?. "));
		desc[0].add(new JLabel( "   *     ê°?ê²? ?…£ 15,000?›. "));
		desc[0].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[1].add(new JLabel("    *     asd"));	
		desc[1].add(new JLabel("    *     ?‹œê°? : ?›”~ëª?| 10:30~20:00"));			
		desc[1].add(new JLabel("          ê¸?~?¼ | 10:30~20:30\" "));
		desc[1].add(new JLabel( "   *     ?¥?†Œ | ?•ˆ?‚° ?•˜ì§? ë¯¸ìˆ ê´?ì¸?. "));
		desc[1].add(new JLabel( "   *     ê°?ê²? ?…£ 15,000?›. "));
		desc[1].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[2].add(new JLabel("    *     asd.31"));	
		desc[2].add(new JLabel("    *     ?‹œê°? : ?›”~ëª?| 10:30~20:00"));			
		desc[2].add(new JLabel("          ê¸?~?¼ | 10:30~20:30\" "));
		desc[2].add(new JLabel( "   *     ?¥?†Œ | ?•ˆ?‚° ?•˜ì§? ë¯¸ìˆ ê´?ì¸?. "));
		desc[2].add(new JLabel( "   *     ê°?ê²? ?…£ 15,000?›. "));
		desc[2].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[3].add(new JLabel("    *     asd019.05.31"));	
		desc[3].add(new JLabel("    *     ?‹œê°? : ?›”~ëª?| 10:30~20:00"));			
		desc[3].add(new JLabel("          ê¸?~?¼ | 10:30~20:30\" "));
		desc[3].add(new JLabel( "   *     ?¥?†Œ | ?•ˆ?‚° ?•˜ì§? ë¯¸ìˆ ê´?ì¸?. "));
		desc[3].add(new JLabel( "   *     ê°?ê²? ?…£ 15,000?›. "));
		desc[3].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[4].add(new JLabel("    *     dddd19.05.31"));	
		desc[4].add(new JLabel("    *     ?‹œê°? : ?›”~ëª?| 10:30~20:00"));			
		desc[4].add(new JLabel("          ê¸?~?¼ | 10:30~20:30\" "));
		desc[4].add(new JLabel( "   *     ?¥?†Œ | ?•ˆ?‚° ?•˜ì§? ë¯¸ìˆ ê´?ì¸?. "));
		desc[4].add(new JLabel( "   *     ê°?ê²? ?…£ 15,000?›. "));
		desc[4].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[5].add(new JLabel("    *     ggg31"));	
		desc[5].add(new JLabel("    *     ?‹œê°? : ?›”~ëª?| 10:30~20:00"));			
		desc[5].add(new JLabel("          ê¸?~?¼ | 10:30~20:30\" "));
		desc[5].add(new JLabel( "   *     ?¥?†Œ | ?•ˆ?‚° ?•˜ì§? ë¯¸ìˆ ê´?ì¸?. "));
		desc[5].add(new JLabel( "   *     ê°?ê²? ?…£ 15,000?›. "));
		desc[5].add(new JLabel( "   *     1544-7744. "));
		
		Reserve_day.add(items_intro2[0],"ê·¸ë¦¼1");
		Reserve_day.add(items_intro2[1],"ê·¸ë¦¼2");
		Reserve_day.add(items_intro2[2],"ê·¸ë¦¼3");
		Reserve_day.add(items_intro2[3],"ê·¸ë¦¼4");
		Reserve_day.add(items_intro2[4],"ê·¸ë¦¼5");
		Reserve_day.add(items_intro2[5],"ê·¸ë¦¼6");
		
		
		adbance =new JButton("?˜ˆë§¤í•˜ê¸?");
		adbance.addActionListener(new MyButtonListener2(this));
		
		
		prev = new JButton("?´? „");
		prev.addActionListener(new MyButtonListener2(this));
		next = new JButton("?‹¤?Œ");
		next.addActionListener(new MyButtonListener2(this));
	
		buttons = new JPanel();	//ë²„íŠ¼?„ ?‹´?„ ?Œ¨?„ ?ƒ?„±
		// buttons.add(last);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(adbance);
		
	}

		public Reserve_day() {
		inIt();
		this.setLayout(new BorderLayout());
		this.add("Center",Reserve_day);
		this.add("South",buttons);
//		this.addWindowListener2(new Reserve_dayExit());	//?´ë²¤íŠ¸ì²˜ë¦¬ ?´?˜?Š¤ë¥? ?”°ë¡? ë§Œë“¤?–´ ì²˜ë¦¬.
//		this.addWindowListener2(new Reserve_dayEnd());	//?œˆ?„?š°?–´?Œ‘?„°ë¡? ?•´ë³´ê¸°.
		
		
	}
	
	public static void main(String[] args) {

	}

}	//end of fruitsShopping class

class Reserve_dayEnd extends WindowAdapter{		//?–´?Œ‘?„°ë¡? ?´ë²¤íŠ¸ì²˜ë¦¬//////////////////

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}													//?–´?Œ‘?„°ë¡? ?´ë²¤íŠ¸ì²˜ë¦¬//////////////////

class Reserve_dayExit implements WindowListener{
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

class Reserve_dayImage extends JPanel{
	Image img;
	Reserve_dayImage(String path){		//path = ê²½ë¡œë¥? ë°›ê¸° ?œ„?•´
		img = Toolkit.getDefaultToolkit().getImage(path);
		
	}
	
	@Override
	public void paint(Graphics g) {

		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	//?Œ¨?„?˜ ?¬ê¸°ì— ë§ê²Œ ?‚¬?´ì¦? ì¡°ì •?•˜ê¸?
	}
			
}

 class MyButtonListener2 implements ActionListener{
		Reserve_day fs;
//		
		MyButtonListener2(Reserve_day fs){
			this.fs = fs;
//		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
	
		if(obj == fs.prev) {
			fs.card.previous(fs.Reserve_day);
		} else if(obj == fs.next) {
			fs.card.next(fs.Reserve_day);
		} 
		
	}
	
}


