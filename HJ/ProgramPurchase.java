package HJ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;




public class ProgramPurchase extends JPanel  {
	


	JPanel[] panels;//�гε�
	JPanel toppanel;//���г�
    JPanel Totalpanel;//��ü�г�
	JLabel toplabel;
	JTextField textfield;
	JTable table;
	JScrollPane scroll;
	String[] columnName = {"�̸� ","��ȭ��ȣ", "��¥", "���Ź�ȣ", "�ݾ�", "���������Ȳ"}; //������
	String[][] data = {
	         {"Ȳ����","010-xxxx-xxxx","2019/05/18","Y0001","45000","���ſϷ�"},
	         {"������","010-xxxx-xxxx","2019/05/18","Y0002","30000","���ſϷ�"},
	         {"����","010-xxxx-xxxx","2019/05/18","Y0003","30000","�������"},
	         {"������","010-xxxx-xxxx","2019/05/18","Y0004","30000","�������"}
	         //������
	   };
	
	ProgramSystem pro;
	
	ProgramPurchase (ProgramSystem pro){ //������ ����
	//	super(str);
		
		this.pro = pro;
		
		panels = new JPanel[2];
		for(int i=0; i < panels.length; i++) {
		panels[i] = new JPanel();
		panels[i].setBackground(new Color(199, 228, 248));
		}//�гλ��� �гο� ��������
		
		
		Totalpanel = new JPanel();
		Totalpanel.setLayout(new GridLayout(2,1));
		toppanel = new JPanel();
		toppanel.setLayout(new BorderLayout());
		toppanel.setBackground(new Color(199, 228, 248));//���гο� ��������
		toplabel = new JLabel("���α׷��ڵ�");
		textfield = new JTextField(5);
		table = new JTable(data,columnName);//������,������
	    scroll = new JScrollPane(table);
	    toppanel.add("Center",panels[0]);
	    panels[0].add(toplabel); panels[0].add(textfield);
	    panels[1].add(table);
	    Totalpanel.add(panels[0]);
	    Totalpanel.add(panels[1]);
	    Totalpanel.setBackground(new Color(199, 228, 248));//��ü�гο� ��������
	    this.add("Center",Totalpanel);
	    this.setBackground(new Color(199, 228, 248));
	    this.setSize(1000, 500);
	    this.setVisible(true);
	}

	public static void main(String[] args) {
	//	new Purchase("�����ϱ�");

	}

}
