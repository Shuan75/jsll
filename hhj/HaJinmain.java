package hhj;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class BackgroundImage extends JPanel {
	final String PATH = "src\\hhj\\30.jpg";
	Image img;

	BackgroundImage() {
		img = Toolkit.getDefaultToolkit().getImage(PATH);
	}

	@Override
	public void paint(Graphics arg0) {
		arg0.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}

//���ο� �߰��Ұ� �α��ι�ưâ ��ȸ��â�� �߰��ϱ�
public class HaJinmain extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if (o == btns[0]) {// ȸ������
			bgi.setVisible(false);
//			this.remove(btnspanel);
			btnspanel.setVisible(false);
	//		CustomerSginUpMain = new CustomerSginUpMain(this);
			//totalpanel.setLayout(card);
		//	totalpanel.add(CustomerSginUpMain, "sginUp");
			//this.add("Center", totalpanel);
			this.card.show(totalpanel, "sginUp");
			
		}
		if (o == btns[1]) {// �α���
			this.remove(bgi);
			btnspanel.setVisible(false);
			//CustomerMainLogin = new CustomerMainLogin(this);
		//	totalpanel.add(CustomerMainLogin,"login");
			this.card.show(totalpanel, "login");
		}
		if (o == item_Reserve) {
		
			this.btnspanel.setVisible(false);
			this.card.show(totalpanel, "Re");
		
		}
		if (o == item_Reserve_day) {
			this.btnspanel.setVisible(false);
			this.card.show(totalpanel, "Rd");
		}
		if (o == item_Reserve_future) {
			this.btnspanel.setVisible(false);
			this.card.show(totalpanel, "Rt");
		}
		
		if (o == item_goodies) {
			
		}
		if (o == item_program) {
			
		}
		if (o == item_event) {
			
		}
	}

	public JButton[] btns;
	public String titles[] = { "        회원가입            "    ,    "        취소           " };

	void makebtns() {
		btns = new JButton[2];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(titles[i]);
			btns[i].setPreferredSize(new Dimension(150, 30));
			btns[i].addActionListener(this);
		}
		label = new JLabel[6];
		for(int i =0; i<label.length; i++) {
			label[i] = new JLabel();
		}
		
	}
	Reserve_day Rd;
	Reserve_future Rt;
	Reserve Rs;
	CardLayout card;
	Panel totalpanel;
	//CustomerSginUpMain CustomerSginUpMain;
	//Customersginupsystem Customersginupsystem;
//	CustomerMainLogin CustomerMainLogin;
	Font menufont;
	JMenuBar mb;
	JMenu menu_exhibition, menu_goodies, menu_program, menu_event;
	JMenuItem item_Reserve,item_Reserve_day, item_Reserve_future, item_goodies, item_program, item_event;
	JPanel btnspanel;
	
	JLabel[] label;
	JPanel bgi;
//	HaJinLoginMain hajinloginmain;
	HaJinmain(String str) {
		super(str);
		makebtns();
		menufont = new Font("����ü", Font.PLAIN, 15);
		this.setLayout(new BorderLayout());
		mb = new JMenuBar();
	// = new HaJinLoginMain(this);
		menu_exhibition = new JMenu("                        전시                                      ");
		menu_goodies = new JMenu("                            굿즈                                     ");
		menu_program = new JMenu("                           프로그램                                  ");
		menu_event = new JMenu("                              이벤트                                        ");
		
		item_Reserve = new JMenuItem("                 예전 전시                          ");
		item_Reserve_day = new JMenuItem("                 현재 전시                           ");
		item_Reserve_future = new JMenuItem("                 예정 전시                           ");
		item_goodies = new JMenuItem("                     굿즈                                   ");
		item_program = new JMenuItem("                      프로그램                              ");
		item_event = new JMenuItem("                        굿즈                               ");
		
		item_Reserve.setFont(menufont);
		item_Reserve_day.setFont(menufont);
		item_Reserve_future.setFont(menufont);
		item_goodies.setFont(menufont);
		item_program.setFont(menufont);
		item_event.setFont(menufont);
		
		item_Reserve.addActionListener(this);
		item_Reserve_day.addActionListener(this);
		item_Reserve_future.addActionListener(this);
		item_goodies.addActionListener(this);
		item_program.addActionListener(this);
		item_event.addActionListener(this);
		
		menu_exhibition.setEnabled(true);
		menu_goodies.setEnabled(true);
		menu_program.setEnabled(true);
		menu_event.setEnabled(true);
		
		menu_exhibition.add(item_Reserve);
		menu_exhibition.add(item_Reserve_day);
		menu_exhibition.add(item_Reserve_future);
		menu_goodies.add(item_goodies);
		menu_program.add(item_program);
		menu_event.add(item_event);
		
		mb.add(menu_exhibition);
		mb.add(menu_goodies);
		mb.add(menu_program);
		mb.add(menu_event);
		
		this.setJMenuBar(mb);
		// �޴� ���� �۾� ��
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
		Rs= new Reserve(this);
		Rd= new Reserve_day();
		Rt= new Reserve_future();
		totalpanel.add(bgi, "image");
		totalpanel.add(Rs,"Re");
		totalpanel.add(Rd,"Rd");
		totalpanel.add(Rt,"Rt");
	//	totalpanel.add(hajinloginmain,"loginmain");
		this.add("Center", totalpanel);
		this.add("South", btnspanel);
		this.setSize(1000, 500);
		this.setLocation(100, 0);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new HaJinmain("하진 미술관입니다.");
	}
}