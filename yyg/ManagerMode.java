package yyg;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ManagerMode extends JPanel {

	public static void main(String[] args) {
	}

	HaJinmain hm;
	JTabbedPane tabs;
	JPanel pan5, pan6;
	CustomerSystem pan1;
	SalesManage pan2;
	Reserve pan3;
	Font menufont;
	GoodsSystem pan4;
	CardLayout card;
	JPanel card_pan;
	
	public ManagerMode(HaJinmain hm) {
		tabs = new JTabbedPane();
		card = new CardLayout();
		card_pan = new JPanel();
		pan1 = new CustomerSystem(this);
		pan2 = new SalesManage();
//		pan2.setSize(200, 200);
		pan2.setBackground(new Color(153, 255, 255));
		pan3 = new Reserve(this);
//		pan3.setSize(200, 200);
		pan3.setBackground(new Color(153, 255, 255));
		pan4 = new GoodsSystem();
//		pan4.setPreferredSize(getSize());
		pan4.setBackground(new Color(153, 255, 255));
		pan5 = new JPanel();
		pan5.setBackground(new Color(153, 255, 255));
		pan6 = new JPanel();
		pan6.setBackground(new Color(153, 255, 255));
		tabs.addTab("회원관리", pan1);
		tabs.addTab("매출관리", pan2);
		tabs.addTab("  전시  ", pan3);
		tabs.addTab("  굿즈  ", pan4);
		tabs.addTab("프로그램", pan5);
		tabs.addTab(" 이벤트 ", pan6);
		card_pan.add(tabs);
		this.add("Center", card_pan);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600,500));
		
	}
}
