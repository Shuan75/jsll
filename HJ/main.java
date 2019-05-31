package HJ;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



class BackgroundImage1 extends JPanel {
   final String PATH = "src\\HJ\\HaJinMain.png";
   Image img;

   BackgroundImage1() {
      img = Toolkit.getDefaultToolkit().getImage(PATH);
   }

   @Override
   public void paint(Graphics arg0) {
      arg0.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
   }
}
class BackgroundImage2 extends JPanel {
	   final String PATH = "src\\HJ\\HaJinMain.png";
	   Image img;

	   BackgroundImage2() {
	      img = Toolkit.getDefaultToolkit().getImage(PATH);
	   }

	   @Override
	   public void paint(Graphics arg0) {
	      arg0.drawImage(img, 0, 0, 500, 300, this);
	   }
	}

//메인에 추가할거 로그인버튼창 비회원창만 추가하기
public class main extends JPanel implements ActionListener{

   @Override
   public void actionPerformed(ActionEvent arg0) {
      Object o = arg0.getSource();
      if (o == btns[0]) {// 회원가입
         bgi.setVisible(false);
         this.remove(btnspanel);
         btnspanel.setVisible(false);
    //     SginUpMain = new SginUpMain(this);
         totalpanel.setLayout(card);
     //    totalpanel.add(SginUpMain, "sginUp");
         this.add("Center", totalpanel);
         this.card.show(totalpanel, "sginUp");
         
      }
      if (o == btns[1]) {// 로그인
         this.remove(bgi);
         btnspanel.setVisible(false);
      //   MainLogin = new MainLogin(this);
     //    totalpanel.add(MainLogin,"login");
         this.card.show(totalpanel, "login");
      }
      if (o == item_exhibition) {
         System.out.println("이전전시를 누름");
      }
      if (o == item_exhibition1) {
         System.out.println("현재전시를 누름");
      }
      if (o == item_exhibition2) {
         System.out.println("예정전시를 누름");
      }
      if (o == item_goodies) {
    	  btnspanel.setVisible(false);
          this.card.show(totalpanel, "goods");
          for(int i=0; i < btns.length; i++) {
         btns[i].remove(this);
          }
      }
      if (o == item_program) {
         
      }
      if (o == item_event) {
    	  this.card.show(totalpanel , "event");
         
      }
   }

   public JButton[] btns;
   public String titles[] = { "   회원가입 ", "   로그인     " };

   void makebtns() {
      btns = new JButton[2];
      for (int i = 0; i < btns.length; i++) {
         btns[i] = new JButton(titles[i]);
         btns[i].setPreferredSize(new Dimension(100, 30));
      //   btns[i].addActionListener(this);
      }
   } //버튼만들기
   
   ShowEvent se;
   GoodsSystem gs;
   CardLayout card;
   Panel totalpanel;
 //  SginUpMain SginUpMain;
//  SginUpSystem SginUpSystem;
 //  MainLogin MainLogin;
   Font menufont;
   JMenuBar mb;
   JMenu menu_exhibition, menu_goodies, menu_program, menu_event;
   JMenuItem item_exhibition,item_exhibition1, item_exhibition2, item_goodies, item_program, item_event;
   JPanel btnspanel;
   JPanel bgi;
   BookSystem b;
   
   
   public main() {
	  //this.gs = gs;
     // super(str);
	  this.b = b;
	  gs = new GoodsSystem(this); 
	  se = new ShowEvent(this);
      makebtns();
      menufont = new Font("굴림체", Font.PLAIN, 15);
      this.setLayout(new BorderLayout());
      
      // 메뉴 //
      mb = new JMenuBar();
      
      menu_exhibition = new JMenu("                         전시                                      ");
      menu_goodies = new JMenu("                            굿즈                                       ");
      menu_program = new JMenu("                            프로그램                                   ");
      menu_event = new JMenu("                              이벤트                                        ");
      
      item_exhibition = new JMenuItem("                  이전 전시                             ");
      item_exhibition1 = new JMenuItem("                  현재 전시                             ");
      item_exhibition2 = new JMenuItem("                  예정 전시                             ");
      item_goodies = new JMenuItem("                      굿즈                                   ");
      item_program = new JMenuItem("                      프로그램                              ");
      item_event = new JMenuItem("                        이벤트                               ");
      
      item_exhibition.setFont(menufont);
      item_exhibition1.setFont(menufont);
      item_exhibition2.setFont(menufont);
      item_goodies.setFont(menufont);
      item_program.setFont(menufont);
      item_event.setFont(menufont);
      
      item_exhibition.addActionListener(this);
      item_exhibition1.addActionListener(this);
      item_exhibition2.addActionListener(this);
      item_goodies.addActionListener(this);
      item_program.addActionListener(this);
      item_event.addActionListener(this);
      
      menu_exhibition.setEnabled(true);
      menu_goodies.setEnabled(true);
      menu_program.setEnabled(true);
      menu_event.setEnabled(true);
      
      menu_exhibition.add(item_exhibition);
      menu_exhibition.add(item_exhibition1);
      menu_exhibition.add(item_exhibition2);
      menu_goodies.add(item_goodies);
      menu_program.add(item_program);
      menu_event.add(item_event);
      
      mb.add(menu_exhibition);
      mb.add(menu_goodies);
      mb.add(menu_program);
      mb.add(menu_event);
      
    //  this.setJMenuBar(mb);
      // 메뉴 관련 작업 끝
      
      card = new CardLayout();
      totalpanel = new Panel(); 
      totalpanel.setLayout(card);
  //    totalpanel.setBackground(new Color(199,228,248));
      btnspanel = new JPanel();
      btnspanel.add(btns[0]);
      btnspanel.add(btns[1]);
      bgi = new BackgroundImage1();
      totalpanel.add(bgi, "image");
      totalpanel.add(gs, "goods");
      totalpanel.add(se, "event");
  //    this.setBackground(new Color(199,228,248));
      this.add("Center", totalpanel);
      this.add("South", btnspanel);
//      this.setSize(1000, 500);
//      this.setLocation(100, 0);
//      this.setVisible(true);
   }

   public static void main(String[] args) {
    //  new HaJinmain2("");
   }
}