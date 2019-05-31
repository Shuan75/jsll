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

import com.sun.javafx.scene.control.skin.ButtonSkin;



public class Reserve extends JPanel {

	
		
	HaJinmain hm;
	HaJinLoginMain hahome;
	JButton prev,next,last,home;
	JPanel buttons;	//버튼을 담을 패널
	JPanel Reserve;
	JPanel[] r;
	JPanel[] items_intro, item, desc,buton;	
	
	JTable[] d;
	CardLayout card;	
	
	void inIt() {
		card = new CardLayout();	//배치관리자 생성
		Reserve = new JPanel(card);	//패널을 생성하면서 배치관리자 설정
		hahome =new HaJinLoginMain();
		
		
		items_intro = new JPanel[6];
		item = new JPanel[6];
		desc = new JPanel[10];
		
	//	buton=new JPanel[1];//모두 크기 6의 배열 생성
		for(int i = 0; i < items_intro.length; i++) {	//6회 반복
			items_intro[i] = new JPanel();	//패널 생성
			items_intro[i].setLayout(new GridLayout(1,2));		//1행 2열의 그리드아웃 배치관리자
			desc[i] = new JPanel(new GridLayout(7,1));
		//	buton[i]= new JPanel(new GridLayout(1,3));
			switch(i) {
			case 0:
				item[i] = new ReserveImage("src\\hhj\\01.jpg"); break;
			case 1:
				item[i] = new ReserveImage("src\\hhj\\02.jpg"); break;
			case 2:
				item[i] = new ReserveImage("src\\hhj\\03.jpg"); break;
			case 3:
				item[i] = new ReserveImage("src\\hhj\\04.jpg"); break;
			case 4:
				item[i] = new ReserveImage("src\\hhj\\05.jpg"); break;
			case 5:
				item[i] = new ReserveImage("src\\hhj\\06.jpg"); break;
			}

			items_intro[i].add(item[i]);	//이미지를 붙임
			items_intro[i].add(desc[i]);
		//	items_intro[i].add(buton[i]);
			//과일 설명을 붙임
		} //end of for
		
		
	
		desc[0].add(new JLabel("    제임스 진"));	
		desc[0].add(new JLabel("    JAMES JEAN(B.1979"));	
		desc[0].add(new JLabel("    1979년 대만에서 출생한 제임스 진은 3살 되던 해 미국 뉴조지로  이주해 "));
		desc[0].add(new JLabel("    현재로스앤젤레서를 기반으로 다양한 작업을 보여주고 있습니다. "));
		desc[0].add(new JLabel("    제임스 진은 뉴욕의 미술 명문인 스쿨 오브 비주얼아츠(SVA)에서 . "));
		desc[0].add(new JLabel("    일러스트를 수학하고, 이후 2001년부터 미국 만화산업을 대표하는  "));
		desc[0].add(new JLabel("    디씨 코믹스(DC Comics)의『페이블즈 Fables』커버 작업을 시작하면서.... "));
	
		desc[1].add(new JLabel("   제임스 진"));	
		desc[1].add(new JLabel("   JAMES JEAN(B.1979"));	
		desc[1].add(new JLabel("   1979년 대만에서 출생한 제임스 진은 3살 되던 해 미국 뉴조지로  이주해 "));
		desc[1].add(new JLabel("   현재로스앤젤레서를 기반으로 다양한 작업을 보여주고 있습니다. "));
		desc[1].add(new JLabel("   제임스 진은 뉴욕의 미술 명문인 스쿨 오브 비주얼아츠(SVA)에서 . "));
		desc[1].add(new JLabel("   일러스트를 수학하고, 이후 2001년부터 미국 만화산업을 대표하는  "));
		desc[1].add(new JLabel("   디씨 코믹스(DC Comics)의『페이블즈 Fables』커버 작업을 시작하면서.... "));

		desc[2].add(new JLabel("   제임스 진"));	
		desc[2].add(new JLabel("   JAMES JEAN(B.1979"));	
		desc[2].add(new JLabel("   1979년 대만에서 출생한 제임스 진은 3살 되던 해 미국 뉴조지로  이주해 "));
		desc[2].add(new JLabel("   현재로스앤젤레서를 기반으로 다양한 작업을 보여주고 있습니다. "));
		desc[2].add(new JLabel("   제임스 진은 뉴욕의 미술 명문인 스쿨 오브 비주얼아츠(SVA)에서 . "));
		desc[2].add(new JLabel("   일러스트를 수학하고, 이후 2001년부터 미국 만화산업을 대표하는  "));
		desc[2].add(new JLabel("   디씨 코믹스(DC Comics)의『페이블즈 Fables』커버 작업을 시작하면서.... "));

		desc[3].add(new JLabel("   제임스 진"));	
		desc[3].add(new JLabel("   JAMES JEAN(B.1979"));	
		desc[3].add(new JLabel("   1979년 대만에서 출생한 제임스 진은 3살 되던 해 미국 뉴조지로  이주해 "));
		desc[3].add(new JLabel("   현재로스앤젤레서를 기반으로 다양한 작업을 보여주고 있습니다. "));
		desc[3].add(new JLabel("   제임스 진은 뉴욕의 미술 명문인 스쿨 오브 비주얼아츠(SVA)에서 . "));
		desc[3].add(new JLabel("   일러스트를 수학하고, 이후 2001년부터 미국 만화산업을 대표하는  "));
		desc[3].add(new JLabel("   디씨 코믹스(DC Comics)의『페이블즈 Fables』커버 작업을 시작하면서.... "));

		desc[4].add(new JLabel("   제임스 진"));	
		desc[4].add(new JLabel("   JAMES JEAN(B.1979"));	
		desc[4].add(new JLabel("   1979년 대만에서 출생한 제임스 진은 3살 되던 해 미국 뉴조지로  이주해 "));
		desc[4].add(new JLabel("   현재로스앤젤레서를 기반으로 다양한 작업을 보여주고 있습니다. "));
		desc[4].add(new JLabel("   제임스 진은 뉴욕의 미술 명문인 스쿨 오브 비주얼아츠(SVA)에서 . "));
		desc[4].add(new JLabel("   일러스트를 수학하고, 이후 2001년부터 미국 만화산업을 대표하는  "));
		desc[4].add(new JLabel("   디씨 코믹스(DC Comics)의『페이블즈 Fables』커버 작업을 시작하면서.... "));

		desc[5].add(new JLabel("   제임스 진"));	
		desc[5].add(new JLabel("   JAMES JEAN(B.1979"));	
		desc[5].add(new JLabel("   1979년 대만에서 출생한 제임스 진은 3살 되던 해 미국 뉴조지로  이주해 "));
		desc[5].add(new JLabel("   현재로스앤젤레서를 기반으로 다양한 작업을 보여주고 있습니다. "));
		desc[5].add(new JLabel("   제임스 진은 뉴욕의 미술 명문인 스쿨 오브 비주얼아츠(SVA)에서 . "));
		desc[5].add(new JLabel("   일러스트를 수학하고, 이후 2001년부터 미국 만화산업을 대표하는  "));
		desc[5].add(new JLabel("   디씨 코믹스(DC Comics)의『페이블즈 Fables』커버 작업을 시작하면서.... "));

		
		Reserve.add(items_intro[0],"그림1");
		Reserve.add(items_intro[1],"그림2");
		Reserve.add(items_intro[2],"그림3");
		Reserve.add(items_intro[3],"그림4");
		Reserve.add(items_intro[4],"그림5");
		Reserve.add(items_intro[5],"그림6");
		Reserve.add(hahome,"home");
		
		home= new JButton("HOME");
		home.addActionListener(new MyButtonListener(this));
		prev = new JButton("이전");
		prev.addActionListener(new MyButtonListener(this));
		next = new JButton("다음");
		next.addActionListener(new MyButtonListener(this));
	
		buttons = new JPanel();	//버튼을 담을 패널 생성
	
		buttons.add(prev);
		buttons.add(next);
		buttons.add(home);
		
		}


		public Reserve(HaJinmain h) {
//			super(str);
		this.hm = hm;	
		inIt();
		this.setLayout(new BorderLayout());
		this.add("Center",Reserve);
		this.add("South",buttons);
//		this.setSize(1000, 500);
//		this.setLocation(230, 200);
//		this.setVisible(true);
//		this.addWindowListener(new ReserveExit());	//이벤트처리 클래스를 따로 만들어 처리.
//		this.addWindowListener(new ReserveEnd());	//윈도우어댑터로 해보기.
		
		
	}
	
	public static void main(String[] args) {
//	new Reserve("하진 미술관");

	}

}	//end of fruitsShopping class

class ReserveEnd extends WindowAdapter{		//어댑터로 이벤트처리//////////////////

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}													//어댑터로 이벤트처리//////////////////

class ReserveExit implements WindowListener{
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

class ReserveImage extends JPanel{
	Image img;
	ReserveImage(String path){		//path = 경로를 받기 위해
		img = Toolkit.getDefaultToolkit().getImage(path);
		
	}
	
	@Override
	public void paint(Graphics g) {

		//g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	//패널의 크기에 맞게 사이즈 조정하기
	}
			
}

class MyButtonListener implements ActionListener{
		Reserve fs;
//		TotalSystem ts;
		MyButtonListener(Reserve fs){
			this.fs = fs;
//			this.ts = ts;
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		//fruits에 있는 패널 중 첫번째로 이동
		if(obj == fs.prev) {
		
			fs.card.previous(fs.Reserve);
		} else if(obj == fs.next) {
			fs.card.next(fs.Reserve);
		} else if(obj ==fs.home) {
			fs.buttons.setVisible(false);
			fs.card.show(fs.Reserve, "home");
		} 
		
	}
	
}


