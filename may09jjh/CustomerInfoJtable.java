package may09jjh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class CustomerInfoJtable extends JFrame implements ActionListener {

	public static void main(String[] args) {
		new CustomerInfoJtable("고객정보 조회");
	}

	JButton select;
	JTable table;
	JPanel centerPanel, southPanel;
	JScrollPane scroll;

	public CustomerInfoJtable(String str) {
		super(str);
		select = new JButton("전체 조회");
		select.addActionListener(this);
		table = new JTable();
		centerPanel = new JPanel();
		southPanel = new JPanel();
		scroll = new JScrollPane(table);
		centerPanel.add(scroll);
		southPanel.add(select);
		this.add("Center", scroll);
		this.add("South", southPanel);
		this.setSize(500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		table.setModel(new CustomerModel());
		// Table이 사용하는 Model을 CustomerModel로 설정

	}

}

class CustomerModel extends AbstractTableModel { // callBack Method
	// 모델(데이터)이 rowcount columnCount등을 가지고 있음
	// JTable이getRowCount등을 호출
	private Object[][] tableData; // DB조회 결과가 저장될 배열
	private int cols, rows;

	private String[] columnName = { "고객번호", "고객이름", "고객주소", "가입일" }; // 열의 제목
	private List<Customer_info> list; // CollectionFrameWork의 List 객체 선언

	CustomerModel() {
		CRUDprocess crud = new CRUDprocess();
		list = crud.selectAllCustomer(); // DB조회 결과가 list에 저장됨
		// list에 있는 조회 결과를 tableData인 2차원 배열에 넣는다.
		setData();
	}

	private void setData() {
		// list에 있는 조회 결과를 2차원 배열(tableData)에 삽입.
		// CollectionFrameWork에 저장된 Data를 검색하는 방법 => Iterator
		Iterator it = list.iterator(); // DB 조회결과를 담음
		rows = list.size(); // 데이터의 갯수를 rows에 저장 (행의 갯수)
		cols = columnName.length; // 제목의 갯수를 cols에 저장 (열의 갯수)
		tableData = new Object[rows][cols]; // 배열 생성
		int r = 0;
		while (it.hasNext()) { // DB조회 결과 삽입
			Customer_info cs = (Customer_info) it.next(); // 조회결과를 가져옴 Customer_info 타입으로 반환
			tableData[r][0] = cs.getCust_id(); // 0.0에 고객ID를 삽입
			tableData[r][1] = cs.getCust_name();
			tableData[r][2] = cs.getCust_addr();
			tableData[r][3] = cs.getCust_reg_date();
			r++;
		}
	}

	@Override
	public String getColumnName(int column) {

		return columnName[column];
	}

	@Override
	public int getRowCount() {
		// DB 조회결과의 열의갯수를 Return
		return rows;
	}

	@Override
	public int getColumnCount() {
		// DB 조회결과의 행의갯수를 Return
		return cols;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableData[rowIndex][columnIndex];
	}

}
