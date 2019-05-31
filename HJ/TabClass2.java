package HJ;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TabClass2 extends JFrame {
	
	 JTabbedPane tabs;
	 SearchTicket st;
	 SearchProgram sp;
	 
	public TabClass2(){
		 
		  tabs = new JTabbedPane();
		  st = new SearchTicket(); 
		  sp = new SearchProgram();
		 
		  tabs.addTab("예매조회", st);//패널1을 탭이 달린 패널에 붙임
		  tabs.addTab("프로그램조회", sp); 
		  this.add("Center",tabs);
		  this.setSize(1000, 500);
		  this.setVisible(true);
	 }

	public static void main(String[] args) {
			new TabClass2();

	}

}
