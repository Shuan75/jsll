package april23jjh;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CustomerSystem extends Panel implements ActionListener {

	public static void main(String[] args) {
		// new CustomerSystem("고객 관리");
	}

	Label[] labels;
	TextField[] textField;
	Button[] btns;
	Panel[] panels;
	String[] label_title = { "I D", "이 름", "주 소", "가입일" };
	String[] btns_title = { "삽 입", "삭 제", "변 경", "조 회", "지우기", "달 력" };
	TotalSystem ts;

	public CustomerSystem(TotalSystem ts) {
		// super(str);
		this.ts = ts;
		makeLabel();
		makeButton();
		makeTextField();
		makePanel();

		panels[0].add(labels[0]);
		panels[0].add(textField[0]);
		panels[1].add(labels[1]);
		panels[1].add(textField[1]);
		panels[2].add(labels[2]);
		panels[2].add(textField[2]);
		panels[3].add(labels[3]);
		panels[3].add(textField[3]);
		panels[3].add(btns[5]);
		panels[4].add(btns[0]);
		panels[4].add(btns[1]);
		panels[4].add(btns[2]);
		panels[4].add(btns[3]);
		panels[4].add(btns[4]);

		for (int i = 0; i < panels.length; i++) {
			this.add(panels[i]);
		}

		this.setBackground(Color.cyan);
		// this.add(new MyImage("src\\april23jjh\\monkey.jpg"));
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setSize(500, 400);
		// this.setVisible(true);
		// this.addWindowListener(new LoginSystemExit());
		this.setLayout(new GridLayout(5, 1));

	}

	void makeLabel() {
		labels = new Label[4];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Label(label_title[i]);
			labels[i].setFont(ts.font);
		}
	}

	void makeTextField() {
		textField = new TextField[4];
		for (int i = 0; i < textField.length; i++) {
			textField[i] = new TextField(15);
			textField[i].setFont(ts.font);
		}
		textField[3].setEnabled(false); // 가입일 텍스트필드 비활성화
	}

	void makeButton() {
		btns = new Button[6];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new Button(btns_title[i]);
			btns[i].setFont(ts.font);
			btns[i].addActionListener(this);
		}
	}

	void makePanel() {
		panels = new Panel[5];
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new Panel();
			panels[i].setFont(ts.font);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btns[0]) {
			String id = textField[0].getText(); // 입력한 id를 불러옴
			if (id == null) {
				JOptionPane.showMessageDialog(ts, "고객 ID가 존재하지 않아서 작업을 진행할 수 없습니다.");
			} else {
				// ID 중복 검사
				CRUDprocess crud = new CRUDprocess();
				Customer_info ci = crud.selectCustomer(id);
				if (ci == null) {
					String name = textField[1].getText(); // 이름
					String addr = textField[2].getText();
					String reg = textField[3].getText();
					Customer_info cust = new Customer_info();
					cust.setCust_id(id);
					cust.setCust_name(name);
					cust.setCust_addr(addr);
					cust.setCust_reg_date(reg);
					int r = crud.insertCustomer(cust);
					if (r > 0) {
						JOptionPane.showMessageDialog(ts, "고객정보가 등록되었습니다.");
					} else {
						JOptionPane.showMessageDialog(ts, "고객 정보 등록중 문제가 발생하였습니다.");
					}
				} else {
					JOptionPane.showMessageDialog(ts, "이미 동일한 ID가 존재합니다.");
				}

			}

		} else if (obj == btns[1]) {

		} else if (obj == btns[2]) {

		} else if (obj == btns[3]) {

		} else if (obj == btns[4]) {

		} else if (obj == btns[5]) {
			new CalendarByAwt(this);
			// new CalendarByAwt(); 는 생성자가없어서 안됨 매개변수로 es를 받고잇음
		}
	}

	class MyImage extends Panel {
		Image img;

		MyImage(String path) { // 생성자를 통해 이미지 경로를 받음
			img = Toolkit.getDefaultToolkit().getImage(path);
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);

			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);

		}

	}
}
