package yyg;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Reserve extends JPanel {

	JButton prev, next, last, load, save, allsave;
	JPanel buttons;
	JPanel Reserve;
	JPanel[] items_intro, item, desc, buton;
	JTextField text;
	JTable[] d;
	CardLayout card;
	ImagePanel imagePanel;
	ManagerMode mm;
	
	void inIt() {
		card = new CardLayout();
		Reserve = new JPanel(card);
		items_intro = new JPanel[6];
		item = new JPanel[6];
		desc = new JPanel[10];
		text = new JTextField(30);
		
		for (int i = 0; i < items_intro.length; i++) {
			items_intro[i] = new JPanel();
			items_intro[i].setLayout(new GridLayout(1, 2));
			desc[i] = new JPanel(new GridLayout(7, 1));

			switch (i) {
			case 0:
				item[i] = new ReserveImage("src\\JJH\\01.jpg");
				break;
			case 1:
				item[i] = new ReserveImage("src\\JJH\\02.jpg");
				break;
			case 2:
				item[i] = new ReserveImage("src\\JJH\\03.jpg");
				break;
			case 3:
				item[i] = new ReserveImage("src\\JJH\\04.jpg");
				break;
			case 4:
				item[i] = new ReserveImage("src\\JJH\\05.jpg");
				break;
			case 5:
				item[i] = new ReserveImage("src\\JJH\\06.jpg");
				break;
			}

			items_intro[i].add(item[i]);
			items_intro[i].add(desc[i]);

		}

		desc[0].add(new JLabel("    ?��?��?�� �? "));
		desc[0].add(new JLabel("    JAMES JEAN(B.1979"));
		desc[0].add(new JLabel("    1979?�� ??만에?�� 출생?�� ?��?��?�� 진�? 3?�� ?��?�� ?�� 미국 ?��??�?�? ?��주해 "));
		desc[0].add(new JLabel("    ?��?�� 로스?��?��?��?���? 기반?���? ?��?��?�� ?��?��?�� 보여주고 ?��?��?��?��. "));
		desc[0].add(new JLabel("    ?��?��?�� 진�? ?��?��?�� 미술 명문?�� ?���? ?���? 비주?��?���?(SVA)?��?��"));

		desc[1].add(new JLabel("   "));
		desc[1].add(new JLabel("   JAMES JEAN(B.1979"));
		desc[1].add(new JLabel("   "));
		desc[1].add(new JLabel("   "));
		desc[1].add(new JLabel("   "));
		desc[1].add(new JLabel("   "));
		desc[1].add(new JLabel("   "));

		desc[2].add(new JLabel("   "));
		desc[2].add(new JLabel("   "));
		desc[2].add(new JLabel("   "));
		desc[2].add(new JLabel("   "));
		desc[2].add(new JLabel("   "));
		desc[2].add(new JLabel("   "));
		desc[2].add(new JLabel("   "));

		desc[3].add(new JLabel("   "));
		desc[3].add(new JLabel("   "));
		desc[3].add(new JLabel("   "));
		desc[3].add(new JLabel("   "));
		desc[3].add(new JLabel("   "));
		desc[3].add(new JLabel("   "));
		desc[3].add(new JLabel("   "));

		desc[4].add(new JLabel("   "));
		desc[4].add(new JLabel("   "));
		desc[4].add(new JLabel("   "));
		desc[4].add(new JLabel("   "));
		desc[4].add(new JLabel("   "));
		desc[4].add(new JLabel("   "));
		desc[4].add(new JLabel("   "));

		desc[5].add(new JLabel("   "));
		desc[5].add(new JLabel("   "));
		desc[5].add(new JLabel("   "));
		desc[5].add(new JLabel("   "));
		desc[5].add(new JLabel("   "));
		desc[5].add(new JLabel("   "));
		desc[5].add(new JLabel("   "));

		Reserve.add(items_intro[0], "그림1");
		Reserve.add(items_intro[1], "그림2");
		Reserve.add(items_intro[2], "그림3");
		Reserve.add(items_intro[3], "그림4");
		Reserve.add(items_intro[4], "그림5");
		Reserve.add(items_intro[5], "그림6");

		save = new JButton("?? ?��");
		save.addActionListener(new SaveActionListener(this, mm));
		load = new JButton("?��미�? ?��로드");
		load.addActionListener(new LoadActionListener(this, imagePanel, mm));
		allsave = new JButton("?���? ???��");
		allsave.addActionListener(new MyButtonListener(this));
		prev = new JButton("?�� ?��");
		prev.addActionListener(new MyButtonListener(this));
		next = new JButton("?�� ?��");
		next.addActionListener(new MyButtonListener(this));

		
		buttons = new JPanel();
		buttons.add(text);
		buttons.add(save);
		buttons.add(load);
		buttons.add(allsave);
		buttons.add(prev);
		buttons.add(next);
		
	}

	public Reserve(ManagerMode mm) {

		inIt();
		this.setLayout(new BorderLayout());
		this.add("Center", Reserve);
		this.add("South", buttons);
		this.setPreferredSize(new Dimension(600,500));

	}

	public static void main(String[] args) {

	}

}

class ReserveImage extends JPanel {
	Image img;

	ReserveImage(String path) {
		img = Toolkit.getDefaultToolkit().getImage(path);

	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}

class MyButtonListener implements ActionListener {
	Reserve fs;

	MyButtonListener(Reserve fs) {
		this.fs = fs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj == fs.prev) {
			fs.card.previous(fs.Reserve);
		} else if (obj == fs.next) {
			fs.card.next(fs.Reserve);
		}

	}

}


class ImagePanel extends JPanel {
	Image image;

	void setImage(String path) {
		image = Toolkit.getDefaultToolkit().getImage(path);
	}

	@Override
	public void paint(Graphics g) {

		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		if (image != null) {
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
}
class LoadActionListener implements ActionListener {
	Reserve re;
	ImagePanel ip;
	FileDialog fileDialog;
	ManagerMode mm;

	LoadActionListener(Reserve re, ImagePanel ip, ManagerMode mm) {
		this.re = re;
		this.ip = ip;
		this.mm = mm;
	}

	static BufferedInputStream bis;
	static String filename;

	@Override
	public void actionPerformed(ActionEvent e) {
		fileDialog = new FileDialog(mm, "?��미�? ?��?�� ?���?", FileDialog.LOAD);
		fileDialog.setVisible(true);
		filename = fileDialog.getFile();
		String path = fileDialog.getDirectory() + fileDialog.getFile();

		re.text.setText(path);
		ip.setImage(path);
		ip.repaint();

		try {
			bis = new BufferedInputStream(new FileInputStream(path));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(re, "?��미�? ?��?��?�� 로드?�� ?�� ?��?��?��?��.");
		}
	}

}

class SaveActionListener implements ActionListener {

	FileDialog fileDialog;
	Reserve re;
	BufferedOutputStream bos; // ?��?��처리?�� ?��?��?��?�� 객체
	ManagerMode mm;

	SaveActionListener(Reserve re, ManagerMode mm) {
		this.re = re;
		this.mm = mm;
	}

	static String path;

	@Override
	public void actionPerformed(ActionEvent e) {
		fileDialog = new FileDialog(mm, "?��미�? ?��?�� ???��", FileDialog.SAVE);
		fileDialog.setFile(LoadActionListener.filename);
		fileDialog.setVisible(true);
		path = fileDialog.getDirectory() + fileDialog.getFile();
		re.text.setText(path);

		try {
			bos = new BufferedOutputStream(new FileOutputStream(path));
			int data = 0; // 4바이?�� ?��?��
			while ((data = LoadActionListener.bis.read()) != -1) {
				bos.write(data);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(re, "?��미�? ?��?��?�� ???��?��?�� ?���? 문제발생");
		} finally {

			try {
				bos.close();
				LoadActionListener.bis.close();
			} catch (Exception exe) {

			}

		}

	}
}
