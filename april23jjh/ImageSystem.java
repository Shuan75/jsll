package april23jjh;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class ImageSystem extends Panel {

	public static void main(String[] args) {
		// new ImageSystem("");
	}

	Button load, save;
	TextField text;
	Panel southPanel;
	ImagePanel imagePanel;
	TotalSystem ts;

	public ImageSystem(TotalSystem ts) {
		this.setLayout(new BorderLayout());
		load = new Button("Image Load");
		save = new Button("Image Save");
		imagePanel = new ImagePanel();
		load.addActionListener(new LoadActionListener(this, imagePanel, ts));
		save.addActionListener(new SaveActionListener(this, ts));

		text = new TextField(40);
		southPanel = new Panel();

		southPanel.setBackground(Color.cyan);
		southPanel.add(text);
		southPanel.add(load);
		southPanel.add(save);

		this.add("Center", imagePanel);
		this.add("South", southPanel);
		// this.setSize(500, 400);
		// this.setVisible(true);
		// this.addWindowListener(new LoginSystemExit());

	}
}

class ImagePanel extends Panel {
	Image image;

	void setImage(String path) {
		image = Toolkit.getDefaultToolkit().getImage(path);
	}

	@Override
	public void paint(Graphics g) {
		// 이미지 출력전 영억을 지움
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		if (image != null) {
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
}

class LoadActionListener implements ActionListener {
	// 이미지 로드 버튼 누른경우 actionPerformed가 자동 호출된다.
	// 이미지 파일의 경로를 ImageSystem에서 불러온다.
	// 위의 경로에 있는 이미지를 불러와서 ImagePanel에 출력한다.
	// 그리고, ImagePanel을 다시 그린다.
	ImageSystem is;
	ImagePanel ip;
	FileDialog fileDialog;
	TotalSystem ts;

	LoadActionListener(ImageSystem is, ImagePanel ip, TotalSystem ts) {
		this.is = is;
		this.ip = ip;
		this.ts = ts;
	}

	static BufferedInputStream bis;
	static String filename;

	@Override
	public void actionPerformed(ActionEvent e) {
		fileDialog = new FileDialog(ts, "이미지 파일 열기", FileDialog.LOAD);
		fileDialog.setVisible(true);
		filename = fileDialog.getFile();
		String path = fileDialog.getDirectory() + fileDialog.getFile();
		// 파일 다이얼로그에서 선택한 파일의 경로와 파일명이 path에 저장된다.

		is.text.setText(path); // 파일의 경로와 파일명을 TextField에 출력
		ip.setImage(path); // 이미지 패널에 이미지 경로를 설정
		ip.repaint(); // 이미지 패널을 다시 그림.

		try {
			bis = new BufferedInputStream(new FileInputStream(path));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(is, "이미지 파일을 로드할 수 없습니다.");
		}
	}

}

class SaveActionListener implements ActionListener {

	FileDialog fileDialog;
	ImageSystem is;
	BufferedOutputStream bos; // 파일처리에 사용하는 객체
	TotalSystem ts;

	SaveActionListener(ImageSystem is, TotalSystem ts) {
		this.is = is;
		this.ts = ts;
	}

	static String path;

	@Override
	public void actionPerformed(ActionEvent e) {
		fileDialog = new FileDialog(ts, "이미지 파일 저장", FileDialog.SAVE);
		fileDialog.setFile(LoadActionListener.filename);
		// 다이얼로그가 동작되는 윈도우
		// fileDialog.setFile("fileDialog.getFile()");
		// fileDialog.setFile("디폴트 파일 이름");
		fileDialog.setVisible(true);
		path = fileDialog.getDirectory() + fileDialog.getFile();
		is.text.setText(path);

		try {
			bos = new BufferedOutputStream(new FileOutputStream(path));
			int data = 0; // 4바이트 설정
			while ((data = LoadActionListener.bis.read()) != -1) {
				bos.write(data);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(is, "이미지 파일을 저장하는 도중 문제발생");
		} finally {

			try {
				bos.close();
				LoadActionListener.bis.close();
			} catch (Exception exe) {

			}

		}

	}

}
