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
	String[] columnName = {"이름 ","전화번호", "날짜", "예매번호", "금액", "예매진행상황"}; //열제목
	String[][] data = {
	         {"황현준","010-xxxx-xxxx","2019/05/18","Y0001","45000","예매완료"},
	         {"이하진","010-xxxx-xxxx","2019/05/18","Y0002","30000","예매완료"},
	         {"김용근","010-xxxx-xxxx","2019/05/18","Y0003","30000","예매취소"},
	         {"정종현","010-xxxx-xxxx","2019/05/18","Y0004","30000","예매취소"}
	         //데이터
	   };
	


	public SearchProgram(){
		//super(str);
		//배치관리자를 꼭 붙여줘야함.
		this.setLayout(new BorderLayout());
		totalpanel = new JPanel(new GridLayout(3,1));
		panel = new JPanel[3];
		for(int i=0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		for(int i=0; i < panel.length; i++) {
			totalpanel.add(panel[i]);
		}
		
		//테이블생성
		table = new JTable(data,columnName);//데이터,열제목
	    scroll = new JScrollPane(table);
	      
		label = new JLabel("예매번호");
		textfield = new JTextField(10);
		
		buttons = new JButton[2];
		buttons[0] = new JButton("검색");
		buttons[1] = new JButton("취소");
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
//		this.add("North", new JLabel("표시중                                            "));
//		this.setSize(1000, 500);
//		this.setVisible(true);
		
		
	

		

		}
	
	public static void main(String[] args) {
		//  new SearchProgram ("프로그램조회화면");

	}

}