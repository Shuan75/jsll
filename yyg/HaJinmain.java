package yyg;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class BackgroundImage extends JPanel {
	final String PATH = "src\\image\\HaJinMain.jpg";
	Image img;

	BackgroundImage() {
		img = Toolkit.getDefaultToolkit().getImage(PATH);
	}

	@Override
	public void paint(Graphics arg0) {
		arg0.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}

public class HaJinmain extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if (o == btns[0]) {// 회원가입
			bgi.setVisible(false);
//			this.remove(btnspanel);
			btnspanel.setVisible(false);
			CustomerSginUpMain = new CustomerSginUpMain(this);
			//totalpanel.setLayout(card);
			totalpanel.add(CustomerSginUpMain, "sginUp");
			//this.add("Center", totalpanel);
			this.card.show(totalpanel, "sginUp");
			
		}else if (o == btns[1]) {// 로그인
			this.remove(bgi);
			btnspanel.setVisible(false);
			CustomerMainLogin = new CustomerMainLogin(this);
			totalpanel.add(CustomerMainLogin,"login");
			this.card.show(totalpanel, "login");
		}
		else if (o == item_exhibition) {
			System.out.println("이전전시를 누름");
		}
		else if (o == item_exhibition1) {
			this.btnspanel.setVisible(false);
			this.card.show(totalpanel, "Reserve_day");
		}
		else if (o == item_exhibition2) {
			System.out.println("예정전시를 누름");
		}
		else if (o == item_goodies) {
			
		}
		else if (o == item_program) {
			
		}
		else if (o == item_event) {
			
		}
	}

	public JButton[] btns;
	public String titles[] = { "        회원가입            "    ,    "         로그인            " };

	void makebtns() {
		btns = new JButton[2];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(titles[i]);
			btns[i].setBackground(new Color(52, 152, 219));
			btns[i].setPreferredSize(new Dimension(150, 30));
			btns[i].addActionListener(this);
		}
		label = new JLabel[6];
		for(int i =0; i<label.length; i++) {
			label[i] = new JLabel();
		}

	}

	CardLayout card;
	Panel totalpanel;
	ManagerMode mm;
	CustomerSginUpMain CustomerSginUpMain;
	Customersginupsystem Customersginupsystem;
	CustomerMainLogin CustomerMainLogin;
	Font menufont;
	JMenuBar mb;
	JMenu menu_exhibition, menu_goodies, menu_program, menu_event;
	JMenuItem item_exhibition,item_exhibition1, item_exhibition2, item_goodies, item_program, item_event;
	JPanel btnspanel;
	JLabel[] label;
	JPanel bgi;
	HaJinLoginMain hajinloginmain;
	HaJinmain(String str) {
		super(str);
		makebtns();
		menufont = new Font("굴림체", Font.PLAIN, 15);
		this.setLayout(new BorderLayout());
		mb = new JMenuBar();
		hajinloginmain = new HaJinLoginMain(this);
		menu_exhibition = new JMenu("                         전시                                      ");
		menu_goodies = new JMenu("                            굿즈                                       ");
		menu_program = new JMenu("                            프로그램                                   ");
		menu_event = new JMenu("                              이벤트                                        ");
		
		item_exhibition = new JMenuItem("                  이전 전시                             ");
		item_exhibition1 = new JMenuItem("                  현재 전시                             ");
		item_exhibition2 = new JMenuItem("                  예정 전시                             ");
		item_goodies = new JMenuItem("                      굿즈                                   ");
		item_program = new JMenuItem("                      프로그램                              ");
		item_event = new JMenuItem("                        이벤트                               ");
		
		item_exhibition.setFont(menufont);
		item_exhibition1.setFont(menufont);
		item_exhibition2.setFont(menufont);
		item_goodies.setFont(menufont);
		item_program.setFont(menufont);
		item_event.setFont(menufont);
		
		item_exhibition.addActionListener(this);
		item_exhibition1.addActionListener(this);
		item_exhibition2.addActionListener(this);
		item_goodies.addActionListener(this);
		item_program.addActionListener(this);
		item_event.addActionListener(this);
		
		menu_exhibition.setEnabled(false);
		menu_goodies.setEnabled(false);
		menu_program.setEnabled(false);
		menu_event.setEnabled(false);
		
		menu_exhibition.add(item_exhibition);
		menu_exhibition.add(item_exhibition1);
		menu_exhibition.add(item_exhibition2);
		menu_goodies.add(item_goodies);
		menu_program.add(item_program);
		menu_event.add(item_event);
		
		
		mb.add(menu_exhibition);
		mb.add(menu_goodies);
		mb.add(menu_program);
		mb.add(menu_event);
		
		this.setJMenuBar(mb);
		// 메뉴 관련 작업 끝
		mm = new ManagerMode(this);
		card = new CardLayout();
		totalpanel = new Panel(); 
		totalpanel.setLayout(card);
		btnspanel = new JPanel();
		btnspanel.add(btns[0]);
		btnspanel.add(label[0]);
		btnspanel.add(label[1]);
		btnspanel.add(label[2]);
		btnspanel.add(label[3]);
		btnspanel.add(label[4]);
		btnspanel.add(label[5]);
		btnspanel.add(btns[1]);
		bgi = new BackgroundImage();
		totalpanel.add(bgi, "image");
		totalpanel.add(hajinloginmain,"loginmain");
		totalpanel.add(mm, "ManagerMode");
		this.add("Center", totalpanel);
		this.add("South", btnspanel);
		this.setSize(1000, 700);
		this.setResizable(false);
		this.setLocation(100, 0);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new HaJinmain("하진미술관 메인");
	}
}