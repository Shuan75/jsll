package april23jjh;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class EmployeeSystem extends Panel implements ActionListener, ItemListener {

	public static void main(String[] args) {
		// new EmployeeSystem();
	}

	TextField[] textFields;
	Label[] labels;
	Checkbox[] gender;
	CheckboxGroup group;
	Choice[] choices;
	Button[] btns;
	Panel[] pan;
	String[] labels_title = { "사 번", "이 름", "부 서", "성 별", "주 소", "입사일" };
	String[] btns_title = { "삽 입", "삭 제", "변 경", "조 회", "지우기", "달 력" };
	String[] dept_names = { "영업부", "홍보부", "개발부", "기획부" };
	Font font;
	TotalSystem ts;

	public EmployeeSystem(TotalSystem ts) { // 생성자로 TotalSystem을 받음
		// super(str);

		// font = new Font("굴림체,Font.BOLD,20")
		this.ts = ts;
		this.setLayout(new GridLayout(7, 1));
		font = new Font("굴림체", Font.BOLD, 20);
		makeLabel();
		makeTextField();
		makeRadio();
		makeChoice();
		makePanel();
		makeButton();

		pan[0].add(labels[0]);
		pan[0].add(textFields[0]); // 사번
		pan[1].add(labels[1]);
		pan[1].add(textFields[1]); // 이름
		pan[2].add(labels[2]);
		pan[2].add(choices[0]);
		pan[3].add(labels[3]);
		pan[3].add(gender[0]);
		pan[3].add(gender[1]);
		pan[4].add(labels[4]);
		pan[4].add(textFields[2]);
		pan[5].add(labels[5]);
		pan[5].add(choices[1]);
		pan[5].add(choices[2]);
		pan[5].add(choices[3]);
		pan[5].add(btns[5]);
		pan[6].add(btns[0]);
		pan[6].add(btns[1]);
		pan[6].add(btns[2]);
		pan[6].add(btns[3]);
		pan[6].add(btns[4]);

		for (int i = 0; i < pan.length; i++) {
			this.add(pan[i]);
		}

		// this.addWindowListener(new LoginSystemExit());
		this.setBackground(Color.cyan);
		// this.setSize(500, 400);
		// this.setVisible(true);
	}

	void makeLabel() {
		labels = new Label[6];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Label(labels_title[i]);
			labels[i].setFont(font);
		}
	}

	void makeButton() {
		btns = new Button[6];
		for (int j = 0; j < btns.length; j++) {
			btns[j] = new Button(btns_title[j]);
			btns[j].setFont(font);
			// 버튼에 리스너를 붙임
			btns[j].addActionListener(this);
		}
	}

	void makeTextField() {
		textFields = new TextField[3]; // 길이3의 텍스트필드 생성
		for (int i = 0; i < textFields.length; i++) {
			textFields[i] = new TextField(15);
			textFields[i].setFont(font);
		}
	}

	void makeRadio() {
		group = new CheckboxGroup();
		gender = new Checkbox[2];
		gender[0] = new Checkbox("남자", group, true);
		gender[1] = new Checkbox("여자", group, false);
		gender[0].setFont(font);
		gender[1].setFont(font);
	}

	void makeChoice() {
		choices = new Choice[4];
		choices[0] = new Choice();
		for (int i = 0; i < dept_names.length; i++) {
			choices[0].add(dept_names[i]);
		}
		choices[1] = new Choice();
		choices[1].add("입사년");
		for (int i = 2019; i >= 1980; i--) {
			choices[1].add(i + "");
		}
		choices[2] = new Choice();
		choices[2].add("입사월");
		for (int i = 1; i <= 12; i++) {
			choices[2].add(i + ""); // 정수를 문자열로 바꿔서 ch에 붙임
		}
		choices[3] = new Choice();
		choices[3].add("입사일");
		choices[0].addItemListener(this);
		choices[1].addItemListener(this);
		choices[2].addItemListener(this);
		choices[3].addItemListener(this);

		for (int j = 0; j < choices.length; j++) {
			choices[j].setFont(font);
		}
	}

	void makePanel() {
		pan = new Panel[7];
		for (int i = 0; i < pan.length; i++) {
			pan[i] = new Panel();
			pan[i].setFont(font);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// 입사월을 선택했을때 입사 일을 채운다
		Object obj = e.getSource();
		if (obj == choices[2]) { // 입사월을 선택한 경우
			// 기존에 저장된 입사일을 지운다.
			choices[3].removeAll();
			choices[3].add("입사일");
			// 선택한 월을 찾는다.
			int month = choices[2].getSelectedIndex(); // 선택한 위치
			// 선택한 위치 즉 , 첫번째 항목이면 0, 두번째 항목이면 1
			switch (month) {
			case 4:
			case 6:
			case 9:
			case 11:
				for (int i = 1; i <= 30; i++) {
					choices[3].add(i + "");
				}
				break;
			case 2:
				for (int i = 1; i <= 28; i++) {
					choices[3].add(i + "");
				}
				break;
			default:
				for (int i = 1; i <= 31; i++) {
					choices[3].add(i + "");
				}

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == btns[0]) {// 삽입버튼을 누른 경우
			// 사번이 없는지 검사
			String id = textFields[0].getText();// 사번을 읽어옴
			if (id.equals("")) {// 사번을 입력하지 않은 경우
				JOptionPane.showMessageDialog(ts, "사번이 존재하지않아서 작업을 진행할 수 없습니다.");
			} else {
				// 동일한 사번이 DB에 존재하는지 검사
				CRUDprocess crud = new CRUDprocess();
				Empl_info emp = crud.selectEmpl(id);
				if (emp != null) {// 동일한 사번이 이미 존재하는 경우
					JOptionPane.showMessageDialog(ts, "동일한 사번이 이미 존재합니다.");
				} else {// 동일한 사번이 존재하지 않은 경우
					String name = textFields[1].getText();// 이름
					String dept = choices[0].getSelectedItem();// 부서명
					String gen = "";
					if (gender[0].getState() == true) {
						gen = "남자";
					} else if (gender[1].getState() == true) {
						gen = "여자";
					}
					String addr = textFields[2].getText();// 주소
					String year = choices[1].getSelectedItem();
					String month = choices[2].getSelectedItem();
					String date = choices[3].getSelectedItem();
					String hire = year + "/" + month + "/" + date;
					Empl_info empl = new Empl_info();
					empl.setEmp_id(id);
					empl.setEmp_name(name);
					empl.setEmp_dept(dept);
					empl.setEmp_gender(gen);
					empl.setEmp_addr(addr);
					empl.setEmp_hire(hire);
					int r = crud.insertEmpl(empl);
					if (r > 0) {
						JOptionPane.showMessageDialog(ts, "사원정보가 등록되었습니다.");
					} else {
						JOptionPane.showMessageDialog(ts, "사원정보 등록 중 오류가 발생했습니다.");
					}
				}
				// 위의 두가지를 통과하면 삽입
			}
		} else if (ob == btns[1]) {// 삭제
			String id = textFields[0].getText(); // 사번을 불러옴
			if (id.equals("")) {
				JOptionPane.showMessageDialog(ts, "사번이 입력되지 않아서 작업을 진행할 수 없습니다.");

			} else {
				int result = JOptionPane.showConfirmDialog(ts, "本当に削除しますか?", "作業確認", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					CRUDprocess crud = new CRUDprocess();
					int r = crud.deleteEmpl(id);
					if (r > 0) {
						JOptionPane.showMessageDialog(ts, "해당정보 삭제 되었습니다.");
					} else {
						JOptionPane.showMessageDialog(ts, "삭제작업중 문제 발생");
					}

				} else if (result == JOptionPane.NO_OPTION) {

				}
			}

		} else if (ob == btns[2]) {// 변경
			String id = textFields[0].getText();
			if (id.equals("")) {
				JOptionPane.showMessageDialog(ts, "사번이 입력되지 않아서 작업을 진행할 수 없습니다");
			} else {
				int result = JOptionPane.showConfirmDialog(ts, "정말로변경하시겠습니까?", "작업 확인", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					CRUDprocess crud = new CRUDprocess();
					String name = textFields[1].getText();
					String addr = textFields[2].getText();
					String dept = choices[0].getSelectedItem();
					String gen = "";
					if (gender[0].getState() == true) { // 남
						gen = "남자";
					} else if (gender[1].getState() == true) {
						gen = "여자";
					}
					String year = choices[1].getSelectedItem(); // 입사년
					String mon = choices[2].getSelectedItem();
					String date = choices[3].getSelectedItem();
					String hire = year + "/" + mon + "/" + date;
					// 모델객체생성
					Empl_info empl = new Empl_info();
					empl.setEmp_id(id);
					empl.setEmp_name(name);
					empl.setEmp_addr(addr);
					empl.setEmp_gender(gen);
					empl.setEmp_dept(dept);
					empl.setEmp_hire(hire);
					int r = crud.updateEmpl(empl);
					if (r > 0) {
						JOptionPane.showMessageDialog(ts, "정보가 변경 되었습니다.");
					} else {
						JOptionPane.showMessageDialog(ts, "정보변경에 실패 하였습니다");
					}
				}
			}
		} else if (ob == btns[3]) {// 조회
			String id = textFields[0].getText(); // 사번을 불러옴
			if (id.equals("")) {
				JOptionPane.showMessageDialog(ts, "사번을 입력하세요.");
			} else {
				CRUDprocess crud = new CRUDprocess();
				Empl_info empl = crud.selectEmpl(id);
				if (empl == null) {
					JOptionPane.showMessageDialog(ts, "입력한 사번의 사원은 존재하지 않습니다.");
				} else {
					textFields[1].setText(empl.getEmp_name());
					textFields[2].setText(empl.getEmp_addr());
					if (empl.getEmp_gender().equals("남자")) {
						gender[0].setState(true);
					} else {
						gender[1].setState(true);
					}
					choices[0].select(empl.getEmp_dept()); // 부서명을 첫번쨰 choices에 선택된 데이터로 만들어줌
					// 입사일은 3개로 분리해야 한다.
					String hire_date = empl.getEmp_hire(); // 입사일을 hire_date에 넣음
					String[] hire = hire_date.split("/"); // /를 기준으로 분리하고 문자열의 배열으로 받음
					// hire[0] : 입사년, hire[1] : 입사월, hire[2] : 입사일
					choices[1].select(hire[0]); // 입사 년 , 월 , 일 설정
					choices[2].select(hire[1]);
					choices[3].select(hire[2]);
				}
			}
		} else if (ob == btns[4]) {// 지우기
			for (int i = 0; i < textFields.length; i++) {
				textFields[i].setText(" ");
				textFields[i].setText("");
			} // 사번 , 이름 , 주소를 지움
			gender[0].setState(true); // 성별을 기본
			choices[0].select(0); // 부서를 처음
			choices[1].select(0); // 입사년
			choices[2].select(0);
			choices[3].select(0);

		} else if (ob == btns[5]) {// 달력
			new CalendarByAwt(this);
		}
	}

}
