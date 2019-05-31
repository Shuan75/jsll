package yyg;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CustomerSginUpMain extends JPanel {

	HaJinmain hm;
	Customersginupsystem pan1;
	JTabbedPane tabs;
	CardLayout card;
	JPanel card_pan;
	
	CustomerSginUpMain(HaJinmain hm) {
		this.hm = hm;
		card = new CardLayout();
		card_pan = new JPanel(card);
		tabs = new JTabbedPane();
		pan1 = new Customersginupsystem(hm);
		tabs.addTab("  회   원   가   입   ", pan1);
		
		this.add("Center", tabs);
		
		this.setBounds(300, 300, 700, 600);
	}

	public static void main(String[] args) {
	}

}