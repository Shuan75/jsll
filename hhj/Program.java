package hhj;	//2019.04.22 이미지/패널 공부.

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;



public class Program extends JFrame {

	
		
	JButton prev,next,adbance;
	JPanel buttons;	//버튼을 담을 패널
	JPanel Program;	
	JPanel[] items_intro4, item4, desc,buton;	
	
	JTable[] d;
	CardLayout card;	
	
	void inIt() {
		card = new CardLayout();	//배치관리자 생성
		Program = new JPanel(card);	//패널을 생성하면서 배치관리자 설정
		items_intro4 = new JPanel[6];
		item4= new JPanel[6];
		desc = new JPanel[10];
	//	buton=new JPanel[1];//모두 크기 6의 배열 생성
		for(int i = 0; i < items_intro4.length; i++) {	//6회 반복
			items_intro4[i] = new JPanel();	//패널 생성
		
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

			items_intro4[i].add(item4[i]);	//이미지를 붙임
			items_intro4[i].add(desc[i]);	
		//	items_intro[i].add(buton[i]);
			//과일 설명을 붙임
		} //end of for
		desc[0].add(new JLabel("       프로그램 설명"));	
		desc[0].add(new JLabel("       기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[0].add(new JLabel( "      가격 ㅣ 15,000원. "));
		desc[0].add(new JLabel("       시간 : 오전 09시~12시까지"));			
		desc[0].add(new JLabel("        	 오후13시~18시까지" ));
		desc[0].add(new JLabel( "       인원: 15명 "));
		desc[0].add(new JLabel( "       1544-7744. "));
		
	
		desc[1].add(new JLabel("       프로그램 설명"));	
		desc[1].add(new JLabel("       기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[1].add(new JLabel( "      가격 ㅣ 15,000원. "));
		desc[1].add(new JLabel("       시간 : 오전 09시~12시까지"));			
		desc[1].add(new JLabel("        	 오후13시~18시까지" ));
		desc[1].add(new JLabel( "       인원: 15명 "));
		desc[1].add(new JLabel( "       1544-7744. "));
		
	
		desc[2].add(new JLabel("       프로그램 설명"));	
		desc[2].add(new JLabel("       기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[2].add(new JLabel( "      가격 ㅣ 15,000원. "));
		desc[2].add(new JLabel("       시간 : 오전 09시~12시까지"));			
		desc[2].add(new JLabel("        	 오후13시~18시까지" ));
		desc[2].add(new JLabel( "       인원: 15명 "));
		desc[2].add(new JLabel( "       1544-7744. "));
		
	
		desc[3].add(new JLabel("       프로그램 설명"));	
		desc[3].add(new JLabel("       기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[3].add(new JLabel( "      가격 ㅣ 15,000원. "));
		desc[3].add(new JLabel("       시간 : 오전 09시~12시까지"));			
		desc[3].add(new JLabel("        	 오후13시~18시까지" ));
		desc[3].add(new JLabel( "       인원: 15명 "));
		desc[3].add(new JLabel( "       1544-7744. "));
		
	
		desc[4].add(new JLabel("       프로그램 설명"));	
		desc[4].add(new JLabel("       기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[4].add(new JLabel( "      가격 ㅣ 15,000원. "));
		desc[4].add(new JLabel("       시간 : 오전 09시~12시까지"));			
		desc[4].add(new JLabel("        	 오후13시~18시까지" ));
		desc[4].add(new JLabel( "       인원: 15명 "));
		desc[4].add(new JLabel( "       1544-7744. "));
		
	
		desc[5].add(new JLabel("       프로그램 설명"));	
		desc[5].add(new JLabel("       기간 :   2019.05.01 ~ 2019.05.31"));	
		desc[5].add(new JLabel( "      가격 ㅣ 15,000원. "));
		desc[5].add(new JLabel("       시간 : 오전 09시~12시까지"));			
		desc[5].add(new JLabel("        	 오후13시~18시까지" ));
		desc[5].add(new JLabel( "       인원: 15명 "));
		desc[5].add(new JLabel( "       1544-7744. "));
		
		Program.add(items_intro4[0],"그림1");
		Program.add(items_intro4[1],"그림2");
		Program.add(items_intro4[2],"그림3");
		Program.add(items_intro4[3],"그림4");
		Program.add(items_intro4[4],"그림5");
		Program.add(items_intro4[5],"그림6");
		
		
		adbance =new JButton("참여하기");
		adbance.addActionListener(new MyButtonListener4(this));
				
		prev = new JButton("이전");
		prev.addActionListener(new MyButtonListener4(this));
		next = new JButton("다음");
		next.addActionListener(new MyButtonListener4(this));
	
		buttons = new JPanel();	//버튼을 담을 패널 생성
		// buttons.add(last);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(adbance);
		
	}

		public Program(String str) {
			super(str);
			
		inIt();
		this.setLayout(new BorderLayout());
		this.add("Center",Program);
		this.add("South",buttons);
		
		this.setSize(1000, 500);
		this.setLocation(230, 200);
		this.setVisible(true);
		this.addWindowListener(new ReserveExit());	//이벤트처리 클래스를 따로 만들어 처리.
		this.addWindowListener(new ReserveEnd());	//윈도우어댑터로 해보기.
		
		
	}
	
	public static void main(String[] args) {
	new Program("하진 미술관");

	}

}	//end of fruitsShopping class

class ProgramEnd extends WindowAdapter{		//어댑터로 이벤트처리//////////////////

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}													//어댑터로 이벤트처리//////////////////

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
	ProgramImage(String path){		//path = 경로를 받기 위해
		img = Toolkit.getDefaultToolkit().getImage(path);
		
	}
	
	@Override
	public void paint(Graphics g) {

		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	//패널의 크기에 맞게 사이즈 조정하기
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


