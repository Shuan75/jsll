package HJ;



import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class BookSystem extends JPanel implements ActionListener {
	
	



	@Override //연도,월,일 액션
	public void actionPerformed(ActionEvent e) {
	
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

		}//여기까지 콤보박스 액션
		
		
		
		
		if(e.getSource() == buttons[0]) {//구입버튼을누른경우
			JOptionPane.showMessageDialog(b,"구입하시겠습니까?");
			int i=1;
			this.card.show(TotalPanel,"purchase");
            p.textfield.setText("Y000"+i);
            
            i++;
//          
//           String ticketcode = p.textfield.getText();//입력한 코드를 불러옴
//	        CRUDprocess crud = new CRUDprocess();
//				int r = crud.insertreservecode(ticketcode);
//			    if(r > 0) {
//			    	JOptionPane.showMessageDialog(b, "예매번호가저장되었습니다 ");
//			  
//				
//			}
            

			
			} 
		
		if(e.getSource() == buttons[1]) {//취소하면 홈으로
			JOptionPane.showMessageDialog(b,"취소하시겠습니까?");
			tab2.card.show(tab2.cardpanel,"main");
			
		
		  //  textfield.setText("   ");
		   //세 개의 텍스트 필드에 입력된 값을 지움
		//  madeIn[0].setSelected(true);//라디오버튼을 오전으로 설정
		//  madeIn[2].setSelected(true);//라디오버튼을 현금으로 설정
		  }
		
		}
	
    TabClass tab;
	JLabel totallabel;
	JLabel[] labels;
	JMenuBar mb;
	JMenu menu_exhibition, menu_goodies, menu_program, menu_event;
	JMenuItem item_exhibition, item_exhibition1,
	item_exhibition2,item_goodies,item_program,item_event;
	Font menufont;
	JPanel[] panels;
	JPanel totalpanel;
	JRadioButton[] madeIn;
	ButtonGroup group;
	JTabbedPane tabs; // 탭이 달린 패널
	String[] radio_title = { "회원", "비회원", "현금", "카드" };
	String[] labels_title = { "미술관람", "날짜", "수량", "금액" };
	JComboBox[] combos;
	JTextField textfield;
	JButton[] buttons;

	Font font;
	JPanel[] panel;
	JPanel TotalPanel; //전부감싸는 카드패널
	CardLayout card; //카드레이아웃 선언
	Purchase p;
	BookSystem b;
	main main2;


	void MakeButton() {
		buttons = new JButton[2];
		buttons[0] = new JButton("구입");
		buttons[1] = new JButton("취소");
		for (int i = 0; i < buttons.length; i++) {

			buttons[i].setBackground(new Color(52, 152, 219));
			buttons[i].setSize(400, 50);
		}

	}//버튼2개만들기

	void MakeLabel() {
		labels = new JLabel[4];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(labels_title[i]);

		}//라벨4개만들기

	}

	void MakeJComboBox() {
		combos = new JComboBox[5];
		for (int i = 0; i < combos.length; i++) {
			combos[i] = new JComboBox();
		}

		combos[0].addItem("전시선택");
		String[] arts_title = { "반고흐", "모네", "루트렉" };
		for (int k = 0; k < arts_title.length; k++) {
			combos[0].addItem(arts_title[k] + "");
		}

		combos[1].addItem("연도선택");
		for (int p = 2019; p >= 2000; p--) {
			combos[1].addItem(p);
		}

		combos[2].addItem("월선택");
		for (int j = 1; j <= 12; j++) {
			combos[2].addItem(j);
		}

		combos[3].addItem("일 선택");

		combos[4].addItem("수량선택");
		for (int t = 1; t < 10; t++) {
			combos[4].addItem(t);
		}

	}//콤보박스초이스5개만들기

	void MakeRadioButton() {
		madeIn = new JRadioButton[radio_title.length]; // 배열생성
		group = new ButtonGroup(); // 묶을 그룹 생성
		for (int i = 0; i < radio_title.length; i++) {
			madeIn[i] = new JRadioButton(radio_title[i]); // 라디오버튼생성
			group.add(madeIn[i]); // 그룹에 붙이기

		}
	}//라디오버튼만들기

	void MakePanel() {
		panels = new JPanel[10];

		for (int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
			// panels[i].setLayout(new GridLayout(9,1));

		}

	}//패널10개만들기
	
	ProgramSystem ps;
	TabClass tab2;
	public BookSystem(TabClass tab2) {//생성자
		// super(str);
		 //메뉴 
		this.tab2 = tab2;
		 this.setLayout(new BorderLayout());
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
	      
         // 메뉴 //
		p = new Purchase(this);//구입클래스인스턴스생성해서 booksys에 붙이기
		main2 = new main(); //홈으로 가는 메인2 인스턴스 생성 booksys에 붙이기
		card = new CardLayout();//카드레이아웃 생성
	
		font = new Font("윤고딕110", font.PLAIN, 12); //폰트생성
		this.setLayout(new BorderLayout()); // booksys레이아웃
		TotalPanel = new JPanel(new GridLayout(1, 3));//전체를감싸는패널 그리드 1,3
		MakePanel();
		MakeLabel();
		MakeJComboBox();
		MakeButton();
		MakeRadioButton();

		textfield = new JTextField(10);
//		this.hm = hm;
//		card = new CardLayout();
//		card_pan = new JPanel(card);
//		tabs = new JTabbedPane();
//		pan1 = new Customersginupsystem(hm);
//		tabs.addTab("  회   원   가   입   ", pan1);
//		
//		this.add("Center", tabs);
//		tabs = new JTabbedPane(); //탭생성
	   
		//ps = new ProgramSystem();
		//tabs.addTab("예매하기", this);
	//	tabs.addTab("프로그램예매", ps);
		//this.add(panels[0]);
		
		totallabel = new JLabel("회원 로그인 화면"); //라벨생성

		panels[0].setBackground(null); //널값?
		panels[0].setLayout(null);
		
		// panels[0].setSize(100, 100);
		// panels[0].setLocation(600, 20);
		
		panels[0].add(totallabel);
		
		totallabel.setFont(font);
		
		
		combos[2].addActionListener(this);

		panels[3].add(labels[0]);
		panels[3].add(combos[0]);
		panels[4].add(labels[1]);
		panels[4].add(combos[1]);
		panels[4].add(combos[2]);
		panels[4].add(combos[3]);
		
		for (int i = 0; i < panels.length; i++) {
			panels[i].setBackground(new Color(199, 228, 248));

		}//패널들색깔저장

		panels[2].add(madeIn[0]);
		panels[2].add(madeIn[1]);
		panels[5].add(madeIn[2]);
		panels[5].add(madeIn[3]);
		panels[6].add(labels[2]);
		panels[6].add(combos[4]);
		panels[7].add(labels[3]);
		panels[7].add(textfield);
		// panels[9].setBackground(Color.WHITE);
		panels[9].add(buttons[0]);
		panels[9].add(buttons[1]);
		
		//버튼 액션 리스너
		buttons[0].addActionListener(this);
		buttons[1].addActionListener(this);
		
		//전체를 감싸는 레이아웃 전에 감싸는 전체패널 10,1
		totalpanel = new JPanel();
		totalpanel.setLayout(new GridLayout(10, 1));

		// panels[0].setSize(100, 100);
		// panels[0].setLocation(600, 20);
		// panels[1].setSize(400, 100);
		// panels[1].setLocation(200,20);
		// panels[2].setSize(600, 100);
		// panels[2].setLocation(400,20);
		// totalpanel.add(panels[0]);
		for (int i = 0; i < 10; i++) {
			totalpanel.add(panels[i]);
		}//전체전체에 패널들붙이기
		TotalPanel.setLayout(card); //전체를 감싸는 패널에 카드레이아웃붙이기 카드레이아웃시 주의할점 순서
		TotalPanel.add(totalpanel,"total");//전체를감싸는패널에 전체전체를 붙이기
		TotalPanel.add(p, "purchase");//예약시스템에 구입창붙이기
		TotalPanel.add(main2,"HaJinmain");//예약시스템에 홈창붙이기
	    TotalPanel.setBackground(new Color(199, 228, 248));
		
		this.add(TotalPanel);
        this.setBackground(new Color(199, 228, 248));
		
        // 메뉴//
		menufont = new Font("Noto Sans CJK KR Black", Font.PLAIN, 10);
		mb = new JMenuBar();
		menu_exhibition = new JMenu("                         전시                                      ");
		menu_goodies = new JMenu("                            굿즈                                       ");
		menu_program = new JMenu("                            프로그램                                   ");
		menu_event = new JMenu("                              이벤트                                        ");

		menu_exhibition.setFont(menufont);
		menu_goodies.setFont(menufont);
		menu_program.setFont(menufont);
		menu_event.setFont(menufont);

		mb.add(menu_exhibition);
		mb.add(menu_goodies);
		mb.add(menu_program);
		mb.add(menu_event);
		menu_exhibition.setEnabled(false);
		menu_goodies.setEnabled(false);
		menu_program.setEnabled(false);
		menu_event.setEnabled(false);
        //메뉴작업끝//
	//	this.setJMenuBar(mb);
	//	this.setSize(1000, 500);
	//	this.setVisible(true);

	}//클래스 생성자 

	

	public static void main(String[] args) {
		// new BookSystem();

	}//메인화면

}//클래스마지막
