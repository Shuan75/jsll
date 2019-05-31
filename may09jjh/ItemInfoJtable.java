package may09jjh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ItemInfoJtable extends JFrame implements ActionListener, MouseListener {

	public static void main(String[] args) {
		
		new ItemInfoJtable("ItemInfo Table");
	}

	public JButton select;
	public JScrollPane scroll;
	public JTable table;
	public JPanel panel, btnPanel;
	
	
	ItemInfoJtable(String str) {
		super(str);
		
		this.is = new ItemSystem(this);
		select = new JButton("전체조회");
		select.addActionListener(this);
		table = new JTable();
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
		panel = new JPanel();
		btnPanel = new JPanel();

		panel.add(is);
		panel.add(scroll);
		this.add("Center", panel);
		btnPanel.add(select);
		this.add("South", btnPanel);
		this.setSize(600, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		table.setModel(new ItemInfoModel());
	}

	ItemSystem is;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// 선택한 행의 전체정보를 불러온다.
		int selectedRow = table.getSelectedRow();
		int columnCount = table.getColumnCount(); // 열의 갯수를 저장
		
		for (int i = 0; i < columnCount; i++) {
			//System.out.println("선택한 행 : " + selectedRow
			//+ ", 전체 정보 " + table.getValueAt(selectedRow, i)
			is.inputs[0].setText(table.getValueAt(selectedRow, 0) + ""); // 상품 번호
			is.inputs[1].setText(table.getValueAt(selectedRow, 1) + ""); // 상품 이름
			is.inputs[2].setText(table.getValueAt(selectedRow, 2) + ""); // 상품 가격
			is.txt_area.setText(table.getValueAt(selectedRow, 3) + ""); // 상품 설명
			String str = table.getValueAt(selectedRow, 4) + "";
			if(str.equals("한국산")) {
				is.madeIn[0].setSelected(true); // 한국산일 때 첫번째 라디오 버튼의 상태를 선택으로 설정
			} else {
				is.madeIn[1].setSelected(true);
			}
			is.btns[0].setEnabled(false); // 삽입 버튼 비활성화
//			is.inputs[3].setText(table.getValueAt(selectedRow, 3) + ""); // 상품 정보
//			is.inputs[4].setText(table.getValueAt(selectedRow, 4) + ""); // 상품 원산지
//			is.inputs[5].setText(table.getValueAt(selectedRow, 5) + ""); // 상품 이미지
			// 3,4,5 화면이나왔을떄 4는 라디오버튼이라 안되고 5는 들어갈 버튼 자리가 없음
			
		}
		
		// 선택한 행과 열의 데이터를 ItemSystem으로 출력한다.
		

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}

class ItemInfoModel extends AbstractTableModel {

	private Object[][] tableData;
	int cols, rows;
	private String[] columnName = { "상품번호", "상품이름", "상품가격", "상품정보", "원산지", "상품 이미지 경로" };
	private List<ItemInfo> list;

	ItemInfoModel() {
		CRUDprocess crud = new CRUDprocess();
		list = crud.selectAllIteminfo();
		setData();

	}

	void setData() {
		Iterator it = list.iterator();
		rows = list.size(); // 검색된 데이터 건수를 행의 갯수로 사용
		cols = columnName.length; // 열 제목의 갯수를 열의 갯수로 사용
		tableData = new Object[rows][cols];
		int r = 0;
		while (it.hasNext()) {
			ItemInfo item = (ItemInfo) it.next();
			tableData[r][0] = item.getCode();
			tableData[r][1] = item.getName();
			tableData[r][2] = item.getPrice();
			tableData[r][3] = item.getInfo();
			tableData[r][4] = item.getOrigin();
			tableData[r][5] = item.getImage();
			r++;
		}
	}

	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return tableData[rowIndex][columnIndex];
	}

}