package april23jjh;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FruitsShopping extends Panel {
//implements ActionListener {

	public static void main(String[] args) {
//		new FruitsShopping("과일 소개");

	}

	Button first, prev, next, last, logout;
	Panel buttons; // 버튼을 담을 패널
	Panel fruits;
	Panel[] items_intro, item, desc;
	// 과일 소개용 패널,(1행 2열의 GridLayout을 사용)
	// 과일 이미지용 패널items_intro의 왼쪽배치
	// 과일 소개글용패널 items_intro의 오른쪽배치
	CardLayout card;
	TotalSystem ts;

	public FruitsShopping(TotalSystem ts) {
		// super(str);
		init();

		this.ts = ts;
		this.setLayout(new BorderLayout());
		this.add("Center", fruits);
		this.add("South", buttons);
		// this.setSize(800, 500);
		this.setLocation(200, 200);
		// this.addWindowListener(new FruitsShoppintEnd());
		// this.addWindowListener(new FruitsShoppingExit());
		this.setVisible(true);
	}

	void init() {
		card = new CardLayout();
		fruits = new Panel(card); // 패널을 생성하면서 배치관리자 설정
		items_intro = new Panel[6];
		item = new Panel[6];
		desc = new Panel[6];
		for (int i = 0; i < items_intro.length; i++) {
			items_intro[i] = new Panel();
			items_intro[i].setLayout(new GridLayout(1, 2));
			desc[i] = new Panel(new GridLayout(3, 1));
			switch (i) {
			case 0:
				item[i] = new FruitImage("src\\april23jjh\\grape.jpg");
				break;
			case 1:
				item[i] = new FruitImage("src\\april23jjh\\tangerine.jpg");
				break;
			case 2:
				item[i] = new FruitImage("src\\april23jjh\\lemon.jpg");
				break;
			case 3:
				item[i] = new FruitImage("src\\april23jjh\\orange.jpg");
				break;
			case 4:
				item[i] = new FruitImage("src\\april23jjh\\strawberry.jpg");
				break;
			case 5:
				item[i] = new FruitImage("src\\april23jjh\\kiwi.jpg");
				break;
			}

			items_intro[i].add(item[i]);
			items_intro[i].add(desc[i]);

		}
		desc[0].add(new Label("이름 : 포도"));
		desc[0].add(new Label("PolyPenol을 다량 함유하고 있어"));
		desc[0].add(new Label("황산화 작용을 합니다."));

		desc[1].add(new Label("이름 : 귤"));
		desc[1].add(new Label("시네피린을 함유하고 있어"));
		desc[1].add(new Label("감기예방에 좋습니다."));

		desc[2].add(new Label("이름 : 레몬"));
		desc[2].add(new Label("비타민C가 풍부합니다."));
		desc[2].add(new Label("레몬에 포함된 구연산은 피로회복에 좋습니다."));

		desc[3].add(new Label("이름 : 오렌지"));
		desc[3].add(new Label("비타민C가 풍부합니다."));
		desc[3].add(new Label("생과일 쥬스로 마시면 좋습니다."));

		desc[4].add(new Label("이름 : 딸기"));
		desc[4].add(new Label("비타민C나 폴라보오이드를 다량"));
		desc[4].add(new Label("함유하고 있습니다."));

		desc[5].add(new Label("이름 : 키위"));
		desc[5].add(new Label("비타민C가 풍부합니다."));
		desc[5].add(new Label("다이터트나 미용에 좋습니다"));

		fruits.add(items_intro[0], "grape");
		fruits.add(items_intro[1], "tangerine");
		fruits.add(items_intro[2], "lemon");
		fruits.add(items_intro[3], "orange");
		fruits.add(items_intro[4], "strawberry");
		fruits.add(items_intro[5], "kiwi");

		first = new Button("처음으로");
		prev = new Button("이전으로");
		next = new Button("다음으로");
		last = new Button("마지막으로");
		logout = new Button("로그아웃");

		first.addActionListener(new MyButtonListener(this, ts));
		prev.addActionListener(new MyButtonListener(this, ts));
		next.addActionListener(new MyButtonListener(this, ts));
		last.addActionListener(new MyButtonListener(this, ts));
		logout.addActionListener(new MyButtonListener(this, ts));

		buttons = new Panel();
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		buttons.add(logout);
	}

	class FruitImage extends Panel {
		Image img;

		FruitImage(String path) {
			img = Toolkit.getDefaultToolkit().getImage(path);
		}

		@Override
		public void paint(Graphics g) {
			// g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	}

	class MyButtonListener implements ActionListener {
		FruitsShopping fs;
		TotalSystem ts;

		MyButtonListener(FruitsShopping fs, TotalSystem ts) {
			this.fs = fs;
			this.ts = ts;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == fs.first) {
				fs.card.first(fs.fruits);
			} else if (obj == fs.prev) {
				fs.card.previous(fs.fruits);
			} else if (obj == fs.next) {
				fs.card.next(fs.fruits);
			} else if (obj == fs.last) {
				fs.card.last(fs.fruits);
			} else if (obj == fs.logout) {
				ts.card.show(ts.totalPanel, "login");
			}
		}
	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//	
//	}

	class FruitsShoppintEnd extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}

	class FruitsShoppingExit implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
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
}