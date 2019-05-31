package HJ;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabClass extends JFrame{
	 Purchase pur;
	 JTabbedPane tabs;
	 BookSystem b;
	 ProgramSystem p;
	 ProgramPurchase pp;
	 main main;
	 main2 main2;
	 CardLayout card;
	 JPanel cardpanel;

	public TabClass(){
		 
		  tabs = new JTabbedPane();
		  
		  b = new BookSystem(this);
		  p = new ProgramSystem(this);
			 
		  main2 = new main2();
		  main = new  main();
		  pur = new Purchase(b);
		  pp = new ProgramPurchase(p); 
		  card = new CardLayout();
		  cardpanel = new JPanel(card);
		  
		  tabs.addTab("예매하기", b);//패널1을 탭이 달린 패널에 붙임
		  tabs.addTab("프로그램예매", p);
		  
		  cardpanel.add(tabs,"tabs");
		  cardpanel.add(main,"main");
		  
		  this.add("Center",cardpanel);
		  this.setSize(1000, 500);
		  this.setVisible(true);
	 }

	public static void main(String[] args) {
		 new TabClass();

	}

}
