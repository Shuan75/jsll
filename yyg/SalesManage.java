package yyg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalesManage extends JPanel implements ActionListener {
	public static void main(String[] args) {

	}

	JButton btn;
	JLabel[] labels;
	JTextField[] textFields;
	JPanel[] panels;
	String labels_title = "전시 및 프로그램 총 매출";
	GraphPanel gp;

	public SalesManage() {

		this.setLayout(new BorderLayout());
		btn = new JButton("조회");
		btn.setPreferredSize(new Dimension(100, 30));
		btn.addActionListener(this);
		panels = new JPanel[2];
		panels[0] = new JPanel();
		panels[1] = new JPanel();
		panels[1].add(btn);
		gp = new GraphPanel();
		this.add("Center", panels[0]);
		this.add("Center", gp);
		this.add("South", panels[1]);
		this.setBackground(new Color(64, 228, 208));
		this.setPreferredSize(new Dimension(600,500));
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
		
		int jan2 = 0;
		int feb2 = 0;
		int mar2 = 0;
		int apr2 = 0;
		int may2 = 0;
		int jun2 = 0;
		int aug2 = 0;
		int jul2 = 0;
		int sep2 = 0;
		int oct2 = 0;
		int nov2 = 0;
		int dec2 = 0;
		
		// DB 연동
		CRUDprocess crud = new CRUDprocess();
		Outputs output = crud.selectOutputs();
		Outputs2 output2 = crud.selectOutputs2();
	
		jan = output.getExhibition_jan();
		feb = output.getExhibition_feb();
		mar = output.getExhibition_mar();
		apr = output.getExhibition_apr();
		may = output.getExhibition_may();
		jun = output.getExhibition_jun();
		jul = output.getExhibition_jul();
		aug = output.getExhibition_aug();
		sep = output.getExhibition_sep();
		oct = output.getExhibition_oct();
		nov = output.getExhibition_nov();
		dec = output.getExhibition_jan();

		jan2 = output2.getProgram_jan();
		feb2 = output2.getProgram_feb();
		mar2 = output2.getProgram_mar();
		apr2 = output2.getProgram_apr();
		may2 = output2.getProgram_may();
		jun2 = output2.getProgram_jun();
		jul2 = output2.getProgram_jul();
		aug2 = output2.getProgram_aug();
		sep2 = output2.getProgram_sep();
		oct2 = output2.getProgram_oct();
		nov2 = output2.getProgram_nov();
		dec2 = output2.getProgram_dec();
		
		gp.exhibition_jan(jan);
		gp.exhibition_feb(feb);
		gp.exhibition_mar(mar);
		gp.exhibition_apr(apr);
		gp.exhibition_may(may);
		gp.exhibition_jun(jun);
		gp.exhibition_jul(jul);
		gp.exhibition_aug(aug);
		gp.exhibition_sep(sep);
		gp.exhibition_oct(oct);
		gp.exhibition_nov(nov);
		gp.exhibition_dec(dec);
		gp.repaint();
		
		gp.program_jan(jan2);
		gp.program_feb(feb2);
		gp.program_mar(mar2);
		gp.program_apr(apr2);
		gp.program_may(may2);
		gp.program_jun(jun2);
		gp.program_jul(jul2);
		gp.program_aug(aug2);
		gp.program_sep(sep2);
		gp.program_oct(oct2);
		gp.program_nov(nov2);
		gp.program_dec(dec2);
		gp.repaint();
		
	}

}

class GraphPanel extends Panel {
	private int exhibition_jan, exhibition_feb, exhibition_mar, exhibition_apr, exhibition_may, exhibition_jun,
			exhibition_jul, exhibition_aug, exhibition_sep, exhibition_oct, exhibition_nov, exhibition_dec;
	
	private int program_jan, program_feb, program_mar, program_apr, program_may, program_jun, program_jul, program_aug,
			program_sep, program_oct, program_nov, program_dec;

	Image img;
	Font font;

	public void exhibition_jan(int total_jan) {
		this.exhibition_jan = total_jan;
	}

	public void exhibition_feb(int total_feb) {
		this.exhibition_feb = total_feb;
	}

	public void exhibition_mar(int total_mar) {
		this.exhibition_mar = total_mar;
	}

	public void exhibition_apr(int total_apr) {
		this.exhibition_apr = total_apr;
	}

	public void exhibition_may(int total_may) {
		this.exhibition_may = total_may;
	}

	public void exhibition_jun(int total_jun) {
		this.exhibition_jun = total_jun;
	}

	public void exhibition_jul(int total_jul) {
		this.exhibition_jul = total_jul;
	}

	public void exhibition_aug(int total_aug) {
		this.exhibition_aug = total_aug;
	}

	public void exhibition_sep(int total_sep) {
		this.exhibition_sep = total_sep;
	}

	public void exhibition_oct(int total_oct) {
		this.exhibition_oct = total_oct;
	}

	public void exhibition_nov(int total_nov) {
		this.exhibition_nov = total_nov;
	}

	public void exhibition_dec(int total_dec) {
		this.exhibition_dec = total_dec;
	}

	// 프로그램
	public void program_jan(int total_jan2) {
		this.program_jan = total_jan2;
	}

	public void program_feb(int total_feb2) {
		this.program_feb = total_feb2;
	}

	public void program_mar(int total_mar2) {
		this.program_mar = total_mar2;
	}

	public void program_apr(int total_apr2) {
		this.program_apr = total_apr2;
	}

	public void program_may(int total_may2) {
		this.program_may = total_may2;
	}

	public void program_jun(int total_jun2) {
		this.program_jun = total_jun2;
	}

	public void program_jul(int total_jul2) {
		this.program_jul = total_jul2;
	}

	public void program_aug(int total_aug2) {
		this.program_aug = total_aug2;
	}

	public void program_sep(int total_sep2) {
		this.program_sep = total_sep2;
	}

	public void program_oct(int total_oct2) {
		this.program_oct = total_oct2;
	}

	public void program_nov(int total_nov2) {
		this.program_nov = total_nov2;
	}

	public void program_dec(int total_dec2) {
		this.program_dec = total_dec2;
	}

	@Override
	public void paint(Graphics g) {
		// g.clearRect(0, 0, this.getWidth(), this.getHeight());
		// 그려질 영역을 지운다. (0,0)에서 (패널의 가로길이,패널의 세로길이)
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g.drawLine(60, 250, 1350, 250);// 수평선을 그린다. (x1 y1 x2 y2)
		g.setColor(Color.black);
		font = new Font("굴림체", Font.BOLD, 20);
		g.setFont(font);
		for (int cnt = 0; cnt < 11; cnt++) {
			g.drawString(cnt * 10 + "", 25, 255 - 20 * cnt); // 앞에껀문자 뒤에2개값은 좌표
			g.drawLine(60, 250 - 20 * cnt, 1350, 250 - 20 * cnt);// ex)50에 230부터 350 ,230까지 선
		} // 10점부터100점까지 점수와 수평선을 그린다.(10회 반복)
		g.drawLine(60, 20, 60, 250);// 수직선을 그린다. (x좌표 50,50)(y좌표 20,250)
		g.drawString("1월", 100, 270);
		g.drawString("2월", 170, 270);
		g.drawString("3월", 240, 270);
		g.drawString("4월", 310, 270);
		g.drawString("5월", 380, 270);
		g.drawString("6월", 450, 270);
		g.drawString("7월", 520, 270);
		g.drawString("8월", 590, 270);
		g.drawString("9월", 660, 270);
		g.drawString("10월", 730, 270);
		g.drawString("11월", 800, 270);
		g.drawString("12월", 870, 270);
		g.setColor(Color.blue);// 막대그래프 색
		if (exhibition_jan > 0) { // 값이있는 경우에만 그래프를 그림
			// 빨강색으로 채워져있는 사각형을그림
			g.fillRect(100, 250 - exhibition_jan * 2, 10, exhibition_jan * 2); // x좌표 110, y좌표 시작위치 , 두께10 , y좌표끝위치
																				// 사각형을그림
		}
		if (exhibition_feb > 0) {
			g.fillRect(170, 250 - exhibition_feb * 2, 10, exhibition_feb * 2);
		}
		if (exhibition_mar > 0) {
			g.fillRect(240, 250 - exhibition_mar * 2, 10, exhibition_mar * 2);
		}
		if (exhibition_apr > 0) {
			g.fillRect(310, 250 - exhibition_apr * 2, 10, exhibition_apr * 2);
		}
		if (exhibition_may > 0) {
			g.fillRect(380, 250 - exhibition_may * 2, 10, exhibition_may * 2);
		}
		if (exhibition_jun > 0) {
			g.fillRect(450, 250 - exhibition_jun * 2, 10, exhibition_jun * 2);
		}
		if (exhibition_jul > 0) {
			g.fillRect(520, 250 - exhibition_jul * 2, 10, exhibition_jul * 2);
		}
		if (exhibition_aug > 0) {
			g.fillRect(590, 250 - exhibition_aug * 2, 10, exhibition_aug * 2);
		}
		if (exhibition_sep > 0) {
			g.fillRect(660, 250 - exhibition_sep * 2, 10, exhibition_sep * 2);
		}
		if (exhibition_oct > 0) {
			g.fillRect(730, 250 - exhibition_oct * 2, 10, exhibition_oct * 2);
		}
		if (exhibition_nov > 0) {
			g.fillRect(800, 250 - exhibition_nov * 2, 10, exhibition_nov * 2);
		}
		if (exhibition_dec > 0) {
			g.fillRect(870, 250 - exhibition_dec * 2, 10, exhibition_dec * 2);
		}

		//
		if (program_jan > 0) {
			g.fillRect(130, 250 - program_jan * 2, 10, program_jan * 2); // x좌표 110, y좌표 시작위치 , 두께10 , y좌표끝위치 사각형을그림
		}
		if (program_feb > 0) {
			g.fillRect(200, 250 - program_feb * 2, 10, program_feb * 2);
		}
		if (program_mar > 0) {
			g.fillRect(270, 250 - program_mar * 2, 10, program_mar * 2);
		}
		if (program_apr > 0) {
			g.fillRect(340, 250 - program_apr * 2, 10, program_apr * 2);
		}
		if (program_may > 0) {
			g.fillRect(410, 250 - program_may * 2, 10, program_may * 2);
		}
		if (program_jun > 0) {
			g.fillRect(480, 250 - program_jun * 2, 10, program_jun * 2);
		}
		if (program_jul > 0) {
			g.fillRect(550, 250 - program_jul * 2, 10, program_jul * 2);
		}
		if (program_aug > 0) {
			g.fillRect(620, 250 - program_aug * 2, 10, program_aug * 2);
		}
		if (program_sep > 0) {
			g.fillRect(690, 250 - program_sep * 2, 10, program_sep * 2);
		}
		if (program_oct > 0) {
			g.fillRect(760, 250 - program_oct * 2, 10, program_oct * 2);
		}
		if (program_nov > 0) {
			g.fillRect(830, 250 - program_nov * 2, 10, program_nov * 2);
		}
		if (program_dec > 0) {
			g.fillRect(900, 250 - program_dec * 2, 10, program_dec * 2);
		}
	}

}
