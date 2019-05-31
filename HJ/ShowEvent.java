package HJ;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;


class EventImage extends JPanel {
	   Image image;
	   
	   public EventImage(String string) {
		   image=Toolkit.getDefaultToolkit().getImage(string);
	}

	
	   @Override
	   public void paint(Graphics g) {
	      //이미지 출력 전에 영역을 깨끗이 지운다.
	      g.clearRect(0, 0, this.getWidth(), this.getHeight());
	      if(image != null) {
	         g.drawImage(image, 0, 0, 
	        		 this.getWidth(),this.getHeight(),this);
	      }
	   }
	}

public class ShowEvent extends JPanel {
	 
	
	JPanel Imagepanel;
	JPanel sizepanel;
	main hjm;
	 
	 
	void makeImagepanel() { //이미지담을이미지패널
		//배열생성
		Imagepanel = new JPanel(); //인스턴스생성
		sizepanel = new JPanel();
	    Imagepanel = new EventImage("src\\HJ\\eventimage.png"); //이미지담기
	}
		ShowEvent(main hjm) {
		//	super(str);
			this.hjm = hjm;
	        makeImagepanel();
		//	this.add("Center",);
			this.add("Center",Imagepanel);
	
		//	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setSize(1000,500);
			this.setVisible(true);
		}
	public static void main(String[] args) {
		// new ShowEvent("이벤트화면");

	}

}
