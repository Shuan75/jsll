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
import javax.swing.table.AbstractTableModel;

public class EmplInfoJtable extends JFrame implements ActionListener {

	public static void main(String[] args) {
		new EmplInfoJtable("사원 정보 전체 조회");
	}

	JButton select;
	JTable table;
	JScrollPane scroll;
	JPanel centerPanel, southPanel;

	public EmplInfoJtable(String str) {
		super(str);

		select = new JButton("전체 검색");
		table = new JTable();
		scroll = new JScrollPane(table);
		centerPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel.add(scroll);
		southPanel.add(select);
		select.addActionListener(this);
		this.add("Center", centerPanel);
		this.add("South", southPanel);
		this.setSize(500, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		table.setModel(new EmplModel());

	}

}

// 1 . Model을 만든다.
class EmplModel extends AbstractTableModel {

	private Object[][] tableData;
	private int rows, cols;
	private String[] columnName = { "사 번", "이 름", "부서명", "성 별", "주 소", "입사일" };
	private List<Empl_info> list;

	EmplModel() {
		CRUDprocess crud = new CRUDprocess();
		list = crud.selectAllEmpl();
		setData();
	}

	private void setData() {
		rows = list.size();
		cols = columnName.length;
		Iterator it = list.iterator();
		tableData = new Object[rows][cols];
		int r = 0;

		while (it.hasNext()) {
			Empl_info empl = (Empl_info) it.next();

			tableData[r][0] = empl.getEmp_id(); // id를 읽음
			tableData[r][1] = empl.getEmp_name();
			tableData[r][2] = empl.getEmp_dept();
			tableData[r][3] = empl.getEmp_gender();
			tableData[r][4] = empl.getEmp_addr();
			tableData[r][5] = empl.getEmp_hire(); // 입사일
			r++;
		}

	}
	
	@Override
	public String getColumnName(int column) {
		
		return columnName[column];
	}

	@Override
	public int getRowCount() {

		return rows;
	}

	@Override
	public int getColumnCount() {

		return cols;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		return tableData[rowIndex][columnIndex];
	}

}