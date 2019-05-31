package HJ;




import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProgramSystem extends JPanel implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		  Object o = e.getSource();
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
		
	if(e.getSource() == buttons[0]) {//���Թ�ư�� �������
		JOptionPane.showMessageDialog(ps,"�����Ͻðڽ��ϱ�?");
		int i=1;
		this.card.show(cardpanel,"programpurchase");
		pp.textfield.setVisible(true);
        pp.textfield.setText("Y000"+i);
        
        i++;
//		
			
		}else if(o == buttons[1]){//��ҹ�ư���������
		      
			JOptionPane.showMessageDialog(ps,"����Ͻðڽ��ϱ�?");
			tab.card.show(tab.cardpanel,"main");  
			  //  textfield.setText("   ");
			   
			   //�� ���� �ؽ�Ʈ �ʵ忡 �Էµ� ���� ����
			
			 //  madeIn[0].setSelected(true);//������ư�� �������� ����
			 //  madeIn[2].setSelected(true);//������ư�� �������� ����
			  }
			
		}
	

	
	
	JPanel[] panels;
	JLabel toplabel;
	JLabel[] labels;
	String[] labels_title = {"���α׷�","��¥","�ð�","�ο���","�ݾ�"};
	String[] radio_title = {"����(09:00~12:00)","����(13:00~18:00)","����","ī��"};
	String[] button_title = {"����","���"};
	JComboBox[] combos;
	JRadioButton[] madeIn; ButtonGroup group;
	JTextField textfield;
	JButton[] buttons;
	JPanel TotalPanel;
	
	JPanel cardpanel;
	JLabel[] label;
	CardLayout card;
	ProgramPurchase pp;
	ProgramSystem ps;
	main2 m2;
	main m;
	BookSystem b;
	
	
	void makeButton() {
		buttons = new JButton[2];
		for(int i=0;i < button_title.length; i++) {
			 buttons[i] = new JButton(button_title[i]);
			 buttons[i].setBackground(new Color(52,152,219));
			 buttons[i].setSize(400, 50);
		}
	}//��ư�����
	
	
	
	void makeRadioButton() {
		madeIn = new JRadioButton[4];
		group = new ButtonGroup();
		for(int i=0;i < radio_title.length; i++) {
			madeIn[i] = new JRadioButton(radio_title[i]);
		}
	}//������ư�����
	
	
	
	void makeCombobox() {
		combos = new JComboBox[5];
		for(int i=0;i < combos.length; i++) {
			combos[i] = new JComboBox();
		}//�޺��ڽ������
		
		combos[0].addItem("���α׷�����");
		   String[] program_title = {"��äȭ","��ȭ","��̱���","��������","�׸���"};
		   for(int k=0; k < program_title.length; k++) {
			   combos[0].addItem(program_title[k]+ "");
		   }
		 combos[1].addItem("��������");
		 for(int p =2019; p >=2000; p--) {
			   combos[1].addItem(p);
		   }
		 combos[2].addItem("������");
		   for(int j=1; j <= 12; j++) {
			   combos[2].addItem(j);
		   }
		   
		   combos[3].addItem("�� ����");
		   
		  combos[4].addItem("�ο��� ����");
		  for(int h=1; h <= 20; h++) {
			  combos[4].addItem(h);
		  }
	}//�޺��ڽ������
	
	
	
	void makelabel() {
		labels = new JLabel[5];
		for(int i=0;i < labels_title.length; i++) {
			labels[i] = new JLabel(labels_title[i]);
		}
	}//�󺧸����
	
	
	
	
	void makepanel(){
		panels = new JPanel[10];
		for(int i =0;i < 10; i++) {
			panels[i] = new JPanel();
			panels[i].setBackground(new Color(199,228,248));//�гε� ��������
			//panels[i].setLayout(new GridLayout(10,1));
			
		}
		
	}//�гθ����
	
	TabClass tab;
	public ProgramSystem(TabClass tab){//�����ڻ���
	this.tab = tab;
	//this.setLayout(new BorderLayout());
	
	
	makelabel();
	makeCombobox();
	makeRadioButton();
	makeButton();
	makepanel();
	m2 = new main2();
	m = new main();
	pp = new ProgramPurchase(this);
	pp.textfield.setVisible(false);
	
	card = new CardLayout();
	cardpanel = new JPanel();
	cardpanel.setBackground(new Color(199,228,248));
	textfield = new JTextField(20);
	
	//�гο� ������Ʈ ���̱�
	panels[2].add(labels[0]); panels[2].add(combos[0]);
	panels[3].add(labels[1]); panels[3].add(combos[1]); panels[3].add(combos[2]); panels[3].add(combos[3]);
	panels[4].add(labels[2]); panels[4].add(madeIn[0]); panels[4].add(madeIn[1]);
	panels[5].add(madeIn[2]); panels[5].add(madeIn[3]);
	panels[6].add(labels[3]); panels[6].add(combos[4]);
	panels[7].add(labels[4]); panels[7].add(textfield);
	panels[9].add(buttons[0]); panels[9].add(buttons[1]);
	//������Ʈ�� �׼Ǹ����� ���̱�
	combos[2].addActionListener(this);
	buttons[0].addActionListener(this);
	buttons[1].addActionListener(this);
	//toplabel = new JLabel("ȸ���α���ȭ��");
	//toplabel.setLocation(900, 200);
   // panels[0].add(toplabel);
	
    TotalPanel = new JPanel();
	TotalPanel.setLayout(new GridLayout(10,1));
    for(int i=0; i< 10; i++) {
    	TotalPanel.add(panels[i]);	
    
    }
    
    TotalPanel.setBackground(new Color(199,228,248));
    
    label = new JLabel[2];
    for(int i=0;i < label.length; i++) {
    	label[i] = new JLabel();
    //	label[i].setBackground(Color.WHITE);
    }
   // Center.add(label[0]);
  //  Center.add(TotalPanel);
  //  Center.add(label[1]);
   
   
	
    cardpanel.setLayout(card); //ī�巹�̾ƿ��� �������� ����
    cardpanel.add(TotalPanel,"total");
    cardpanel.add( pp , "programpurchase");
    cardpanel.add(m2,"main");
    //cardpanel.add(m,"main");
    cardpanel.setBackground(new Color(199,228,248));
    
    this.setLayout(new BorderLayout());
    this.add(cardpanel);
    this.setBackground(new Color(199,228,248));
   // this.setSize(1000, 500);
  //  this.setVisible(true);
	}

	public static void main(String[] args) {
		//new ProgramSystem();

	}

}
