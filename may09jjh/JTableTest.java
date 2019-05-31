package may09jjh;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest extends JFrame {

	public static void main(String[] args) {
		new JTableTest("JTable ver 1.0");
	}
	
	JTable table;
	String[] columnName = {"학 번", "이 름", "주 소", "연락처"};
	String[][] data = {
			{"2001A01", "홍길동", "서울시 송파구", "010-111-2222"},
			{"2001B01", "마길동", "서울시 강남구", "010-2121-3456"},
			{"2001C01", "오길동", "서울시 종로구", "010-4523-5678"}
			
	};
	
	JPanel panel;
	JScrollPane scroll;
	
	public JTableTest(String str) {
		super(str);
		panel = new JPanel();
		table = new JTable(data, columnName); // 데이터 , 열 제목
		scroll = new JScrollPane(table);
		
		panel.add(scroll);
		this.add("Center", panel);
		this.setSize(350, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
