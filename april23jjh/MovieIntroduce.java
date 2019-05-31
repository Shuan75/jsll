package april23jjh;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
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

public class MovieIntroduce extends Frame implements WindowListener {

	public static void main(String[] args) {
		new MovieIntroduce("영화 소개");
	}

	Button first, last, prev, next;
	Panel button;
	Panel movies;
	Panel[] movies_intro, movies_item, movies_desc;
	CardLayout card;

	public MovieIntroduce(String str) {
		super(str);
		doIt();

		this.add("Center", movies);
		this.add("South", button);
		this.setSize(500, 400);
		this.setLocation(200, 200);
		this.setVisible(true);
		this.addWindowListener(new MovieEnd());
	}

	void doIt() {
		card = new CardLayout();
		movies = new Panel(card);
		movies_intro = new Panel[6];
		movies_item = new Panel[6];
		movies_desc = new Panel[6];
		for (int i = 0; i < movies_intro.length; i++) {
			movies_intro[i] = new Panel();
			movies_intro[i].setLayout(new GridLayout(1, 2));
			movies_desc[i] = new Panel(new GridLayout(3, 1));
			switch (i) {
			case 0:
				movies_item[i] = new MoviesImage("src\\jjh\\13시간.jpg");
				break;
			case 1:
				movies_item[i] = new MoviesImage("src\\jjh\\33.jpg");
				break;
			case 2:
				movies_item[i] = new MoviesImage("src\\jjh\\6년째 연애중.jpg");
				break;
			case 3:
				movies_item[i] = new MoviesImage("src\\jjh\\7급 공무원.jpg");
				break;
			case 4:
				movies_item[i] = new MoviesImage("src\\jjh\\7번방의 선물.jpg");
				break;
			case 5:
				movies_item[i] = new MoviesImage("src\\jjh\\신세계.jpg");
				break;

			}
			movies_intro[i].add(movies_item[i]);
			movies_intro[i].add(movies_desc[i]);
		}

		for (int j = 0; j < movies_desc.length; j++) {
			movies_desc[j].add(new Label("안봤다."));
			movies_desc[j].add(new Label("들어는봤다."));
			movies_desc[j].add(new Label("유투브에서 떠도는건 봤다."));
			movies_desc[j].setBackground(Color.cyan);
		}

		movies.add(movies_intro[0], "13시간");
		movies.add(movies_intro[1], "33");
		movies.add(movies_intro[2], "6년째 연애중");
		movies.add(movies_intro[3], "7급 공무원");
		movies.add(movies_intro[4], "7번방의 선물");
		movies.add(movies_intro[5], "신세계");

		first = new Button("처음");
		last = new Button("마지막");
		prev = new Button("이전");
		next = new Button("다음");

		first.addActionListener(new ButtonListener(this));
		last.addActionListener(new ButtonListener(this));
		next.addActionListener(new ButtonListener(this));
		prev.addActionListener(new ButtonListener(this));

		button = new Panel();
		button.add(first);
		button.add(last);
		button.add(prev);
		button.add(next);

	}

	class MoviesImage extends Panel {
		Image img;

		MoviesImage(String path) {
			img = Toolkit.getDefaultToolkit().getImage(path);
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}

	}

	class ButtonListener implements ActionListener {
		MovieIntroduce mi;

		ButtonListener(MovieIntroduce mi) {
			this.mi = mi;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == mi.first) {
				mi.card.first(mi.movies);
			} else if (obj == mi.prev) {
				mi.card.previous(mi.movies);
			} else if (obj == mi.next) {
				mi.card.next(mi.movies);
			} else if (obj == mi.last) {
				mi.card.last(mi.movies);
			}
		}
	}
	class MovieEnd extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}

	}
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
