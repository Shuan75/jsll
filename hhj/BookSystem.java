package hhj;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class BookSystem extends JPanel implements ActionListener {
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		// ������ ������ ����� �´�.
		// ���� ������ ����� �´�.
		// ���� ������ ����� �´�.
		if (e.getSource() == combos[2]) {// ���� �������

			// ������ ���� ã�Ƽ�, ���� ���� ���� date�� �ִ´�.
			// getSelectedItem()�޼���� ������ ���̽��� �����͸� ã�´�.
			int m = (int)combos[2].getSelectedItem();
			//int month_int = Integer.parseInt(m);
			// ���ڿ��� int�� ��ȯ
			// date�� ������ ���ִ� �����͸� �� �����.
			// ���ִ� �����͸� ����� �޼���
			 combos[3].removeAllItems();
			switch (m) {
			case 2:// date�� 28���� ä���.
				
				for (int i = 1; i <= 28; i++) {
					combos[3].addItem(i + "");
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11: // date�� 30���� ä���.
				for (int i = 1; i <= 30; i++) {
					combos[3].addItem(i + "");
				}
				break;
			default: // date�� 31���� ä���.
				
				for (int i = 1; i <= 31; i++) {
					combos[3].addItem(i + "");
				}
			}

		}
		
		if(e.getSource() == buttons[0]) {
			
		}else if(e.getSource() == buttons[1]) {
		//������ư���������
		      
		    textfield.setText("   ");
		   
		   //�� ���� �ؽ�Ʈ �ʵ忡 �Էµ� ���� ����
		
		   madeIn[0].setSelected(true);//������ư�� �������� ����
		   madeIn[2].setSelected(true);//������ư�� �������� ����
		  }
		
		}
	

	JLabel totallabel;
	JLabel[] labels;
	MenuBar mb;
	Menu menu_exhibition, menu_goodies, menu_program, menu_event;
	MenuItem item_exhibition, item_exhibition1, item_exhibition2;
	Font menufont;
	JPanel[] panels;
	JPanel totalpanel;
	JRadioButton[] madeIn;
	ButtonGroup group;
	JTabbedPane tabs; // ���� �޸� �г�
	String[] radio_title = { "회원", "비회원", "현금", "카드" };
	String[] labels_title = { "미술작품", "날짜", "수량", "금액" };
	JComboBox[] combos;
	JTextField textfield;
	JButton[] buttons;
	BookSystem pan1;
	Font font;
	JPanel[] panel;
	JPanel TotalPanel;

	void MakeButton() {
		buttons = new JButton[2];
		buttons[0] = new JButton("구입하기");
		buttons[1] = new JButton("지우기");
		for (int i = 0; i < buttons.length; i++) {

			buttons[i].setBackground(new Color(52, 152, 219));
			buttons[i].setSize(400, 50);
		}

	}

	void MakeLabel() {
		labels = new JLabel[4];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(labels_title[i]);

		}

	}

	void MakeJComboBox() {
		combos = new JComboBox[5];
		for (int i = 0; i < combos.length; i++) {
			combos[i] = new JComboBox();
		}

		combos[0].addItem("���ü���");
		String[] arts_title = { "�ݰ���", "���", "��Ʈ��" };
		for (int k = 0; k < arts_title.length; k++) {
			combos[0].addItem(arts_title[k] + "");
		}

		combos[1].addItem("��������");
		for (int p = 2019; p >= 2000; p--) {
			combos[1].addItem(p);
		}

		combos[2].addItem("������");
		for (int j = 1; j <= 12; j++) {
			combos[2].addItem(j);
		}

		combos[3].addItem("�� ����");

		combos[4].addItem("��������");
		for (int t = 1; t < 10; t++) {
			combos[4].addItem(t);
		}

	}

	void MakeRadioButton() {
		madeIn = new JRadioButton[radio_title.length]; // �迭����
		group = new ButtonGroup(); // ���� �׷� ����
		for (int i = 0; i < radio_title.length; i++) {
			madeIn[i] = new JRadioButton(radio_title[i]); // ������ư����
			group.add(madeIn[i]); // �׷쿡 ���̱�

		}
	}

	void MakePanel() {
		panels = new JPanel[10];

		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			// panels[i].setLayout(new GridLayout(9,1));

		}

	}

	public BookSystem() {
		// super(str);
		font = new Font("�����110", font.PLAIN, 12);
		this.setLayout(new BorderLayout());
		TotalPanel = new JPanel(new GridLayout(1, 3));
		MakePanel();
		MakeLabel();
		MakeJComboBox();
		MakeButton();
		MakeRadioButton();

		textfield = new JTextField(10);

		tabs = new JTabbedPane();
		tabs.addTab("�����ϱ�", panels[0]);
		tabs.addTab("���α׷�����", panels[0]);
		this.add(panels[0]);
		totallabel = new JLabel("ȸ�� �α��� ȭ��");

		panels[0].setBackground(null);
		panels[0].setLayout(null);
		// panels[0].setSize(100, 100);
		// panels[0].setLocation(600, 20);
		panels[0].add(totallabel);
		totallabel.setFont(font);
		combos[2].addActionListener(this);

		panels[3].add(labels[0]);
		panels[3].add(combos[0]);
		panels[4].add(labels[1]);
		panels[4].add(combos[1]);
		panels[4].add(combos[2]);
		panels[4].add(combos[3]);
		for (int i = 0; i < panels.length; i++) {
			panels[i].setBackground(new Color(199, 228, 248));

		}

		panels[2].add(madeIn[0]);
		panels[2].add(madeIn[1]);
		panels[5].add(madeIn[2]);
		panels[5].add(madeIn[3]);
		panels[6].add(labels[2]);
		panels[6].add(combos[4]);
		panels[7].add(labels[3]);
		panels[7].add(textfield);
		// panels[9].setBackground(Color.WHITE);
		panels[9].add(buttons[0]);
		panels[9].add(buttons[1]);
		totalpanel = new JPanel();

		totalpanel.setLayout(new GridLayout(10, 1));

		// panels[0].setSize(100, 100);
		// panels[0].setLocation(600, 20);
		// panels[1].setSize(400, 100);
		// panels[1].setLocation(200,20);
		// panels[2].setSize(600, 100);
		// panels[2].setLocation(400,20);
		// totalpanel.add(panels[0]);
		for (int i = 0; i < 10; i++) {
			totalpanel.add(panels[i]);
		}
		TotalPanel.add("Center", totalpanel);
		this.add(TotalPanel);

		// �޴�//
		menufont = new Font("Noto Sans CJK KR Black", Font.PLAIN, 10);
		mb = new MenuBar();
		menu_exhibition = new Menu("                         전시                                      ");
		menu_goodies = new Menu("                            굿즈                                       ");
		menu_program = new Menu("                            프로그램                                   ");
		menu_event = new Menu("                              이벤트                                        ");

		menu_exhibition.setFont(menufont);
		menu_goodies.setFont(menufont);
		menu_program.setFont(menufont);
		menu_event.setFont(menufont);

		mb.add(menu_exhibition);
		mb.add(menu_goodies);
		mb.add(menu_program);
		mb.add(menu_event);
		menu_exhibition.setEnabled(true);
		menu_goodies.setEnabled(true);
		menu_program.setEnabled(true);
		menu_event.setEnabled(true);

		// this.setMenuBar(mb);
		this.setSize(1000, 500);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		// new BookSystem("�����ϱ�ȭ��");

	}

}
