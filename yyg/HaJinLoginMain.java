package yyg;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Backimage extends JPanel {
	final String PATH = "src\\image\\HaJinMain.jpg";
	Image img;

	Backimage() {
		img = Toolkit.getDefaultToolkit().getImage(PATH);
	}

	@Override
	public void paint(Graphics arg0) {
		arg0.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}

public class HaJinLoginMain extends JPanel implements ActionListener {

	NcustomerSginUp NcustomerSginUp;
	NcustomerMain NcustomerMain;
	CustomerMainLogin CustomerMainLogin;
	Customersginupsystem Customersginupsystem;
	CustomerLogin CustomerLogin;
	HaJinmain hm;
	JButton[] btns;
	String titles[] = { "   Mypage   ", "   Logout     " };
	JLabel[] label;
	JPanel btnspanel;
	JPanel bgi;
	CardLayout card;
	JPanel totalpanel, Southpanel;

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btns[0]) {// 마이페이지 //아직
		
		}
		if (o == btns[1]) {
			JOptionPane.showMessageDialog(hm, "로그아웃 진행중입니다.");
			hm.card.show(hm.totalpanel, "login");
			hm.menu_exhibition.setEnabled(false);
			hm.menu_goodies.setEnabled(false);
			hm.menu_program.setEnabled(false);
			hm.menu_event.setEnabled(false);
		}
	}

	void makebtns() {
		btns = new JButton[2];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(titles[i]);
			btns[i].setPreferredSize(new Dimension(100, 30));
			btns[i].addActionListener(this);
		}
		label = new JLabel[15];
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel();
		}
		btnspanel = new JPanel();
		btnspanel.add(btns[0]);
		btnspanel.add(label[0]);
		btnspanel.add(label[1]);
		btnspanel.add(label[2]);
		btnspanel.add(label[3]);
		btnspanel.add(label[4]);
		btnspanel.add(label[5]);
		btnspanel.add(label[6]);
		btnspanel.add(btns[1]);
		btnspanel.add(label[7]);
		btnspanel.add(label[8]);
		btnspanel.add(label[9]);
		btnspanel.add(label[10]);
		btnspanel.add(label[11]);
		btnspanel.add(label[12]);
		btnspanel.add(label[13]);
		btnspanel.add(label[14]);
		btns[0].setBackground(new Color(52, 152, 219));
		btns[1].setBackground(new Color(52, 152, 219));
	}

	HaJinLoginMain(HaJinmain hm) {
//		super(str);
		this.hm = hm;
		makebtns();
		this.setLayout(new BorderLayout());
		card = new CardLayout();
		Southpanel = new JPanel();
		totalpanel = new JPanel();
		bgi = new Backimage();
		totalpanel.add(bgi, "image");
		totalpanel.setLayout(card);
		Southpanel.setLayout(card);
		this.add("Center", totalpanel);
		this.add("South", btnspanel);
//		HaJinmain.menu_exhibition.setEnabled(true);
//		HaJinmain.menu_goodies.setEnabled(true);
//		HaJinmain.menu_program.setEnabled(true);
//		HaJinmain.menu_event.setEnabled(true);
//		this.setVisible(true);
//		this.setSize(400,500);

	}

	public static void main(String[] args) {

//		new HaJinLoginMain("메인로그인 ");
	}
}