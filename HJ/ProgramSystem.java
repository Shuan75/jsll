package HJ;




import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProgramSystem extends JPanel implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		  Object o = e.getSource();
		// 연도를 눌러도 여기로 온다.
		// 월을 눌러도 여기로 온다.
		// 일을 눌러도 여기로 온다.
		if (e.getSource() == combos[2]) {// 월을 누른경우

			// 선택한 월을 찾아서, 월에 따라 일을 date에 넣는다.
			// getSelectedItem()메서드는 선택한 초이스의 데이터를 찾는다.
			int m = (int)combos[2].getSelectedItem();
			//int month_int = Integer.parseInt(m);
			// 문자열을 int로 변환
			// date에 기존에 들어가있는 데이터를 싹 지운다.
			// 들어가있는 데이터를 지우는 메서드
			 combos[3].removeAllItems();
			switch (m) {
			case 2:// date에 28일을 채운다.
				
				for (int i = 1; i <= 28; i++) {
					combos[3].addItem(i + "");
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11: // date에 30일을 채운다.
				for (int i = 1; i <= 30; i++) {
					combos[3].addItem(i + "");
				}
				break;
			default: // date에 31일을 채운다.
				
				for (int i = 1; i <= 31; i++) {
					combos[3].addItem(i + "");
				}
			}

		}
		
	if(e.getSource() == buttons[0]) {//구입버튼을 누른경우
		JOptionPane.showMessageDialog(ps,"구입하시겠습니까?");
		int i=1;
		this.card.show(cardpanel,"programpurchase");
		pp.textfield.setVisible(true);
        pp.textfield.setText("Y000"+i);
        
        i++;
//		
			
		}else if(o == buttons[1]){//취소버튼을누른경우
		      
			JOptionPane.showMessageDialog(ps,"취소하시겠습니까?");
			tab.card.show(tab.cardpanel,"main");  
			  //  textfield.setText("   ");
			   
			   //세 개의 텍스트 필드에 입력된 값을 지움
			
			 //  madeIn[0].setSelected(true);//라디오버튼을 오전으로 설정
			 //  madeIn[2].setSelected(true);//라디오버튼을 현금으로 설정
			  }
			
		}
	

	
	
	JPanel[] panels;
	JLabel toplabel;
	JLabel[] labels;
	String[] labels_title = {"프로그램","날짜","시간","인원수","금액"};
	String[] radio_title = {"오전(09:00~12:00)","오후(13:00~18:00)","현금","카드"};
	String[] button_title = {"구입","취소"};
	JComboBox[] combos;
	JRadioButton[] madeIn; ButtonGroup group;
	JTextField textfield;
	JButton[] buttons;
	JPanel TotalPanel;
	
	JPanel cardpanel;
	JLabel[] label;
	CardLayout card;
	ProgramPurchase pp;
	ProgramSystem ps;
	main2 m2;
	main m;
	BookSystem b;
	
	
	void makeButton() {
		buttons = new JButton[2];
		for(int i=0;i < button_title.length; i++) {
			 buttons[i] = new JButton(button_title[i]);
			 buttons[i].setBackground(new Color(52,152,219));
			 buttons[i].setSize(400, 50);
		}
	}//버튼만들기
	
	
	
	void makeRadioButton() {
		madeIn = new JRadioButton[4];
		group = new ButtonGroup();
		for(int i=0;i < radio_title.length; i++) {
			madeIn[i] = new JRadioButton(radio_title[i]);
		}
	}//라디오버튼만들기
	
	
	
	void makeCombobox() {
		combos = new JComboBox[5];
		for(int i=0;i < combos.length; i++) {
			combos[i] = new JComboBox();
		}//콤보박스만들기
		
		combos[0].addItem("프로그램선택");
		   String[] program_title = {"수채화","유화","어린이교실","종이접기","그리기"};
		   for(int k=0; k < program_title.length; k++) {
			   combos[0].addItem(program_title[k]+ "");
		   }
		 combos[1].addItem("연도선택");
		 for(int p =2019; p >=2000; p--) {
			   combos[1].addItem(p);
		   }
		 combos[2].addItem("월선택");
		   for(int j=1; j <= 12; j++) {
			   combos[2].addItem(j);
		   }
		   
		   combos[3].addItem("일 선택");
		   
		  combos[4].addItem("인원수 선택");
		  for(int h=1; h <= 20; h++) {
			  combos[4].addItem(h);
		  }
	}//콤보박스만들기
	
	
	
	void makelabel() {
		labels = new JLabel[5];
		for(int i=0;i < labels_title.length; i++) {
			labels[i] = new JLabel(labels_title[i]);
		}
	}//라벨만들기
	
	
	
	
	void makepanel(){
		panels = new JPanel[10];
		for(int i =0;i < 10; i++) {
			panels[i] = new JPanel();
			panels[i].setBackground(new Color(199,228,248));//패널들 색입히기
			//panels[i].setLayout(new GridLayout(10,1));
			
		}
		
	}//패널만들기
	
	TabClass tab;
	public ProgramSystem(TabClass tab){//생성자생성
	this.tab = tab;
	//this.setLayout(new BorderLayout());
	
	
	makelabel();
	makeCombobox();
	makeRadioButton();
	makeButton();
	makepanel();
	m2 = new main2();
	m = new main();
	pp = new ProgramPurchase(this);
	pp.textfield.setVisible(false);
	
	card = new CardLayout();
	cardpanel = new JPanel();
	cardpanel.setBackground(new Color(199,228,248));
	textfield = new JTextField(20);
	
	//패널에 컴포넌트 붙이기
	panels[2].add(labels[0]); panels[2].add(combos[0]);
	panels[3].add(labels[1]); panels[3].add(combos[1]); panels[3].add(combos[2]); panels[3].add(combos[3]);
	panels[4].add(labels[2]); panels[4].add(madeIn[0]); panels[4].add(madeIn[1]);
	panels[5].add(madeIn[2]); panels[5].add(madeIn[3]);
	panels[6].add(labels[3]); panels[6].add(combos[4]);
	panels[7].add(labels[4]); panels[7].add(textfield);
	panels[9].add(buttons[0]); panels[9].add(buttons[1]);
	//컴포넌트에 액션리스너 붙이기
	combos[2].addActionListener(this);
	buttons[0].addActionListener(this);
	buttons[1].addActionListener(this);
	//toplabel = new JLabel("회원로그인화면");
	//toplabel.setLocation(900, 200);
   // panels[0].add(toplabel);
	
    TotalPanel = new JPanel();
	TotalPanel.setLayout(new GridLayout(10,1));
    for(int i=0; i< 10; i++) {
    	TotalPanel.add(panels[i]);	
    
    }
    
    TotalPanel.setBackground(new Color(199,228,248));
    
    label = new JLabel[2];
    for(int i=0;i < label.length; i++) {
    	label[i] = new JLabel();
    //	label[i].setBackground(Color.WHITE);
    }
   // Center.add(label[0]);
  //  Center.add(TotalPanel);
  //  Center.add(label[1]);
   
   
	
    cardpanel.setLayout(card); //카드레이아웃시 주의할점 순서
    cardpanel.add(TotalPanel,"total");
    cardpanel.add( pp , "programpurchase");
    cardpanel.add(m2,"main");
    //cardpanel.add(m,"main");
    cardpanel.setBackground(new Color(199,228,248));
    
    this.setLayout(new BorderLayout());
    this.add(cardpanel);
    this.setBackground(new Color(199,228,248));
   // this.setSize(1000, 500);
  //  this.setVisible(true);
	}

	public static void main(String[] args) {
		//new ProgramSystem();

	}

}
