package yyg;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NcustomerSginUp extends JPanel implements ActionListener {

	HaJinLoginMain HaJinLoginMain;
	NcustomerMain NcustomerMain;
	CustomerMainLogin CustomerMainLogin;
	CustomerLogin CustomerLogin;
	HaJinmain hm;
	CardLayout card;
	Panel totalpanel;
	JPanel[] panel;
	JLabel[] label, beelabel;
	JButton[] btns;
	JTextField[] inputs;

	void doIt() {
		panel = new JPanel[4];
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		inputs = new JTextField[3];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new JTextField(20);
		}
		String[] label_name = { "�̸�", "E-mail", "����ó" };// ��������
		label = new JLabel[3];
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(label_name[i]);
			panel[i].add(label[i]);
		}

		String[] btnstitle = { "����", "���" };
		btns = new JButton[2];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(btnstitle[i]);
			btns[i].setBackground(new Color(52, 152, 219));
			btns[i].addActionListener(this);
		}

		panel[0].add(label[0]);// �̸�
		panel[0].add(inputs[0]);
		panel[1].add(label[1]);// mail
		panel[1].add(inputs[1]);
		panel[2].add(label[2]);// ����ó
		panel[2].add(inputs[2]);
		panel[3].add(btns[0]); // ��ư
		panel[3].add(btns[1]);

		for (int i = 0; i < panel.length; i++) {
			panel[i].setBackground(new Color(199, 228, 248));
			totalpanel.add(panel[i]);
			totalpanel.setLayout(new GridLayout(4, 1));
		}

	}

	public NcustomerSginUp(HaJinmain hm) {
		this.hm = hm;
		CustomerMainLogin = CustomerMainLogin;
		HaJinLoginMain HaJinLoginMain;
		NcustomerMain NcustomerMain;
		card = new CardLayout();
		totalpanel = new Panel();
		totalpanel.setLayout(card);
		doIt();
		this.add("Center", totalpanel);
		this.setBounds(300, 300, 700, 600);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		CRUDprocess crud = new CRUDprocess();
		if (o == btns[0]) { // ����
			JOptionPane.showMessageDialog(hm, "��ȸ���� ���α׷�,����,�̺�Ʈ � �����ϽǼ� �����ϴ�.");
			String ncustomer_name = inputs[0].getText();
			if (!(ncustomer_name == null)) {
				String ncustomer_email = inputs[1].getText();
				String phone = (inputs[2].getText());
				if (phone.equals("")) {
					JOptionPane.showMessageDialog(hm, "�ڵ��� ��ȣ�� �Է����ּ���");
				} else if (!(phone == null)) {
					int ncustomer_phone = Integer.valueOf(phone);
					NCustomer_info cust = new NCustomer_info();
					cust.setNcustomer_name(ncustomer_name);
					cust.setNcustomer_email(ncustomer_email);
					cust.setNcustomer_phone(ncustomer_phone);
					int r = crud.insertNCustomer(cust);
					if (r > 0) {
						JOptionPane.showMessageDialog(hm, "��ȸ�� ���ԵǾ����ϴ�.");
					} else {
						JOptionPane.showMessageDialog(hm, "��ȸ�� ���� �� ������ �߻��߽��ϴ�.");
					}
					hm.card.show(hm.totalpanel, "loginmain");
					hm.menu_exhibition.setEnabled(true);// �޴��� Ȱ��ȭ
					hm.menu_goodies.setEnabled(false);// �޴��� Ȱ��ȭ
					hm.menu_program.setEnabled(false);
					hm.menu_event.setEnabled(false);
				}
			}
		}
		if (o == btns[1]) { // ��� �������� ���ư�
			hm.card.show(hm.totalpanel, "image");
			hm.btnspanel.setVisible(true);
		}

	}
}