package HJ;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;


class EventImage2 extends JPanel {
	   Image image;
	   
	   public EventImage2(String string) {
		   image=Toolkit.getDefaultToolkit().getImage(string);
	}

	
	   @Override
	   public void paint(Graphics g) {
	      //�̹��� ��� ���� ������ ������ �����.
	      g.clearRect(0, 0, this.getWidth(), this.getHeight());
	      if(image != null) {
	         g.drawImage(image, 0, 0, 
	        		 this.getWidth(),this.getHeight(),this);
	      }
	   }
	}

public class ShowEvent2 extends JPanel {
	 
	
	JPanel Imagepanel;
	JPanel sizepanel;
	main2 hjm;
	 
	 
	void makeImagepanel() { //�̹��������̹����г�
		//�迭����
		Imagepanel = new JPanel(); //�ν��Ͻ�����
		sizepanel = new JPanel();
	    Imagepanel = new EventImage("src\\HJ\\eventimage.png"); //�̹������
	}
		ShowEvent2(main2 Main2) {
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
		// new ShowEvent("�̺�Ʈȭ��");

	}

}
