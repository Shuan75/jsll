package JJH;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ManagerMode extends JFrame {

	public static void main(String[] args) {
		new ManagerMode("Manager Display");
	}

	JMenuBar mb;
	JMenu menu_exhibition, menu_goods, menu_program, menu_event;
	JMenuItem item_exhibition, item_exhibition1, item_exhibition2,
		item_goods, item_program, item_event;	
	JTabbedPane tabs;
	JPanel  pan6;
	CustomerSystem pan1;
	SalesManage pan2;
	Reserve pan3;
	Font menufont;
	GoodsSystem pan4;
	Program pan5;
	
	public ManagerMode(String str) {
		super(str);

		menufont = new Font("굴림체", Font.PLAIN,30);
		
		mb = new JMenuBar();
		menu_exhibition = new JMenu("      전시      ");
		menu_goods = new JMenu("      굿즈      ");
		menu_program = new JMenu("      프로그램      ");
		menu_event = new JMenu("      이벤트      ");
		
		item_exhibition = new JMenuItem("이전 전시");
		item_exhibition1 = new JMenuItem("현재 전시");
		item_exhibition2 = new JMenuItem("예정 전시");
		item_goods = new JMenuItem("굿즈");
		item_program = new JMenuItem("프로그램");
		item_event = new JMenuItem("이벤트");
	
		menu_exhibition.setFont(menufont);
		menu_goods.setFont(menufont);
		menu_program.setFont(menufont);
		menu_event.setFont(menufont);
		
		item_exhibition.setFont(menufont);
		item_exhibition1.setFont(menufont);
		item_exhibition2.setFont(menufont);
		item_goods.setFont(menufont);
		item_program.setFont(menufont);
		item_event.setFont(menufont);
		
//		menu_exhibiton.add(item_exhibition);
//		menu_exhibiton.add(item_exhibition1);
//		menu_exhibiton.add(item_exhibition2);
		menu_goods.add(item_goods);
		menu_program.add(item_program);
		menu_event.add(item_event);
		
		mb.add(menu_exhibition);
		mb.add(menu_goods);
		mb.add(menu_program);
		mb.add(menu_event);
		this.setJMenuBar(mb);
		tabs = new JTabbedPane();
		pan1 = new CustomerSystem(this);
		pan2 = new SalesManage();
		pan2.setSize(200, 200);
		pan2.setBackground(new Color(153, 255, 255));
		pan3 = new Reserve(this);
		pan3.setSize(200, 200);
		pan3.setBackground(new Color(153, 255, 255));
		pan4 = new GoodsSystem();
		pan4.setPreferredSize(getSize());
		pan4.setBackground(new Color(153, 255, 255));
		pan5 = new Program(this);
		pan5.setBackground(new Color(153, 255, 255));
		pan6 = new JPanel();
		pan6.setBackground(new Color(153, 255, 255));
		tabs.addTab("회원관리", pan1);
		tabs.addTab("매출관리", pan2);
		tabs.addTab("  전시  ", pan3);
		tabs.addTab("  굿즈  ", pan4);
		tabs.addTab("프로그램", pan5);
		tabs.addTab(" 이벤트 ", pan6);
		this.add("Center", tabs);
		///////////////////////////////////////////

		this.setBounds(150, 150, 1000, 700);
		// 200,200에 출력 크기는 가로 600 세로 300
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
