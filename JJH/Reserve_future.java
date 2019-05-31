package JJH;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;



public class Reserve_future extends JFrame {

	
		
	

	JButton prev,next,last;
	JPanel buttons;
	JPanel Reserve_future;	
	JPanel[] items_intro3, item3, desc,buton;	
	
	JTable[] d;
	CardLayout card;	
	
	void inIt() {
		card = new CardLayout();
		Reserve_future = new JPanel(card);
		items_intro3 = new JPanel[6];
		item3= new JPanel[6];
		desc = new JPanel[10];
		for(int i = 0; i < items_intro3.length; i++) {
			items_intro3[i] = new JPanel();
		
			items_intro3[i].setLayout(new GridLayout(1,2));
			
			desc[i] = new JPanel(new GridLayout(7,1));

			switch(i) {
			case 0:
				item3[i] = new Reserve_futureImage("src\\hhj\\13.jpg"); break;
			case 1:
				item3[i] = new Reserve_futureImage("src\\hhj\\14.jpg"); break;
			case 2:
				item3[i] = new Reserve_futureImage("src\\hhj\\15.jpg"); break;
			case 3:
				item3[i] = new Reserve_futureImage("src\\hhj\\16.jpg"); break;
			case 4:
				item3[i] = new Reserve_futureImage("src\\hhj\\17.jpg"); break;
			case 5:
				item3[i] = new Reserve_futureImage("src\\hhj\\18.jpg"); break;
			}

			items_intro3[i].add(item3[i]);
			items_intro3[i].add(desc[i]);	
			
		} //end of for
		
		desc[0].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[0].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[0].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[0].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[0].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[0].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[1].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[1].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[1].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[1].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[1].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[1].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[2].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[2].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[2].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[2].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[2].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[2].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[3].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[3].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[3].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[3].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[3].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[3].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[4].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[4].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[4].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[4].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[4].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[4].add(new JLabel( "   *     1544-7744. "));
		
	
		desc[5].add(new JLabel("    *     湲곌컙 :   2019.05.01 ~ 2019.05.31"));	
		desc[5].add(new JLabel("    *     �떆媛� : �썡~紐�| 10:30~20:00"));			
		desc[5].add(new JLabel("          湲�~�씪 | 10:30~20:30\" "));
		desc[5].add(new JLabel( "   *     �옣�냼 | �븞�궛 �븯吏� 誘몄닠愿�痢�. "));
		desc[5].add(new JLabel( "   *     媛�寃� �뀭 15,000�썝. "));
		desc[5].add(new JLabel( "   *     1544-7744. "));
		
		Reserve_future.add(items_intro3[0],"洹몃┝1");
		Reserve_future.add(items_intro3[1],"洹몃┝2");
		Reserve_future.add(items_intro3[2],"洹몃┝3");
		Reserve_future.add(items_intro3[3],"洹몃┝4");
		Reserve_future.add(items_intro3[4],"洹몃┝5");
		Reserve_future.add(items_intro3[5],"洹몃┝6");
		
		
		last =new JButton("�삁留ㅽ븯湲�");
		last.addActionListener(new MyButtonListener3(this));
				
		prev = new JButton("�씠�쟾");
		prev.addActionListener(new MyButtonListener3(this));
		next = new JButton("�떎�쓬");
		next.addActionListener(new MyButtonListener3(this));
	
		buttons = new JPanel();	//踰꾪듉�쓣 �떞�쓣 �뙣�꼸 �깮�꽦
		// buttons.add(last);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		
	}

		public Reserve_future(String str) {
			super(str);
			
		inIt();
		this.setLayout(new BorderLayout());
		this.add("Center",Reserve_future);
		this.add("South",buttons);
		
		this.setSize(1000, 500);
		this.setLocation(230, 200);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
	new Reserve_future("�븯吏� 誘몄닠愿�");

	}

}	//end of fruitsShopping class

class Reserve_futureEnd extends WindowAdapter{		//�뼱�뙌�꽣濡� �씠踰ㅽ듃泥섎━//////////////////

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}													//�뼱�뙌�꽣濡� �씠踰ㅽ듃泥섎━//////////////////

class Reserve_futureExit implements WindowListener{
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

class Reserve_futureImage extends JPanel{
	Image img;
	Reserve_futureImage(String path){		//path = 寃쎈줈瑜� 諛쏄린 �쐞�빐
		img = Toolkit.getDefaultToolkit().getImage(path);
		
	}
	
	@Override
	public void paint(Graphics g) {

		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	//�뙣�꼸�쓽 �겕湲곗뿉 留욊쾶 �궗�씠利� 議곗젙�븯湲�
	}
			
}

 class MyButtonListener3 implements ActionListener{
	 Reserve_future fs;
//		
		MyButtonListener3(Reserve_future fs){
			this.fs = fs;
//		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
	
		if(obj == fs.prev) {
			fs.card.previous(fs.Reserve_future);
		} else if(obj == fs.next) {
			fs.card.next(fs.Reserve_future);
		} 
		
	}
	
}


