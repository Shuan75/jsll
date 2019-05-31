package hhj;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabClass extends JPanel{
		Reserve_day day;
	 JTabbedPane tabs;
	 BookSystem b;
	// ProgramSystem p;
	 
	public TabClass(){
		 Reserve Rs;
		  tabs = new JTabbedPane();
		  b = new BookSystem(); 
		  //day=new Reserve_day();
	//	  p = new ProgramSystem();
		 
		  tabs.addTab("�����ϱ�", b);//�г�1�� ���� �޸� �гο� ����
	//	  tabs.addTab("���α׷�����", p); 
		  this.add("Center",tabs);
		  this.setSize(1000, 500);
		//  this.setVisible(true);
	 }

	public static void main(String[] args) {
		// new TabClass();

	}

}
