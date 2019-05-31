package JJH;	//2019.04.22 �씠誘몄�/�뙣�꼸 怨듬�.

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;



public class Reserve_day extends JFrame {

	
		
	

	JButton prev,next,last;
	JPanel buttons;	//踰꾪듉�쓣 �떞�쓣 �뙣�꼸
	JPanel Reserve_day;	
	JPanel[] items_intro2, item2, desc,buton;	
	
	JTable[] d;
	CardLayout card;	
	
	void inIt() {
		card = new CardLayout();	//諛곗튂愿�由ъ옄 �깮�꽦
		Reserve_day = new JPanel(card);	//�뙣�꼸�쓣 �깮�꽦�븯硫댁꽌 諛곗튂愿�由ъ옄 �꽕�젙
		items_intro2 = new JPanel[6];
		item2= new JPanel[6];
		desc = new JPanel[10];
	//	buton=new JPanel[1];//紐⑤몢 �겕湲� 6�쓽 諛곗뿴 �깮�꽦
		for(int i = 0; i < items_intro2.length; i++) {	//6�쉶 諛섎났
			items_intro2[i] = new JPanel();	//�뙣�꼸 �깮�꽦
		
			items_intro2[i].setLayout(new GridLayout(1,2));
			
			desc[i] = new JPanel(new GridLayout(7,1));

			switch(i) {
			case 0:
				item2[i] = new ReserveImage("src\\hhj\\07.jpg"); break;
			case 1:
				item2[i] = new ReserveImage("src\\hhj\\08.jpg"); break;
			case 2:
				item2[i] = new ReserveImage("src\\hhj\\09.jpg"); break;
			case 3:
				item2[i] = new ReserveImage("src\\hhj\\10.jpg"); break;
			case 4:
				item2[i] = new ReserveImage("src\\hhj\\11.jpg"); break;
			case 5:
				item2[i] = new ReserveImage("src\\hhj\\12.jpg"); break;
			}

			items_intro2[i].add(item2[i]);	//�씠誘몄�瑜� 遺숈엫
			items_intro2[i].add(desc[i]);	
		//	items_intro[i].add(buton[i]);
			//怨쇱씪 �꽕紐낆쓣 遺숈엫
		} //end of for
		
		desc[0].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[0].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[0].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[0].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[0].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[0].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[1].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[1].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[1].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[1].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[1].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[1].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[2].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[2].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[2].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[2].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[2].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[2].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[3].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[3].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[3].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[3].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[3].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[3].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[4].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[4].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[4].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[4].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[4].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[4].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[5].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[5].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[5].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[5].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[5].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[5].add(new JLabel( "   *     1544-7744. "));
		
		Reserve_day.add(items_intro2[0],"洹몃┝1");
		Reserve_day.add(items_intro2[1],"洹몃┝2");
		Reserve_day.add(items_intro2[2],"洹몃┝3");
		Reserve_day.add(items_intro2[3],"洹몃┝4");
		Reserve_day.add(items_intro2[4],"洹몃┝5");
		Reserve_day.add(items_intro2[5],"洹몃┝6");
		
		
		last =new JButton("�삁留ㅽ븯湲�");
		last.addActionListener(new MyButtonListener2(this));
		
		
		prev = new JButton("�씠�쟾");
		prev.addActionListener(new MyButtonListener2(this));
		next = new JButton("�떎�쓬");
		next.addActionListener(new MyButtonListener2(this));
	
		buttons = new JPanel();	//踰꾪듉�쓣 �떞�쓣 �뙣�꼸 �깮�꽦
		// buttons.add(last);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		
	}

		public Reserve_day(String str) {
			super(str);
			
		inIt();
		this.setLayout(new BorderLayout());
		this.add("Center",Reserve_day);
		this.add("South",buttons);
		
		this.setSize(1000, 500);
		this.setLocation(230, 200);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
	new Reserve_day("�븯吏� 誘몄닠愿�");

	}

}	//end of fruitsShopping class

class Reserve_dayEnd extends WindowAdapter{		//�뼱�뙌�꽣濡� �씠踰ㅽ듃泥섎━//////////////////

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}													//�뼱�뙌�꽣濡� �씠踰ㅽ듃泥섎━//////////////////

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
	Reserve_dayImage(String path){		//path = 寃쎈줈瑜� 諛쏄린 �쐞�빐
		img = Toolkit.getDefaultToolkit().getImage(path);
		
	}
	
	@Override
	public void paint(Graphics g) {

		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	//�뙣�꼸�쓽 �겕湲곗뿉 留욊쾶 �궗�씠利� 議곗젙�븯湲�
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


