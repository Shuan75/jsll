package april23jjh;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class OrderingSystem extends Panel implements WindowListener, ActionListener {

	public static void main(String[] args) {
		//new OrderingSystem("음료 주문 System");

	}

	Panel[] panels;
	Checkbox[] drinks;
	Choice[] numbers;
	Button[] btns;
	Label total;
	String[] drinks_name = { "우유", "아메리카노", "라떼", "사이다", "콜라" };
	// 음료수 가격 설정
	final int MILK_PRICE = 1000;
	final int AMERICANO_PRICE = 1500;
	final int LATTE_PRICE = 2000;
	final int SAIDA_PRICE = 500;
	final int COLA_PRICE = 500;
	int total_price = 0;

	public OrderingSystem(TotalSystem ts) {
		//super(str);

		this.setLayout(new GridLayout(7, 1));
		doIt();
		for (int z = 0; z < 7; z++) {
			this.add(panels[z]);
		}
		//this.setSize(400, 350);
		//this.addWindowListener(this);
		// this.setBackground(Color.cyan);
		//this.setVisible(true);
	}

	void doIt() { // 모든 컴포넌트 생성작업
		panels = new Panel[7];
		drinks = new Checkbox[5];
		numbers = new Choice[5];
		btns = new Button[2];
		total = new Label("         ");

		for (int i = 0; i < panels.length; i++) {
			panels[i] = new Panel();
			panels[i].setLayout(new FlowLayout());
			switch (i) {
			case 0:
				panels[i].setBackground(new Color(176,196,222));
				break;
			case 1:
				panels[i].setBackground(new Color(176,224,230));
				break;
			case 2:
				panels[i].setBackground(new Color(173,216,230));
				break;
			case 3:
				panels[i].setBackground(new Color(135,206,235));
				break;
			case 4:
				panels[i].setBackground(new Color(0,191,255));
				break;
			case 5:
				panels[i].setBackground(new Color(100,149,237));
				break;
			case 6:
				panels[i].setBackground(new Color(0,0,255));
				break;
			}
		}

		for (int j = 0; j < drinks.length; j++) {
			drinks[j] = new Checkbox(drinks_name[j]);

		}

		for (int y = 0; y < numbers.length; y++) {
			numbers[y] = new Choice();
			for (int k = 1; k <= 10; k++) { // choices에 갯수를 채움(1~10)
				numbers[y].add(k + "");
			}
		}

		btns[0] = new Button("계산하기");
		btns[1] = new Button("다시하기");
		btns[0].addActionListener(this);
		btns[1].addActionListener(this);

		for (int l = 0; l < 5; l++) { // 첫번째패널부터 세번쨰까지 체크박스와 choice를붙임
			panels[l].add(drinks[l]);
			panels[l].add(numbers[l]);

		}

		panels[5].add(total);
		panels[6].add(btns[0]);
		panels[6].add(btns[1]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 눌럿을때 자동으로 호출되는 메서드(callback method)
		if (e.getSource() == btns[0]) { // 계산하기 button
			total_price = 0;
			if (drinks[0].getState()) {
				String m = numbers[0].getSelectedItem();
				int price = MILK_PRICE * Integer.parseInt(m);
				total_price = total_price + price;
			}
			if (drinks[1].getState()) {
				String a = numbers[1].getSelectedItem();
				int price = AMERICANO_PRICE * Integer.parseInt(a);
				total_price = total_price + price;
			}
			if (drinks[2].getState()) {
				String l = numbers[2].getSelectedItem();
				int price = LATTE_PRICE * Integer.parseInt(l);
				total_price = total_price + price;
			}
			if (drinks[3].getState()) {
				String s = numbers[3].getSelectedItem();
				int price = SAIDA_PRICE * Integer.parseInt(s);
				total_price = total_price + price;
			}
			if (drinks[4].getState()) {
				String c = numbers[4].getSelectedItem();
				int price = COLA_PRICE * Integer.parseInt(c);
				total_price = total_price + price;
			}
			total.setText("총합 : " + total_price);
		} else if (e.getSource() == btns[1]) {
			total_price = 0;
			for (int r = 0; r < numbers.length; r++) {
				drinks[r].setState(false);
			}
			// 음료수체크박스 해제
			for (int t = 0; t < numbers.length; t++) {
				numbers[t].select(0); // 0 => 첫번째항목 choice의 데이터를 첫번쨰항목으로 설정
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {

	}
	@Override
	public void windowIconified(WindowEvent e) {

	}
	@Override
	public void windowDeiconified(WindowEvent e) {

	}
	@Override
	public void windowActivated(WindowEvent e) {

	}
	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}

