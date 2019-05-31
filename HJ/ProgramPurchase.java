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
	


	JPanel[] panels;//패널들
	JPanel toppanel;//윗패널
    JPanel Totalpanel;//전체패널
	JLabel toplabel;
	JTextField textfield;
	JTable table;
	JScrollPane scroll;
	String[] columnName = {"이름 ","전화번호", "날짜", "예매번호", "금액", "예매진행상황"}; //열제목
	String[][] data = {
	         {"황현준","010-xxxx-xxxx","2019/05/18","Y0001","45000","예매완료"},
	         {"이하진","010-xxxx-xxxx","2019/05/18","Y0002","30000","예매완료"},
	         {"김용근","010-xxxx-xxxx","2019/05/18","Y0003","30000","예매취소"},
	         {"정종현","010-xxxx-xxxx","2019/05/18","Y0004","30000","예매취소"}
	         //데이터
	   };
	
	ProgramSystem pro;
	
	ProgramPurchase (ProgramSystem pro){ //생성자 생성
	//	super(str);
		
		this.pro = pro;
		
		panels = new JPanel[2];
		for(int i=0; i < panels.length; i++) {
		panels[i] = new JPanel();
		panels[i].setBackground(new Color(199, 228, 248));
		}//패널생성 패널에 색입히기
		
		
		Totalpanel = new JPanel();
		Totalpanel.setLayout(new GridLayout(2,1));
		toppanel = new JPanel();
		toppanel.setLayout(new BorderLayout());
		toppanel.setBackground(new Color(199, 228, 248));//윗패널에 색입히기
		toplabel = new JLabel("프로그램코드");
		textfield = new JTextField(5);
		table = new JTable(data,columnName);//데이터,열제목
	    scroll = new JScrollPane(table);
	    toppanel.add("Center",panels[0]);
	    panels[0].add(toplabel); panels[0].add(textfield);
	    panels[1].add(table);
	    Totalpanel.add(panels[0]);
	    Totalpanel.add(panels[1]);
	    Totalpanel.setBackground(new Color(199, 228, 248));//전체패널에 색입히기
	    this.add("Center",Totalpanel);
	    this.setBackground(new Color(199, 228, 248));
	    this.setSize(1000, 500);
	    this.setVisible(true);
	}

	public static void main(String[] args) {
	//	new Purchase("구입하기");

	}

}
