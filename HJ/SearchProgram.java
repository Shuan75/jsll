package HJ;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


    public class SearchProgram extends JPanel {
    	
    	
	JPanel[] panel;
	JLabel label;
	JButton[] buttons;
	JTextField textfield;
	JTable table;
	JScrollPane scroll;
	JPanel totalpanel;
	String[] columnName = {"�̸� ","��ȭ��ȣ", "��¥", "���Ź�ȣ", "�ݾ�", "���������Ȳ"}; //������
	String[][] data = {
	         {"Ȳ����","010-xxxx-xxxx","2019/05/18","Y0001","45000","���ſϷ�"},
	         {"������","010-xxxx-xxxx","2019/05/18","Y0002","30000","���ſϷ�"},
	         {"����","010-xxxx-xxxx","2019/05/18","Y0003","30000","�������"},
	         {"������","010-xxxx-xxxx","2019/05/18","Y0004","30000","�������"}
	         //������
	   };
	


	public SearchProgram(){
		//super(str);
		//��ġ�����ڸ� �� �ٿ������.
		this.setLayout(new BorderLayout());
		totalpanel = new JPanel(new GridLayout(3,1));
		panel = new JPanel[3];
		for(int i=0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		for(int i=0; i < panel.length; i++) {
			totalpanel.add(panel[i]);
		}
		
		//���̺����
		table = new JTable(data,columnName);//������,������
	    scroll = new JScrollPane(table);
	      
		label = new JLabel("���Ź�ȣ");
		textfield = new JTextField(10);
		
		buttons = new JButton[2];
		buttons[0] = new JButton("�˻�");
		buttons[1] = new JButton("���");
		for(int i=0;i < buttons.length; i++) {
		
		buttons[i].setBackground(new Color(52, 152, 219));
		}
		
		panel[0].add(label); panel[0].add(textfield); panel[0].add(buttons[0]);
		for(int i=0;i < panel.length; i++) {
			panel[i].setBackground(new Color(199,228,248));
		}
		panel[2].add(buttons[1]);
		panel[1].add(scroll);
//		this.add(panel[0]);
//		this.add(panel[2]);
//
//		this.add(panel[1]);
//		
//		this.add(panel[3]); 
		this.add("Center",totalpanel);
//		this.add("North", new JLabel("ǥ����                                            "));
//		this.setSize(1000, 500);
//		this.setVisible(true);
		
		
	

		

		}
	
	public static void main(String[] args) {
		//  new SearchProgram ("���α׷���ȸȭ��");

	}

}