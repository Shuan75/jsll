package yyg;	//2019.04.22 ?��미�?/?��?�� 공�?.

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
	JPanel buttons;	//버튼?�� ?��?�� ?��?��
	JPanel Reserve_day;	
	JPanel[] items_intro2, item2, desc,buton;	
	
	JTable[] d;
	CardLayout card;	
	
	void inIt() {
		card = new CardLayout();	//배치�?리자 ?��?��
		Reserve_day = new JPanel(card);	//?��?��?�� ?��?��?��면서 배치�?리자 ?��?��
		items_intro2 = new JPanel[6];
		item2= new JPanel[6];
		desc = new JPanel[10];
	//	buton=new JPanel[1];//모두 ?���? 6?�� 배열 ?��?��
		for(int i = 0; i < items_intro2.length; i++) {	//6?�� 반복
			items_intro2[i] = new JPanel();	//?��?�� ?��?��
		
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

			items_intro2[i].add(item2[i]);	//?��미�?�? 붙임
			items_intro2[i].add(desc[i]);	
		//	items_intro[i].add(buton[i]);
			//과일 ?��명을 붙임
		} //end of for
		
		desc[0].add(new JLabel("    *     asd"));	
		desc[0].add(new JLabel("    *     ?���? : ?��~�?| 10:30~20:00"));			
		desc[0].add(new JLabel("          �?~?�� | 10:30~20:30\" "));
		desc[0].add(new JLabel( "   *     ?��?�� | ?��?�� ?���? 미술�?�?. "));
		desc[0].add(new JLabel( "   *     �?�? ?�� 15,000?��. "));
		desc[0].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[1].add(new JLabel("    *     asd"));	
		desc[1].add(new JLabel("    *     ?���? : ?��~�?| 10:30~20:00"));			
		desc[1].add(new JLabel("          �?~?�� | 10:30~20:30\" "));
		desc[1].add(new JLabel( "   *     ?��?�� | ?��?�� ?���? 미술�?�?. "));
		desc[1].add(new JLabel( "   *     �?�? ?�� 15,000?��. "));
		desc[1].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[2].add(new JLabel("    *     asd.31"));	
		desc[2].add(new JLabel("    *     ?���? : ?��~�?| 10:30~20:00"));			
		desc[2].add(new JLabel("          �?~?�� | 10:30~20:30\" "));
		desc[2].add(new JLabel( "   *     ?��?�� | ?��?�� ?���? 미술�?�?. "));
		desc[2].add(new JLabel( "   *     �?�? ?�� 15,000?��. "));
		desc[2].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[3].add(new JLabel("    *     asd019.05.31"));	
		desc[3].add(new JLabel("    *     ?���? : ?��~�?| 10:30~20:00"));			
		desc[3].add(new JLabel("          �?~?�� | 10:30~20:30\" "));
		desc[3].add(new JLabel( "   *     ?��?�� | ?��?�� ?���? 미술�?�?. "));
		desc[3].add(new JLabel( "   *     �?�? ?�� 15,000?��. "));
		desc[3].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[4].add(new JLabel("    *     dddd19.05.31"));	
		desc[4].add(new JLabel("    *     ?���? : ?��~�?| 10:30~20:00"));			
		desc[4].add(new JLabel("          �?~?�� | 10:30~20:30\" "));
		desc[4].add(new JLabel( "   *     ?��?�� | ?��?�� ?���? 미술�?�?. "));
		desc[4].add(new JLabel( "   *     �?�? ?�� 15,000?��. "));
		desc[4].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[5].add(new JLabel("    *     ggg31"));	
		desc[5].add(new JLabel("    *     ?���? : ?��~�?| 10:30~20:00"));			
		desc[5].add(new JLabel("          �?~?�� | 10:30~20:30\" "));
		desc[5].add(new JLabel( "   *     ?��?�� | ?��?�� ?���? 미술�?�?. "));
		desc[5].add(new JLabel( "   *     �?�? ?�� 15,000?��. "));
		desc[5].add(new JLabel( "   *     1544-7744. "));
		
		Reserve_day.add(items_intro2[0],"그림1");
		Reserve_day.add(items_intro2[1],"그림2");
		Reserve_day.add(items_intro2[2],"그림3");
		Reserve_day.add(items_intro2[3],"그림4");
		Reserve_day.add(items_intro2[4],"그림5");
		Reserve_day.add(items_intro2[5],"그림6");
		
		
		adbance =new JButton("?��매하�?");
		adbance.addActionListener(new MyButtonListener2(this));
		
		
		prev = new JButton("?��?��");
		prev.addActionListener(new MyButtonListener2(this));
		next = new JButton("?��?��");
		next.addActionListener(new MyButtonListener2(this));
	
		buttons = new JPanel();	//버튼?�� ?��?�� ?��?�� ?��?��
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
//		this.addWindowListener2(new Reserve_dayExit());	//?��벤트처리 ?��?��?���? ?���? 만들?�� 처리.
//		this.addWindowListener2(new Reserve_dayEnd());	//?��?��?��?��?��?���? ?��보기.
		
		
	}
	
	public static void main(String[] args) {

	}

}	//end of fruitsShopping class

class Reserve_dayEnd extends WindowAdapter{		//?��?��?���? ?��벤트처리//////////////////

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}													//?��?��?���? ?��벤트처리//////////////////

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
	Reserve_dayImage(String path){		//path = 경로�? 받기 ?��?��
		img = Toolkit.getDefaultToolkit().getImage(path);
		
	}
	
	@Override
	public void paint(Graphics g) {

		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	//?��?��?�� ?��기에 맞게 ?��?���? 조정?���?
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


