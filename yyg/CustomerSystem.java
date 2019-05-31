package yyg;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

public class CustomerSystem extends JPanel implements ActionListener , MouseListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btns[0]) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (!inputs[0].getText().equals("")) {
				map.put("Customer_ID", inputs[0].getText());
			}
			CRUDprocess crud = new CRUDprocess();
			ItemModel itemModel = new ItemModel(crud, map);
			mm.pan1.table.setModel(itemModel);

			
		} else if (o == btns[3]) {
			for (int i = 0; i < inputs.length; i++) {
				inputs[i].setText(" ");
				inputs[i].setText("");
			} 
			txt_area.setText(" ");
			txt_area.setText("");
			in.setText(" ");
			in.setText("");
		} else if (o == btns[2]) {
			int result = JOptionPane.showConfirmDialog(mm, "?ú¨ÂΩì„Å´?âä?ô§?Åó?Åæ?Åô?Åã?", "‰ΩúÊ??Á¢∫Ë™ç", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				if (!inputs[0].getText().equals("")) {
					map.put("Customer_ID", inputs[0].getText());
				}
				if (!inputs[1].getText().equals("")) {
					map.put("Customer_PWD", inputs[1].getText());
				}
				if (!inputs[2].getText().equals("")) {
					map.put("Customer_name", inputs[2].getText());
				}
				if (!inputs[3].getText().equals("")) {
					map.put("Customer_mail", inputs[3].getText());
				}
				if (!inputs[4].getText().equals("")) {
					map.put("Customer_phone", inputs[4].getText());
				}
				
				if (ch[0].isSelected()) {
					map.put("Customer_gender", "?Ç®?Ñ±");
				} else if (ch[1].isSelected()) {
					map.put("Customer_gender", "?ó¨?Ñ±");
				}

				CRUDprocess crud = new CRUDprocess();
				int r = crud.deleteIteminfoCondition(map);
				if (r > 0) {
					JOptionPane.showMessageDialog(mm, "?Ñ±Í≥µÏ†Å?úºÎ°? ?Ç≠?†ú?êò?óà?äµ?ãà?ã§.");
				} else {
					JOptionPane.showMessageDialog(mm, "?Ç≠?†ú?èÑÏ§? Î¨∏Ï†úÍ∞? Î∞úÏÉù?ïò???äµ?ãà?ã§.");
				}
		} else if ( o == btns[1]) {
			String id = inputs[0].getText();
			if (id.equals("")) {
				JOptionPane.showMessageDialog(mm, "IDÍ∞? ?ûÖ?†•?êòÏß? ?ïä?ïÑ?Ñú ?ûë?óÖ?ùÑ ÏßÑÌñâ?ï† ?àò ?óÜ?äµ?ãà?ã§");
			} else {
				int result1 = JOptionPane.showConfirmDialog(mm, "?†ïÎßêÎ°úÎ≥?Í≤ΩÌïò?ãúÍ≤†Ïäµ?ãàÍπ??", "?ûë?óÖ ?ôï?ù∏", JOptionPane.YES_NO_OPTION);
				if (result1 == JOptionPane.YES_OPTION) {
					CRUDprocess crud = new CRUDprocess();
					String pwd = inputs[1].getText();
					String name = inputs[2].getText();
					String mail = inputs[3].getText();
					String phone = inputs[4].getText();
					Icon dept = ch[0].getSelectedIcon();
					String gender = "";
//					if (ch[0].getState() == true) { // ?Ç®
//						gender = "?Ç®?Ñ±";
//					} else if (ch[1].getState() == true) {
//						gender = "?ó¨?Ñ±";
//					}
					
					Customer_info cusi = new Customer_info();
					cusi.setCustomer_ID(id);
					cusi.getCustomer_PWD();
					cusi.setCustomer_name(name);
					cusi.getCustomer_mail();
					cusi.getCustomer_phone();
					cusi.getCustomer_gender();
//					int r = crud.updateEmpl(cusi);
//					if (r > 0) {
//						JOptionPane.showMessageDialog(mm, "?†ïÎ≥¥Í? Î≥?Í≤? ?êò?óà?äµ?ãà?ã§.");
//					} else {
//						JOptionPane.showMessageDialog(mm, "?†ïÎ≥¥Î?Í≤ΩÏóê ?ã§?å® ?ïò???äµ?ãà?ã§");
//					}
				}
			}
		}
			
		} else if (o == select) {
			table.setModel(new ItemModel());
		}
	}

	JButton[] btns;
	JLabel[] titles;
	JLabel lal, haipun;
	JTextField[] inputs;
	JTextArea txt_area;
	JCheckBox[] ch;
	JList list, li;
	JTextField in;
	ButtonGroup group;
	JPanel[] panels;
	Font font;
	String[] titles_txt = { "ID     ", "ÎπÑÎ?Î≤àÌò∏", "?ù¥Î¶?   ", "E-mail ", "?ó∞?ùΩÏ≤?       ", "?Ñ±Î≥?            " };
	String[] titles_btn = { "Ï°? ?öå", "?àò ?†ï", "?Ç≠ ?†ú", "Ïß??ö∞Í∏?" };
	JButton select;
	JScrollPane scroll, scr;
	JTable table;
	JPanel panel, btnPanel;
	Panel centerPanel, southPanel;
	ManagerMode mm;
	JComboBox combo, mailCom;

	void makeCheckBox() {
		ch = new JCheckBox[2];
		group = new ButtonGroup();

		group.add(ch[0]);
		group.add(ch[1]);

		ch[0] = new JCheckBox("?Ç®?Ñ±", false);
		ch[1] = new JCheckBox("?ó¨?Ñ±", false);

		ch[0].setFont(font);
		ch[1].setFont(font);
	}

	void makeLabel() {
		titles = new JLabel[6];
		for (int i = 0; i < titles.length; i++) {
			titles[i] = new JLabel(titles_txt[i]);
			titles[i].setFont(font);
			titles[i].setHorizontalAlignment(SwingConstants.LEFT);
		}
	}

	void makeTextField() {
		inputs = new JTextField[6];

		inputs[0] = new JTextField(20);
		inputs[1] = new JTextField(20);
		inputs[2] = new JTextField(20);
		inputs[3] = new JTextField(15);
		inputs[4] = new JTextField(6);
		inputs[5] = new JTextField(6);
	}

	void makeButton() {
		btns = new JButton[4];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(titles_btn[i]);
			btns[i].setFont(font);
			btns[i].addActionListener(this);
			btns[i].setPreferredSize(new Dimension(100, 30));
		}
	}

	void makePanel() {
		panels = new JPanel[9];
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
		}
	}

	public CustomerSystem(ManagerMode mm) {

		select = new JButton("?†ÑÏ≤¥Ï°∞?öå");
		select.addActionListener(this);
		select.setPreferredSize(new Dimension(200, 30));
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(700, 90));
		scroll = new JScrollPane(table);
		panel = new JPanel();
		btnPanel = new JPanel();
		lal = new JLabel("@");
		in = new JTextField(10);
		haipun = new JLabel(" - ");
		haipun.setFont(new Font("Íµ¥Î¶ºÏ≤?", Font.BOLD, 20));
		scroll.setSize(900, 300);
		JScrollPane scr = new JScrollPane(li);

		this.mm = mm;
		this.setLayout(new GridLayout(2, 1));
		centerPanel = new Panel();
		font = new Font("Íµ¥Î¶ºÏ≤?", Font.BOLD, 20);
		centerPanel.setLayout(new GridLayout(6, 1));
		southPanel = new Panel();
		southPanel.setLayout(new GridLayout(3, 1));
		combo = new JComboBox();
		mailCom = new JComboBox();
		for (int i = 10; i <= 19; i++) {
			combo.addItem("0" + i);
		}

		mailCom.addItem("ÏßÅÏ†ë?ûÖ?†•");
		mailCom.addItem("naver.com");
		mailCom.addItem("nate.com");
		mailCom.addItem("daum.net");
		mailCom.addItem("gmail.com");

		makeCheckBox();
		makeLabel();
		makeTextField();
		makeButton();
		makePanel();
		txt_area = new JTextArea(2, 15);
		panels[0].add(titles[0]);
		panels[0].add(inputs[0]);
		panels[1].add(titles[1]);
		panels[1].add(inputs[1]);
		panels[1].setPreferredSize(new Dimension(400, 20));
		panels[2].add(titles[2]);
		panels[2].add(inputs[2]);
		panels[3].add(titles[3]);
		panels[3].add(inputs[3]);
		panels[3].add(lal);
		panels[3].add(in);
		panels[3].add(mailCom);
		panels[4].add(titles[4]);
		panels[4].add(combo);
		panels[4].add(inputs[4]);
		panels[4].add(inputs[5]);
		panels[5].add(titles[5]);
		panels[5].add(ch[0]);
		panels[5].add(ch[1]);
		panels[6].add(scroll);
		panels[7].add(btns[0]);
		panels[7].add(btns[1]);
		panels[7].add(btns[2]);
		panels[7].add(btns[3]);
		panels[8].add(select);
		for (int j = 0; j < 6; j++) {
			centerPanel.add(panels[j]);
		}
		for (int j = 6; j < 9; j++) {
			southPanel.add(panels[j]);
		}
		this.add("Center", centerPanel);
		this.add("South", southPanel);
		this.setPreferredSize(new Dimension(500,500));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int selectedRow = table.getSelectedRow();
		int columnCount = table.getColumnCount();
		
		for (int i = 0; i < columnCount; i++) {
			this.inputs[0].setText(table.getValueAt(selectedRow, 0) + "");
			this.inputs[1].setText(table.getValueAt(selectedRow, 1) + "");
			this.inputs[2].setText(table.getValueAt(selectedRow, 2) + "");
			this.inputs[3].setText(table.getValueAt(selectedRow, 3) + "");
			this.inputs[4].setText(table.getValueAt(selectedRow, 4) + "");
			String str = table.getValueAt(selectedRow, 5) + "";
			if(str.equals("?Ç®?Ñ±")) {
				this.ch[0].setSelected(true);
			} else {
				this.ch[1].setSelected(true);
			}
		}
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

class ItemModel extends AbstractTableModel {
	Object tableData[][];
	int rows, cols;
	String[] columnName = { "?ù¥Î¶?", "?†Ñ?ôîÎ≤àÌò∏", "ID", "?Ñ±Î≥?", "?ù¥Î©îÏùº", "?òàÎß§ÏßÑ?ñâ?ÉÅ?ô©" };
	List<Customer_info> list;

	ItemModel(ManagerMode mm , String id) {
		CRUDprocess crud = new CRUDprocess();
		list = crud.selectidIteminfo(id);
		setDelta();
		
		
	}

	void setDelta() {
		
		java.util.Iterator<Customer_info> it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];
		int r = 0;
		while (it.hasNext()) {
			Customer_info info = (Customer_info) it.next();
			tableData[r][0] = info.getCustomer_name(); // ?ÉÅ?íà Î≤àÌò∏
			tableData[r][1] = info.getCustomer_phone();
			tableData[r][2] = info.getCustomer_ID();
			tableData[r][3] = info.getCustomer_gender();
			tableData[r][4] = info.getCustomer_mail();
			r++;

			
		}
	}

	ItemModel() {
		CRUDprocess crud = new CRUDprocess();
		list = crud.selectAllCustomer();
		List<Exhibit_reserve> li = crud.selectReState();
		setData();
	}
	void setData() {
		Iterator it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];

		int r = 0;
		while (it.hasNext()) {
			Customer_info info = (Customer_info) it.next();
			Exhibit_reserve re = (Exhibit_reserve) it.next();
			tableData[r][0] = info.getCustomer_name();
			tableData[r][1] = info.getCustomer_phone();
			tableData[r][2] = info.getCustomer_ID();
			tableData[r][3] = info.getCustomer_gender();
			tableData[r][4] = info.getCustomer_mail();
			tableData[r][5] = re.getReserve_state();
			r++;

		}
	}
	public ItemModel(CRUDprocess crud, HashMap<String, Object> map) {
		list = crud.selectIteminfoCondition(map);
		cols = columnName.length;
		rows = list.size();
		setData2();
		
	}

	void setData2() {
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];
		Iterator it = list.iterator();
		int r = 0;
		while ( it.hasNext()) {
			Customer_info info = (Customer_info)it.next();
			Exhibit_reserve re = (Exhibit_reserve) it.next();
			tableData[r][0] = info.getCustomer_name();
			tableData[r][1] = info.getCustomer_phone();
			tableData[r][2] = info.getCustomer_ID();
			tableData[r][3] = info.getCustomer_gender();
			tableData[r][4] = info.getCustomer_mail();
			tableData[r][5] = re.getReserve_state();
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
