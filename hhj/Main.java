package hhj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Main extends JPanel implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	JMenuBar mb;
	JMenu menu1, sub, menu_logout, menu_fruits, menu_ordering, //menu_item, menu_home, menu_employee,
	 menu_customer, menu_barchart, menu_image;
	JMenuItem mItem1, mItem2, mItem3, subItem1, subItem2;
	JTabbedPane tabs;	//탭이 달린 패널
	Reserve p1;
//	PcRoomSystem pan2;//그냥 패널
//	fruitsShopping pan3;
//	CustomerSystem pan4;
	public Main() {
		
		//uper(str);
		mb = new JMenuBar();	//메뉴 바 생성
		menu1 = new JMenu("                                전시                                  ");
		menu_logout = new JMenu("                          굿즈                                  ");
		menu_fruits = new JMenu("                       프로그램                                 ");
		menu_ordering = new JMenu("                       이벤트                                 ");
		
		mItem1 = new JMenuItem("                         이전전시                        ");
		mItem2 = new JMenuItem("                         현재전시                        ");
		mItem3 = new JMenuItem("                         예정전시                        ");

		menu1.add(mItem2);
		menu1.add(mItem3);
		menu1.addSeparator();		//구분선을 넣는다.

		mb.add(menu1);
		mb.add(menu_logout);
		mb.add(menu_fruits);
		mb.add(menu_ordering);
		
		////////////////   탭 패널 구성 ////////////////////////////////
		tabs = new JTabbedPane();
		this.add("Center",tabs);
		
		tabs.setPreferredSize(new Dimension( 200, 200));
	;
	}
	public static void main(String[] args) {
		new Menu("하진미술관");
	}

}
