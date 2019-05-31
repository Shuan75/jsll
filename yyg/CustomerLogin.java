package yyg;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class CustomerLogin extends JPanel implements ActionListener {

	ManagerMode mm;
	CustomerSginUpMain CustomerSginUpMain;
	HaJinLoginMain HaJinLoginMain;
	HaJinmain hm;
	Customersginupsystem Customersginupsystem;
	CustomerMainLogin cml;
	CardLayout card;
	Panel totalpanel, southpanel;
	JPanel[] panel;
	JLabel[] label;
	JPanel btnpanel;
	JTextField[] text;
	JButton[] btns;
	JPasswordField pw;

	void make() {
		pw = new JPasswordField(15);
		panel = new JPanel[9];
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		String[] labeltitle = { "", " ID ", " Pw ", "" };
		label = new JLabel[3];
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(labeltitle[i]);
		}
		text = new JTextField[2];
		for (int i = 0; i < text.length; i++) {
			text[i] = new JTextField(15);
		}
		String[] btnstitle = { "   로   그    인     ", "  회   원   가   입     " };
		btns = new JButton[2];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(btnstitle[i]);
			btns[i].setBackground(new Color(52, 152, 219));
			btns[i].addActionListener(this);
		}
		panel[0].add(label[1]);
		panel[0].add(text[0]);
		panel[1].add(label[2]);
		panel[1].add(pw);
		panel[2].add(btns[0]);
		panel[2].add(btns[1]);
		panel[3].add(label[0]);
		panel[4].add(label[0]);
		panel[5].add(label[0]);
		panel[6].add(label[0]);
		panel[7].add(label[0]);

		for (int i = 0; i < panel.length - 1; i++) {
			panel[i].setBackground(new Color(199, 228, 248));
			totalpanel.add(panel[i]);
			totalpanel.setLayout(new GridLayout(8, 1));
		}
	}

	public CustomerLogin(HaJinmain hm, CustomerMainLogin cm, HaJinLoginMain HaJinLoginMain, ManagerMode mm) {
		cml = cm;
		this.hm = hm;
		this.mm = mm;
		this.HaJinLoginMain = HaJinLoginMain;
		card = new CardLayout();
		totalpanel = new Panel();
		southpanel = new Panel();
		this.cml = cm;
		mm = new ManagerMode(hm);
		Customersginupsystem = new Customersginupsystem(hm);
		CustomerSginUpMain = new CustomerSginUpMain(hm);
		southpanel.setLayout(card);
		totalpanel.setLayout(card);
		make();
		this.add("Center", totalpanel);
		this.add("South", southpanel);
		this.setBackground(new Color(199, 228, 248));
		this.setBounds(300, 300, 700, 600);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if (o == btns[0]) {// 로그인
			CRUDprocess crud = new CRUDprocess();
			UserIdPwd idpwd = new UserIdPwd();
			String id = this.text[0].getText();
			String pwd = this.pw.getText();
			idpwd.setId(id);
			idpwd.setPwd(pwd);
			Customer_info info = crud.selectIdPwd(idpwd);
			if (id.equals("")) {// 로그인 실패
				JOptionPane.showMessageDialog(hm, "ID를 입력하세요");
			}
			if (pwd.equals("")) {
				JOptionPane.showMessageDialog(hm, "PWD를 입력하세요");
			}else if (info == null) {
				JOptionPane.showMessageDialog(hm, "ID또는 PWD를 확인해주세요.");
			}
			if (id.equals("jjh")) {
				JOptionPane.showMessageDialog(hm, "관리자 로그인 되었습니다.");
				cml.card.show(cml.card_pan, "ManagerMode");
				hm.menu_exhibition.setEnabled(true);// 메뉴바 활성화
				hm.menu_goodies.setEnabled(true);// 메뉴바 활성화
				hm.menu_program.setEnabled(true);
				hm.menu_event.setEnabled(true);
			} else if (!(info == null)) {
				JOptionPane.showMessageDialog(hm, "로그인 되었습니다.");
				hm.card.show(hm.totalpanel, "loginmain");
				hm.menu_exhibition.setEnabled(true);// 메뉴바 활성화
				hm.menu_goodies.setEnabled(true);// 메뉴바 활성화
				hm.menu_program.setEnabled(true);
				hm.menu_event.setEnabled(true);
			}
		}

		if (o == btns[1]) {// 회원가입
			cml.card.show(cml.card_pan, "CustomerSginUpMain");
		}

	}
}