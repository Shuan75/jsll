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
		  
		  tabs.addTab("�����ϱ�", b);//�г�1�� ���� �޸� �гο� ����
		  tabs.addTab("���α׷�����", p);
		  
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
