package HJ;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class BookSystem extends JPanel implements ActionListener {
	
	



	@Override //����,��,�� �׼�
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

		}//������� �޺��ڽ� �׼�
		
		
		
		
		if(e.getSource() == buttons[0]) {//���Թ�ư���������
			JOptionPane.showMessageDialog(b,"�����Ͻðڽ��ϱ�?");
			int i=1;
			this.card.show(TotalPanel,"purchase");
            p.textfield.setText("Y000"+i);
            
            i++;
//          
//           String ticketcode = p.textfield.getText();//�Է��� �ڵ带 �ҷ���
//	        CRUDprocess crud = new CRUDprocess();
//				int r = crud.insertreservecode(ticketcode);
//			    if(r > 0) {
//			    	JOptionPane.showMessageDialog(b, "���Ź�ȣ������Ǿ����ϴ� ");
//			  
//				
//			}
            

			
			} 
		
		if(e.getSource() == buttons[1]) {//����ϸ� Ȩ����
			JOptionPane.showMessageDialog(b,"����Ͻðڽ��ϱ�?");
			tab2.card.show(tab2.cardpanel,"main");
			
		
		  //  textfield.setText("   ");
		   //�� ���� �ؽ�Ʈ �ʵ忡 �Էµ� ���� ����
		//  madeIn[0].setSelected(true);//������ư�� �������� ����
		//  madeIn[2].setSelected(true);//������ư�� �������� ����
		  }
		
		}
	
    TabClass tab;
	JLabel totallabel;
	JLabel[] labels;
	JMenuBar mb;
	JMenu menu_exhibition, menu_goodies, menu_program, menu_event;
	JMenuItem item_exhibition, item_exhibition1,
	item_exhibition2,item_goodies,item_program,item_event;
	Font menufont;
	JPanel[] panels;
	JPanel totalpanel;
	JRadioButton[] madeIn;
	ButtonGroup group;
	JTabbedPane tabs; // ���� �޸� �г�
	String[] radio_title = { "ȸ��", "��ȸ��", "����", "ī��" };
	String[] labels_title = { "�̼�����", "��¥", "����", "�ݾ�" };
	JComboBox[] combos;
	JTextField textfield;
	JButton[] buttons;

	Font font;
	JPanel[] panel;
	JPanel TotalPanel; //���ΰ��δ� ī���г�
	CardLayout card; //ī�巹�̾ƿ� ����
	Purchase p;
	BookSystem b;
	main main2;


	void MakeButton() {
		buttons = new JButton[2];
		buttons[0] = new JButton("����");
		buttons[1] = new JButton("���");
		for (int i = 0; i < buttons.length; i++) {

			buttons[i].setBackground(new Color(52, 152, 219));
			buttons[i].setSize(400, 50);
		}

	}//��ư2�������

	void MakeLabel() {
		labels = new JLabel[4];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(labels_title[i]);

		}//��4�������

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

	}//�޺��ڽ����̽�5�������

	void MakeRadioButton() {
		madeIn = new JRadioButton[radio_title.length]; // �迭����
		group = new ButtonGroup(); // ���� �׷� ����
		for (int i = 0; i < radio_title.length; i++) {
			madeIn[i] = new JRadioButton(radio_title[i]); // ������ư����
			group.add(madeIn[i]); // �׷쿡 ���̱�

		}
	}//������ư�����

	void MakePanel() {
		panels = new JPanel[10];

		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			// panels[i].setLayout(new GridLayout(9,1));

		}

	}//�г�10�������
	
	ProgramSystem ps;
	TabClass tab2;
	public BookSystem(TabClass tab2) {//������
		// super(str);
		 //�޴� 
		this.tab2 = tab2;
		 this.setLayout(new BorderLayout());
		 mb = new JMenuBar();
	      
	      menu_exhibition = new JMenu("                         ����                                      ");
	      menu_goodies = new JMenu("                            ����                                       ");
	      menu_program = new JMenu("                            ���α׷�                                   ");
	      menu_event = new JMenu("                              �̺�Ʈ                                        ");
	      
	      item_exhibition = new JMenuItem("                  ���� ����                             ");
	      item_exhibition1 = new JMenuItem("                  ���� ����                             ");
	      item_exhibition2 = new JMenuItem("                  ���� ����                             ");
	      item_goodies = new JMenuItem("                      ����                                   ");
	      item_program = new JMenuItem("                      ���α׷�                              ");
	      item_event = new JMenuItem("                        �̺�Ʈ                               ");
	      
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
	      
	      menu_exhibition.setEnabled(true);
	      menu_goodies.setEnabled(true);
	      menu_program.setEnabled(true);
	      menu_event.setEnabled(true);
	      
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
	      
         // �޴� //
		p = new Purchase(this);//����Ŭ�����ν��Ͻ������ؼ� booksys�� ���̱�
		main2 = new main(); //Ȩ���� ���� ����2 �ν��Ͻ� ���� booksys�� ���̱�
		card = new CardLayout();//ī�巹�̾ƿ� ����
	
		font = new Font("�����110", font.PLAIN, 12); //��Ʈ����
		this.setLayout(new BorderLayout()); // booksys���̾ƿ�
		TotalPanel = new JPanel(new GridLayout(1, 3));//��ü�����δ��г� �׸��� 1,3
		MakePanel();
		MakeLabel();
		MakeJComboBox();
		MakeButton();
		MakeRadioButton();

		textfield = new JTextField(10);
//		this.hm = hm;
//		card = new CardLayout();
//		card_pan = new JPanel(card);
//		tabs = new JTabbedPane();
//		pan1 = new Customersginupsystem(hm);
//		tabs.addTab("  ȸ   ��   ��   ��   ", pan1);
//		
//		this.add("Center", tabs);
//		tabs = new JTabbedPane(); //�ǻ���
	   
		//ps = new ProgramSystem();
		//tabs.addTab("�����ϱ�", this);
	//	tabs.addTab("���α׷�����", ps);
		//this.add(panels[0]);
		
		totallabel = new JLabel("ȸ�� �α��� ȭ��"); //�󺧻���

		panels[0].setBackground(null); //�ΰ�?
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

		}//�гε��������

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
		
		//��ư �׼� ������
		buttons[0].addActionListener(this);
		buttons[1].addActionListener(this);
		
		//��ü�� ���δ� ���̾ƿ� ���� ���δ� ��ü�г� 10,1
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
		}//��ü��ü�� �гε���̱�
		TotalPanel.setLayout(card); //��ü�� ���δ� �гο� ī�巹�̾ƿ����̱� ī�巹�̾ƿ��� �������� ����
		TotalPanel.add(totalpanel,"total");//��ü�����δ��гο� ��ü��ü�� ���̱�
		TotalPanel.add(p, "purchase");//����ý��ۿ� ����â���̱�
		TotalPanel.add(main2,"HaJinmain");//����ý��ۿ� Ȩâ���̱�
	    TotalPanel.setBackground(new Color(199, 228, 248));
		
		this.add(TotalPanel);
        this.setBackground(new Color(199, 228, 248));
		
        // �޴�//
		menufont = new Font("Noto Sans CJK KR Black", Font.PLAIN, 10);
		mb = new JMenuBar();
		menu_exhibition = new JMenu("                         ����                                      ");
		menu_goodies = new JMenu("                            ����                                       ");
		menu_program = new JMenu("                            ���α׷�                                   ");
		menu_event = new JMenu("                              �̺�Ʈ                                        ");

		menu_exhibition.setFont(menufont);
		menu_goodies.setFont(menufont);
		menu_program.setFont(menufont);
		menu_event.setFont(menufont);

		mb.add(menu_exhibition);
		mb.add(menu_goodies);
		mb.add(menu_program);
		mb.add(menu_event);
		menu_exhibition.setEnabled(false);
		menu_goodies.setEnabled(false);
		menu_program.setEnabled(false);
		menu_event.setEnabled(false);
        //�޴��۾���//
	//	this.setJMenuBar(mb);
	//	this.setSize(1000, 500);
	//	this.setVisible(true);

	}//Ŭ���� ������ 

	

	public static void main(String[] args) {
		// new BookSystem();

	}//����ȭ��

}//Ŭ����������
