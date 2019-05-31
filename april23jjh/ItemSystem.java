package april23jjh;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ItemSystem extends Panel implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource(); // 상품번호를 담는 메소드
		if (o == btns[0]) {
			String code = inputs[0].getText();
			if (code.equals("")) { // 상품번호는 반드시 입력해야한다라는 다이얼로그 출력
				JOptionPane.showMessageDialog(ts, "商品番号は必ず登録しざるお得ない.");
			} else { // 존재하는지 검사
				CRUDprocess crud = new CRUDprocess();
				ItemInfo itemInfo = crud.selectItemCode(code);
				if (itemInfo == null) { // 삽입작업진행
					String name = inputs[1].getText(); // 상품이름 불러오기
					String price = inputs[2].getText();
					String info = txt_area.getText();
					String origin = ""; // 원산지용 변수
					if (madeIn[0].getState()) { // 한국산 선택된경우
						origin = "한국산";
					} else if (madeIn[1].getState()) {
						origin = "외국산";
					}
					String image = SaveActionListener.path; // 상품 이미지경로
					ItemInfo item_info = new ItemInfo();
					item_info.setCode(code);
					item_info.setName(name);
					item_info.setPrice(Integer.parseInt(price)); // 모델에서정수이므로 변환
					item_info.setInfo(info);
					item_info.setOrigin(origin);
					item_info.setImage(image);
					int result = crud.insertItemInfo(item_info);

					if (result > 0) {
						JOptionPane.showMessageDialog(ts, "商品情報が登録できました");
					} else {
						JOptionPane.showMessageDialog(ts, "商品情報登録中問題が発生しました");
					}

				} else { // 번호가 이미있으므로
					JOptionPane.showMessageDialog(ts, "当該商品情報は既に存在します");
				}
			}
		} else if (o == btns[1]) {
			// 버튼이 두개있는 다이얼로그 출력
			int result = JOptionPane.showConfirmDialog(ts, "本当に削除しますか?", "作業確認", JOptionPane.YES_NO_OPTION);
			// Yes와 No 버튼이 있는 다이얼로그 생성 리턴메소드라서 변수를만들어서 받아야함
			if (result == JOptionPane.YES_OPTION) {
				// DB에서 삭제작업 진행
				String code = inputs[0].getText(); // 상품정보 저장
				if (code.equals("")) { // 상품번호가 없는 경우
					JOptionPane.showMessageDialog(ts, "商品番号がなくて作業を進めることができません");
				} else {
					// db에서 삭제
					CRUDprocess crud = new CRUDprocess();
					int r = crud.deleteItemCode(code);
					if (r > 0) {
						JOptionPane.showMessageDialog(ts, "当該商品情報が削除しました");
					} else {
						JOptionPane.showMessageDialog(ts, "상품정보 삭제 중 문제가 발생했습니다");
					}

				}
			} else if (result == JOptionPane.NO_OPTION) {

			}
		} else if (o == btns[2]) { // 변경
			int result = JOptionPane.showConfirmDialog(ts, "本当に変更なさいますか", "作業確認", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				String code = inputs[0].getText(); // 상품정보저장
				if (code.equals("")) {
					JOptionPane.showMessageDialog(ts, "商品番号がなくて作業を進められません");
				} else {
					CRUDprocess crud = new CRUDprocess();
					String name = inputs[1].getText();
					String price = inputs[2].getText();
					String info = txt_area.getText();
					String origin = "";
					if (madeIn[0].getState() == true) {
						origin = "한국산";
					} else if (madeIn[1].getState() == true) {
						origin = "외국산";
					}
					ItemInfo item_info = new ItemInfo();
					item_info.setCode(code);
					item_info.setName(name);
					item_info.setPrice(Integer.parseInt(price));
					item_info.setInfo(info);
					item_info.setOrigin(origin);
					int r = crud.updateItemInfo(item_info);
					if (r > 0) {
						JOptionPane.showMessageDialog(ts, "상품정보가 변경되었습니다.");
					} else {
						JOptionPane.showMessageDialog(ts, "상품정보 변경 중 문제가 발생했습니다.");
					}
				}
			} else if (result == JOptionPane.NO_OPTION) {

			}
		} else if (o == btns[3]) {
			String code = inputs[0].getText();
			CRUDprocess crud = new CRUDprocess();
			ItemInfo info = crud.selectItemCode(code);
			if (info == null) { // 상품정보가 null
				JOptionPane.showMessageDialog(ts, "当該商品情報は存在しません.");
			} else { // 상품 정보가 있는경우 db의 검색정보를 윈도우 컴포넌트에 출력
				inputs[0].setText(info.getCode());
				inputs[1].setText(info.getName());
				inputs[2].setText(info.getPrice() + ""); // 길이가없는문자를 더해주면 문자로바뀜
				txt_area.setText(info.getInfo());
				imageSystem.imagePanel.setImage(info.getImage());
				// 상품이미지 경로를 이미지 패널에 설정
				imageSystem.imagePanel.repaint();
				if (info.getOrigin().equals("한국산")) {
					madeIn[0].setState(true);
				} else if (info.getOrigin().equals("외국산")) {
					madeIn[1].setState(true);
				}
			}
		} else if (o == btns[4]) {
			for (int i = 0; i < inputs.length; i++) {
				inputs[i].setText(" ");
				inputs[i].setText("");
			} // 세개의 텍스트 필드에 입력된값을 지움
			txt_area.setText(" ");
			txt_area.setText("");
			madeIn[0].setState(true);
		}
	}

	public static void main(String[] args) {
		// new ItemSystem("물품 관리 시스템");
	}

	TotalSystem ts;
	Button[] btns;
	Label[] titles;
	TextField[] inputs;
	TextArea txt_area;
	Checkbox[] madeIn;
	CheckboxGroup group;
	Panel[] panels;
	Font font;
	String[] titles_txt = { "상품번호", "상품이름", "상품가격", "상품설명", "상품원산지" };
	String[] titles_btn = { "삽 입", "삭 제", "변 경", "조 회", "지우기" };

	void makeRadioButton() {
		group = new CheckboxGroup();
		madeIn = new Checkbox[2];
		madeIn[0] = new Checkbox("한국산", group, true);
		madeIn[1] = new Checkbox("외국산", group, false);
		madeIn[0].setFont(font);
		madeIn[1].setFont(font);
	}

	void makeLabel() {
		titles = new Label[5];
		for (int i = 0; i < titles.length; i++) {
			titles[i] = new Label(titles_txt[i]);
			titles[i].setFont(font);
		}
	}

	void makeTextField() {
		inputs = new TextField[3];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new TextField(15); // 길이 15의 텍스트필드
		}
	}

	void makeButton() {
		btns = new Button[5];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new Button(titles_btn[i]);
			btns[i].setFont(font);
			btns[i].addActionListener(this);
		}
	}

	void makePanel() {
		panels = new Panel[6];
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new Panel();
		}
	}

	Panel centerPanel; // 상품 정보
	ImageSystem imageSystem;

	public ItemSystem(TotalSystem ts) {
		// super(str);
		this.ts = ts;
		this.setLayout(new BorderLayout());
		centerPanel = new Panel();
		centerPanel.setLayout(new GridLayout(5, 1));
		font = new Font("굴림체", Font.BOLD, 20);

		makeRadioButton();
		makeLabel();
		makeTextField();
		makeButton();
		makePanel();
		txt_area = new TextArea(2, 15);
		panels[0].add(titles[0]);
		panels[0].add(inputs[0]);
		panels[1].add(titles[1]);
		panels[1].add(inputs[1]);
		panels[2].add(titles[2]);
		panels[2].add(inputs[2]);
		panels[3].add(titles[3]);
		panels[3].add(txt_area);
		panels[4].add(titles[4]);
		panels[4].add(madeIn[0]);
		panels[4].add(madeIn[1]);
		panels[5].add(btns[0]);
		panels[5].add(btns[1]);
		panels[5].add(btns[2]);
		panels[5].add(btns[3]);
		panels[5].add(btns[4]);

		for (int j = 0; j < panels.length - 1; j++) {
			centerPanel.add(panels[j]);
		}
		imageSystem = new ImageSystem(ts);
		// 화면 가운대에 centerPanel을 붙인다.
		this.add("Center", centerPanel);
		// 화면 오른쪽에 imageSystem을 붙인다.
		this.add("East", imageSystem);
		// 화면 아래에 panels[5]를 붙인다. ( 버튼을 가지고 있는 패널 )
		this.add("South", panels[5]);
		this.setBackground(new Color(200,150,100));

		// this.setLayout(new GridLayout(6, 1));
		// this.setSize(400, 400);
		// this.addWindowListener(new LoginSystemExit());
		// this.setVisible(true);
		
	}
}
