package hhj;	//2019.04.22 이미지/패널 공부.

import java.awt.BorderLayout;
import java.awt.Button;
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



public class Reserve_day extends JPanel {

	
		
	
	TabClass Ta;
	HaJinLoginMain hahome;
	JButton prev,next,adbance,home;
	JPanel buttons;	//버튼을 담을 패널
	JPanel Reserve_day;	
	JPanel[] items_intro2, item2, desc,buton;	
	
	JTable[] d;
	CardLayout card;	
	
	void inIt() {
		card = new CardLayout();	//배치관리자 생성
		Reserve_day = new JPanel(card);	//패널을 생성하면서 배치관리자 설정
		Ta=new TabClass()	;
		hahome=new HaJinLoginMain();
		items_intro2 = new JPanel[6];
		item2= new JPanel[6];
		desc = new JPanel[10];
	//	buton=new JPanel[1];//모두 크기 6의 배열 생성
		for(int i = 0; i < items_intro2.length; i++) {	//6회 반복
			items_intro2[i] = new JPanel();	//패널 생성
		
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

			items_intro2[i].add(item2[i]);	//이미지를 붙임
			items_intro2[i].add(desc[i]);	
		//	items_intro[i].add(buton[i]);
			//과일 설명을 붙임
		} //end of for
		
		desc[0].add(new JLabel("    *     기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[0].add(new JLabel("    *     시간 : 월~목| 10:30~20:00"));			
		desc[0].add(new JLabel("          금~일 | 10:30~20:30\" "));
		desc[0].add(new JLabel( "   *     장소 | 안산 하진 미술관층. "));
		desc[0].add(new JLabel( "   *     가격 ㅣ 15,000원. "));
		desc[0].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[1].add(new JLabel("    *     기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[1].add(new JLabel("    *     시간 : 월~목| 10:30~20:00"));			
		desc[1].add(new JLabel("          금~일 | 10:30~20:30\" "));
		desc[1].add(new JLabel( "   *     장소 | 안산 하진 미술관층. "));
		desc[1].add(new JLabel( "   *     가격 ㅣ 15,000원. "));
		desc[1].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[2].add(new JLabel("    *     기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[2].add(new JLabel("    *     시간 : 월~목| 10:30~20:00"));			
		desc[2].add(new JLabel("          금~일 | 10:30~20:30\" "));
		desc[2].add(new JLabel( "   *     장소 | 안산 하진 미술관층. "));
		desc[2].add(new JLabel( "   *     가격 ㅣ 15,000원. "));
		desc[2].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[3].add(new JLabel("    *     기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[3].add(new JLabel("    *     시간 : 월~목| 10:30~20:00"));			
		desc[3].add(new JLabel("          금~일 | 10:30~20:30\" "));
		desc[3].add(new JLabel( "   *     장소 | 안산 하진 미술관층. "));
		desc[3].add(new JLabel( "   *     가격 ㅣ 15,000원. "));
		desc[3].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[4].add(new JLabel("    *     기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[4].add(new JLabel("    *     시간 : 월~목| 10:30~20:00"));			
		desc[4].add(new JLabel("          금~일 | 10:30~20:30\" "));
		desc[4].add(new JLabel( "   *     장소 | 안산 하진 미술관층. "));
		desc[4].add(new JLabel( "   *     가격 ㅣ 15,000원. "));
		desc[4].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[5].add(new JLabel("    *     기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[5].add(new JLabel("    *     시간 : 월~목| 10:30~20:00"));			
		desc[5].add(new JLabel("          금~일 | 10:30~20:30\" "));
		desc[5].add(new JLabel( "   *     장소 | 안산 하진 미술관층. "));
		desc[5].add(new JLabel( "   *     가격 ㅣ 15,000원. "));
		desc[5].add(new JLabel( "   *     1544-7744. "));
		
		Reserve_day.add(items_intro2[0],"그림1");
		Reserve_day.add(items_intro2[1],"그림2");
		Reserve_day.add(items_intro2[2],"그림3");
		Reserve_day.add(items_intro2[3],"그림4");
		Reserve_day.add(items_intro2[4],"그림5");
		Reserve_day.add(items_intro2[5],"그림6");
		Reserve_day.add(Ta,"adb");
		Reserve_day.add(hahome,"home");
		
		
		home=new JButton("HOME");
		home.addActionListener(new MyButtonListener2(this));
		adbance =new JButton("예매하기");
		adbance.addActionListener(new MyButtonListener2(this));
		
		
		prev = new JButton("이전");
		prev.addActionListener(new MyButtonListener2(this));
		next = new JButton("다음");
		next.addActionListener(new MyButtonListener2(this));
	
		buttons = new JPanel();	//버튼을 담을 패널 생성
		// buttons.add(last);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(adbance);
		buttons.add(home);
		
	}

		public Reserve_day() {
			//super(str);
			
		inIt();
		this.setLayout(new BorderLayout());
		this.add("Center",Reserve_day);
		this.add("South",buttons);
	
//		this.setSize(1000, 500);
//		this.setLocation(230, 200);
//		this.setVisible(true);
	//	this.addWindowListener(new ReserveExit());	//이벤트처리 클래스를 따로 만들어 처리.
	//	this.addWindowListener(new ReserveEnd());	//윈도우어댑터로 해보기.
		
		
	}
	
	public static void main(String[] args) {
	//new Reserve_day("하진 미술관");

	}

}	//end of fruitsShopping class

class Reserve_dayEnd extends WindowAdapter{		//어댑터로 이벤트처리//////////////////

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}													//어댑터로 이벤트처리//////////////////

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
	Reserve_dayImage(String path){		//path = 경로를 받기 위해
		img = Toolkit.getDefaultToolkit().getImage(path);
		
	}
	
	@Override
	public void paint(Graphics g) {

		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	//패널의 크기에 맞게 사이즈 조정하기
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
		} else if(obj== fs.adbance) {
			fs.buttons.setVisible(false);	
			fs.card.show(fs.Reserve_day, "adb");
		} else if(obj==fs.home) {
			fs.buttons.setVisible(false);
			fs.card.show(fs.Reserve_day, "home");
			
			
			
		}
		
	}
	
}
