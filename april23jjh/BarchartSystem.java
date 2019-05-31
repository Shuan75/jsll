package april23jjh;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarchartSystem extends Panel implements ActionListener {
	public static void main(String[] args) {
		// new BarchartSystem("막대 그래프 ver1.0");
	}

	Button btn;
	Label[] labels;
	TextField[] textFields;
	Panel[] panels;
	String[] labels_title = { "1월의 매출", "2월의 매출", "3월의 매출" };
	GraphPanel gp;

	void makeTextfield() {
		textFields = new TextField[3];
		for (int i = 0; i < textFields.length; i++) {
			textFields[i] = new TextField(5);
		}
	}

	void makeLabel() {
		labels = new Label[3];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new Label(labels_title[i]);
		}
	}

	TotalSystem ts;

	public BarchartSystem(TotalSystem ts) {
		// super(str);
		this.ts = ts;
		this.setLayout(new BorderLayout());
		makeLabel();
		makeTextfield();
		btn = new Button("그리기");
		btn.addActionListener(this); // implement해서 this해도가능
		panels = new Panel[2];
		panels[0] = new Panel();
		panels[1] = new Panel();
		for (int i = 0; i < labels.length; i++) {// 3회 반복
			panels[1].add(labels[i]);// 레이블을 두번째 패널에 붙임
			panels[1].add(textFields[i]);// 텍스트필드를 패널에 붙임
		}
		panels[1].add(btn);// 두번째 패널에 버튼을 붙임
		panels[1].setBackground(Color.ORANGE);// 배경색 지정
		gp = new GraphPanel();// 막대그래프 패널 생성
		// this.add("Center", panels[0]);// 윈도 가운데에 첫번째패널 붙임
		this.add("Center", gp);// 윈도 가운데에 그래프패널 붙임
		this.add("South", panels[1]);// 윈도 아래에 두번째패널 붙임
		this.setBackground(new Color(64, 228, 208));
		// this.setSize(500, 400);
		// this.addWindowListener(new LoginSystemExit());
		// this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int jan = 0;
		int feb = 0;
		int mar = 0;
		int apr = 0;
		int may = 0;
		int jun = 0;
		int aug = 0;
		int jul = 0;
		int sep = 0;
		int oct = 0;
		int nov = 0;
		int dec = 0;
		// DB 연동
		CRUDprocess crud = new CRUDprocess();
		Outputs output = crud.selectOutputs(); // DB에서 매출정보 거샘ㄱ
		jan = output.getJan();
		feb = output.getFeb();
		mar = output.getMar();
		apr = output.getApr();
		may = output.getMay();
		jun = output.getJun();
		jul = output.getJul();
		aug = output.getAug();
		sep = output.getSep();
		oct = output.getOct();
		nov = output.getNov();
		dec = output.getDec();
//		if (!(textFields[0].getText().equals(""))) { // 매출액이없지않으면 숫자로바꿔서 넣음
//			jan = Integer.parseInt(textFields[0].getText());
//		}
//		if (!textFields[1].getText().equals("")) {
//			feb = Integer.parseInt(textFields[1].getText());
//		}
//		if (!textFields[2].getText().equals("")) {
//			mar = Integer.parseInt(textFields[2].getText());
//		}
		gp.setTotal_jan(jan);
		gp.setTotal_feb(feb);
		gp.setTotal_mar(mar);
		gp.setTotal_apr(apr);
		gp.setTotal_may(may);
		gp.setTotal_jun(jun);
		gp.setTotal_jul(jul);
		gp.setTotal_aug(aug);
		gp.setTotal_sep(sep);
		gp.setTotal_oct(oct);
		gp.setTotal_nov(nov);
		gp.setTotal_dec(dec);
		gp.repaint(); // 다시그림.
	}

}

class GraphPanel extends Panel {
	private int total_jan, total_feb, total_mar, total_apr, total_may, total_jun, total_jul, total_aug, total_sep,
			total_oct, total_nov, total_dec;
	final String PATH = "src\\JJH\\161.jpg";
	Image img;

	GraphPanel(){
		img = Toolkit.getDefaultToolkit().getImage(PATH);
	}
	public void setTotal_jan(int total_jan) {
		this.total_jan = total_jan;
	}

	public void setTotal_feb(int total_feb) {
		this.total_feb = total_feb;
	}

	public void setTotal_mar(int total_mar) {
		this.total_mar = total_mar;
	}

	public void setTotal_apr(int total_apr) {
		this.total_apr = total_apr;
	}

	public void setTotal_may(int total_may) {
		this.total_may = total_may;
	}

	public void setTotal_jun(int total_jun) {
		this.total_jun = total_jun;
	}

	public void setTotal_jul(int total_jul) {
		this.total_jul = total_jul;
	}

	public void setTotal_aug(int total_aug) {
		this.total_aug = total_aug;
	}

	public void setTotal_sep(int total_sep) {
		this.total_sep = total_sep;
	}

	public void setTotal_oct(int total_oct) {
		this.total_oct = total_oct;
	}

	public void setTotal_nov(int total_nov) {
		this.total_nov = total_nov;
	}

	public void setTotal_dec(int total_dec) {
		this.total_dec = total_dec;
	}
	Font font;
	@Override
	public void paint(Graphics g) {
		//g.clearRect(0, 0, this.getWidth(), this.getHeight());
		// 그려질 영역을 지운다. (0,0)에서 (패널의 가로길이,패널의 세로길이)
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g.drawLine(60, 250, 1350, 250);// 수평선을 그린다. (x1 y1 x2 y2)
		g.setColor(Color.white);
		font = new Font("굴림체", Font.BOLD, 20);
		g.setFont(font);
		for (int cnt = 0; cnt < 11; cnt++) {
			g.drawString(cnt * 10 + "", 25, 255 - 20 * cnt); // 앞에껀문자 뒤에2개값은 좌표
			g.drawLine(60, 250 - 20 * cnt, 1350, 250 - 20 * cnt);// ex)50에 230부터 350 ,230까지 선
		} // 10점부터100점까지 점수와 수평선을 그린다.(10회 반복)
		g.drawLine(60, 20, 60, 250);// 수직선을 그린다. (x좌표 50,50)(y좌표 20,250)
		g.drawString( "1월", 100,  270);
		g.drawString( "2월", 200,  270);
		g.drawString( "3월", 300,  270);
		g.drawString( "4월", 400,  270);
		g.drawString( "5월", 500,  270);
		g.drawString( "6월", 600,  270);
		g.drawString( "7월", 700,  270);
		g.drawString( "8월", 800,  270);
		g.drawString( "9월", 900,  270);
		g.drawString("10월", 1000, 270);
		g.drawString("11월", 1100, 270);
		g.drawString("12월", 1200, 270);
		g.setColor(Color.blue);// 막대그래프 색
		if (total_jan > 0) { // 값이있는 경우에만 그래프를 그림
			// 빨강색으로 채워져있는 사각형을그림
			g.fillRect(110, 250 - total_jan * 2, 10, total_jan * 2); // x좌표 110, y좌표 시작위치 , 두께10 , y좌표끝위치 사각형을그림
		}
		if (total_feb > 0) {
			g.fillRect(210, 250 - total_feb * 2, 10, total_feb * 2);
		}
		if (total_mar > 0) {
			g.fillRect(310, 250 - total_mar * 2, 10, total_mar * 2);
		}
		if (total_apr > 0) {
			g.fillRect(410, 250 - total_apr * 2, 10, total_apr * 2);
		}
		if (total_may > 0) {
			g.fillRect(510, 250 - total_may * 2, 10, total_may * 2);
		}
		if (total_jun > 0) {
			g.fillRect(610, 250 - total_jun * 2, 10, total_jun * 2);
		}
		if (total_jul > 0) {
			g.fillRect(710, 250 - total_jul * 2, 10, total_jul * 2);
		}
		if (total_aug > 0) {
			g.fillRect(810, 250 - total_aug * 2, 10, total_aug * 2);
		}
		if (total_sep > 0) {
			g.fillRect(910, 250 - total_sep * 2, 10, total_sep * 2);
		}
		if (total_oct > 0) {
			g.fillRect(1010, 250 - total_oct * 2, 10, total_oct * 2);
		}
		if (total_nov > 0) {
			g.fillRect(1110, 250 - total_nov * 2, 10, total_nov * 2);
		}
		if (total_dec > 0) {
			g.fillRect(1210, 250 - total_dec * 2, 10, total_dec * 2);
		}
	}

}
