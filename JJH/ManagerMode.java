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

		menufont = new Font("����ü", Font.PLAIN,30);
		
		mb = new JMenuBar();
		menu_exhibition = new JMenu("      ����      ");
		menu_goods = new JMenu("      ����      ");
		menu_program = new JMenu("      ���α׷�      ");
		menu_event = new JMenu("      �̺�Ʈ      ");
		
		item_exhibition = new JMenuItem("���� ����");
		item_exhibition1 = new JMenuItem("���� ����");
		item_exhibition2 = new JMenuItem("���� ����");
		item_goods = new JMenuItem("����");
		item_program = new JMenuItem("���α׷�");
		item_event = new JMenuItem("�̺�Ʈ");
	
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
		tabs.addTab("ȸ������", pan1);
		tabs.addTab("�������", pan2);
		tabs.addTab("  ����  ", pan3);
		tabs.addTab("  ����  ", pan4);
		tabs.addTab("���α׷�", pan5);
		tabs.addTab(" �̺�Ʈ ", pan6);
		this.add("Center", tabs);
		///////////////////////////////////////////

		this.setBounds(150, 150, 1000, 700);
		// 200,200�� ��� ũ��� ���� 600 ���� 300
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
