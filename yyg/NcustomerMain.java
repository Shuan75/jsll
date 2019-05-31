package yyg;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NcustomerMain extends JPanel implements ActionListener {

	HaJinLoginMain HaJinLoginMain;
	NcustomerSginUp NcustomerSginUp;
	HaJinmain hm;
	CustomerMainLogin CustomerMainLogin;
	CardLayout card;
	Panel totalpanel;
	JPanel[] panel;
	JLabel[] label;
	JPanel btnpanel;
	JTextField[] text;
	JButton[] btns;

	void make() {
		panel = new JPanel[9];
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		String[] labeltitle = { "", "E-Mail", "Phone", "" };
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
		panel[1].add(text[1]);
		panel[2].add(btns[0]);
		panel[2].add(btns[1]);
		panel[3].add(label[0]);
		panel[4].add(label[0]);
		panel[5].add(label[0]);
		panel[6].add(label[0]);
		panel[7].add(label[0]);
		totalpanel.setLayout(new GridLayout(8, 1));
		for (int i = 0; i < panel.length - 1; i++) {
			panel[i].setBackground(new Color(199, 228, 248));
			totalpanel.add(panel[i]);
		}
	}

	NcustomerMain(HaJinmain hm, CustomerMainLogin CustomerMainLogin) {
		NcustomerSginUp = NcustomerSginUp;
		this.hm = hm;
		this.CustomerMainLogin = CustomerMainLogin;
		card = new CardLayout();
		HaJinLoginMain = new HaJinLoginMain(hm);
		totalpanel = new Panel();
		totalpanel.setLayout(card);
		make();
		this.add("Center", totalpanel);
		this.setBackground(new Color(199, 228, 248));
		this.setBounds(300, 300, 700, 600);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if (o == btns[0]) {// 로그인
			String email = this.text[0].getText();
			String phone = this.text[1].getText();
			NUserIdPwd emph = new NUserIdPwd();
			emph.setEmail(email);
			emph.setPhone(phone);
			CRUDprocess crud = new CRUDprocess();
			NCustomer_info info = crud.selectNUserIdPwd(emph);
			if (email.equals("")) {// 로그인 실패
				JOptionPane.showMessageDialog(hm, "E-Mail을 확인해주세요");
			} else if(phone.equals("")){
				JOptionPane.showMessageDialog(hm, "phone을 확인해주세요");
			}else if(info == null) {
				JOptionPane.showMessageDialog(hm, "존재하지 않는 회원입니다.");
			}else if(!(info == null)) {
				JOptionPane.showMessageDialog(hm, "로그인 되었습니다.");
				hm.card.show(hm.totalpanel, "loginmain");
				hm.menu_exhibition.setEnabled(true);
				hm.menu_goodies.setEnabled(false);
				hm.menu_program.setEnabled(false);
				hm.menu_event.setEnabled(false);
				hm.card.show(hm.totalpanel, "loginmain");
			}
		}
		

		if (o == btns[1]) {
			CustomerMainLogin.card.show(CustomerMainLogin.card_pan, "NonSginUp");
		}

	}
}
