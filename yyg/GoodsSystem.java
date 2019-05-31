package yyg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class goodsImage extends JPanel {
      Image image;
      
      public goodsImage(String string) {
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


public class GoodsSystem extends JPanel {
   JPanel[] panel;
   JPanel[] panels;
   JPanel[] Imagepanel;
//   JPanel[] imagepanel;
   JPanel[] totalpanel;
   JLabel[] labels;
   JPanel[] image;
   JPanel[] gappanels;
   
   void inimage() {
      image =  new JPanel[9]; //이미지패널
      for(int i=0;i < image.length; i++) {
         image[i] = new JPanel();
         image[i].setLayout(new BorderLayout());
      }//이미지 인스턴스 생성
      
      //image[0] = new goodsImage("src\\LHJ\\goodsimage1.jpg");//이미지를 가지고 있는 
//      Imagepanel[0].add(image[0]);
   }

   
   void makeImagepanel() { //이미지담을이미지패널
      Imagepanel = new JPanel[10]; //배열생성
      for(int i=0; i < Imagepanel.length; i++) {
         Imagepanel[i] = new JPanel(); //인스턴스생성
      }
      
      Imagepanel[0] = new goodsImage("src\\JJH\\12.jpg"); //이미지담기
      Imagepanel[1] = new goodsImage("src\\JJH\\13.jpg");
      Imagepanel[2] = new goodsImage("src\\JJH\\14.jpg");
      Imagepanel[3] = new goodsImage("src\\JJH\\15.jpg");
      Imagepanel[4] = new goodsImage("src\\LHJ\\goodsimage5.jpg");
      Imagepanel[5] = new goodsImage("src\\LHJ\\goodsimage6.jpg");
      Imagepanel[6] = new goodsImage("src\\LHJ\\goodsimage7.jpg");
      Imagepanel[7] = new goodsImage("src\\LHJ\\goodsimage8.jpg");
      Imagepanel[8] = new goodsImage("src\\LHJ\\goodsimage9.jpg"); 
      Imagepanel[9] = new goodsImage("src\\LHJ\\goodsimage10.jpg");
      for(int i=3; i <=8; i++) {
      //   Imagepanel[i].setLayout(new BorderLayout());
         Imagepanel[i].add("North", new JLabel("                                      "));
         Imagepanel[i].add("West",new JLabel("                                             ") );
         Imagepanel[i].add("South", new JLabel("                                                "));
         Imagepanel[i].add("East", new JLabel("                                   "));
      }
      
      for(int i=0; i < Imagepanel.length; i++) {
      Imagepanel[i].setBackground(Color.LIGHT_GRAY);//표시용배경색입히기
      
      }
      
      
   }
   
   void makepanel() { //윈도우에 붙여진 패널
      panels = new JPanel[4]; //배열생성
      for(int i=0; i<panels.length; i++) {
         panels[i] = new JPanel(); //인스턴스생성
         
      }
      for(int i=0; i < 3; i++) {
      panels[i].setLayout(new BorderLayout()); //배치관리자생성
      }
      
      panels[3].setLayout(new GridLayout(2,3));
      //panels[0].setBackground(Color.BLACK);
       //panels[1].setBackground(Color.ORANGE);
      //panels[2].setBackground(Color.PINK);
      panels[3].setBackground(Color.LIGHT_GRAY);
   }
   
   public GoodsSystem(){//생성자
 
	   this.setLayout(new GridLayout(2,4));
      gappanels = new JPanel[3];
      for(int i=0;i < gappanels.length; i++) {
         gappanels[i] = new JPanel();
         
      }
      makepanel();
      makeImagepanel();
      inimage();
      
      totalpanel = new JPanel[4];
      for(int i=0; i < totalpanel.length; i++) {
          totalpanel[i] = new JPanel();
         totalpanel[i].setLayout(new BorderLayout());
      }
      totalpanel[3].add("North", new JLabel("         "));
      totalpanel[3].add("West",new JLabel  ("                              ") );
      totalpanel[3].add("South", new JLabel("                                                    KENNY SCHARF PLATE(S)/33,000KRW"));
      totalpanel[3].add("East", new JLabel ("                          "));
      
      //1번째패널
      panels[0].add("North", new JLabel("                                      "));
      panels[0].add("West",new JLabel("                                             ") );
   //   panels[0].add("South", new JLabel("                 "));
      panels[0].add("South", gappanels[0].add(new JLabel("                                          KENNY SCHARF PLATE(S)/33,000KRW")));

      panels[0].add("East", new JLabel("                                   "));
      
      //2번째패널
      panels[1].add("North", new JLabel("                                      "));
      panels[1].add("West",new JLabel("                                             ") );
        panels[1].add("South", gappanels[1].add(new JLabel("                          KENNY SCHARF FIGURE LIMITED EDITION/80,000KRW")));

      panels[1].add("East", new JLabel("                                   "));
      
      //3번째패널
      //가운데정렬만들때는 패널안에 패널을 넣어서 레이블을 붙인다
      panels[2].add("North", new JLabel("                                      "));
      panels[2].add("West",new JLabel("                                             ") );
      panels[2].add("South", gappanels[2].add(new JLabel("                                      KENNY SCHARF TOTE BAG\\13,0000KRW")));
      panels[2].add("East", new JLabel("                                   "));

      
      
      
      panels[0].add("Center",Imagepanel[0]);
      panels[1].add("Center",Imagepanel[1]);
      panels[2].add("Center",Imagepanel[2]);
      //panels[3].setLayout(new BorderLayout());
//      panels[3].add("North", new JLabel("                                      "));
//      panels[3].add("West",new JLabel("                                             ") );
//      panels[3].add("South", new JLabel("                                                "));
//      panels[3].add("East", new JLabel("                                   "));
      for(int i =3; i < 9; i++) {
      panels[3].add(Imagepanel[i]);
      }
      totalpanel[3].add(panels[3]);
      
       this.add(panels[0]);
       this.add(panels[1]);
      
      this.add(panels[2]);
   //   this.add(panels[2].add(new JLabel("   ")));
       this.add(totalpanel[3]);
      //panel = new JPanel[2];
      //panel[0] = new JPanel();
      //panel[1] = new JPanel();
      //panel[0].setBackground(Color.cyan);
      //panel[1].setBackground(Color.GREEN);
      //this.add(panel[0]); this.add(panel[1]);
//      this.setSize(1000, 500);
//      this.setVisible(true);
       this.setPreferredSize(new Dimension(600,500));
   }
   public static void main(String[] args) {

   }

}