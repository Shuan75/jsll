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
		 
		  tabs.addTab("������ȸ", st);//�г�1�� ���� �޸� �гο� ����
		  tabs.addTab("���α׷���ȸ", sp); 
		  this.add("Center",tabs);
		  this.setSize(1000, 500);
		  this.setVisible(true);
	 }

	public static void main(String[] args) {
			new TabClass2();

	}

}
